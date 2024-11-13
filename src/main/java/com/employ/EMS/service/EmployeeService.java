package com.employ.EMS.service;


import com.employ.EMS.dto.EmployeeDto;
import com.employ.EMS.entity.Employee;
import com.employ.EMS.mappre.EmployeeMapper;
import com.employ.EMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.dtoToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.entityToDto(savedEmployee);


    }
}
