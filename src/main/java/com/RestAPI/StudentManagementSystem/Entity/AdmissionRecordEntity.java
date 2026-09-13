package com.RestAPI.StudentManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "AdmissionRecord")
public class AdmissionRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int fees;

    @OneToOne
    @JoinColumn(name = "Student_id")
    private StudentEntity student;
}
