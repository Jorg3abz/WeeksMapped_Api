package org.jorge.weeksmapped.Service;

import lombok.RequiredArgsConstructor;
import org.jorge.weeksmapped.Dto.PersonRequest;
import org.jorge.weeksmapped.Dto.PersonResponse;
import org.jorge.weeksmapped.Dto.PersonWeeksResponse;
import org.jorge.weeksmapped.Entity.Person;
import org.jorge.weeksmapped.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    //register
    public PersonResponse register(PersonRequest request) {
        if (personRepository.existsByUser(request.user())) {
            throw new RuntimeException("The user exists");
        }
        Person person = new Person();
        person.setUser(request.user());
        person.setFullName(request.fullName());
        person.setDateOfBirth(request.dateOfBirth());

        Person savedPerson = personRepository.save(person);
        return new PersonResponse(
                savedPerson.getUser(),
                savedPerson.getFullName(),
                savedPerson.getDateOfBirth()
        );
    }

    //Calculate weeks numbers
    public PersonWeeksResponse getWeeksLived(Long id){
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        long weeks = calculateWeeks(person);
        return new PersonWeeksResponse(
                person.getId(),
                person.getFullName(),
                weeks
        );
    }

    public long calculateWeeks(Person person){
        LocalDate today = LocalDate.now();
        return  ChronoUnit.WEEKS.between(person.getDateOfBirth(), today);
    }

}