package com.example.employeepayroll.repository;

import com.example.employeepayroll.model.EmployeePayrollDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePayrollDataModel, Long> {
}
