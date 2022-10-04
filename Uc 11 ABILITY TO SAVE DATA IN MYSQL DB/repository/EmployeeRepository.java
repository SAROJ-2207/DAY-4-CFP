package com.example.employeepayroll.repository;

import com.example.employeepayroll.model.EmployeePayrollDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePayrollDataModel, Long> {

    @Query(value = "select * from employee_payroll_data_model where department = department",nativeQuery = true)
    List<EmployeePayrollDataModel> findByDepartment(String Department);

//    @Query(value = "select * from employee_payroll_data_model where  = department",nativeQuery = true)
//    List<EmployeePayrollDataModel> findByDepartment(String Department);

}
