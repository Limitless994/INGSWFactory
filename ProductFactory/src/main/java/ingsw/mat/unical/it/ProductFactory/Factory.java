package ingsw.mat.unical.it.ProductFactory;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;

public class Factory extends Panel {

	private Display display;
	private Product out;
	public int width, height;
	public String title;
	public ArrayList<Product> products = new ArrayList<Product>(); // Create an ArrayList object

	private BufferStrategy bs;
	private Graphics g;

	public Factory(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void init(){
		display = new Display(title, width, height);
		Assets.init();
		display.b.addActionListener(new ActionListener() {          
			public void actionPerformed(ActionEvent e) {

				out = new AndroidPhone("Samsung", "S10", 8);
				System.out.println("Added an Android phone to shelf");
				add(out);

			}
		}); 
		display.b2.addActionListener(new ActionListener() {          
			public void actionPerformed(ActionEvent e) {
				out = new IosPhone("Apple", "Iphone 10", 6);
				System.out.println("Added an iPhone to shelf");
				add(out);
			}
		});
		display.b3.addActionListener(new ActionListener() {          
			public void actionPerformed(ActionEvent e) {
				remove();
			}

		});
	}

	public void add(Product p) {
		if(products.size()<=7) {
			products.add(p);
		}
	}

	public void remove() {
		if(products.size()>=1) {
			System.out.println("Rimosso");
			products.remove(products.size()-1);
		}

	}
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		//Draw Here!
		g.drawImage(Assets.bg, 0, 200, null);
		int i=50;

		//Iterator<Product> iter = products.iterator();

		for(Product it:products) {
			if(it instanceof AndroidPhone) {
				g.drawImage(Assets.android, i, 280, null);
			}else if(it instanceof IosPhone) {
				g.drawImage(Assets.iphone, i, 280, null);
			}
			i+=100;
		}
		bs.show();
		g.dispose();
	}

	public void run(){

		init();
		while(1!=100)render();
	}


	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}






