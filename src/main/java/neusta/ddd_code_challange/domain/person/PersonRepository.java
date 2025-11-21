package neusta.ddd_code_challange.domain.person;

public interface PersonRepository {

    Person legePersonAn(Person person);

    Person ladePerson(Person.Id id);

    boolean existiertBenutzername(String benutzerName);
}
