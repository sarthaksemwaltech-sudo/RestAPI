package com.RestAPI.StudentManagementSystem.Repository;

import com.RestAPI.StudentManagementSystem.Entity.AdmissionRecordEntity;
import com.RestAPI.StudentManagementSystem.Entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Long> {
}
