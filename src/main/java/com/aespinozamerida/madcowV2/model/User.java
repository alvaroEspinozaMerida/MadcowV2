package com.aespinozamerida.madcowV2.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Lombok annotations for creating setter,getters, toString and constructors
@Getter
@Setter
@ToString
@AllArgsConstructor

// a JPA annotation that marks the class as a persistent entity.
//A persistent entity is a term used in software development to describe an object that can be stored in a database and later retrieved. The term is often used in the context of Object-Relational Mapping (ORM) frameworks, where the object is used to represent a record in a database table.
//
//In a typical ORM setup, the persistent entity is mapped to a database table,
// and the fields of the object correspond to the columns in the table.
// The ORM framework provides the necessary infrastructure to store and
// retrieve the persistent entities from the database, abstracting the
// underlying database management system and allowing the developer to
// work with the entities as regular Java objects.
@Entity
@Table(name = "_users")
/*
* The @Table annotation in Java is used to specify the
*  database table that a persistent entity is mapped to.
* It is part of the Java Persistence API (JPA) and is used
*  to define the mapping between a Java class and a database table.
The @Table annotation is used in conjunction with the @Entity
* annotation to indicate that a class is a persistent entity.
* The annotation is placed on the class and can be used to
*  specify various properties of the table, such as the name
*  of the table, the name of the schema that the table is in
* , and the catalog that the table is in.
* */
public class User  {
    /*
    * The @Id and @GeneratedValue annotations in Java are
    *  part of the Java Persistence API (JPA) and are used
    * to specify the primary key of a persistent entity.
    * The @Id annotation is used to indicate that a field
    * is the primary key of the entity, and the @GeneratedValue
    *  annotation is used to specify how the primary key should be generated.
    *
    * The @Id and @GeneratedValue annotations are important for managing
    *  the primary key of a persistent entity. By using these annotations,
    * you can ensure that each entity has a unique identifier and that
    *  the primary key is generated automatically, making it easier
    *  to manage the data in your application.
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;

    private double squatWeight, benchWeight, opWeight, deadliftWeight, rowWeight;
    private int squatReps, benchReps, opReps, deadliftReps, rowReps;
    /*
    * The @OneToMany annotation in Spring is part of the Java Persistence API (JPA)
    *  and is used to define a one-to-many relationship between two entities.
    * The annotation is used to specify the relationship between the source entity (the "one" side)
    *  and the target entity (the "many" side).
    * In a one-to-many relationship, one source entity can be associated
    *  with multiple target entities. For example, in a Department and
    *  Employee relationship, one department can have many employees.
    * */
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
