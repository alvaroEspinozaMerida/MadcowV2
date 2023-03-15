package com.aespinozamerida.madcowV2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Maxes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*
    * The @ManyToOne and @JoinColumn annotations in Spring
    *  are part of the Java Persistence API (JPA)
    * and are used to define a many-to-one relationship
    *  between two entities. The @ManyToOne annotation
    * is used to specify the relationship between the target
    *  entity (the "many" side) and the source entity (the "one" side),
    *  and the @JoinColumn annotation is used to specify the name of
    *  the column in the target entity's table that will store the foreign
    * key to the source entity's table.
    *
    * */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public String workoutName;
    public double weight;
    public double reps;

    public Maxes(String workoutName, double weight, double reps, User user) {
        this.workoutName = workoutName;
        this.weight = weight;
        this.reps = reps;
        this.user = user;
    }

    public Maxes() {

    }

    public double getOneRepMax(){
        return Math.round(weight/(1.0278 - (.0278*reps)));
    }

    public double getFiveRepMax(){
        return Math.round(getOneRepMax() * (1.0278 - (.0278*5)));
    }

    public double getStartWeight(){
        return Math.round(getFiveRepMax() * Math.pow((1/1.025),(Constants.PRWEEK-1))/(2*Constants.PLATE)) * 2 * Constants.PLATE;
    }


}
