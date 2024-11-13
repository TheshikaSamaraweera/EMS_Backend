package com.employ.EMS.service;


import com.employ.EMS.dto.EmployeeDto;
import com.employ.EMS.entity.Employee;
import com.employ.EMS.exceptions.ResourceNotFoundException;
import com.employ.EMS.mappre.EmployeeMapper;
import com.employ.EMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.dtoToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.entityToDto(savedEmployee);
    }

    public EmployeeDto getEmployeeById(Long id) {
       Employee employee= employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        return EmployeeMapper.entityToDto(employee);
    }


    public List<EmployeeDto> getAllEmployees() {
        List<Employee> list = employeeRepository.findAll();
        return list.stream().map((Elist) -> EmployeeMapper.entityToDto(Elist))
                .collect(Collectors.toList());
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.entityToDto(updatedEmployee);
    }


    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employeeRepository.delete(employee);
    }
}
