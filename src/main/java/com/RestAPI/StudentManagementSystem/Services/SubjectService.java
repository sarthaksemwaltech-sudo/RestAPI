package com.RestAPI.StudentManagementSystem.Services;

import com.RestAPI.StudentManagementSystem.DTO.SubjectDTO;
import com.RestAPI.StudentManagementSystem.Entity.SubjectEntity;
import com.RestAPI.StudentManagementSystem.Repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubjectService {


    //Varible for the DI
    private SubjectRepository subjectRepository;
    private ModelMapper modelMapper;



    //Dependancy injection

    public SubjectService(SubjectRepository subjectRepository, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
    }



    //Method to create the subject inside the DB
    public SubjectDTO insertSubject(SubjectDTO subjectDTO) {

        SubjectEntity subject = modelMapper.map(subjectDTO, SubjectEntity.class);

        subjectRepository.save(subject);

        return modelMapper.map(subject, SubjectDTO.class);
    }

    public List<SubjectDTO> getAllSubjectService() {

        List<SubjectEntity> subjects = subjectRepository.findAll();

        return subjects.
                stream().
                map(subject -> modelMapper.map(subject, SubjectDTO.class)).
                toList();
    }


    //Method to Get Subject By ID

    public SubjectDTO getSubjectByIdService(Long id) {

        SubjectEntity subject = subjectRepository.findById(id).orElseThrow();

        return modelMapper.map(subject, SubjectDTO.class);


    }


    //Method to Update Subject
    public SubjectDTO updateSubjectService(Long id, SubjectDTO subjectDTO) {

        SubjectEntity subject = modelMapper.map(subjectDTO, SubjectEntity.class);

        subject.setId(id);

        subjectRepository.save(subject);


        return modelMapper.map(subject, SubjectDTO.class);


    }


    //Method to Delete Subject By ID

    public Boolean deleteSubjectService(Long id) {
        if(!subjectRepository.existsById(id)) {
            throw new NoSuchElementException("Entity Not Found");
        }

        subjectRepository.deleteById(id);

        return true;
    }
}