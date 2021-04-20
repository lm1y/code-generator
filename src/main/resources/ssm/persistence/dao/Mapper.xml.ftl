<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${targetPackage}.persistence.dao.${domain}Dao">

    <resultMap id="${domainVariable}Map" type="${targetPackage}.persistence.entity.${domain}">
        <#list columns as column>
            <#if column.id>
                <id column="${column.column}" property="${column.property}"/>
            <#else>
                <result column="${column.column}" property="${column.property}"/>
            </#if>
        </#list>
    </resultMap>

    <sql id="fields">
        <#list columns as column>
            ${column.column} <#if column_has_next>,</#if>
        </#list>
    </sql>

    <select id="find${domain}ById" parameterType="java.lang.Long" resultMap="${domainVariable}Map">
        select
        <include refid="fields"/>
        from ${table.name}
        where id = #{id}
    </select>

</mapper>