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
    private final int hourlyThroughput;
    private final int popularity;
    private final boolean expeditedBoolean;
    private final double expeditedQueueRatio;
    private final boolean childEligible;
    private final boolean adultEligible;
    private ArrayList<Person> regularQueue;
    private ArrayList<Person> expeditedQueue;


    public Ride(String name) throws IOException {
        this.name = name;
        this.runTime = loadRunTime(name);
        this.hourlyThroughput = loadHourlyThroughput(name);
        this.popularity = loadPopularity(name);
        this.expeditedBoolean = loadExpeditedBoolean(name);
        this.expeditedQueueRatio = loadExpeditedQueueRatio(name);
        this.childEligible = loadChildEligible(name);
        this.adultEligible = loadAdultEligible(name);
        this.regularQueue = new ArrayList<>();
        this.expeditedQueue = new ArrayList<>();
    }

    private int loadHourlyThroughput(String name) throws IOException {
        Map<?,?> map = (Map<?, ?>) getRideFile();
        Object ride = map.get(name);
        Map<?,?> rideMap = (Map<?, ?>) ride;
        return (int) rideMap.get("hourly_throughput");
    }
    private int loadPopularity(String name) throws IOException {
        Map<?,?> map = (Map<?, ?>) getRideFile();
        Object ride = map.get(name);
        Map<?,?> rideMap = (Map<?, ?>) ride;
        return (int) rideMap.get("popularity");
    }
    private boolean loadExpeditedBoolean(String name) throws IOException {
        Map<?,?> map = (Map<?, ?>) getRideFile();
        Object ride = map.get(name);
        Map<?,?> rideMap = (Map<?, ?>) ride;
        return (boolean) rideMap.get("expedited_boolean");
    }
    private double loadExpeditedQueueRatio(String name) throws IOException {
        Map<?,?> map = (Map<?, ?>) getRideFile();
        Object ride = map.get(name);
        Map<?,?> rideMap = (Map<?, ?>) ride;
        return (double) rideMap.get("expedited_queue_ratio");
    }

    private int loadRunTime(String name) throws IOException {
        Map<?,?> map = (Map<?, ?>) getRideFile();
        Object ride = map.get(name);
        Map<?,?> rideMap = (Map<?, ?>) ride;
        return (int) rideMap.get("run_time");
    }
    private boolean loadChildEligible(String name) throws IOException {
        Map<?,?> map = (Map<?, ?>) getRideFile();
        Object ride = map.get(name);
        Map<?,?> rideMap = (Map<?, ?>) ride;
        return (boolean) rideMap.get("child_eligible");
    }
    private boolean loadAdultEligible(String name) throws IOException {
        Map<?,?> map = (Map<?, ?>) getRideFile();
        Object ride = map.get(name);
        Map<?,?> rideMap = (Map<?, ?>) ride;
        return (boolean) rideMap.get("adult_eligible");
    }
    public static Object getRideFile() throws IOException {
        Path currentRelativePath = Paths.get("");
        String currentPath = currentRelativePath.toAbsolutePath().toString();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get(currentPath + "/src/main/resources/ride.json").toFile(), Map.class);
    }
}
