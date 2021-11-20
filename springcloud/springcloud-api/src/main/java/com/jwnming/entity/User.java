package com.jwnming.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 蒋文明
 * 用户实体
 */

@Data // getters、setters、toString... 不建议
@NoArgsConstructor  // 无参构造 不建议
@Accessors(chain = true) // 链式写法 (new User()).setId(xxx).setName(xxx);
public class User implements Serializable {

    private Integer id;
    private String name;


    // 数据源，做微服务分布式使用，标明资源对应的数据库资源
    private String dataSource;


    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


}
