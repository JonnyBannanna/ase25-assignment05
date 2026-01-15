package de.unibayreuth.se.taskboard.business.impl;

import de.unibayreuth.se.taskboard.business.domain.User;
import de.unibayreuth.se.taskboard.business.exceptions.DuplicateNameException;
import de.unibayreuth.se.taskboard.business.exceptions.MalformedRequestException;
import de.unibayreuth.se.taskboard.business.exceptions.UserNotFoundException;
import de.unibayreuth.se.taskboard.business.ports.UserPersistenceService;
import de.unibayreuth.se.taskboard.business.ports.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPersistenceService userPersistenceService;
    
    @Override
    public void clear() {
        userPersistenceService.clear();
    }

    @Override
    @NonNull
    public User create(@NonNull User user) throws MalformedRequestException, DuplicateNameException {        
        return upsert(user);
    }

    @Override
    @NonNull
    public List<User> getAll() {
        return userPersistenceService.getAll();
    }

    @Override
    @NonNull
    public User getById(UUID id) throws UserNotFoundException {
        return userPersistenceService.getById(id)
            .orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist."));
    }

    @Override
    @NonNull
    public User upsert(User user) throws UserNotFoundException, DuplicateNameException {
        return userPersistenceService.upsert(user);
    }
}
