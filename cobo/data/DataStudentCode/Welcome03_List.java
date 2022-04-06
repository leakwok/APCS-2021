/*
Team Fried Chicken :: Nina Jiang, Lea Kwok, Lindsey Phung
APCS
LAB08 -- America's Next Top Data Scientist
2022-04-06
time spent: 02.3 hrs

 * Arrays of objects
 */

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Welcome03_List {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ds.printUsageString();
      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name",
             "station/station_id", "station/state",
             "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);

      ArrayList<WeatherStation> stateStations = new ArrayList<WeatherStation>();
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            System.out.println("  " + ws.getId() + ": " + ws.getName());
            stateStations.add(ws);
         }
      }


      double mostSouth = allstns.get(0).getLat();
      int loc = 0;
      for(int i = 0; i < stateStations.size(); i++){
        if(stateStations.get(i).getLat() < mostSouth){
          mostSouth = stateStations.get(i).getLat();
          loc = i;
        }
      }
      System.out.println("The most south station is: " + stateStations.get(loc).getName());

   }
}
