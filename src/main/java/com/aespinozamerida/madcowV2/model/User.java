package com.aespinozamerida.madcowV2.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "_users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    private double squatWeight, benchWeight, opWeight, deadliftWeight, rowWeight;
    private int squatReps, benchReps, opReps, deadliftReps, rowReps;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Workout>workouts = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Maxes> maxes = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(){
    }

    public void calculateMaxes(){
        //Squat Maxes
        maxes.add(new Maxes("Squat",squatWeight,squatReps,this));
        maxes.add(new Maxes("Bench",benchWeight,benchReps,this));
        maxes.add(new Maxes("Overhead Press",opWeight,opReps,this));
        maxes.add(new Maxes("Dead lift",deadliftWeight,deadliftReps,this));
        maxes.add(new Maxes("Row",rowWeight,rowReps,this));
    }

    public void addWorkouts(){

        Workout newWorkout = new Workout(maxes.get(0),maxes.get(1),maxes.get(2),this);
        //Day1
        workouts.add(newWorkout);
    }
    public void createWorkouts(){
        workouts.get(0).calculateExercise1();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
