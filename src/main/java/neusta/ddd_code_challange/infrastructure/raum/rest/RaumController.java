package neusta.ddd_code_challange.infrastructure.raum.rest;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.application.raum.RaumAbfrage;
import neusta.ddd_code_challange.application.raum.RaumAnlage;
import neusta.ddd_code_challange.infrastructure.raum.rest.dto.RaumDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class RaumController {

  private final RaumAnlage raumAnlage;

  private final RaumAbfrage raumAbfrage;


  @RequestMapping("/hello")
  String hello() {
    return "Hello World!";
  }

  @PostMapping("/room")
  RaumDto createRoom(@RequestBody RaumDto raum) {
    final var created = raumAnlage.legeRaumAn(raum.getNummer(), raum.getName());
    return new RaumDto(created.getNummer().getValue(), created.getName().getValue());
  }

  @GetMapping("/room/{id}")
  RaumDto findRoom(@PathVariable final String id) {
    final var raum = raumAbfrage.ladeRaum(id);
    return new RaumDto(raum.getNummer().getValue(), raum.getName().getValue());
  }
}
