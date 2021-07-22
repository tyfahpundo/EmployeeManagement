package zw.co.afrosoft.employeemanagement.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.employeemanagement.domain.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //JPA FINDER METHODS or QUERY METHODS
    List<Employee> findByName(String name);

    List<Employee> findByAge(long age);

    //SELECT * FROM table WHERE name=? AND location = ?
    List<Employee> findByNameAndLocation(String name, String location);
}
