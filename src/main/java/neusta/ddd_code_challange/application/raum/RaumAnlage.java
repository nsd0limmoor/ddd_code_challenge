package neusta.ddd_code_challange.application.raum;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.domain.raum.Raum;
import neusta.ddd_code_challange.domain.raum.RaumRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RaumAnlage {

  private RaumRepository raumRepository;

  public void legeRaumAn(String nummer, String name) {
    final var raum = new Raum(nummer, name);
    pruefeEindeutigkeit(raum.getNummer());
    raumRepository.legeRaumAn(raum);
  }

  private void pruefeEindeutigkeit(final Raum.Nummer nummer) {
    if (raumRepository.ladeRaum(nummer) != null) {
      throw new IllegalArgumentException("Le Raum n'existe pas");
    }
  }
}
