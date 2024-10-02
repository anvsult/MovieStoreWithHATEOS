package org.example.movielistapp.dataAcesssLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {



    Director findDirectorByDirectorId(String directorId);


}
