package app.project.content.rate.infrastructure.repository.jpa.entity;

import app.project.content.pack.infrastructure.repository.jpa.entity.PackJpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RateJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rate")
    private Long idRate;

    @Column(name = "price_hour", nullable = false)
    private Double pricePerHour;

//    @JsonManagedReference
    @OneToMany(mappedBy = "rate", cascade = CascadeType.ALL)//, orphanRemoval = true)
//    @OneToMany(mappedBy = "rateJpa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)//, orphanRemoval = true)
    private List<PackJpa> packs;

//    @OneToMany(mappedBy = "rateJpa",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<Pack> packs = new ArrayList<>();


    public void addPack(PackJpa pack) {
        if (packs == null) {
            packs = new ArrayList<>();
        }
        packs.add(pack);
//        packJpa.setRate(this);
    }
    public void removePack(PackJpa pack) {
        if (packs != null) {
            packs.remove(pack);
            if (packs.isEmpty()) {
                packs = null;
            }
//            else {
//                packJpa.setRate(null);
//            }
        }
    }
}
