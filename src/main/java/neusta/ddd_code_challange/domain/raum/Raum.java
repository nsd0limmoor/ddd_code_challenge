package neusta.ddd_code_challange.domain.raum;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import lombok.Getter;
import neusta.ddd_code_challange.domain.person.Person;

@Getter
public class Raum {

    private final Id id;
    private final Nummer nummer;
    private final Name name;
    private final Set<Person.Id> personen;

    public Raum(String nummer, String name) {
        id = new Id(UUID.randomUUID());
        this.nummer = new Nummer(nummer);
        this.name = new Name(name);
        personen = new HashSet<>();
    }

    public void fuegePersonHinzu(Person.Id personId) {
        personen.add(personId);
    }

    public Set<Person.Id> getPersonen() {
        return Set.copyOf(personen);
    }

    public record Id(UUID id) {
    }

    public record Nummer(String value) {

        public Nummer {
            validiere(value);
        }

        private void validiere(final String nummer) {
            if (nummer == null || nummer.isBlank()) {
                throw new IllegalArgumentException("Nummer must not be empty");
            }
            if (nummer.length() != 4) {
                throw new IllegalArgumentException("Nummer must be 4 characters");
            }
            if (!nummer.matches("\\d+")) {
                throw new IllegalArgumentException("Nummer must only contain digits");
            }
        }
    }

    public record Name(String value) {

        public Name {
            validiere(value);
        }

        private void validiere(final String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            if (name.length() > 100) {
                throw new IllegalArgumentException("Name must not be longer than 100 characters");
            }
        }
    }
}
