package neusta.ddd_code_challange.infrastructure.raum.repository;

import java.util.HashMap;
import java.util.Map;
import neusta.ddd_code_challange.domain.person.Person;
import neusta.ddd_code_challange.domain.raum.Raum;
import neusta.ddd_code_challange.domain.raum.RaumRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RaumRepositoryImpl implements RaumRepository {

  private final Map<Raum.Id, Raum> raeume = new HashMap<>();

  @Override
  public Raum ladeRaum(final Raum.Id raumId) {
    return raeume.get(raumId);
  }

  @Override
  public Raum legeRaumAn(final Raum raum) {
    raeume.put(raum.getId(), raum);
    return raum;
  }

  @Override
  public boolean existiertRaumNummer(final Raum.Nummer raumNummer) {
    return raeume.values().stream().anyMatch(r -> r.getNummer().equals(raumNummer));
  }

  @Override
  public Raum aktualisiereRaum(final Raum raum) {
    return raeume.put(raum.getId(), raum);
  }

  @Override
  public boolean existiertBelegungFuerPerson(Person.Id personId) {
    return raeume.values().stream()
        .anyMatch(raum -> raum.getPersonen().contains(personId));
  }
}
