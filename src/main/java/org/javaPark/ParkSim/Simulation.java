package org.example.ParkSim;

import java.util.ArrayList;
public class Simulation {
    // create a constructor with a array list named population containing the object of ParkSim.Person
    private ArrayList<Person> population;
    private int populationSize;
    public Simulation(int createdPopulationSize) {
        this.populationSize = createdPopulationSize;
        this.population = new ArrayList<Person>(this.populationSize);
    }
    // create a method to add people to the array list
    private void addPeople(Person person) {
        this.population.add(person);
    }

    private void removePeople(Person person) {
        this.population.remove(person);
    }

    private void movePeople(Person person, String location) {
        person.setLocation(location);
    }

    private void randomExpedited() {
        //read settings.json

    }


    public void main(String arg) {
        // create a for loop to add people to the array list
        for (int i = 0; i < this.populationSize; i++) {
            Person person = new Person(i, "arche", "hub", true);
            this.addPeople(person);
        }


    }

}