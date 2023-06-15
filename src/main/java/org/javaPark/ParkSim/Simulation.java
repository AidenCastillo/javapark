package org.javapark.ParkSim;
//import org.javapark.ParkSim.Ride;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class Simulation {
    // create a constructor with an array list named population containing the object of ParkSim.Person
    private ArrayList<Person> population;
    private int populationSize;
    private final Settings settings;
    private int time;
    private ArrayList<Ride> rides;

    public Simulation(String mode) throws IOException {
        this.population = new ArrayList<>(this.populationSize);
        this.settings = new Settings(mode);
        this.populationSize = this.settings.populationSize;
        this.time = 0;
        this.rides = new ArrayList<>();
    }
    // create a method to add people to the array list
    private void addPerson(Person person) {
        this.population.add(person);
    }

    private void removePerson(Person person) {
        this.population.remove(person);
    }

    private void movePerson(Person person, String location) {
        person.setLocation(location);
    }

    private boolean randomExpedited() {
        // create a random number generator to determine if the person is expedited or not
        // if the number is 1 then the person is expedited
        // if the number is 0 then the person is not expedited

        double expAbilityPercent = this.settings.expAbilityPercent;
        double random = Math.random();

        return !(random < expAbilityPercent);
    }
    public String randomArcheType() {

        String[] archeTypes = {"tourist", "visitor", "rideEnthusiast", "rideFavorer", "activityEnthusiast", "activityFavorer"};

        // based on this.settings.agentDistribution, create a random number generator to determine the archeType of the person
        int totalWeight = 0;
        for (double weight : this.settings.agentDistribution.values()) {
            totalWeight += weight;
        }
        int inx = 0;
        for (double r = Math.random() + totalWeight; inx < this.settings.agentDistribution.size() -1; ++inx) {
            r -= this.settings.agentDistribution.get(archeTypes[inx]);
            if (r <= 0.0d) break;
        }

        return archeTypes[inx];
    }
    private void addToPopulation() throws IOException {
        // for loop that adds x amount of Person to population based on settings hourlyRate

        double addCount = this.settings.populationSize * this.settings.hourlyRate.get(this.time) * 0.01;
        for (int i = 0; i < addCount; i++) {
            Person person = new Person(i, randomArcheType(), "hub", randomExpedited());
            addPerson(person);
        }
        System.out.println(this.population.size());
    }
    private void updateLocation() {

    }

    public void main(String args) throws IOException {
        System.out.println("Simulation started");
        // Create rides

        // Run
        for (int i = 0; i < 14; i++){
            addToPopulation();
            updateLocation();



            this.time++;
        }
    }

}