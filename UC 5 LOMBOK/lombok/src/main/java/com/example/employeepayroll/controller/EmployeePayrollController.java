package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeePayrollDto;

import com.example.employeepayroll.model.EmployeePayrollDataModel;
import com.example.employeepayroll.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService iEmployeePayrollService;

    @GetMapping("/getEmployeedata/{id}")
    public Optional<EmployeePayrollDataModel> getEmployeeData(@PathVariable long id){

        return iEmployeePayrollService.getEmployeeData(id);
    }

    @PostMapping("/addemployee")
    public EmployeePayrollDataModel addEmployee(@RequestBody EmployeePayrollDto employeeDto){
        return iEmployeePayrollService.addEmployee(employeeDto);
    }

    @PutMapping("/updateemployee/{id}")
    public EmployeePayrollDataModel updateemployee(@PathVariable long id,@RequestBody EmployeePayrollDataModel employeePayrollDataModel ){
    return iEmployeePayrollService.updateEmployee(id, employeePayrollDataModel);
  }

    @DeleteMapping("/delete/{id}")
    public EmployeePayrollDataModel deleteEmployeeById(@PathVariable long id){
        return this.iEmployeePayrollService.deleteEmployeeById(id);
    }
}

