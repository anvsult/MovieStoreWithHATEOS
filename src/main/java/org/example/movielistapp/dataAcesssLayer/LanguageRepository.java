package org.example.movielistapp.dataAcesssLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Language findLanguageByLanguageId(String languageId);
}
