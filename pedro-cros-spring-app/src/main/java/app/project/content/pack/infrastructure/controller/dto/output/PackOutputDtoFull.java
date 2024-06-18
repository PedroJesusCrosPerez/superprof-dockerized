package app.project.content.pack.infrastructure.controller.dto.output;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PackOutputDtoFull {

    private Long idPack;
    private String hours;
    private Double price;
}

