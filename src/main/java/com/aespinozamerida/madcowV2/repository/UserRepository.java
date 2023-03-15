package com.aespinozamerida.madcowV2.repository;

import com.aespinozamerida.madcowV2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//The @Repository annotation in Spring is used to annotate a class
// as a data access object (DAO). It is used to indicate that a
// class provides persistence services, such as
// retrieving and storing data in a database.
//
//The @Repository annotation is typically used in the persistence
// layer of an application, where it is responsible for interacting
// with the database to retrieve and store data. The persistence layer
// is often used to provide a higher level of abstraction over the database,
// making it easier to change the underlying database technology
// without affecting the rest of the application.
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
