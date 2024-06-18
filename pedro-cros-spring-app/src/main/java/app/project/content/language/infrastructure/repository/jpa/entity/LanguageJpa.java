package app.project.content.language.infrastructure.repository.jpa.entity;

import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "language")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LanguageJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_language")
    private Long idLanguage;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @ManyToMany(mappedBy = "languages")
    @Column(name = "agreements")
    private List<AgreementJpa> agreements;
}
