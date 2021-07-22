package zw.co.afrosoft.employeemanagement.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import zw.co.afrosoft.employeemanagement.domain.Employee;

import java.util.List;
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {

    //JPA FINDER METHODS or QUERY METHODS
    List<Employee> findByName(String name);

    List<Employee> findByAge(long age);

    //SELECT * FROM table WHERE name=? AND location = ?
    List<Employee> findByNameAndLocation(String name, String location);

    //SELECT * FROM table WHERE name LIKE "%ram%"
    List<Employee> findByNameContaining(String keyword, Sort sort);
}
