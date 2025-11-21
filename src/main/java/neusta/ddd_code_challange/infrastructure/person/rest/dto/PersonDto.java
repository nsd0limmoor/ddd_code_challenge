package neusta.ddd_code_challange.infrastructure.person.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class PersonDto {
  private final String vorname;

  private final String nachname;

  private final String benutzername;

  private final String namenszusatz;

}
