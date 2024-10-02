package org.example.movielistapp.presentationLayer;

import org.example.movielistapp.businessLogicLayer.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directors")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("")
    public ResponseEntity<List<DirectorResponseModel>> getDirectors() {
        return ResponseEntity.status(HttpStatus.OK).body(directorService.findAllDirectors());
    }

    @GetMapping("/{directorId}")
    public ResponseEntity<DirectorResponseModel> getDirectorByDirectorId(@PathVariable String directorId) {
        return ResponseEntity.status(HttpStatus.OK).body(directorService.findDirectorByDirectorId(directorId));
    }

    @PostMapping()
    public ResponseEntity<DirectorResponseModel> addDirector(@RequestBody DirectorRequestModel directorRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.addDirector(directorRequestDTO));
    }

    @PutMapping("/{directorId}")
    public ResponseEntity<DirectorResponseModel> updateDirector(@RequestBody DirectorRequestModel directorRequestDTO,
                                                                @PathVariable String directorId) {
        return ResponseEntity.status(HttpStatus.OK).body(directorService.updateDirector(directorRequestDTO, directorId));
    }

    @DeleteMapping("/{directorId}")
    public ResponseEntity<Void> deleteDirector(@PathVariable String directorId) {
        directorService.deleteDirectorByDirectorId(directorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

