package neusta.ddd_code_challange.infrastructure.raum.rest.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RaumDto {

    private UUID id;
    private String nummer;
    private String name;
    private List<RaumBelegungDto> personen;

}
