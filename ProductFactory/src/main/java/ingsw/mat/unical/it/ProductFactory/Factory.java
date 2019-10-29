package ingsw.mat.unical.it.ProductFactory;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Factory implements Runnable {

	private Display display;
	private Product out;
	public int width, height;
	public String title;
	ArrayList<Product> products = new ArrayList<Product>(); // Create an ArrayList object


	private boolean running = false;
	private Thread thread;

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
				if(products.size()<=7) {
					out = new AndroidPhone("Samsung", "S10", 8);
					System.out.println("Added an Android phone to shelf");
					products.add(out);
				}else {
					System.out.println("Scaffale Pieno");	
				}
			}
		}); 
		display.b2.addActionListener(new ActionListener() {          
			public void actionPerformed(ActionEvent e) {
				if(products.size()<=7) {
					out = new IosPhone("Apple", "Iphone 10", 6);
					System.out.println("Added an iPhone to shelf");
					products.add(out);
				}else {
					System.out.println("Scaffale Pieno");	
				}
			}
		});
		display.b3.addActionListener(new ActionListener() {          
			public void actionPerformed(ActionEvent e) {
				if(products.size()>=1) {
					System.out.println("Rimosso");
					products.remove(products.size()-1);
				}
			}

		});
	}

	private void tick(){
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
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}






