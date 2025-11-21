package neusta.ddd_code_challange.application.raum;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.domain.raum.Raum;
import neusta.ddd_code_challange.domain.raum.RaumRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RaumAnlage {

  private final RaumRepository raumRepository;

  public Raum legeRaumAn(final String raumNummer, final String name) {
    final var raum = new Raum(raumNummer, name);
    pruefeEindeutigkeit(raum.getNummer());
    return raumRepository.legeRaumAn(raum);
  }

  private void pruefeEindeutigkeit(final Raum.Nummer raumNummer) {
    if (raumRepository.existiertRaumNummer(raumNummer)) {
      throw new IllegalArgumentException("Le Raum n'existe pas");
    }
  }
}
