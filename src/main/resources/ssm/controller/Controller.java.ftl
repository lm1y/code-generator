package ${targetPackage}.controller;

import  ${targetPackage}.persistence.entity.${domain};
import  ${targetPackage}.service.${domain}Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author ${author}
* @date ${date}
*/
@RestController
@RequestMapping("/${domainVariable}s")
public class ${domain}Controller {

@Resource
private ${domain}Service ${domainVariable}Service;

@GetMapping("/{${domainVariable}Id}")
public ${domain} find${domain}ById(@PathVariable Long ${domainVariable}Id) {
return ${domainVariable}Service.find${domain}ById(${domainVariable}Id);
}

}
