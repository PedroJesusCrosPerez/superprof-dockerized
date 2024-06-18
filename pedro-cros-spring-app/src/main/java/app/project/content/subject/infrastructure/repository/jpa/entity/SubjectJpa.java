package app.project.content.subject.infrastructure.repository.jpa.entity;

import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Long idSubject;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<AgreementJpa> agreements;
}
