package com.none.code.generator.core;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author lmly
 * @date 2021/04/15
 */
public class CodeGenerator {

    private final DataModel dataModel;
    private final Env env;


    public CodeGenerator(Env env, DataModel dataModel) {
        this.dataModel = dataModel;
        this.env = env;
    }

    public void generator() throws IOException, TemplateException {
        //模板 数据 生成文件地址 1:1:1 一个一个生成
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setInterpolationSyntax(Configuration.DOLLAR_INTERPOLATION_SYNTAX);
        Map<Template, File> packageStructures = new HashMap<>(16);
        Map<Template, File> maps =
                packageStructure(new File(env.getResources() + "/" + env.getDir()), configuration, packageStructures);
        for (Map.Entry<Template, File> meta : maps.entrySet()) {
            Template template = meta.getKey();
            try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(meta.getValue())))) {
                template.process(dataModel.dataModel(), out);
                out.flush();
            }
        }
    }

    private Map<Template, File> packageStructure(File directory,
                                                 Configuration configuration,
                                                 Map<Template, File> packageStructures) throws IOException {
        if (!directory.isDirectory()) {
            throw new RuntimeException();
        }
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                packageStructure(file, configuration, packageStructures);
            } else {
                Reader reader = new InputStreamReader(new FileInputStream(file), UTF_8);
                Template template = new Template(file.getName(), file.getName(), reader, configuration, null, UTF_8.name());
                File servicePackage = getDirectory(env.getTargetProject(), getTargetPackage(file.getPath()));
                File serviceJava = new File(servicePackage, getFileName(file.getName()));
                packageStructures.put(template, serviceJava);
            }
        }
        return packageStructures;
    }

    private File getDirectory(String targetProject, String targetPackage) {
        File project = new File(targetProject);
        if (!project.isDirectory()) {
            throw new RuntimeException();
        }
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(targetPackage, ".");
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
            sb.append(File.separatorChar);
        }
        File directory = new File(project, sb.toString());
        if (!directory.isDirectory()) {
            boolean rc = directory.mkdirs();
            if (!rc) {
                throw new RuntimeException();
            }
        }
        return directory;
    }

    private String getTargetPackage(String path) {
        String[] hierarchies = path.split(env.getDir())[1].substring(1).split("\\\\");
        int length = hierarchies.length;
        StringBuilder builder = new StringBuilder(env.getTargetPackage());
        for (int i = 0; i < length - 1; i++) {
            builder.append(".").append(env.swap(hierarchies[i]));
        }
        return builder.toString();
    }

    /**
     * 如果.ftl文件名是变量中存在的,以变量中存在的名字
     * 如果变量中不存在,将文件ftl作为后缀
     */
    private String getFileName(String name) {
        name = name.replace(".ftl", "");
        String swap = env.swap(name);
        return Objects.equals(swap, name) ? env.getDomain() + name : swap;
    }

}
