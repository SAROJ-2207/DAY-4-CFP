package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollDto;
import com.example.employeepayroll.model.EmployeePayrollDataModel;

import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {
    EmployeePayrollDataModel addEmployee(EmployeePayrollDto employeePayrollDto);
    EmployeePayrollDataModel updateEmployee(long id, EmployeePayrollDataModel EmployeePayrollDataModel);
    EmployeePayrollDataModel deleteEmployeeById(long id);
    Optional<EmployeePayrollDataModel> getEmployeeDataById(long empId);
    public List<EmployeePayrollDataModel> findDataByDepartment(String department);

}
