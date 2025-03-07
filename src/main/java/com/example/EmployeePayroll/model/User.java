
package com.example.EmployeePayroll.model;
import com.example.EmployeePayroll.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String salary;

    // Constructor to map DTO to Entity
    public User(EmployeeDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.salary = userDTO.getSalary();
    }
}
