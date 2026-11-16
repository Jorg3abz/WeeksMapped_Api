package org.jorge.weeksmapped.Dto;

public record PersonWeeksResponse(
        Long id,
        String fullName,
        long weeksLived
) {
}
