package com.classicmodels.classicmodels.service.employee;

import com.classicmodels.classicmodels.entities.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
}

