package com.aespinozamerida.madcowV2.controller;


import com.aespinozamerida.madcowV2.exception.ResourceNotFoundException;
import com.aespinozamerida.madcowV2.model.Exercise;
import com.aespinozamerida.madcowV2.model.User;
import com.aespinozamerida.madcowV2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/all")
        public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping ("/add")
    String createUser(@RequestBody User user){
        userService.createUser(user);
        return "New User was added";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{id}/get_all_exercises")
    public List<Exercise> getAllExercicesByID(@PathVariable Integer id){
        User user = userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
        return user.getWorkouts().get(0).getExercise1();
    }



    @PutMapping("/users/{id}")
    public ResponseEntity<User> calculateMaxes(@PathVariable Integer id){
        User user = userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
        user.calculateMaxes();

        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

//    @PutMapping("/users/{id}/add_workouts")
//    public ResponseEntity<User> addWorkouts(@PathVariable Integer id){
//        User user = userService.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
//        user.addWorkouts();
//        User updatedUser = userService.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }

    @PutMapping("/users/{id}/create_workouts")
    public ResponseEntity<User> createWorkouts(@PathVariable Integer id){
        User user = userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
        user.addWorkouts();
        user.createWorkouts();
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }


//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/users")
//    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//
//    @PostMapping ("/users")
//    User createUser(@RequestBody User user){
//        return userRepository.save(user);
//    }
//
//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Integer id){
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User with that ID cannot be found"));
//        return ResponseEntity.ok(user);
//    }
//
//    //TODO: Add the code for updating the user maxes
//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userDetails){
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee with that ID does not exist"));
//
//        user.setFirstName(userDetails.getFirstName());
//        user.setFirstName(userDetails.getFirstName());
//        user.setLastName(userDetails.getLastName());
//
//        User updatedUser = userRepository.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @DeleteMapping("/users/{id}")
//
//    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Integer id){
//        User user = userRepository.findById(id)
//                .orElseThrow(()-> new ResourceNotFoundException("User with that id does not exist ID:"+id));
//        userRepository.delete(user);
//
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted",Boolean.TRUE);
//        return ResponseEntity.ok(response);
//
//    }




}
