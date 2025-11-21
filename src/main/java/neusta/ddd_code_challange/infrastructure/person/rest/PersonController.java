package neusta.ddd_code_challange.infrastructure.person.rest;

import lombok.RequiredArgsConstructor;
import neusta.ddd_code_challange.application.person.PersonAnlage;
import neusta.ddd_code_challange.infrastructure.person.rest.dto.PersonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonAnlage personAnlage;

    @PostMapping
    public PersonDto createPerson(@RequestBody final PersonDto personDto) {
        final var created = personAnlage.legePersonAn(
            personDto.vorname(),
            personDto.nachname(),
            personDto.namenszusatz(), personDto.benutzername()
        );

        return new PersonDto(
            created.getId().id(),
            created.getName().getVorname(),
            created.getName().getNachname(),
            created.getName().getNamensZusatz(),
        created.getBenutzerName().benutzerName());
    }
}
