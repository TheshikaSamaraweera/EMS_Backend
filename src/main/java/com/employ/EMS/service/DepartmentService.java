package com.employ.EMS.service;

import com.employ.EMS.dto.DepartmentDto;
import com.employ.EMS.entity.Department;
import com.employ.EMS.exceptions.ResourceNotFoundException;
import com.employ.EMS.mappre.DepartmentMapper;
import com.employ.EMS.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDto createDepartment(DepartmentDto departmentDto){
        Department department = DepartmentMapper.dtoToDepartmentEntEntity(departmentDto);
        Department savedDepartment =departmentRepository.save(department);
        return DepartmentMapper.entityToDepartmentDto(savedDepartment);
    }


    public DepartmentDto getDepartmentById(Long id){
        Department department = departmentRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        return DepartmentMapper.entityToDepartmentDto(department);
    }

    public List<DepartmentDto> getAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((dlist) -> DepartmentMapper.entityToDepartmentDto(dlist))
        .collect(Collectors.toList());
    }

    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto){
        Department department = departmentRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

       department.setDepartmentName(departmentDto.getDepartmentName());
       department.setDepartmentDescription(departmentDto.getDepartmentDescription());

       Department updatedDepartment = departmentRepository.save(department);

       return DepartmentMapper.entityToDepartmentDto(updatedDepartment);

    }

    public void deleteDepartment(Long id){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found" + id));
        departmentRepository.deleteById(id);
    }
}
