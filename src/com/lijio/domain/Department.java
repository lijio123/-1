package com.lijio.domain;

import com.lijio.annotation.NotThreadSafe;

/**
 * 班级表

 */
@NotThreadSafe
public class Department {
    private int id;//班级id，对应数据库id
    private String name;//班级名，对应数据库名
    
    public Department() {
        name="";
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
