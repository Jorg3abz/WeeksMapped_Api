package org.jorge.weeksmapped.Dto;

import java.time.LocalDate;

public record PersonResponse (
        String user,
        String fullName,
        LocalDate dateOfBirth
){}
