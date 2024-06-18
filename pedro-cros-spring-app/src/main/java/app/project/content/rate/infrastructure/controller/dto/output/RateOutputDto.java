package app.project.content.rate.infrastructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RateOutputDto {

    private Long idRate;
    private Double rate;
}
