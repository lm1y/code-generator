### 使用说明
    根据自己的个人习惯，定义包结构，生成代码模板文件。
#### ftl文件
    抽象代码中的业务片段，生成代码；
    文件名称生成规则：去除.ftl并替换出现在env中的变量

#### 操作步骤
    1.抽象通用代码
    2.改写成ftl文件
    3.如新增变量，自定义dataModel子类，导入新增的变量到CodeGenerator类
    eg:Env env = new MybatisEnv();
       DataModel dataModel = new MysqlDataModel(env);
       CodeGenerator codeGenerator = new CodeGenerator(env, dataModel);
       codeGenerator.generator();