package com.none.code.generator.core.mybatis;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lmly
 * @date 2021/04/16
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Column {

    private boolean id;

    private String column;

    private String jdbcType;

    private String javaType;

    private String property;

    private String comment;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Filed {
        public static final Map<Integer, Filed> MAPS = new HashMap<>();
        private Integer types;
        private String dataType;
        private String javaType;
        private String baseShortName;
        /**
         * 是否需要导入
         */
        private boolean explicitlyImported;

        static {
            MAPS.put(Types.ARRAY, new Filed(Types.ARRAY, "ARRAY", Object.class.getName(), "Object", false));
            MAPS.put(Types.BIGINT, new Filed(Types.ARRAY, "BIGINT", Long.class.getName(), "Long", false));
            MAPS.put(Types.BINARY, new Filed(Types.BINARY, "BINARY", "byte[]", "byte[]", false));
            MAPS.put(Types.BIT, new Filed(Types.BIT, "BIT", Boolean.class.getName(), "Boolean", false));
            MAPS.put(Types.BLOB, new Filed(Types.BLOB, "BLOB", "byte[]", "byte[]", false));
            MAPS.put(Types.BOOLEAN, new Filed(Types.BOOLEAN, "BOOLEAN", Boolean.class.getName(), "Boolean", false));
            MAPS.put(Types.CHAR, new Filed(Types.CHAR, "CHAR", String.class.getName(), "String", false));
            MAPS.put(Types.CLOB, new Filed(Types.CLOB, "CLOB", String.class.getName(), "String", false));
            MAPS.put(Types.DATALINK, new Filed(Types.DATALINK, "DATALINK", Object.class.getName(), "Object", false));
            MAPS.put(Types.DATE, new Filed(Types.DATE, "DATE", Date.class.getName(), "Date", true));
            MAPS.put(Types.DECIMAL, new Filed(Types.DECIMAL, "DECIMAL", BigDecimal.class.getName(), "BigDecimal", true));
            MAPS.put(Types.DISTINCT, new Filed(Types.DISTINCT, "DISTINCT", Object.class.getName(), "Object", false));
            MAPS.put(Types.DOUBLE, new Filed(Types.DOUBLE, "DOUBLE", Double.class.getName(), "Double", false));
            MAPS.put(Types.FLOAT, new Filed(Types.FLOAT, "FLOAT", Double.class.getName(), "Double", false));
            MAPS.put(Types.INTEGER, new Filed(Types.INTEGER, "INTEGER", Integer.class.getName(), "Integer", false));
            MAPS.put(Types.JAVA_OBJECT, new Filed(Types.JAVA_OBJECT, "JAVA_OBJECT", Object.class.getName(), "Object", false));
            MAPS.put(Types.LONGNVARCHAR, new Filed(Types.LONGNVARCHAR, "LONGNVARCHAR", String.class.getName(), "String", false));
            MAPS.put(Types.LONGVARBINARY, new Filed(Types.LONGVARBINARY, "LONGVARBINARY", "byte[]", "byte[]", false));
            MAPS.put(Types.LONGVARCHAR, new Filed(Types.LONGVARCHAR, "LONGVARCHAR", String.class.getName(), "String", false));
            MAPS.put(Types.NCHAR, new Filed(Types.NCHAR, "NCHAR", String.class.getName(), "String", false));
            MAPS.put(Types.NCLOB, new Filed(Types.NCLOB, "NCLOB", String.class.getName(), "String", false));
            MAPS.put(Types.NVARCHAR, new Filed(Types.NVARCHAR, "NVARCHAR", String.class.getName(), "String", false));
            MAPS.put(Types.NULL, new Filed(Types.NULL, "NULL", Object.class.getName(), "Object", false));
            MAPS.put(Types.NUMERIC, new Filed(Types.NUMERIC, "NUMERIC", BigDecimal.class.getName(), "BigDecimal", true));
            MAPS.put(Types.OTHER, new Filed(Types.OTHER, "OTHER", Object.class.getName(), "Object", false));
            MAPS.put(Types.REAL, new Filed(Types.REAL, "REAL", Float.class.getName(), "Float", false));
            MAPS.put(Types.REF, new Filed(Types.REF, "REF", Object.class.getName(), "Object", false));
            MAPS.put(Types.SMALLINT, new Filed(Types.SMALLINT, "SMALLINT", Short.class.getName(), "Short", false));
            MAPS.put(Types.STRUCT, new Filed(Types.STRUCT, "STRUCT", Object.class.getName(), "Object", false));
            MAPS.put(Types.TIME, new Filed(Types.TIME, "TIME", Date.class.getName(), "Date", true));
            MAPS.put(Types.TIMESTAMP, new Filed(Types.TIMESTAMP, "TIMESTAMP", Date.class.getName(), "Date", true));
            MAPS.put(Types.TINYINT, new Filed(Types.TINYINT, "TINYINT", Byte.class.getName(), "Byte", false));
            MAPS.put(Types.VARBINARY, new Filed(Types.VARBINARY, "VARBINARY", "byte[]", "byte[]", false));
            MAPS.put(Types.VARCHAR, new Filed(Types.VARCHAR, "VARCHAR", String.class.getName(), "String", false));
            MAPS.put(Types.TIME_WITH_TIMEZONE, new Filed(Types.TIME_WITH_TIMEZONE, "TIME_WITH_TIMEZONE", "java.time.OffsetTime", "OffsetTime", true));
            MAPS.put(Types.TIMESTAMP_WITH_TIMEZONE, new Filed(Types.TIMESTAMP_WITH_TIMEZONE, "TIMESTAMP_WITH_TIMEZONE", "java.time.OffsetDateTime", "OffsetDateTime", true));
        }
    }

}
