package xyz.lexops.pontomaismais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lexops.pontomaismais.exceptions.EmployeeNotFoundException;
import xyz.lexops.pontomaismais.exceptions.UserNotFoundException;
import xyz.lexops.pontomaismais.model.Employee;
import xyz.lexops.pontomaismais.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        findById(id);
        employeeRepository.deleteById(id);
    }

}
