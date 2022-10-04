package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollDto;
import com.example.employeepayroll.model.EmployeePayrollDataModel;
import com.example.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService  implements IEmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;


//    public List<EmployeePayrollDataModel> employeePayrollDataModelList =  new ArrayList<>();
//    public List<EmployeePayrollDataModel> getEmployeePayrollDataModelList(){
//        return employeePayrollDataModelList;
//    }
    @Override
    public EmployeePayrollDataModel addEmployee(EmployeePayrollDto employeePayrollDto) {
//        EmployeePayrollDataModel employeeAddData = null;
        EmployeePayrollDataModel employeeAddData = new EmployeePayrollDataModel(employeePayrollDto);
//        employeePayrollDataModelList.add(employeeAddData);
        return employeeRepository.save(employeeAddData);
    }

    @Override
    public EmployeePayrollDataModel updateEmployee(long id, EmployeePayrollDataModel employeePayrollDataModel) {

        Optional<EmployeePayrollDataModel> isEmployeePresent = employeeRepository.findById(id);
        if (isEmployeePresent.isPresent()) {
            isEmployeePresent.get().setFirstName(employeePayrollDataModel.getFirstName());
            isEmployeePresent.get().setLastName(employeePayrollDataModel.getLastName());
            isEmployeePresent.get().setCompanyName(employeePayrollDataModel.getCompanyName());
            isEmployeePresent.get().setDepartment(employeePayrollDataModel.getDepartment());
            isEmployeePresent.get().setSalary((employeePayrollDataModel.getSalary()));

            return  employeeRepository.save(isEmployeePresent.get());
        }  return null;
    }

    @Override
    public EmployeePayrollDataModel deleteEmployeeById(long id) {
        Optional<EmployeePayrollDataModel> isEmployeePresent = employeeRepository.findById(id);
        if (isEmployeePresent.isPresent()) {
            employeeRepository.delete(isEmployeePresent.get());
            return isEmployeePresent.get();
        }
        return null;
    }

    @Override
    public Optional<EmployeePayrollDataModel> getEmployeeData(long empId) {
        Optional<EmployeePayrollDataModel> isEmployeePresent = employeeRepository.findById(empId);
        return isEmployeePresent;
    }

}


