package neusta.ddd_code_challange.application.person;


import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.domain.person.Person;
import neusta.ddd_code_challange.domain.person.PersonRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonAbfrage {

  private final PersonRepository personRepository;

  public String leseKurzschreibweiseVonPerson(final Person.Id personId) {
    return personRepository.ladePerson(personId).getKurzschreibweise();
  }
}
