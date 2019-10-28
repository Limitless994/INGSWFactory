package ingsw.mat.unical.it.ProductFactory;

public class IosPhone extends Smartphone {

	IosPhone(String b, String m, int r) {
		super(b, m, r);
	}
	public void printStats() {
		System.out.println("IOS2-> Brand:" + brand + " Model:"+model+" Ram:"+ram);
	}
}
