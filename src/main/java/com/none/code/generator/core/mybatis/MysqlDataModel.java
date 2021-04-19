package com.none.code.generator.core.mybatis;


import com.none.code.generator.core.Env;
import com.none.code.generator.core.DataModel;

import java.sql.*;
import java.util.*;

import static com.none.code.generator.core.Utils.firstCharToLowerCase;
import static com.none.code.generator.core.Utils.firstCharToUpperCase;
import static com.none.code.generator.core.Utils.toCamelCase;
import static com.none.code.generator.core.mybatis.Column.Filed.MAPS;

/**
 * @author lmly
 * @date 2021/04/16
 */
public class MysqlDataModel extends DataModel {

    private final MybatisEnv env;

    public MysqlDataModel(Env env) {
        super(env);
        this.env = (MybatisEnv) env;
    }

    private final Map<String, Table> maps = new HashMap<>();

    @Override
    public Map<String, Object> dataModel() {
        String tableName = env.getTable();
        Table table = maps.get(tableName);
        if (table == null) {
            table = columns(env.getJdbcUrl(), env.getUsername(), env.getPassword(), env.getTable());
            maps.put(tableName, table);
        }
        Map<String, Object> maps = super.dataModel();
        maps.put("table", table);
        maps.put("columns", table.getColumns());
        return maps;
    }


    private Table columns(String url, String username, String password, String table) {
        ResultSet crs = null;
        Connection conn = null;
        ResultSet trs = null;
        ResultSet primaryKeys = null;
        List<Column> columns = new ArrayList<>();
        String tableName = "", comment = "";
        Set<String> imports = new HashSet<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            crs = databaseMetaData.getColumns(null, null, table, "%");
            trs = databaseMetaData.getTables(null, null, table, new String[]{"TABLE"});
            primaryKeys = databaseMetaData.getPrimaryKeys(null, null, table);
            String primaryKey = "";
            while (primaryKeys.next()) {
                primaryKey = primaryKeys.getString("COLUMN_NAME");
            }
            while (trs.next()) {
                tableName = trs.getString("TABLE_NAME");
                comment = trs.getString("REMARKS");
                while (crs.next()) {
                    String column = crs.getString("COLUMN_NAME");
                    String jdbcTypeName = crs.getString("TYPE_NAME");
                    int jdbcType = crs.getInt("DATA_TYPE");
                    String columnComment = crs.getString("REMARKS");
                    Column.Filed filed = MAPS.get(jdbcType);
                    if (filed.isExplicitlyImported()) {
                        imports.add(filed.getJavaType());
                    }
                    columns.add(Column.builder()
                            .id(Objects.equals(column, primaryKey))
                            .column(column)
                            .jdbcType(jdbcTypeName)
                            .javaType(filed.getBaseShortName())
                            .property(firstCharToLowerCase(toCamelCase(column)))
                            .comment(columnComment)
                            .build());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (primaryKeys != null) {
                    primaryKeys.close();
                }
                if (trs != null) {
                    trs.close();
                }
                if (crs != null) {
                    crs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return Table.builder()
                .name(tableName)
                .imports(imports)
                .domain(firstCharToUpperCase(toCamelCase(tableName)))
                .comment(comment).columns(columns).build();
    }

}