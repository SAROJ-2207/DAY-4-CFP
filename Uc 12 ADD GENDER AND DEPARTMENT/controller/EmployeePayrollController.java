package com.example.employeepayroll.controller;

import com.example.employeepayroll.Exception.EmployeeException;
import com.example.employeepayroll.Exception.EmployeePayrollExceptionHandler;
import com.example.employeepayroll.dto.EmployeePayrollDto;

import com.example.employeepayroll.dto.ResponseDto;
import com.example.employeepayroll.model.EmployeePayrollDataModel;
import com.example.employeepayroll.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService iEmployeePayrollService;

    @GetMapping("/getEmployeedata/{id}")
    public Optional<EmployeePayrollDataModel> getEmployeeData(@PathVariable long id) {

        return iEmployeePayrollService.getEmployeeDataById(id);
    }

    @PostMapping("/addemployee")
    public EmployeePayrollDataModel addEmployeePayroll(@Valid @RequestBody EmployeePayrollDto employeeDto) {
        return iEmployeePayrollService.addEmployee(employeeDto);
    }

    @PutMapping("/update-employee/{id}")
    public EmployeePayrollDataModel updateEmployeeById(@PathVariable long id, @RequestBody EmployeePayrollDataModel employeePayrollDataModel) {
        return iEmployeePayrollService.updateEmployee(id, employeePayrollDataModel);
    }

    @DeleteMapping("/delete/{id}")
    public EmployeePayrollDataModel deleteEmployeeById(@PathVariable long id) {
        return iEmployeePayrollService.deleteEmployeeById(id);
    }

//    @GetMapping("/find-All-Employee")
//    public EmployeePayrollDataModel findAllemployee() {
//     return (EmployeePayrollDataModel) iEmployeePayrollService.findAllemployeeData();
//    }

//    @GetMapping("/getDepartment/{department}")
//    public ResponseEntity<ResponseDto> getDetailsByDepartment(@PathVariable("department") String department) {
//        List<EmployeePayrollDataModel> depEmp = null;
//        depEmp = iEmployeePayrollService.getDataByDepartment(department);
//        ResponseDto dto = new ResponseDto("Record for given Department retrive successfully", depEmp);
//        return new ResponseEntity<ResponseDto>(dto, HttpStatus.Ok);
//    }


//    @GetMapping("/empDepartment/{department}")
//    public ResponseEntity <ResponseDto> getEmployeeDataByDepartment(@PathVariable String department) {
//        List<EmployeePayrollDataModel> empDataList = service.findByDepartment(department);
//        ResponseDto respDTO = new ResponseDto("Get Data By Department", empDataList);
//        return new ResponseEntity<>(respDTO, HttpStatus.OK);
//    }
}

