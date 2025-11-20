package neusta.ddd_code_challange.infrastructure.raum.rest;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.application.raum.RaumAbfrage;
import neusta.ddd_code_challange.application.raum.RaumAnlage;
import neusta.ddd_code_challange.infrastructure.raum.rest.dto.RaumDto;
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
  String createRoom(@RequestBody RaumDto raum) {

  }
}
