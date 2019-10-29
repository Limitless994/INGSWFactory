package ingsw.mat.unical.it.ProductFactory;
public class FactoryMethod
{
	public static void main(String[] args)
	{
		Factory f = new Factory("My factory",1000,1000);
		f.run();
	}
}

