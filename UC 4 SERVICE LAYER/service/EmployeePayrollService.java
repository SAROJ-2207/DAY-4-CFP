package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollDto;
import com.example.employeepayroll.model.EmployeePayrollDataModel;
import com.example.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

}



