package neusta.ddd_code_challange.application.raum;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.domain.person.Person;
import neusta.ddd_code_challange.domain.person.PersonRepository;
import neusta.ddd_code_challange.domain.raum.Raum;
import neusta.ddd_code_challange.domain.raum.RaumRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RaumAktualisierung {

  private final RaumRepository raumRepository;

  private final PersonRepository personRepository;

  Raum fuegePersonZuRaumHinzu(String raumNummer, Person.Id personId) {

    final var person1 = personRepository.ladePerson(personId);
    if (person1 == null) {
      throw new IllegalArgumentException("Person does not exist, create person first");
    }

    final var raum = raumRepository.ladeRaum(new Raum.Nummer(raumNummer));
    if (raum == null) {
      throw new IllegalArgumentException("Raum does not exist, create room first");
    }
    //todo check if person is already in other room
    raum.fuegePersonHinzu(personId);
    return raumRepository.aktualisiereRaum(raum);
  }
}
