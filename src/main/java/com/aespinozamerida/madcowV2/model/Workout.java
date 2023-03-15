package com.aespinozamerida.madcowV2.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "maxes_id1")
    private Maxes maxes1;
    @ManyToOne
    @JoinColumn(name = "maxes_id2")
    private Maxes maxes2;
    @ManyToOne
    @JoinColumn(name = "maxes_id3")
    private Maxes maxes3;

    private Day day;

    //The @JsonManagedReference annotation is used by the Jackson
    // library to control the serialization of the relationship.
    // This annotation is placed on the field in the source entity
    // that represents the relationship and is used to indicate
    // that the target entities should be serialized and included
    // in the JSON representation of the source entity.
    //
    //Here is an example of how you might use the @OneToMany and @JsonManagedReference annotations in a Spring application:
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Exercise> exercise1 = new ArrayList<>();

    public Workout() {
    }

    public Workout(Maxes maxes1, Maxes maxes2, Maxes maxes3, User user) {
        this.maxes1 = maxes1;
        this.maxes2 = maxes2;
        this.maxes3 = maxes3;
        this.user = user;
    }


    public void setMaxes1(Maxes maxes1) {
        this.maxes1 = maxes1;
    }

    public void setMaxes2(Maxes maxes2) {
        this.maxes2 = maxes2;
    }

    public void setMaxes3(Maxes maxes3) {
        this.maxes3 = maxes3;
    }

    public Maxes getMaxes1() {
        return maxes1;
    }

    public Maxes getMaxes2() {
        return maxes2;
    }

    public Maxes getMaxes3() {
        return maxes3;
    }

    public List<Exercise> getExercise1() {
        return exercise1;
    }

    public List<Exercise> calcNewExercise(Maxes maxes){
        List<Exercise> newExercise = new ArrayList<>();
        for(int i = 0; i < 12; i++){
            double dayMax;
            if(i == 0){
                dayMax = maxes.getStartWeight();
            }
            else {
                dayMax = Math.round((maxes.getStartWeight()*(Math.pow(1.025,i))/(2*Constants.PLATE))) *2*Constants.PLATE ;
            }
            Exercise weekSets = new Exercise(this);
            for(int j = 0; j < 5; j++){
                if(j == 0){
                    weekSets.getSets().add(dayMax);
                }else {
                    weekSets.getSets().add(Math.round( dayMax*(1-Constants.SET_INTERVAL*(j))/(2*Constants.PLATE))*2*Constants.PLATE);
                }
            }
            newExercise.add(weekSets);
        }
        return newExercise;
    }

    public void calculateExercise1(){
        this.exercise1 = calcNewExercise(maxes1);
    }
}


