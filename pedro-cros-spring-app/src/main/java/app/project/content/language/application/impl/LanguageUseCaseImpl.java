package app.project.content.language.application.impl;

import app.project.content.language.application.LanguageUseCase;
import app.project.content.language.domain.entity.Language;
import app.project.content.language.domain.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageUseCaseImpl implements LanguageUseCase {

    private final LanguageRepository languageRepository;


    @Override
    public Long save(Language language) {

        return languageRepository.save(language);
    }

    @Override
    public Language findById(Long idLanguage) {

        return languageRepository.findById(idLanguage);
    }

    @Override
    public List<Language> findAll() {

        return languageRepository.findAll();
    }

    @Override
    public Language update(Language language) {

        return languageRepository.update(language);
    }

    @Override
    public Boolean delete(Long idLanguage) {

        return languageRepository.delete(idLanguage);
    }
}
