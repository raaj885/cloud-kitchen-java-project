package com.kitchenapp.client;

import java.util.Scanner;

import com.kitchenapp.exceptions.CategoryNotFoundException;
import com.kitchenapp.exceptions.ItemNotFoundException;
import com.kitchenapp.exceptions.MenuNotFoundException;
import com.kitchenapp.exceptions.OrderNotFoundExpection;
import com.kitchenapp.model.Menu;
import com.kitchenapp.service.CartServiceImpl;
import com.kitchenapp.service.ICartService;
import com.kitchenapp.service.IMenuService;
import com.kitchenapp.service.IOrderService;
import com.kitchenapp.service.IUserService;
import com.kitchenapp.service.MenuServiceImpl;
import com.kitchenapp.service.OrderServiceImpl;
import com.kitchenapp.service.UserServiceImpl;

/**
 * @author RajasekharMandireddy
 *
 */
public class Admin {
	public static void main(String[] args) {

		IUserService userService = new UserServiceImpl();
		IMenuService menuService = new MenuServiceImpl();
		IOrderService orderService = new OrderServiceImpl();
		ICartService cartService = new CartServiceImpl();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n ------------------------------------------------------ \n ");
			System.out.println("Press 1 To Fetch New Order");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 2 to Add to Menu");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 3 to update Menu");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 4 to delete Menu");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 5 to show Menu");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 6 to show Menu by Type(morning,afternoon,evening)");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 7 to show Menu by Category(veg/non-veg)");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 8 to show Menu by price");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 9 to show Menu by item type(dessert,main course,biriyani,breakfast)");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 10 to exit");
			System.out.println("\n ------------------------------------------------------\n");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\n ------------------------------------------------------\n");
				scanner.nextLine();

				try {
					orderService.showTodayOrders().forEach(System.out::println);
				} catch (OrderNotFoundExpection e1) {
					// TODO Auto-generated catch block
					System.out.println("No Orders Today");
				}

				break;
			// To add to MENU
			case 2:
				System.out.println("\n ------------------------------------------------------\n");
				scanner.nextLine();
				System.out.println("Enter the menu type(morning,afternoon,evening)");
				String menutype = scanner.nextLine();
				System.out.println("------------------------------------------------------");
				System.out.println("Enter item name");
				String itemname = scanner.nextLine();
				System.out.println("------------------------------------------------------");
				System.out.println("Enter item type(biriyani,breakfast,dessert...)");
				String itemtype = scanner.nextLine();
				System.out.println("------------------------------------------------------");
				System.out.println("Enter price of the item");
				int price = scanner.nextInt();
				System.out.println("------------------------------------------------------");
				System.out.println("Enter the servings of the food");
				int servings = scanner.nextInt();
				System.out.println("------------------------------------------------------");
				System.out.println("Enter the food category(veg/non-neg)");
				scanner.nextLine();
				System.out.println("------------------------------------------------------");
				String category = scanner.nextLine();
				Menu menu = new Menu(menutype, itemname, itemtype, price, servings, category);
				menuService.addMenu(menu);

				break;
			// to update Menu
			case 3:
				System.out.println("\n ------------------------------------------------------ \n");
				System.out.println("Enter the item Price that to be updated ");
				double prices = scanner.nextDouble();
				System.out.println("------------------------------------------------------");
				System.out.println("Enter the item id ");
				int itemid = scanner.nextInt();
				System.out.println("------------------------------------------------------");
				try {
					menuService.updateMenu(prices, itemid);
				} catch (ItemNotFoundException e) {

					System.out.println(e.getMessage());
				}
				System.out.println();
				break;
			// to delete an item
			case 4:
				System.out.println("\n ------------------------------------------------------ \n");
				System.out.println("Enter the itemId to delete the item");
				int itemids = scanner.nextInt();
				System.out.println("------------------------------------------------------");
				try {
					menuService.deleteMenu(itemids);
				} catch (ItemNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;
			// To show Menu
			case 5:
				System.out.println("\n ------------------------------------------------------ \n");
				menuService.getAllMenu().forEach(System.out::println);
				System.out.println();
				break;

			// to show menu type

			case 6:
				System.out.println("\n ------------------------------------------------------ \n");
				System.out.println("Enter the menu type(morning,afternoon,evening)");
				scanner.nextLine();
				System.out.println("------------------------------------------------------");
				String menutypes = scanner.nextLine();
				try {
					menuService.getByMenuType(menutypes).forEach(System.out::println);
				} catch (MenuNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;

			// to show menu by category
			case 7:
				System.out.println("\n ------------------------------------------------------ \n");
				System.out.println("Enter the menu category(veg/non-veg)");
				scanner.nextLine();
				System.out.println("------------------------------------------------------");
				String categoryy = scanner.nextLine();
				try {
					menuService.getByCategory(categoryy).forEach(System.out::println);
				} catch (CategoryNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;

			// to show menu by pricelessthan
			case 8:
				System.out.println("\n ------------------------------------------------------ \n");
				System.out.println("Enter the maximum price");
				scanner.nextLine();
				System.out.println("------------------------------------------------------");
				double pricee = scanner.nextDouble();
				try {
					menuService.getbyPrice(pricee).forEach(System.out::println);
				} catch (ItemNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;
			// to show my by itemtype
			case 9:
				System.out.println("\n ------------------------------------------------------ \n");
				System.out.println("Enter the itemtype(breakfast,dessert,biriyani,main course)");
				System.out.println("------------------------------------------------------");
				scanner.nextLine();
				String itemtypee = scanner.nextLine();
				try {
					menuService.getByItemtype(itemtypee).forEach(System.out::println);
				} catch (ItemNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;
			case 10:
				System.out.println("\n ------------------------------------------------------ \n");
				System.exit(0);
				break;
			default:
				System.out.println("Please check and enter the valid option");
				System.out.println();
				break;
			}
		}

	}
}
