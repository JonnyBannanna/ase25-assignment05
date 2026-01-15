package de.unibayreuth.se.taskboard.api.dtos;

import java.time.LocalDateTime;
import java.util.UUID;


// Add DTO for users.
// NOTE: Minimum requirements from UserDtoMapperImpl, line 31, and UserDtoMapper, line 23
public record UserDto(
    UUID id,
    String name,
    String email,
    String role,
    LocalDateTime createdAt
) { }
