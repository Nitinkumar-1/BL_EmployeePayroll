
package com.example.EmployeePayroll.service;

import com.example.EmployeePayroll.dto.EmployeeDTO;
import com.example.EmployeePayroll.model.User;
import com.example.EmployeePayroll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//services added
@Service
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;

    // Create Employee
    public User createEmployee(EmployeeDTO userDTO) {
        User employee = new User(userDTO);
        return userRepository.save(employee);
    }

    // Get all employees
    public List<User> getAllEmployees() {
        return userRepository.findAll();
    }

    // Get employee by ID
    public Optional<User> getEmployeeById(Long id) {
        return userRepository.findById(id);
    }

    // Update Employee
    public User updateEmployee(Long id, EmployeeDTO userDTO) {
        Optional<User> existingEmployee = userRepository.findById(id);
        if (existingEmployee.isPresent()) {
            User emp = existingEmployee.get();
            emp.setName(userDTO.getName());
            emp.setEmail(userDTO.getEmail());
            emp.setSalary(userDTO.getSalary());
            return userRepository.save(emp);
        }
        return null; // Or throw an exception
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
