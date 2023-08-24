package com.employeeservice.employee.service.serviceimpl;

import com.employeeservice.employee.entity.Employee;
import com.employeeservice.employee.entity.EmployeeProject;
import com.employeeservice.employee.repository.EmployeeProjectRepository;
import com.employeeservice.employee.repository.EmployeeRepository;
import com.employeeservice.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
                //.orElseThrow(() -> new NoSuchEmployeeExistsException("No Employee Exist With Id : " + id));
    }

    @Override
    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Optional<Employee> existedEmployee = getEmployee(id);
        if (!existedEmployee.isEmpty()) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    @Override
    public EmployeeProject addEmployeeProject(EmployeeProject employeeProject) {
        return employeeProjectRepository.save(employeeProject);
    }


}
