package org.javapark.ParkSim;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Settings {

    public int populationSize;
    public HashMap<Integer, Integer> hourlyRate;
    public HashMap<String, Double> agentDistribution;
    public double expAbilityPercent;
    Path currentRelativePath = Paths.get("");
    String currentPath = currentRelativePath.toAbsolutePath().toString();

    public Settings(String mode) throws IOException {
        this.populationSize = getPopulationSize(mode);
        this.hourlyRate = getHourlyRate(mode);
        this.agentDistribution = setAgentDistribution(mode);
        this.expAbilityPercent = getExpAbilityPercent(mode);
    }



    private double getExpAbilityPercent(String mode) throws IOException {
        Map<?,?> map = (Map<?, ?>) getSettingsFile(mode);
        return (double) map.get("expAbilityPercent");
    }

    private HashMap<Integer, Integer> getHourlyRate(String mode) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (mode == "regular") {
            map.put(0, 10);
            map.put(1, 20);
            map.put(2, 17);
            map.put(3, 20);
            map.put(4, 15);
            map.put(5, 10);
            map.put(6, 1);
            map.put(7, 5);
            map.put(8, 1);
            map.put(9, 1);
            map.put(10, 0);
            map.put(11, 0);
            map.put(12, 0);
            map.put(13, 0);
            map.put(14, 0);
        }
        return map;
    }

    private int getPopulationSize(String mode) throws IOException {
        Map<?,?> map = (Map<?, ?>) getSettingsFile(mode);
        return (int) map.get("populationSize");
    }

    public HashMap<String, Double> setAgentDistribution(String mode) {
        HashMap<String, Double> map = new HashMap<String, Double>();
        if (mode == "regular") {
            map.put("tourist", 0.25);
            map.put("visitor", 0.25);
            map.put("rideFavorer", 0.15);
            map.put("rideEnthusiast", 0.15);
            map.put("activityFavorer", 0.15);
            map.put("activityEnthusiast", 0.5);
        }
        return map;
    }
    public Object getSettingsFile(String mode) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<?,?> map = mapper.readValue(Paths.get(currentPath + "/src/main/resources/settings.json").toFile(), Map.class);
        // get the value of the key "population" inside of the "regular" key
        return (Map<?,?>) map.get(mode);
    }
    public Object getArcheTypeFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get(currentPath + "/src/main.resources/archetype.json").toFile(), Map.class);
    }
}
