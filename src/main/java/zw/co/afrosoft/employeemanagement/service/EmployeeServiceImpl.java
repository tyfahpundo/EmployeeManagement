package zw.co.afrosoft.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.employeemanagement.domain.Employee;
import zw.co.afrosoft.employeemanagement.persistence.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber,pageSize);
        return repo.findAll(pages).getContent();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = repo.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new RuntimeException("Employee Not Found...!!");
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByAge(Long age) {
        return repo.findByAge(age);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return repo.findByNameAndLocation(name,location);
    }

    @Override
    public List<Employee> getEmployeesContaining(String name) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return repo.findByNameContaining(name, sort);
    }

    @Override
    public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
        return repo.getEmployeeByNameOrLocation(name,location);
    }

    @Override
    public Integer deleteEmployeeByName(String name) {
        return repo.deleteEmployeeByName(name);
    }
}
