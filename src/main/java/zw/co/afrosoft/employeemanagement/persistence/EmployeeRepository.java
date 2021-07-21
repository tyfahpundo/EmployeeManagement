package zw.co.afrosoft.employeemanagement.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.employeemanagement.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
