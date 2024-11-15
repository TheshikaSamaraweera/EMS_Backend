package com.employ.EMS.mappre;

import com.employ.EMS.dto.DepartmentDto;
import com.employ.EMS.entity.Department;

public class DepartmentMapper {


    public static DepartmentDto entityToDepartmentDto(Department entity) {
        return new DepartmentDto(
                entity.getId(),
                entity.getDepartmentName(),
                entity.getDepartmentName()

        );
    }


    public static Department dtoToDepartmentEntEntity(DepartmentDto dto){
        return new Department(
                dto.getId(),
                dto.getDepartmentName(),
                dto.getDepartmentName()
        );
    }
}
