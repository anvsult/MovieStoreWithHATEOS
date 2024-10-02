package org.example.movielistapp.businessLogicLayer;


import org.example.movielistapp.presentationLayer.DirectorRequestModel;
import org.example.movielistapp.presentationLayer.DirectorResponseModel;

import java.util.List;

public interface DirectorService {

    List<DirectorResponseModel> findAllDirectors();
    DirectorResponseModel findDirectorByDirectorId(String directorId);
    DirectorResponseModel addDirector(DirectorRequestModel directorRequestDTO);
    DirectorResponseModel updateDirector(DirectorRequestModel directorRequestDTO, String directorId);
    void deleteDirectorByDirectorId(String directorId);
}
