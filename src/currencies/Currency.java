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
public class Currency implements ICurrency {

	private CurrencyType type;
	
	/**
	 * 
	 */
	public Currency() {

	}

	@Override
	public CurrencyType getCurrencyType() {
		return type;
	}

	@Override
	public void setCurrencyType(CurrencyType type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(int currency) {
		return this.type.getCurrency() == currency;
	}

}
