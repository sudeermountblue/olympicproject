package com.sudeer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int SEX = 2;
    public static final int AGE = 3;
    public static final int HEIGHT = 4;
    public static final int WEIGHT = 5;
    public static final int TEAM = 6;
    public static final int NOC = 7;
    public static final int GAMES = 8;
    public static final int YEAR = 9;
    public static final int SEASON = 10;
    public static final int CITY = 11;
    public static final int SPORT = 12;
    public static final int EVENT = 13;
    public static final int MEDAL = 14;




    public static void main(String[] args) {
        List<AthleteEvents> athleteEventsData = getAthleteEventsData();
        List<NocRegions> nocRegionsData = getnocRegionsData();
    }

    private static List<NocRegions> getnocRegionsData() {
        List<AthleteEvents> athleteEventsData = new ArrayList<>();
        String path = "/home/sudheer/Downloads/archive (1)/athlete_events.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<AthleteEvents> getAthleteEventsData() {
        List<NocRegions> nocRegionsData = new ArrayList<>();
        return null;
    }
}
