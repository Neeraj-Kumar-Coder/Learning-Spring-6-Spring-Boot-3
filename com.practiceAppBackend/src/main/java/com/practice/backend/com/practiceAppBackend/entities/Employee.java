package com.practice.backend.com.practiceAppBackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "joining_date", nullable = false)
    @CreationTimestamp
    private Date joiningDate;

    @Column(name = "last_details_updation_date", nullable = false)
    @UpdateTimestamp
    private Date lastDetailsUpdationDate;
}
