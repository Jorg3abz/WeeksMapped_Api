package org.jorge.weeksmapped;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.jorge.weeksmapped.Dto.PersonRequest;
import org.jorge.weeksmapped.Dto.PersonResponse;
import org.jorge.weeksmapped.Entity.Person;
import org.jorge.weeksmapped.Repository.PersonRepository;
import org.jorge.weeksmapped.Service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

//    private PersonService personService;
//
//    @BeforeEach
//    void setUp(){
//        personService = new PersonService(null);
//    }
//
//    @Test
//    @DisplayName("Test for calculate weeks")
//    void sholdCalculateWeeks(){
//        Person person = new Person();
//        person.setDateOfBirth(LocalDate.now().minusWeeks(100));
//
//        long result = personService.calculateWeeks(person);
//        assertEquals(100, result);
//    }

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    @DisplayName("Test whit mokito")
    void shoildRegisterPerson(){
        PersonRequest request = new PersonRequest(
                "jorge12",
                "Jorge Alvarez",
                LocalDate.of(2008, 5, 18)
        );
        when(personRepository.existsByUser("jorge12"))
                .thenReturn(false);

        when(personRepository.save(any(Person.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        PersonResponse response = personService.register(request);

        assertEquals("jorge12", response.user());
        assertEquals("Jorge Alvarez", response.fullName());
    }


}
