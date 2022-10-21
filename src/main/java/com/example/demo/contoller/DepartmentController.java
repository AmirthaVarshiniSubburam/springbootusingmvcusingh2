package com.example.demo.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepositary;

@RestController
public class DepartmentController {

	
	DepartmentRepositary deptRepo;
		
	
	@Autowired
public DepartmentController(DepartmentRepositary deptRepo) {
		super();
		this.deptRepo = deptRepo;
	}

//	@PostMapping("/dept")
//	public String insertARecord(@RequestBody Department department)
//	Department savedDepartment = deptRepo.save(department);
//	return "Department saved..";
	
	@PostMapping("/dept")	
	public ResponseEntity<Department> insertARecord(@RequestBody Department department) {
		Department savedDepartment = deptRepo.save(department);
		return new ResponseEntity<Department>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("/depts")
	public ResponseEntity<List<Department>> findAllDepartments(){
		List<Department> departments = deptRepo.findAll();
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
	}
			
	
	@GetMapping("/dept/{deptId}")
	public ResponseEntity<Department> findingADepartment(@PathVariable Integer deptId){
			Department departments = deptRepo.findById(deptId).get();
			return new ResponseEntity<Department>(departments, HttpStatus.OK);
	
}

	@DeleteMapping("/dept/{deptId}")
	public void deleteARecord(@PathVariable Integer deptId) {
		deptRepo.deleteById(deptId);
	}
		
}