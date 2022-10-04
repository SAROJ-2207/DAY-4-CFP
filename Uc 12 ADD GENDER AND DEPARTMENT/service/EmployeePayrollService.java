package com.example.employeepayroll.service;

import com.example.employeepayroll.Exception.EmployeeException;
import com.example.employeepayroll.dto.EmployeePayrollDto;
import com.example.employeepayroll.model.EmployeePayrollDataModel;
import com.example.employeepayroll.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeePayrollService  implements IEmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeePayrollDataModel addEmployee(EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollDataModel employeeAddData = new EmployeePayrollDataModel(employeePayrollDto);
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

            return employeeRepository.save(isEmployeePresent.get());
        }
        return null;
    }

    @Override
    public EmployeePayrollDataModel deleteEmployeeById(long id) {
        Optional<EmployeePayrollDataModel> emp = employeeRepository.findById(id);
//        if (isEmployeePresent.isPresent()) {
//            employeeRepository.delete(isEmployeePresent.get());
//            return isEmployeePresent.get();
//        }

        if (emp.isEmpty()) {
            log.warn("Unable to find employee for given id:-" + id);
            throw new EmployeeException("Employee Not Found!!!");  /** Using Exception **/
        } else {
            employeeRepository.deleteById(id);
            log.info("Id Number " + id + " Successfully Deleted");
        }
        return null;
    }

    @Override
    public Optional<EmployeePayrollDataModel> getEmployeeDataById(long empId) {
        Optional<EmployeePayrollDataModel> isEmployeePresent = employeeRepository.findById(empId);
        if (isEmployeePresent.isEmpty()) {
            log.warn("Unable to find employee for given id:-" + empId);
            throw new EmployeeException("Employee Not Found!!!");
        }
        return isEmployeePresent;
    }



//    @Override
//    public List<EmployeePayrollDataModel> findAllemployeeData() {
//        List<EmployeePayrollDataModel> getallemployee = employeeRepository.findAll();
//        if(getallemployee.size() > 0)
//            return getallemployee;
//
//        else
//            throw new EmployeeException("No Data Present");
//    }
//
//    @Override
//    public List<EmployeePayrollDataModel> findDataByName(String empFirstName) {
//            List<EmployeePayrollDataModel> empName = employeeRepository.
//
//        return null;
//    }
//    public List<EmployeeEntity> findByName(String firstName) {
//        return (repository.findEmployeeByName(firstName));
//    }


    @Override
    public List<EmployeePayrollDataModel> findDataByDepartment(String department) {
        List<EmployeePayrollDataModel> depEmp = employeeRepository.findByDepartment(department);
        if(depEmp.isEmpty()){
            throw new EmployeeException("Employee Not Found");
        }
        return depEmp;
    }
}



