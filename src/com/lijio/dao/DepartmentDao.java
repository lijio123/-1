package com.lijio.dao;

import java.util.List;

import com.lijio.annotation.Immutable;
import com.lijio.domain.Department;

/**
 * 班级DAO接口
 */
@Immutable
public interface DepartmentDao {
    public void insert(Department department);
    public void update(Department department);
    public void delete(Department department);
    
    public Department queryById(int id);
    public Department queryByName(String name);
    public List<Department> queryAll();
}
