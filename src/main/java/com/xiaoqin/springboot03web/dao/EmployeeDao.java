package com.xiaoqin.springboot03web.dao;

import com.xiaoqin.springboot03web.pojo.Department;
import com.xiaoqin.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    //员工有所属部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer,Employee>();//创建一个数据表

        employees.put(101,new Employee(1001,"AA","1511713422@qq.com",1,new Department(101,"后勤部")));
        employees.put(102,new Employee(1002,"BB","1511713422@qq.com",0,new Department(102,"后勤部")));
        employees.put(103,new Employee(1003,"CC","1511713422@qq.com",1,new Department(103,"后勤部")));
        employees.put(104,new Employee(1004,"DD","1511713422@qq.com",1,new Department(104,"后勤部")));
        employees.put(105,new Employee(1005,"EE","1511713422@qq.com",0,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId= 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId((initId++));
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息(返回的是一个集合)
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工(返回的是一个员工对象)
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工通过id
    public void delete(Integer id){
        employees.remove(id);
    }
}