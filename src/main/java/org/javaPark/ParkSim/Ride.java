package org.javapark.ParkSim;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class Ride {

    private final String name;
    private final int runTime;
//    private final int hourlyThroughput;
//    private final int popularity;
//    private final boolean expeditedQueue;
//    private final double expeditedQueueRatio;
//    private final boolean childEligible;
//    private final boolean adultEligible;
    private ArrayList<Person> regularQueue;
    private ArrayList<Person> expeditedQueue;


    public Ride(String name) throws IOException {
        this.name = name;
        this.runTime = loadRunTime(name);


    }

    private int loadRunTime(String name) throws IOException {
        Map<?,?> map = (Map<?, ?>) getRideFile();
        Object ride = map.get(name);
        Map<?,?> rideMap = (Map<?, ?>) ride;
        return (int) rideMap.get("runTime");
    }


    public static Object getRideFile() throws IOException {
        Path currentRelativePath = Paths.get("");
        String currentPath = currentRelativePath.toAbsolutePath().toString();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get(currentPath + "/src/main/resources/ride.json").toFile(), Map.class);
    }
}
