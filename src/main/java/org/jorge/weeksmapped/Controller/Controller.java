package org.jorge.weeksmapped.Controller;

import lombok.RequiredArgsConstructor;
import org.jorge.weeksmapped.Dto.PersonRequest;
import org.jorge.weeksmapped.Dto.PersonResponse;
import org.jorge.weeksmapped.Dto.PersonWeeksResponse;
import org.jorge.weeksmapped.Service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/WeeksMappedApi")
@RequiredArgsConstructor
public class Controller {

    private final PersonService personService;

    @PostMapping("/register")
    public ResponseEntity<PersonResponse> register(@RequestBody PersonRequest request){
        PersonResponse newPerson = personService.register(request);
        return new ResponseEntity<> (newPerson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/weeks")
    public  ResponseEntity<PersonWeeksResponse> getWeeksLived(@PathVariable Long id){
        PersonWeeksResponse response = personService.getWeeksLived(id);
        return ResponseEntity.ok(response);
    }
}