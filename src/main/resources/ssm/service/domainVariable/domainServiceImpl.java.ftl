package ${targetPackage}.service.${domainVariable};

import ${targetPackage}.manager.${domain}Manager;
import ${targetPackage}.persistence.entity.${domain};
import ${targetPackage}.service.${domain}Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author ${author}
* @date ${date}
*/
@Service
public class ${domain}ServiceImpl implements ${domain}Service {

@Resource
private ${domain}Manager ${domainVariable}Manager;

@Override
public ${domain} find${domain}ById(Long ${domainVariable}Id) {
return ${domainVariable}Manager.find${domain}ById(${domainVariable}Id);
}
}
