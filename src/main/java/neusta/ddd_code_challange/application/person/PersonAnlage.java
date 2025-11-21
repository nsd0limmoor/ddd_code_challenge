package neusta.ddd_code_challange.application.person;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.domain.person.Person;
import neusta.ddd_code_challange.domain.person.PersonRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonAnlage {

    private final PersonRepository personRepository;

    public Person legePersonAn(
        final String vorname,
        final String nachname,
        final String namensZusatz,
        final String benutzerName) {

        if (personRepository.existiertBenutzername(benutzerName)) {
            throw new IllegalArgumentException("Benutzername existiert bereits");
        }

        final var person = new Person(vorname, nachname, namensZusatz, benutzerName);
        return personRepository.legePersonAn(person);
    }
}
