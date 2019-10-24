package ingsw.mat.unical.it.ProductFactory;
import java.util.Scanner;

public class ProductFactory {

	public Product getProduct (ProductType type){
		Product out = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Insert the product brand: ");
		String brand = scanner.nextLine();
		System.out.print("Insert the product model: ");
		String model = scanner.nextLine();
		if(type==ProductType.Smartphone) {
			System.out.print("Insert the ram value: ");
			int ram = scanner.nextInt();
			out = new Smartphone(brand, model, ram);
		}
		if(type==ProductType.Smartwatch) {
			System.out.print("Insert the smartwacth ram value: ");
			int power = scanner.nextInt();
			out = new Smartwatch(brand, model, power);
		}
		return out;
	}
}