package com.aespinozamerida.madcowV2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Maxes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
