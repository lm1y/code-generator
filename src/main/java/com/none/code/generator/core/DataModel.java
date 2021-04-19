package com.none.code.generator.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lmly
 * @date 2021/04/16
 */
public class DataModel {

    private final Env env;

    public DataModel(Env env) {
        this.env = env;
    }

    public Map<String, Object> dataModel() {
        Map<String, Object> dataMap = new HashMap<>(16);
        dataMap.put("author", env.getAuthor());
        dataMap.put("date", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDate.now()));
        dataMap.put("domain", env.getDomain());
        dataMap.put("domainVariable", env.getDomainVariable());
        dataMap.put("targetPackage", env.getTargetPackage());
        return dataMap;
    }

}
