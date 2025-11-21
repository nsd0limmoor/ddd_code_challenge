package neusta.ddd_code_challange.infrastructure.raum.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class RaumDto {

    private UUID id;
    private String nummer;
    private String name;
    private List<RaumBelegungDto> personen;

    @Data
    @AllArgsConstructor
    public static class RaumBelegungDto {

        private String person;
    }
}
