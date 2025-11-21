package neusta.ddd_code_challange.domain.raum;

import neusta.ddd_code_challange.domain.person.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface RaumRepository {

    Raum ladeRaum(Raum.Nummer nummer);

    Raum legeRaumAn(Raum raum);

    Raum aktualisiereRaum(Raum raum);

    boolean existiertBelegungFuerPerson(Person.Id personId);
}
