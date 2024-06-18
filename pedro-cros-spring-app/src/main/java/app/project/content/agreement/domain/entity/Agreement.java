package app.project.content.agreement.domain.entity;

import app.project.content.language.domain.entity.Language;
import app.project.content.rate.domain.entity.Rate;
import app.project.content.subject.domain.entity.Subject;
import app.project.shared.enums.EPlace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agreement {

    private Long idAgreement;
    private String title;
    private String description;
    private String aboutMe;
    private Boolean isActive;
    private List<Subject> subjects;
    private List<EPlace> places;
    private List<Language> languages;
    private Rate rate;


    public void addSubject(Subject subject) {
        if (Objects.isNull(this.subjects)) {
            this.subjects = new ArrayList<>();
        }
        this.subjects.add(subject);
    }
    public void removeSubject(Subject subject) {
        if (Objects.isNull(this.subjects)) {
            this.subjects = new ArrayList<>();
        }
        this.subjects.remove(subject);
    }

    public void addLanguage(Language language) {
        if (Objects.isNull(this.languages)) {
            this.languages = new ArrayList<>();
        }
        this.languages.add(language);
    }
    public void removeLanguage(Language language) {
        if (Objects.isNull(this.languages)) {
            this.languages = new ArrayList<>();
        }
        this.languages.remove(language);
    }

    public void addPlace(EPlace place) {
        if (Objects.isNull(this.places)) {
            this.places = new ArrayList<>();
        }
        this.places.add(place);
    }
    public void removePlace(EPlace place) {
        if (Objects.isNull(this.places)) {
            this.places = new ArrayList<>();
        }
        this.places.remove(place);
    }
}