package com.RestAPI.StudentManagementSystem.Services;

import com.RestAPI.StudentManagementSystem.DTO.ProfessorDTO;
import com.RestAPI.StudentManagementSystem.DTO.StudentDTO;
import com.RestAPI.StudentManagementSystem.Entity.ProfessorEntity;
import com.RestAPI.StudentManagementSystem.Entity.StudentEntity;
import com.RestAPI.StudentManagementSystem.Repository.ProfessorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    private ModelMapper modelMapper;


    public ProfessorService(ProfessorRepository professorRepository,ModelMapper modelMapper) {

        this.professorRepository = professorRepository;
        this.modelMapper=modelMapper;
    }



    public ProfessorDTO insertProfessorService(ProfessorDTO professorDTO) {

        ProfessorEntity professor=modelMapper.map(professorDTO,ProfessorEntity.class);

        professorRepository.save(professor);

        return modelMapper.map(professor, ProfessorDTO.class);

    }




    public List<ProfessorDTO> getAllProfessorService() {

        List<ProfessorEntity>professors=professorRepository.findAll();

        return professors.
                stream().
                map(professor->modelMapper.map(professor,ProfessorDTO.class)).
                toList();
    }



    public ProfessorDTO getProfessorByIdService(Long id) {

        ProfessorEntity professor=professorRepository.findById(id).orElseThrow();

        return modelMapper.map(professor,ProfessorDTO.class);
    }



    public ProfessorDTO updateProfessorService(Long id, ProfessorDTO professorDTO) {

        ProfessorEntity professor =modelMapper.map(professorDTO,ProfessorEntity.class);

        professor.setId(id);

        professorRepository.save(professor);


        return modelMapper.map(professor,ProfessorDTO.class);
    }



    public Boolean deleteProfessorService(Long id) {

        if(!professorRepository.existsById(id)) {
            throw new NoSuchElementException("Entity Not Found");
        }

        professorRepository.deleteById(id);

        return true;
    }



}
