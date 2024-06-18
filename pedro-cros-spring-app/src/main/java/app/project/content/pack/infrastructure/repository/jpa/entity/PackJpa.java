package app.project.content.pack.infrastructure.repository.jpa.entity;

import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pack")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PackJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pack")
    private Long idPack;

    @Column(name = "hours", nullable = false)
    private String hours;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_RATE", nullable = false, updatable = false)
    private RateJpa rate;
}
