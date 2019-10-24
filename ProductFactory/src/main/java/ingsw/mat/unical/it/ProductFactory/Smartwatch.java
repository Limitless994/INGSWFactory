package ingsw.mat.unical.it.ProductFactory;
public class Smartwatch implements Product {

	String brand;
	String model;
	int ram;
	Smartwatch(String b, String m,int r){
		brand=b;
		model=m;
		ram=r;
		
	}

	public void printStats() {
		System.out.println("Smartwatch-> Brand:" + brand + " Model:"+model+" Ram:"+ram);
	}

}