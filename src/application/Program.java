package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Locale.setDefault(Locale.US);
			Scanner tec = new Scanner(System.in);
			
			List<Product> productList = new ArrayList<>();
			
			System.out.print("Enter the number of products: ");
			int n  = tec.nextInt();
			
			for(int i = 1; i <= n; i++)
			{
				System.out.println("Product #" +i +" data:");
				System.out.print("Common, used or imported (c/u/i)? ");
				char response = tec.next().charAt(0);
				System.out.print("Name: ");
				tec.nextLine();
				String name = tec.nextLine();
				System.out.print("Price: ");
				double price = tec.nextDouble();
				
				switch(response)
				{
					case 'c':
						productList.add(new Product(name, price));
						break;
					case 'u':
						System.out.print("Manufacture date (DD/MM/YYYY): ");
						String date = tec.next();
						productList.add(new UsedProduct(name, price, sdf.parse(date)));
						break;
					default:
						System.out.print("Customs fee: ");
						double customsFee = tec.nextDouble();
						productList.add(new ImportedProduct(name, price, customsFee));
				}
			}
			
			System.out.println();
			System.out.println("PRICE TAGS:");
			
			for(Product p : productList)
			{
				System.out.println(p.priceTag());
			}
			tec.close();
	}

}
