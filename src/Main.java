import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

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
			
//			foods.forEach((item) -> {
//				System.out.println(item.getName() + " " + item.getPrice());
//			});
			IntStream.range(0, foods.size()).forEach(i -> {
				System.out.printf("%2d: %-10s  ¥%-5d\r", 
						i+1, foods.get(i).getName(), foods.get(i).getPrice());
			});
			System.out.println("購入したい商品番号を入力してください: ");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			
			System.out.println(foods.get(input).getName());
		
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("存在しない商品です");
		} catch(InputMismatchException e) {
			System.out.println("番号で選んでください");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
