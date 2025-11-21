package neusta.ddd_code_challange.infrastructure.person.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import neusta.ddd_code_challange.domain.person.Person;
import neusta.ddd_code_challange.domain.person.PersonRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final Map<Person.Id, Person> personen = new HashMap<>();

    @Override
    public Person legePersonAn(final Person person) {
        personen.putIfAbsent(person.getId(), person);
        return person;
    }

    @Override
    public Person ladePerson(final Person.Id id) {
        return personen.get(id);
    }

    @Override
    public boolean existiertBenutzername(String benutzerName) {
        Collection<Person> personenCollection = personen.values();
        return personenCollection.stream()
            .anyMatch(person -> person.getBenutzerName().benutzerName().equals(benutzerName));
    }
}
