package com.none.code.generator;


import com.none.code.generator.core.CodeGenerator;
import com.none.code.generator.core.DataModel;
import com.none.code.generator.core.Env;
import com.none.code.generator.core.mybatis.MybatisEnv;
import com.none.code.generator.core.mybatis.MysqlDataModel;
import freemarker.template.TemplateException;

import java.io.*;

/**
 * @author lmly
 * @date 2021/04/15
 */
public class Main {

    public static void main(String[] args) throws IOException, TemplateException {
        Env env = new MybatisEnv();
        DataModel dataModel = new MysqlDataModel(env);
        CodeGenerator codeGenerator = new CodeGenerator(env, dataModel);
        codeGenerator.generator();
    }


}
