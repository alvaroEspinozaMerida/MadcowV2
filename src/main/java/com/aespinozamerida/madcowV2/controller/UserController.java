package com.aespinozamerida.madcowV2.controller;


import com.aespinozamerida.madcowV2.exception.ResourceNotFoundException;
import com.aespinozamerida.madcowV2.model.Exercise;
import com.aespinozamerida.madcowV2.model.User;
import com.aespinozamerida.madcowV2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//used to allow Cross-Origin Resource Sharing (CORS)
// from a specific domain or from any domain.
// This annotation allows a web page to make
// requests to a server from a different domain.
@CrossOrigin(origins = "http://localhost:3000")

//@RestController is a type-level annotation that is used to define
// a controller that provides RESTful services.
// It is a combination of the @Controller and @ResponseBody
// annotations. The @RestController annotation indicates that
// the annotated class is a controller that is capable of serving
// RESTful requests. The @ResponseBody annotation indicates that the
// return value of a method should be serialized into the response
// body of the HTTP request, rather than being rendered as a view.
@RestController

//The @RequestMapping annotation in Spring is used to map a specific
// HTTP request to a method in a controller class. It is used to define
// the URL that the method will handle and the HTTP methods (such as GET, POST, PUT, DELETE, etc.)
// that the method will support.
//
//The @RequestMapping annotation can be used at both the class
// level and the method level. If it is used at the class level,
// it serves as a base mapping for all the methods in the class.
// If it is used at the method level, it overrides the class-level
// mapping for that particular method.
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserService userService;
    //@PostMapping, @GetMapping, and @PutMapping are
    // annotations in Spring that are used to map specific
    // HTTP requests to methods in a controller class.
    // They are short forms of the @RequestMapping
    // annotation with a specific HTTP method set.
    //
    //@PostMapping is used to map a method to an HTTP POST request.
    //@GetMapping is used to map a method to an HTTP GET request.
    //@PutMapping is used to map a method to an HTTP PUT request.

    @GetMapping("/all")
        public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping ("/add")
    String createUser(@RequestBody User user){
        userService.createUser(user);
        return "New User was added";
    }

    //ResponseEntity is a class in the Spring framework
    // that represents an HTTP response.
    // It is a generic type that can be used to return a
    // response with a specific type of body, headers, and status code.
    //
    //The ResponseEntity class provides a way to return a custom
    // HTTP response from a controller method, with full control
    // over the response body, headers, and status code. It is
    // particularly useful for returning specific error codes or custom headers.
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
        return ResponseEntity.ok(user);
    }

//    @GetMapping("/users/get_all_exercises/{id}")
//    public List<Exercise> getAllExercicesByID(@PathVariable Integer id){
//        User user = userService.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
//        return user.getWorkouts().get(0).getExercise1();
//    }
//
//    @PutMapping("/users/calculate_maxes/{id}")
//    public ResponseEntity<User> calculateMaxesByID(@PathVariable Integer id){
//        User user = userService.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
//        user.calculateMaxes();
//
//        User updatedUser = userService.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @PutMapping("/users/create_workouts/{id}")
//    public ResponseEntity<User> createWorkoutsByID(@PathVariable Integer id){
//        User user = userService.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
//        user.addWorkouts();
//        user.createWorkouts();
//        User updatedUser = userService.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }


    @GetMapping("/usersEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with that EMAIL does not exist"));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/calculate_maxes/{email}")
    public ResponseEntity<User> calculateMaxesByEmail(@PathVariable String email){
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
        user.calculateMaxes();

        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/users/create_workouts/{email}")
    public ResponseEntity<User> createWorkoutsByEmail(@PathVariable String email){
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with that email does not exist"));
        user.addWorkouts();
        user.createWorkouts();
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

}
