package com.aespinozamerida.madcowV2.service;

import com.aespinozamerida.madcowV2.model.User;
import com.aespinozamerida.madcowV2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//The @Service annotation in Spring is used to annotate
// a class as a service class. It is used to indicate
// that a class provides some business logic and is a
// candidate for being managed by the Spring container.
//
//The @Service annotation is typically used in the
// service layer of an application, where it is responsible
// for implementing the business logic and interacting with
// the persistence layer to retrieve and store data.
// The service layer is often used to provide a higher
// level of abstraction over the persistence layer, making
// it easier to change the underlying persistence mechanism
// without affecting the rest of the application

//Business logic refers to the specific rules, algorithms, and processes
// that determine how a software application performs its intended functions
// and achieves its desired outcomes. It defines the rules and processes
// that govern the flow of data and control the behavior of the application.
//
//In the context of a software application, the business logic encapsulates
// the knowledge and expertise of the domain for which the application is
// being built. It defines the rules for validating input data, processing data,
// and making decisions based on that data.
//

//For example, in an e-commerce application, the business logic might define
// the rules for calculating the total cost of an order, applying discounts,
// and determining tax liabilities. In a financial management application,
// the business logic might define the rules for calculating interest,
// generating reports, and performing reconciliation.
//
//The business logic is usually implemented in the service layer of an application,
// which is separated from the presentation layer (e.g. the user interface)
// and the persistence layer (e.g. the database).
// This separation allows the business logic to be tested, reused, and maintained
// independently of the other layers, making the application more flexible and maintainable.
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
