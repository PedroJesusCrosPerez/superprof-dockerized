package app.project.content.pack.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pack {

    private Long idPack;
    private String hours;
    private Double price;
//    private Rate rate;
}
