package org.example.ParkSim;
public class Person {

    private int tag;
    private String arche;
    private String location;
    private Boolean expeditedAbility;
    public Person(int createdTag, String createdArche, String createdLocation, Boolean createdExpetitedAbility) {
        this.tag = createdTag;
        this.arche = createdArche;
        this.location = createdLocation;
        this.expeditedAbility = createdExpetitedAbility;
    }

    public int getTag() {
        return tag;
    }

    public String getArche() {
        return arche;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getExpeditedAbility() {
        return expeditedAbility;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}