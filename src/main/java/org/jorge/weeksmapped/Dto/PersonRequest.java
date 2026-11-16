package org.jorge.weeksmapped.Dto;


import java.time.LocalDate;

public record PersonRequest (
        String user,
        String fullName,
        LocalDate dateOfBirth
){}