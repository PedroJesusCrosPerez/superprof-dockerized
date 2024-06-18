package app.project.content.rate.domain.entity;

import app.project.content.pack.domain.entity.Pack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rate {

    private Long idRate;
    private Double pricePerHour;
    private List<Pack> packs;


    public void addPack(Pack pack) {
        if (packs == null) {
            packs = new ArrayList<>();
        }
        packs.add(pack);
//        pack.setRate(this);
    }
    public void removePack(Pack pack) {
        if (packs != null) {
            packs.remove(pack);
            if (packs.isEmpty()) {
                packs = null;
            }
//            else {
//                pack.setRate(null);
//            }
        }
    }
}
