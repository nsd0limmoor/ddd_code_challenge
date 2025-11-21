package neusta.ddd_code_challange.infrastructure.raum.repository;

import java.util.HashMap;
import java.util.Map;

import neusta.ddd_code_challange.domain.person.Person;
import neusta.ddd_code_challange.domain.raum.Raum;
import neusta.ddd_code_challange.domain.raum.RaumRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RaumRepositoryImpl implements RaumRepository {

    private final Map<Raum.Nummer, Raum> raeume = new HashMap<>();

    @Override
    public Raum ladeRaum(final Raum.Nummer nummer) {
        return raeume.get(nummer);
    }

    @Override
    public Raum legeRaumAn(final Raum raum) {
        return raeume.putIfAbsent(raum.getNummer(), raum);
    }

    @Override
    public Raum aktualisiereRaum(final Raum raum) {
        return raeume.put(raum.getNummer(), raum);
    }

    @Override
    public boolean existiertBelegungFuerPerson(Person.Id personId) {
        return raeume.values().stream()
            .anyMatch(raum -> raum.getPersonen().contains(personId));
    }
}
