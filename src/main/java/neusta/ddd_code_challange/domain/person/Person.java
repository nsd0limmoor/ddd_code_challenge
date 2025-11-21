package neusta.ddd_code_challange.domain.person;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Person {

  private final Id id;
  private final Name name;
  private final BenutzerName benutzerName;

  public Person(String vorname, String nachname, String benutzerName) {
    this.id = new Id(java.util.UUID.randomUUID());
    this.name = new Name(vorname, nachname);
    this.benutzerName = new BenutzerName(benutzerName);
  }

  public Person(String vorname, String nachname, String namensZusatz, String benutzerName) {
    this.id = new Id(java.util.UUID.randomUUID());
    this.name = new Name(vorname, nachname, namensZusatz);
    this.benutzerName = new BenutzerName(benutzerName);
  }

  public String getKurzschreibweise() {
    return name.vorname + (name.namensZusatz != null ? " " + name.namensZusatz : " ") + name.nachname + " (" + benutzerName + ")";
  }

  public record Id(UUID id) {
  }

  @Getter
  public static final class Name {
    private final String vorname;

    private final String nachname;

    private final String namensZusatz;

    private final List<String> erlaubteNamensZusaetze = List.of("von", "van", "de");

    private Name(String vorname, String nachname, String namensZusatz) {
      validiere(vorname, nachname, namensZusatz);

      this.vorname = vorname;
      this.nachname = nachname;
      this.namensZusatz = namensZusatz;
    }

    public Name(String vorname, String nachname) {
      this(vorname, nachname, null);
    }

    private void validiere(final String vorname, final String nachname, final String namensZusatz) {
      if (vorname.isBlank()) {
        throw new IllegalArgumentException("Vorname must not be empty");
      }
      if (nachname.isBlank()) {
        throw new IllegalArgumentException("Nachname must not be empty");
      }
      if (vorname.length() > 100) {
        throw new IllegalArgumentException("Vorname must not be longer than 100 characters");
      }
      if (nachname.length() > 100) {
        throw new IllegalArgumentException("Nachname must not be longer than 100 characters");
      }
      if ((namensZusatz != null && !namensZusatz.isBlank()) && !erlaubteNamensZusaetze.contains(namensZusatz)) {
        throw new IllegalArgumentException("Namenszusatz must be one of " + erlaubteNamensZusaetze);
      }
    }
  }

  public record BenutzerName(String benutzerName) {
  }
}
