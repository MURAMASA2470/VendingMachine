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
import items.ItemType;

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
		
		try (Scanner scan = new Scanner(System.in)) {
			String jsonDirectory = "/Users/muramasa/ws/java/eclipse-workspace/VendingMachine/resources/";
			
			int input = -1;
			ItemType[] itemTypes = ItemType.values();
			IntStream.range(0, itemTypes.length).forEach(i -> {
				System.out.printf("%2d: %-8s\r", i+1, itemTypes[i]);
			});
			System.out.println("購入したい商品番号を入力してください: ");
			input = scan.nextInt();
			
			List<Item> items = Arrays.asList(
					new ObjectMapper().readValue(
							new File(jsonDirectory + itemTypes[input] + "s.json"), Item[].class)
					);
			
			IntStream.range(0, items.size()).forEach(i -> {
				System.out.printf("%2d: %-10s  ¥%-5d\r", 
						i+1, items.get(i).getName(), items.get(i).getPrice());
			});
			System.out.println("購入したい商品番号を入力してください: ");
			input = scan.nextInt();
			
			System.out.println(items.get(input).getName());
		
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("存在しない商品です");
		} catch (InputMismatchException e) {
			System.out.println("番号で選んでください");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
