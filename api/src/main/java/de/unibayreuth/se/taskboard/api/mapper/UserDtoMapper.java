package de.unibayreuth.se.taskboard.api.mapper;

import de.unibayreuth.se.taskboard.api.dtos.UserDto;
import de.unibayreuth.se.taskboard.business.domain.User;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Mapper(componentModel = "spring")
@ConditionalOnMissingBean // prevent IntelliJ warning about duplicate beans
@NoArgsConstructor
public abstract class UserDtoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "createdAt", expression = "java(mapTimestamp(source.getCreatedAt()))")
    public abstract UserDto fromBusiness(User source);

    // Fix this mapper after resolving the other TODOs.
    @Mapping(target = "id", expression = "java(source.id())")
    @Mapping(target = "name", expression = "java(source.name())")
    @Mapping(target = "createdAt", expression = "java(mapTimestamp(source.createdAt()))")
    public abstract User toBusiness(UserDto source);

    protected LocalDateTime mapTimestamp (LocalDateTime timestamp) {
        if (timestamp == null) {
            return LocalDateTime.now(ZoneId.of("UTC"));
        }
        return timestamp;
    }
}
