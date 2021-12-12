package com.kitchenapp.client;

import java.util.Scanner;

import com.kitchenapp.exceptions.CartNotFoundException;
import com.kitchenapp.exceptions.CategoryNotFoundException;
import com.kitchenapp.exceptions.ItemNotFoundException;
import com.kitchenapp.exceptions.MenuNotFoundException;
import com.kitchenapp.exceptions.OrderNotFoundExpection;
import com.kitchenapp.exceptions.UserNotFoundException;
import com.kitchenapp.model.Cart;
import com.kitchenapp.model.Customer;
import com.kitchenapp.service.CartServiceImpl;
import com.kitchenapp.service.ICartService;
import com.kitchenapp.service.IMenuService;
import com.kitchenapp.service.IOrderService;
import com.kitchenapp.service.IUserService;
import com.kitchenapp.service.MenuServiceImpl;
import com.kitchenapp.service.OrderServiceImpl;
import com.kitchenapp.service.UserServiceImpl;

/**
 * @author ArunSaiSurapaneni
 *
 */
public class Client {
	public static void main(String[] args) throws CartNotFoundException {
		IUserService userService = new UserServiceImpl();
		IMenuService menuService = new MenuServiceImpl();
		IOrderService orderService = new OrderServiceImpl();
		ICartService cartService = new CartServiceImpl();
		String items = "";
		Scanner scanner = new Scanner(System.in);
		cartService.clearCart();
		cartService.clearCalculateOrder();
		while (true) {
			
			System.out.println("\n------------------------------------------------------\n");
			System.out.println("Press 1) To Display Whole Menu");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 2) To Display By Category Veg / Non-Veg ");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 3) To Display By Morning \t Afternoon \t Evening");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 4) To Display Menu by Type ( Dessert,  Main Course, Biriyani, Breakfast)");
			System.out.println("------------------------------------------------------");
			System.out.println("Press 5) To Order Food ");
			System.out.println("------------------------------------------------------");
			System.out.println("\n------------------------------------------------------\n");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Items in menu");
				System.out.println("------------------------------------------------------");
				menuService.getAllMenu().forEach(System.out::println);
				System.out.println("------------------------------------------------------");
				break;
			case 2:
				System.out.println("Items in Menu By category");
				System.out.println("Enter the menu category(veg/non-veg)");
				scanner.nextLine();
				String categoryy = scanner.nextLine();
				try {
					menuService.getByCategory(categoryy).forEach(System.out::println);
				} catch (CategoryNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;
			case 3:
				System.out.println("Items by By Morning \t Afternoon \t Evening");
				System.out.println("Enter the menu type(morning,afternoon,evening)");
				scanner.nextLine();
				String menutypes = scanner.nextLine();
				try {
					menuService.getByMenuType(menutypes).forEach(System.out::println);
				} catch (MenuNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;
			case 4:
				System.out.println("------------------------------------------------------");
				System.out.println("Press 4 to show Menu by item type(dessert,main course,biriyani,breakfast)");
				scanner.nextLine();
				String itemtypee=scanner.nextLine();
				try {
				menuService.getByItemtype(itemtypee).forEach(System.out::println);
				}catch(ItemNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;
			case 5:
				System.out.println("------------------------------------------------------");
				System.out.println("To Order Food You need to login or \t SignUp");
				System.out.println("------------------------------------------------------");
				System.out.println("Press 1 to login \t \t  Press 2 to Sign-Up");
				System.out.println("------------------------------------------------------");
				
				int option = scanner.nextInt();
				if (option == 1) {
					System.out.println("\n ------------------------------------------------------ \n");
					System.out.println("Enter your email");
					String email = scanner.next();
					System.out.println("------------------------------------------------------");
					System.out.println("Enter Your Password");
					String password = scanner.next();
					System.out.println("------------------------------------------------------");
					
					try {
						userService.selectUser(email, password);
						while (true) {
							System.out.println("Press 1 To Order Food / Add More Food");
							System.out.println("------------------------------------------------------");
							/*
							 * System.out.println("Press 2 To Display Cart items");
							 * System.out.println("------------------------------------------------------");
							 */
							System.out.println("Press 2 To Place your order");
							System.out.println("------------------------------------------------------");
							System.out.println("Press 3 To Show previous Orders");
							System.out.println("------------------------------------------------------");
							System.out.println("Press 4 To Logout");
							System.out.println("------------------------------------------------------");
							int options = scanner.nextInt();
							switch (options) {
							case 1:
								System.out.println("Enter Item name to order food");
								scanner.nextLine();
								String itemname = scanner.nextLine();
								System.out.println("Enter the Item Quantity");
								int quantity = scanner.nextInt();
								String quantities = String.valueOf(quantity);
								items ="Items in cart :"+ items + itemname + " x " + quantities + " + ";
								
								System.out.println("Do You wish to add more more ");
								System.out.println("------------------------------------------------------");
								Cart cart = new Cart(email, itemname, quantity, 0);
								cartService.addItemToCart(cart);
								System.out.println(items);
								System.out.println("------------------------------------------------------");
								break;
							/*
							 * case 2: System.out.println("Items in Cart");
							 * System.out.println("------------------------------------------------------");
							 * cartService.calculateOrder();
							 * cartService.getAllCart().forEach(System.out::println);
							 * System.out.println("------------------------------------------------------");
							 * break;
							 */
							case 2:
								cartService.calculateOrder();
								System.out.println("Order is Placed ");
								System.out.println("------------------------------------------------------");
								orderService.orderFood(email, items);
								cartService.clearCart();
								cartService.clearCalculateOrder();
								break;
							case 3:
								System.out.println("------------------------------------------------------");
								System.out.println("Previous Orders");
								try {
									orderService.showOrders(email).forEach(System.out::println);
									System.out.println("------------------------------------------------------");
								} catch (OrderNotFoundExpection e) {
									e.printStackTrace();
								}
								break;
							case 4:
								System.out.println("Thank U for Visiting");
								
								System.exit(0);
							default:
								System.out.println("Please Check the input");
								break;
							}

						}

					} catch (UserNotFoundException e) {

						System.out.println("User not Found");;
					}

				} else {
					System.out.println("\n ------------------------------------------------------ \n ");
					System.out.println();
					System.out.println("Enter your Name : ");
					System.out.println("------------------------------------------------------");
					scanner.nextLine();
					String name = scanner.nextLine();
					System.out.println("Enter your Phone Number");
					String number = scanner.next();
					System.out.println("------------------------------------------------------");
					long phonenumber = Long.valueOf(number);
					System.out.println("Enter your Address ");
					scanner.nextLine();
					String address = scanner.nextLine();
					System.out.println("------------------------------------------------------");
					System.out.println("Enter your pincode");
					String pincode = scanner.nextLine();
					System.out.println("------------------------------------------------------");
					System.out.println("Enter your Email");
					String mail = scanner.nextLine();
					System.out.println("------------------------------------------------------");
					System.out.println("Enter your password");
					String passwords = scanner.nextLine();
					System.out.println("------------------------------------------------------");
					Customer customer = new Customer(name, phonenumber, address, pincode, mail, passwords);
					userService.createUser(customer);
					System.out.println("Account Created Sucessfully \t Proceed to Login");
				}
			}
		}

	}

}
