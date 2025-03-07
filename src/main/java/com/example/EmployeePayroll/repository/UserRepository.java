
package com.example.EmployeePayroll.repository;

import com.example.EmployeePayroll.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
