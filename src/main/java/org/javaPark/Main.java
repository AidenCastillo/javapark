package org.example;

import org.example.ParkSim.Simulation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean Selection = true;

        try {
            String mode = "regular";
//            while (Selection == true) {
//                System.out.println("Enter mode: ");
//                mode = scanner.nextLine();
//                System.out.println(mode);
//                Selection = false;
//            }
            Simulation parkInstance = new Simulation(100);
            parkInstance.main(mode);

        } catch(Exception e) {
            System.out.println(e);
        }


    }
}