package ${targetPackage}.manager;

import ${targetPackage}.persistence.dao.${domain}Dao;
import ${targetPackage}.persistence.entity.${domain};
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
* @author ${author}
* @date ${date}
*/
@Component
public class ${domain}Manager {

@Resource
private ${domain}Dao ${domainVariable}Dao;

public ${domain} find${domain}ById(Long ${domainVariable}Id) {
return ${domainVariable}Dao.find${domain}ById(${domainVariable}Id);
}
}
