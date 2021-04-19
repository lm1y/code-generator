package com.none.user.persistence.entity;

import lombok.*;

import java.util.Date;

/**
 * t_user
 *
 * @author xx
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User  {

      /**
      * 
      */
      private Long id;
      /**
      * 姓名
      */
      private String name;
      /**
      * 年龄
      */
      private Integer age;
      /**
      * 更新时间
      */
      private Date updated;
      /**
      * 创建时间
      */
      private Date created;
      /**
      * 是否删除 1:是 0:否
      */
      private Boolean deleted;

}