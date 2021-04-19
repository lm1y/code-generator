package ${targetPackage}.persistence.entity;

import lombok.*;

<#list table.imports as import>
import ${import};
</#list>

/**
 * ${table.name}
 *
 * @author ${author}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ${domain}  {

    <#list columns as column>
      /**
      * ${column.comment}
      */
      private ${column.javaType} ${column.property};
    </#list>

}