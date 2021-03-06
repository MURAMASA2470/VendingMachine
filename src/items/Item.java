package items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author muramasa
 *
 */
public class Item implements IItem {

	@JsonProperty("name")
	private String name;

	@JsonProperty("price")
	private int price;
	
	@JsonProperty("wait")
	private int wait;
	
	@JsonProperty("type")
	private ItemType type;
	
	/**
	 * 
	 */
	public Item() {
		
	}
	
	/**
	 * 
	 */
	public Item(String name, int price, ItemType type) {
		this(name, price, 0, type);
	}
	
	/**
	 * 
	 */
	public Item(String name, int price, int wait, ItemType type) {
		this.name = name;
		this.price = price;
		this.wait = wait;
		this.type = type;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the wait
	 */
	public int getWait() {
		return wait;
	}

	/**
	 * @param wait the wait to set
	 */
	public void setWait(int wait) {
		this.wait = wait;
	}

	/**
	 * @return the type
	 */
	public ItemType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ItemType type) {
		this.type = type;
	}

}
