/**
 * 
 */
package currencies;

/**
 * @author muramasa
 *
 */
public class Currency implements ICurrency {

	private CurrencyType currencyType;
	
	/**
	 * 
	 */
	public Currency() {
		// TODO Auto-generated constructor stub
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

}
