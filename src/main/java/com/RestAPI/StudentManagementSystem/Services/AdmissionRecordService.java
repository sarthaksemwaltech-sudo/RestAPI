package com.RestAPI.StudentManagementSystem.Services;

import com.RestAPI.StudentManagementSystem.DTO.AdmissionRecordDTO;
import com.RestAPI.StudentManagementSystem.Entity.AdmissionRecordEntity;
import com.RestAPI.StudentManagementSystem.Repository.AdmissionRecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdmissionRecordService {


    //Varible for the DI
    private AdmissionRecordRepository admissionRecordRepository;
    private ModelMapper modelMapper;



    //Dependancy injection

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, ModelMapper modelMapper) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.modelMapper = modelMapper;
    }



    //Method to create the admission record inside the DB
    public AdmissionRecordDTO insertAdmissionRecord(AdmissionRecordDTO admissionRecordDTO) {

        AdmissionRecordEntity admissionRecord = modelMapper.map(admissionRecordDTO, AdmissionRecordEntity.class);

        admissionRecordRepository.save(admissionRecord);

        return modelMapper.map(admissionRecord, AdmissionRecordDTO.class);
    }

    public List<AdmissionRecordDTO> getAllAdmissionRecordService() {

        List<AdmissionRecordEntity> admissionRecords = admissionRecordRepository.findAll();

        return admissionRecords.
                stream().
                map(admissionRecord -> modelMapper.map(admissionRecord, AdmissionRecordDTO.class)).
                toList();
    }


    //Method to Get Admission Record By ID

    public AdmissionRecordDTO getAdmissionRecordByIdService(Long id) {

        AdmissionRecordEntity admissionRecord = admissionRecordRepository.findById(id).orElseThrow();

        return modelMapper.map(admissionRecord, AdmissionRecordDTO.class);


    }


    //Method to Update Admission Record
    public AdmissionRecordDTO updateAdmissionRecordService(Long id, AdmissionRecordDTO admissionRecordDTO) {

        AdmissionRecordEntity admissionRecord = modelMapper.map(admissionRecordDTO, AdmissionRecordEntity.class);

        admissionRecord.setId(id);

        admissionRecordRepository.save(admissionRecord);


        return modelMapper.map(admissionRecord, AdmissionRecordDTO.class);


    }


    //Method to Delete Admission Record By ID

    public Boolean deleteAdmissionRecordService(Long id) {
        if(!admissionRecordRepository.existsById(id)) {
            throw new NoSuchElementException("Entity Not Found");
        }

        admissionRecordRepository.deleteById(id);

        return true;
    }
}