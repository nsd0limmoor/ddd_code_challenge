package neusta.ddd_code_challange.infrastructure.raum.rest;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.application.person.PersonAbfrage;
import neusta.ddd_code_challange.application.raum.RaumAbfrage;
import neusta.ddd_code_challange.application.raum.RaumAnlage;
import neusta.ddd_code_challange.application.raum.RaumBelegung;
import neusta.ddd_code_challange.domain.person.Person;
import neusta.ddd_code_challange.domain.raum.Raum;
import neusta.ddd_code_challange.infrastructure.raum.rest.dto.RaumBelegungDto;
import neusta.ddd_code_challange.infrastructure.raum.rest.dto.RaumDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
class RaumController {

  private final RaumAnlage raumAnlage;

  private final RaumAbfrage raumAbfrage;

  private final RaumBelegung raumBelegung;

  private final PersonAbfrage personAbfrage;

  @PostMapping
  RaumDto createRoom(@RequestBody final RaumDto raum) {
    final var created = raumAnlage.legeRaumAn(raum.getNummer(), raum.getName());
    List<RaumBelegungDto> personDtos = null;
    if (created.getPersonen() != null && !created.getPersonen().isEmpty()) {
      personDtos = created.getPersonen().stream()
          .map(personAbfrage::leseKurzschreibweiseVonPerson)
          .map(RaumBelegungDto::new)
          .toList();
    }
    return new RaumDto(created.getId().id(), created.getNummer().value(), created.getName().value(), personDtos);
  }

  @GetMapping("/{id}")
  RaumDto findRoom(@PathVariable final UUID id) {
    final var raum = raumAbfrage.ladeRaum(new Raum.Id(id));
    final var personDtos = raum.getPersonen().stream()
        .map(personAbfrage::leseKurzschreibweiseVonPerson)
        .map(RaumBelegungDto::new)
        .toList();

    return new RaumDto(raum.getId().id(), raum.getNummer().value(), raum.getName().value(), personDtos);
  }

  @PutMapping("/{roomId}/person/{personId}")
  RaumDto addPersonToRoom(@PathVariable final UUID roomId, @PathVariable final UUID personId) {
    final Raum raum = raumBelegung.fuegePersonZuRaumHinzu(new Raum.Id(roomId), new Person.Id(personId));
    final var personDtos = raum.getPersonen().stream()
        .map(personAbfrage::leseKurzschreibweiseVonPerson)
        .map(RaumBelegungDto::new)
        .toList();

    return new RaumDto(raum.getId().id(), raum.getNummer().value(), raum.getName().value(), personDtos);
  }
}
