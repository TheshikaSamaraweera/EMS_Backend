package com.employ.EMS.controller;

import com.employ.EMS.dto.DepartmentDto;
import com.employ.EMS.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
     public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){

       DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);

     }


     @GetMapping("{id}")
     public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long id){
         DepartmentDto departmentDto = departmentService.getDepartmentById(id);
         return ResponseEntity.ok(departmentDto);
     }


     @GetMapping
     public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
         List<DepartmentDto> departmentDtoList = departmentService.getAllDepartments();
         return ResponseEntity.ok(departmentDtoList);
     }


     @PutMapping("{id}")
     public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id")Long id,
                                                           @RequestBody DepartmentDto departmentDto){
         DepartmentDto updatedDepartment = departmentService.updateDepartment(id,departmentDto);
         return ResponseEntity.ok(updatedDepartment);
     }


     @DeleteMapping("{id}")
     public ResponseEntity<String> deleteDepartment(@PathVariable("id")Long id){
         departmentService.deleteDepartment(id);
         return ResponseEntity.ok("Department deleted successfully!  ID: " + id);
     }
}
