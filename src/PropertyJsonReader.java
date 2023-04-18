import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;


public class PropertyJsonReader {
     public static LinkedList<Square> squares = new LinkedList<>();
	 
     public PropertyJsonReader(){
         JSONParser processor = new JSONParser();
         try (Reader file = new FileReader("property.json")){
             JSONObject jsonfile = (JSONObject) processor.parse(file);
             JSONArray Land = (JSONArray) jsonfile.get("1");
             for(Object i:Land){
				 
				 //You can reach items by using statements below:
				 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
				 String name = (String)((JSONObject)i).get("name");
				 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
                 Land newLand = new Land(id, cost, name);
                 squares.add(newLand);
				 //And you can add these items to any data structure (e.g. array, linkedlist etc.
				 
				 
                 
             }
             JSONArray RailRoad = (JSONArray) jsonfile.get("2");
             for(Object i:RailRoad)
             {
				 //You can reach items by using statements below:
                 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
                 String name = (String)((JSONObject)i).get("name");
                 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
                 RailRoad newRailRoad = new RailRoad(id, cost, name);
                 squares.add(newRailRoad);
				//And you can add these items to any data structure (e.g. array, linkedlist etc.
             }
			 
             JSONArray Company = (JSONArray) jsonfile.get("3");
             for(Object i:Company)
             {
				 //You can reach items by using statements below:
                 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
                 String name = (String)((JSONObject)i).get("name");
                 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
                 Company newCompany = new Company(id, cost, name);
                 squares.add(newCompany);
             }
             squares.add(new Go(1));
             squares.add(new CommunityChest(3));
             squares.add(new IncomeTax(5));
             squares.add(new Chance(8));
             squares.add(new Jail(11));
             squares.add(new CommunityChest(18));
             squares.add(new FreeParking(21));
             squares.add(new Chance(23));
             squares.add(new GoJail(31));
             squares.add(new CommunityChest(34));
             squares.add(new Chance(37));
             squares.add(new IncomeTax(39));


             
         } catch (IOException | ParseException e){
             e.printStackTrace();
         }
     }
     //You can add function(s) if you want
}