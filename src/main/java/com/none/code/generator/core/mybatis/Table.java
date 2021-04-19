package com.none.code.generator.core.mybatis;

import lombok.*;

import java.util.List;
import java.util.Set;

/**
 * @author lmly
 * @date 2021/04/16
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Table {

    private String name;

    private String domain;

    private String comment;

    private List<Column> columns;

    private Set<String> imports;

}
