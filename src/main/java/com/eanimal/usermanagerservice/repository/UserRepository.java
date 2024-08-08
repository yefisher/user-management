package com.eanimal.usermanagerservice.repository;

import com.eanimal.usermanagerservice.domain.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  @Query(value = "select u from User u where u.id = ?1 and u.isDeleted = false")
  Optional<User> findByIdAndIsDeletedIsFalse(UUID id);

  @Query(value = "select u from User  u where u.userEmail = ?1 and u.isDeleted = false")
  Optional<User> findByUserEmailAndIsDeletedIsFalse(String email);
}
