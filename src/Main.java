import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import items.Item;

/**
 * @author muramasa
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			String jsonDirectory = "/Users/muramasa/ws/java/eclipse-workspace/VendingMachine/resources/";
			
			ObjectMapper om = new ObjectMapper();
			
			List<Item> foods = Arrays.asList(om.readValue(new File(jsonDirectory + "foods.json"), Item[].class));
			List<Item> drinks = Arrays.asList(om.readValue(new File(jsonDirectory + "drinks.json"), Item[].class));
			
			foods.forEach(item -> {
				System.out.println(item.getName() + " " + item.getPrice() + " " + item.getType());
			});
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}
