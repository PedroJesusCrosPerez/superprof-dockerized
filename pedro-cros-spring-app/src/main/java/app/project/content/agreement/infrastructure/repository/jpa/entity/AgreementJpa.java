package app.project.content.agreement.infrastructure.repository.jpa.entity;

import app.project.content.language.infrastructure.repository.jpa.entity.LanguageJpa;
import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import app.project.shared.enums.EPlace;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "agreement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgreementJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agreement")
    private Long idAgreement;

    @Column(name = "title", nullable = false)
    @Size(min = 10, max = 100, message = "El título debe tener entre 10 y 100 caracteres")
    private String title;

    @Column(name = "description", nullable = false, length = 250)
    @Size(min = 10, max = 250, message = "La descripción debe tener entre 10 y 250 caracteres")
    private String description;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive = true;

    @ManyToMany
    @JoinTable(
            name = "agreement_subject",
            joinColumns = @JoinColumn(name = "agreement_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<SubjectJpa> subjects;

    @ElementCollection(targetClass = EPlace.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "agreement_place")
    @Column(name = "places", nullable = false)
    private List<EPlace> places;

    @ManyToMany
    @JoinTable(
            name = "agreement_language",
            joinColumns = @JoinColumn(name = "agreement_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<LanguageJpa> languages;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rate", referencedColumnName = "id_rate")
    private RateJpa rate;


    public void addSubject(SubjectJpa subject) {
        if (Objects.isNull(this.subjects)) {
            this.subjects = new ArrayList<>();
        }
        this.subjects.add(subject);
    }
    public void removeSubject(SubjectJpa subject) {
        if (Objects.isNull(this.subjects)) {
            this.subjects = new ArrayList<>();
        }
        this.subjects.remove(subject);
    }
}
