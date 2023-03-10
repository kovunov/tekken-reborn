package com.cpan252.tekkenreborn.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpan252.tekkenreborn.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
