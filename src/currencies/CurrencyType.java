/**
 * 
 */
package currencies;

/**
 * @author muramasa
 *
 */
public enum CurrencyType {
	_10(10),
	_50(50),
	_100(100),
	_500(500),
	_1000(1000);

	private final int currency;
	
	CurrencyType(final int currency) {
		this.currency = currency;
	}
	
	public int getCurrency() {
		return this.currency;
	}
	
	public boolean equals(int value) {
		return this.getCurrency() == value;
	}
}
