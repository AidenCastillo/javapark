package org.javapark.ParkSim;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Person {

    private final int tag;
    private final String arche;
    private String location;
    private final Boolean expeditedAbility;
    private final int waitInLineTime;
//    private final int stayInParkTime;
    public Person(int createdTag, String createdArche, String createdLocation, Boolean createdExpetitedAbility) throws IOException {
        this.tag = createdTag;
        this.arche = createdArche;
        this.location = createdLocation;
        this.expeditedAbility = createdExpetitedAbility;
        this.waitInLineTime = setWaitInLinetime();
    }
    private int setWaitInLinetime() throws IOException {
        Path currentRelativePath = Paths.get("");
        String currentPath = currentRelativePath.toAbsolutePath().toString();
        ObjectMapper mapper = new ObjectMapper();
        Map<?,?> map = mapper.readValue(Paths.get(currentPath + "/src/main/resources/archetype.json").toFile(), Map.class);
        Map<?,?> archetype = (Map<?, ?>) map.get(this.getArche());
        return (int) archetype.get("waitInLineTime");
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

    public int getWaitInLineTime() {
        return waitInLineTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArcheType() {
        return this.arche;
    }
}