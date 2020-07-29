package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter Client data\nName: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birth = sdf.parse(sc.nextLine());
		System.out.print("Enter order data:\nStatus: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Client client = new Client(name, email, birth);
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order?: ");
		int items = sc.nextInt();
		
		for(int i = 0; i < items; i++) {
			i++;
			System.out.println("Enter #"+i+" item data:");
			i--;
			System.out.print("Product name: ");
			sc.nextLine();
			String nameP = sc.nextLine();
			
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			Product product = new Product(nameP, price);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			
			OrderItem orderItem = new OrderItem(quantity, price, product); 
			order.addItem(orderItem);
			
		}
		
		
		
		System.out.println("\nORDER SUMMARY:");
		System.out.println(order.toString());
		
		
		
		sc.close();
	}

}
