package neusta.ddd_code_challange.infrastructure.person.rest.dto;

import java.util.UUID;

public record PersonDto(
    UUID id,
    String vorname,
    String nachname,
    String namenszusatz,
    String benutzername) {
}
