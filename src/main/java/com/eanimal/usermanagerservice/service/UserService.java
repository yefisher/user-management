package com.eanimal.usermanagerservice.service;

import com.eanimal.usermanagerservice.api.exception.EntityNotFoundException;
import com.eanimal.usermanagerservice.domain.User;
import com.eanimal.usermanagerservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User createUser(final User user) {
    return userRepository.save(user);
  }

  public User getUserByUserEmail(final String email) {
    return userRepository
        .findByUserEmailAndIsDeletedIsFalse(email)
        .orElseThrow(() -> new EntityNotFoundException("User with email: %s is not found!", email));
  }

  public User getUserById(final UUID id) {
    return userRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User with Id: %s is not found!", id));
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User deleteUser(final UUID id) {
    return userRepository
        .findByIdAndIsDeletedIsFalse(id)
        .map(user -> (User) user.toBuilder().isDeleted(true).build())
        .map(userRepository::save)
        .orElseThrow(() -> new EntityNotFoundException("User with Id: %s is not found!", id));
  }
}
