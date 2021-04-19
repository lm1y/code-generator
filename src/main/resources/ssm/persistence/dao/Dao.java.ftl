package ${targetPackage}.persistence.dao;

import ${targetPackage}.persistence.entity.${domain};
import org.apache.ibatis.annotations.Mapper;

/**
* @author ${author}
* @date ${date}
*/
@Mapper
public interface ${domain}Dao {

${domain} find${domain}ById(Long id);

}