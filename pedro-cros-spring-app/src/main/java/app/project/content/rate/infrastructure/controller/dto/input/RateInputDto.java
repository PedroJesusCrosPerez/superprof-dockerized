package app.project.content.rate.infrastructure.controller.dto.input;

import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RateInputDto {

    private Double pricePerHour;
    private List<PackInputDto> packs;
}
