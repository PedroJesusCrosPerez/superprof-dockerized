package app.project.content.language.domain.repository;

import app.project.content.language.domain.entity.Language;
import app.project.shared.exceptions.NotFoundException;
import app.project.shared.exceptions.UnprocessableEntityException;

import java.util.List;

public interface LanguageRepository {

    Long save(Language language);

    Language findById(Long idLanguage) throws NotFoundException;

    List<Language> findAll();

    Language update(Language language) throws NotFoundException, UnprocessableEntityException;

    Boolean delete(Long idLanguage);
}
