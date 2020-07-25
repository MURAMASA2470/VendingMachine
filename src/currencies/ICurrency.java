/**
 * 
 */
package currencies;

import java.util.Arrays;
import java.util.List;

/**
 * @author muramasa
 *
 */
public interface ICurrency {

	public CurrencyType getCurrencyType();

	public void setCurrencyType(CurrencyType currencyType);
	
	public static List<CurrencyType> getCurrencyTypes() {
		return Arrays.asList(CurrencyType.values());
	}
	
	public boolean equals(int currency);
}
