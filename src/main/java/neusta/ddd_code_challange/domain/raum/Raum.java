package neusta.ddd_code_challange.domain.raum;

import java.util.UUID;
import lombok.Getter;

@Getter
public class Raum {

  private Id id;

  private Nummer nummer;

  private Name name;

  public Raum(String nummer, String name) {
    id = new Id(UUID.randomUUID());
    this.nummer = new Nummer(nummer);
    this.name = new Name(name);
  }

  @Getter
  public static class Id {
    private UUID id;

    public Id(UUID id) {
      this.id = id;
    }
  }

  @Getter
  public static class Nummer {

    private String value;

    public Nummer(final String nummer) {
      validiere(nummer);
      value = nummer;
    }

    private void validiere(final String nummer) {
      if (nummer == null || nummer.isBlank()) {
        throw new IllegalArgumentException("Nummer must not be empty");
      }
      if (nummer.length() == 4) {
        throw new IllegalArgumentException("Nummer must be 4 characters");
      }
      if (!nummer.matches("\\d+")) {
        throw new IllegalArgumentException("Nummer must only contain digits");
      }
    }
  }

  @Getter
  public static class Name {

    private String value;

    public Name(final String name) {
      validiere(name);
      value = name;
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
