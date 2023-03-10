package com.sgdevcamp.membershipservice.repository;

import com.sgdevcamp.membershipservice.model.User;
import com.sgdevcamp.membershipservice.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findByUsernameIn(List<String> usernames);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByEmailAndRoleLike(String email, UserRole role);

    Optional<User> findByEmail(String email);

    Page<User> findByUsernameContaining(String username, Pageable pageable);

    void deleteByUsername(String username);
}
