package neusta.ddd_code_challange.application.raum;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.domain.raum.Raum;
import neusta.ddd_code_challange.domain.raum.RaumRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RaumAbfrage {

  private final RaumRepository raumRepository;

  public Raum ladeRaum(String nummer) {
    final var raumNummer = new Raum.Nummer(nummer);
    return raumRepository.ladeRaum(raumNummer);
  }
}
