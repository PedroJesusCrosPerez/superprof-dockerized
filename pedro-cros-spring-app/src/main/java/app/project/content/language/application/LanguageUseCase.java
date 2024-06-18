package app.project.content.language.application;

import app.project.content.language.domain.entity.Language;

import java.util.List;

public interface LanguageUseCase {

    Long save(Language language);

    Language findById(Long idLanguage);

    List<Language> findAll();

    Language update(Language language);

    Boolean delete(Long idLanguage);
}
