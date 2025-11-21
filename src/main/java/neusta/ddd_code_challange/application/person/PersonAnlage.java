package neusta.ddd_code_challange.application.person;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.domain.person.Person;
import neusta.ddd_code_challange.domain.person.PersonRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonAnlage {

    private final PersonRepository personRepository;

    public Person legePersonAn(String vorname, String nachname, String benutzerName, Optional<String> namensZusatz) {

        if (personRepository.existiertBenutzername(benutzerName)) {
            throw new IllegalArgumentException("Benutzername existiert bereits");
        }

        final var person = new Person(vorname, nachname, benutzerName, namensZusatz.orElse(null));
        return personRepository.legePersonAn(person);
    }
}
