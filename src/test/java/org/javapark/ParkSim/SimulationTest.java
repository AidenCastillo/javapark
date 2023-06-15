package org.javapark.ParkSim;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    Simulation testSimulation = new Simulation("regular");

    SimulationTest() throws IOException {
    }

    @org.junit.jupiter.api.Test
    void testRandomAcheType() {
        String[] archeTypes = {"tourist", "visitor", "rideEnthusiast", "rideFavorer", "activityEnthusiast", "activityFavorer"};
        String testArcheType = testSimulation.randomArcheType();
        boolean testArcheTypeIsInArray = false;
        for (String archeType : archeTypes) {
            if (testArcheType.equals(archeType)) {
                testArcheTypeIsInArray = true;
            }
        }
        assertTrue(testArcheTypeIsInArray);
    }
}