package ingsw.mat.unical.it.ProductFactory;

import java.util.Scanner;

import ingsw.mat.unical.it.ProductFactory.Product.productId;

public class ProductFactory {

	public Product getProduct (productId type){
		Product out = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Insert the product brand: ");
		String brand = scanner.nextLine();
		System.out.print("Insert the product model: ");
		String model = scanner.nextLine();
		switch (type){
		case Smartphone:
			System.out.print("Insert the ram value: ");
			int ram = scanner.nextInt();
			out = new Smartphone(brand, model, ram);
			break;
		case Vacuum:
			System.out.print("Insert the vacuum power: ");
			int power = scanner.nextInt();
			out = new Vacuum(brand, model, power);
			break;
		}
		return out;
	}
}
