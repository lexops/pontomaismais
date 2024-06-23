package xyz.lexops.pontomaismais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.lexops.pontomaismais.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
