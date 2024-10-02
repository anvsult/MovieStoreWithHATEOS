package org.example.movielistapp.businessLogicLayer;


import org.example.movielistapp.dataAcesssLayer.Director;
import org.example.movielistapp.dataAcesssLayer.DirectorRepository;
import org.example.movielistapp.dataMapperLayer.DirectorRequestMapper;
import org.example.movielistapp.dataMapperLayer.DirectorResponseMapper;
import org.example.movielistapp.presentationLayer.DirectorRequestModel;
import org.example.movielistapp.presentationLayer.DirectorResponseModel;
import org.example.movielistapp.utils.exceptions.InUseException;
import org.example.movielistapp.utils.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DirectorServiceImpl implements DirectorService{

    private final DirectorRepository directorRepository;
    private final DirectorRequestMapper directorRequestMapper;
    private final DirectorResponseMapper directorResponseMapper;

    public DirectorServiceImpl(DirectorRepository directorRepository,
                               DirectorRequestMapper directorRequestMapper,
                               DirectorResponseMapper directorResponseMapper) {
        this.directorRepository = directorRepository;
        this.directorRequestMapper = directorRequestMapper;
        this.directorResponseMapper = directorResponseMapper;
    }

    @Override
    public List<DirectorResponseModel> findAllDirectors() {
        List<Director> directorEntities = directorRepository.findAll();
        //convert list of Director entities to list of DirectorResponseModel
        return this.directorResponseMapper.entityListToResponseModelList( directorEntities );
    }

    @Override
    public DirectorResponseModel findDirectorByDirectorId(String directorId) {
        Director foundDirector = directorRepository.findDirectorByDirectorId(directorId);
        if (foundDirector == null) {
            throw new NotFoundException("Unknown director id: " + directorId);
        }
        //convert Director entity to DirectorResponseModel
        return this.directorResponseMapper.entityToResponseModel(foundDirector);
    }

    @Override
    public DirectorResponseModel addDirector(DirectorRequestModel directorRequestModel) {
        //convert DirectorRequestModel to an Entity
        Director director = this.directorRequestMapper.requestModelToEntity(directorRequestModel);
//        BeanUtils.copyProperties(DirectorRequestModel, director);
//        director.setDirectorId(UUID.randomUUID().toString());
        //save director entity to database via repository
        Director savedDirector = directorRepository.save(director);
        //convert savedDirector (entity) to DirectorResponseModel
        return this.directorResponseMapper.entityToResponseModel(savedDirector);
    }

    @Override
    public DirectorResponseModel updateDirector(DirectorRequestModel DirectorRequestModel, String directorId) {
        Director foundDirector = directorRepository.findDirectorByDirectorId(directorId);
        if (foundDirector == null) {
            throw new NotFoundException("Unknown director id: " + directorId);
        }
        //convert movieRequestDTO to an Entity
        Director director = new Director();
        BeanUtils.copyProperties(DirectorRequestModel, director);
        director.setDirectorId(foundDirector.getDirectorId()); // important
        director.setId(foundDirector.getId());  // important
        //save director entity to director repository
        Director savedDirector = directorRepository.save(director);
        //convert savedDirector (entity) to DirectorResponseModel
        return this.directorResponseMapper.entityToResponseModel(savedDirector);
    }

    @Override
    public void deleteDirectorByDirectorId(String directorId) {
        Director foundDirector = directorRepository.findDirectorByDirectorId(directorId);
        if (foundDirector == null) {
            throw new NotFoundException("Unknown director id: " + directorId);
        }
        try {
            directorRepository.delete(foundDirector);
        } catch (DataIntegrityViolationException ex) {
            throw new InUseException("Cannot delete director with directorId: " + directorId +
                    " as it is currently assigned to one or more movies.");
        }

    }
}
