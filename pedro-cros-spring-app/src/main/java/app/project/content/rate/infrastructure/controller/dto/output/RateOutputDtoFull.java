package app.project.content.rate.infrastructure.controller.dto.output;

import app.project.content.pack.infrastructure.controller.dto.output.PackOutputDtoFull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RateOutputDtoFull {

    private Long idRate;
    private Double pricePerHour;
    private List<PackOutputDtoFull> packs;
}
