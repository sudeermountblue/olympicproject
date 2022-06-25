package com.sudeer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        List<Event> eventData = getAthleteEventsData();
        List<Region> regionData = getNocRegionsData();

        displayYearWiseNumberOfGoldMedalsWonByEachPlayer(eventData);
    }

    private static void displayYearWiseNumberOfGoldMedalsWonByEachPlayer(List<Event> eventData) {
        HashMap<String, HashMap> yearWiseNumberOfGoldMedalsWonByEachPlayer = new HashMap<>();

        for (Event data :eventData){
            String medal = data.getMedal();
            if (medal.equals("Gold")){
                String eventYear = data.getYear();
                String athleteName = data.getName();
                int count;
                if (yearWiseNumberOfGoldMedalsWonByEachPlayer.containsKey(eventYear)) {
                     HashMap result = yearWiseNumberOfGoldMedalsWonByEachPlayer.get(eventYear);
                     if (result.containsKey(athleteName)){
                         int medalsCount = (int) result.get(athleteName);
                         result.put(athleteName,medalsCount+=1);
                     }
                     else{
                         result.put(athleteName,1);
                     }
                } else {
                    HashMap<String, Integer> numberOfGoldMedalsWonByEachPlayer = new HashMap<>();
                    numberOfGoldMedalsWonByEachPlayer.put(athleteName,1);
                    yearWiseNumberOfGoldMedalsWonByEachPlayer.put(eventYear,numberOfGoldMedalsWonByEachPlayer );
                }
            }
        }
        System.out.println(yearWiseNumberOfGoldMedalsWonByEachPlayer);
    }

    private static List<Event> getAthleteEventsData() {
        List<Event> eventData = new ArrayList<>();
        String path = "/home/sudheer/Downloads/Athlete.csv";
        String line = "";
        try {

            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Event event = new Event();

                event.setID(values[ID]);
                event.setName(values[NAME]);
                event.setSex(values[SEX]);
                event.setAge(values[AGE]);
                event.setHeight(values[HEIGHT]);
                event.setWeight(values[WEIGHT]);
                event.setTeam(values[TEAM]);
                event.setNOC(values[NOC]);
                event.setGames(values[GAMES]);
                event.setYear(values[YEAR]);
                event.setSeason(values[SEASON]);
                event.setCity(values[CITY]);
                event.setSport(values[SPORT]);
                event.setEvent(values[EVENT]);
                event.setMedal(values[MEDAL]);

                eventData.add(event);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eventData;
    }

    private static List<Region> getNocRegionsData() {
        List<Region> regionData = new ArrayList<>();
        return null;
    }
}
