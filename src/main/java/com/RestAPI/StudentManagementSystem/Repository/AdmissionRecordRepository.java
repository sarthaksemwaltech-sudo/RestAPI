package com.RestAPI.StudentManagementSystem.Repository;

import com.RestAPI.StudentManagementSystem.Entity.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity,Long> {
}
