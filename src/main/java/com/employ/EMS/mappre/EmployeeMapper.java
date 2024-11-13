package com.employ.EMS.mappre;

import com.employ.EMS.dto.EmployeeDto;
import com.employ.EMS.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto entityToDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee dtoToEntity(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
