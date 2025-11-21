package neusta.ddd_code_challange.infrastructure.raum.rest;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.application.raum.RaumAbfrage;
import neusta.ddd_code_challange.application.raum.RaumAnlage;
import neusta.ddd_code_challange.application.raum.RaumBelegung;
import neusta.ddd_code_challange.domain.person.Person;
import neusta.ddd_code_challange.domain.raum.Raum;
import neusta.ddd_code_challange.infrastructure.raum.rest.dto.RaumDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
class RaumController {

    private final RaumAnlage raumAnlage;
    private final RaumAbfrage raumAbfrage;
    private final RaumBelegung raumBelegung;


    @PostMapping
    RaumDto createRoom(@RequestBody RaumDto raum) {
        final var created = raumAnlage.legeRaumAn(raum.getNummer(), raum.getName());
        return new RaumDto(created.getNummer().getValue(), created.getName().getValue());
    }

    @GetMapping("/{id}")
    RaumDto findRoom(@PathVariable final String id) {
        final var raum = raumAbfrage.ladeRaum(id);
        return new RaumDto(raum.getNummer().getValue(), raum.getName().getValue());
    }

    @PutMapping("/{roomId}/person/{personId}")
    RaumDto addPersonToRoom(@PathVariable final UUID roomId, @PathVariable final UUID personId) {
        Raum raum = raumBelegung.fuegePersonZuRaumHinzu(new Raum.Id(roomId), new Person.Id(personId));
        //
        return new RaumDto(raum.getNummer().getValue(), raum.getName().getValue(), raum.getPersonen());
    }
}
