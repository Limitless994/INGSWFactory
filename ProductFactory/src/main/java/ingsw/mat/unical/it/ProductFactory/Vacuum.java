package ingsw.mat.unical.it.ProductFactory;

public class Vacuum implements Product {
	String brand;
	String model;
	int power;
	Vacuum(String b, String m,int p){
		brand=b;
		model=m;
		power=p;
	}

	public void printStats() {
		System.out.println("Vacuum-> Brand:" + brand + " Model:"+model+" Power:"+power);

	}

}
