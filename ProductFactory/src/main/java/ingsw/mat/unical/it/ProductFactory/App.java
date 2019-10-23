package ingsw.mat.unical.it.ProductFactory;

import ingsw.mat.unical.it.ProductFactory.Product.productId;

public class App 
{
	public static void main( String[] args )
	{
		ProductFactory factory = new ProductFactory();
		Product p = factory.getProduct(productId.Smartphone);
		p.printStats();
		Product p2 = factory.getProduct(productId.Vacuum);
		p2.printStats();
	}
}
