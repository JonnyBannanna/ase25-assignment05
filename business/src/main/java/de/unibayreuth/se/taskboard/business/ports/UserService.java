package de.unibayreuth.se.taskboard.business.ports;

import de.unibayreuth.se.taskboard.business.domain.User;
import de.unibayreuth.se.taskboard.business.exceptions.DuplicateNameException;
import de.unibayreuth.se.taskboard.business.exceptions.MalformedRequestException;
import de.unibayreuth.se.taskboard.business.exceptions.UserNotFoundException;

import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;


public interface UserService {
    // Add user service interface that the controller uses to interact with the business layer.
    // Implement the user service interface in the business layer, using the existing user persistence service.
    void clear();
    @NonNull
    User create(@NonNull User user) throws MalformedRequestException, DuplicateNameException;
    @NonNull
    List<User> getAll();
    @NonNull
    User getById(UUID id) throws UserNotFoundException;
    @NonNull
    User upsert(User user) throws UserNotFoundException, DuplicateNameException;
}
