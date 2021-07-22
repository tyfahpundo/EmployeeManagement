package zw.co.afrosoft.employeemanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.employeemanagement.domain.Employee;
import zw.co.afrosoft.employeemanagement.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>>  getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){

        return new ResponseEntity<List<Employee>>(service.getEmployees(pageNumber,pageSize),HttpStatus.OK) ;
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee>  getSingleEmployee(@PathVariable long id)
    {
        return new ResponseEntity<Employee>(service.getSingleEmployee(id),HttpStatus.OK) ;
    }
    @PostMapping("/employees")
    public ResponseEntity<Employee>  saveEmployee(@Valid @RequestBody Employee employee){

        return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.CREATED) ;
    }
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id){

       return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT) ;
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee>  updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<Employee>(service.updateEmployee(employee),HttpStatus.OK) ;
    }
    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(service.getEmployeesByName(name),HttpStatus.OK);
    }
    @GetMapping("/employees/filterByAge")
    public ResponseEntity<List<Employee>> getEmployeesByAge(@RequestParam Long age){
        return new ResponseEntity<List<Employee>>(service.getEmployeesByAge(age), HttpStatus.OK);
    }
    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
        return new ResponseEntity<List<Employee>>(service.getEmployeesByNameAndLocation(name, location),HttpStatus.OK);
    }
    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(service.getEmployeesContaining(name),HttpStatus.OK);
    }
}
