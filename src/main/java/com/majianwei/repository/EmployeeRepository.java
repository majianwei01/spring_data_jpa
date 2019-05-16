package com.majianwei.repository;

import com.majianwei.domain.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//传入实体表类名，抽取的id的类型
public interface EmployeeRepository extends BaseRepository<Employee,Long>{
    //springdatajpa自带
    List<Employee> findByUsernameLike(String username);
    //自定义查询方法
    @Query("select e from Employee e where e.username like ?1")
    List<Employee> queryByUn(String username);

    Employee findByUsername(String username);

    //通过传入部门名称找到对应部门的员工
    @Query("select e from Employee e where e.department.name=?1")
    List<Employee> findBuyersByDept(String deptName);

}
