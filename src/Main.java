import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currencies.CurrencyType;
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
			System.out.print("自販機の番号を入力してください: ");
			input = scan.nextInt();

			
			List<Item> items = Arrays.asList(
					new ObjectMapper().readValue(
							new File(jsonDirectory + itemTypes[--input] + "s.json"), Item[].class)
					);
			
			// 商品一覧
			IntStream.range(0, items.size()).forEach(i -> {
				System.out.printf("%2d: %s  ¥%-5d\r", 
						i+1, f(items.get(i).getName(), 25), items.get(i).getPrice());
			});
			
			
			CurrencyType[] currencyTypes = CurrencyType.values();
			IntStream.range(0, currencyTypes.length).forEach(i -> {
				System.out.printf("%2d: ¥%-5d  ", i+1, currencyTypes[i].getCurrency());
			});
			System.out.print("\r\n投入する金額を入力してください: ");
			int total = 0;
			int count = 1;

			while(true) {
				System.out.printf("\r\n%d枚目: ", count);
				int inputCurrency = scan.nextInt();
				if(inputCurrency == -1) break;
				if(Arrays.asList(currencyTypes).stream().anyMatch(x -> x.equals(inputCurrency))) {
					total += inputCurrency;
					System.out.printf("合計: %5d円\r\n", total);
					count++;
				} else {
					System.out.println("対応していないお金です");
				}
 			}
			final int totalAmount = total; 
			// 商品一覧
			IntStream.range(0, items.size()).forEach(i -> {
				System.out.printf("%2s  %2d: %-10s  ¥%-5d\r", 
						totalAmount - items.get(i).getPrice() >= 0 ? "🔴" : "", 
						i+1, 
						items.get(i).getName(), 
						items.get(i).getPrice());
			});
			
			System.out.print("購入したい商品番号を入力してください: ");
			input = scan.nextInt();
			
			Item returnItem = items.get(input-1);
			if(totalAmount - returnItem.getPrice() < 0) {
				System.out.println("挿入金額が不足しています");
				return;
			}
			
			if(returnItem.getType() == ItemType.Food) {
				int wait = returnItem.getWait();
				System.out.printf("%d秒お待ちください\r\n", wait);
				Thread.sleep(wait * 1000);
			}
			
			System.out.println(returnItem.getName());
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("存在しない番号です");
		} catch (InputMismatchException e) {
			System.out.println("番号で選んでください");
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
	private static String f(String str, int len){
        int diff = (str.getBytes(Charset.forName("Shift_JIS")).length - str.length()) / 2;
        return String.format("%-" + (len - diff) + "s", str);
    }
	
}
