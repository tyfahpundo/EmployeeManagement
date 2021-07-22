package zw.co.afrosoft.employeemanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Employee> getEmployees(){

        return service.getEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee getSingleEmployee(@PathVariable long id)
    {
        return service.getSingleEmployee(id);
    }
    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){

        return service.saveEmployee(employee);
    }
    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam Long id){

        service.deleteEmployee(id);
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        employee.setId(id);
        return service.updateEmployee(employee);
    }
}
