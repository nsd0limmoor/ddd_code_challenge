package neusta.ddd_code_challange.infrastructure.person.rest.dto;

public record PersonDto(
    String vorname,
    String nachname,
    String namenszusatz,
    String benutzername) {
}
