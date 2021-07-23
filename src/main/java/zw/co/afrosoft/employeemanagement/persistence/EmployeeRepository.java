package zw.co.afrosoft.employeemanagement.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

    //SELECT * FROM table WHERE name=? OR location=?
    @Query("FROM Employee WHERE name = :name OR location = :location ")
    List<Employee> getEmployeeByNameOrLocation(String name, String location);

    //DELETE FROM table WHERE name=?
    @Transactional
    @Modifying
    @Query("DELETE FROM Employee WHERE name = :name")
    Integer deleteEmployeeByName(String name);
}
