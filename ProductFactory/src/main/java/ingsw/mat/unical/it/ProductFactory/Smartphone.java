package ingsw.mat.unical.it.ProductFactory;

public class Smartphone implements Product {

	String brand;
	String model;
	int ram;
	Smartphone(String b, String m,int r){
		brand=b;
		model=m;
		ram=r;
	}

	public void printStats() {
		System.out.println("Smartphone-> Brand:" + brand + " Model:"+model+" Ram:"+ram);
	}

}
