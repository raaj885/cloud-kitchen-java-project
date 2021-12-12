package com.kitchenapp.model;

/**
 * @author ArunSaiSurapaneni
 *
 */
public class Menu {
	private String itemName;
	private String menuType;
	private String itemType;
	private double price;
	private Integer servings;
	private String category;
	public Menu() {
		super();
	}
	public Menu(String menuType,String itemName,  String itemType, double price, Integer servings, String category) {
		super();
		this.itemName = itemName;
		this.menuType = menuType;
		this.itemType = itemType;
		this.price = price;
		this.servings = servings;
		this.category = category;
	}
	/**
	 * 
	 * @return
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * 
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * 
	 * @return
	 */
	public String getMenuType() {
		return menuType;
	}
	/**
	 * 
	 * @param menuType
	 */
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	/**
	 * 
	 * @return
	 */
	public String getItemType() {
		return itemType;
	}
	/**
	 * 
	 * @param itemType
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	/**
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getServings() {
		return servings;
	}
	/**
	 * 
	 * @param servings
	 */
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	/**
	 * 
	 * @return
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Menu [itemName=" + itemName + ", menuType=" + menuType + ", itemType=" + itemType + ", price=" + price
				+ ", servings=" + servings + ", category=" + category + "]";
	}
	
	
	
}
