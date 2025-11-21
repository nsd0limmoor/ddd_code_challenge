package neusta.ddd_code_challange.infrastructure.raum.rest.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RaumDto {

  private String nummer;

  private String name;

  private List<RaumBelegungDto> personen;

}
