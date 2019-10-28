package ingsw.mat.unical.it.ProductFactory;

import java.awt.image.BufferedImage;

public class Assets {
		
	public static BufferedImage iphone, android, bg;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("shelf.png"));
		SpriteSheet sheetIphone = new SpriteSheet(ImageLoader.loadImage("iphone.png"));
		SpriteSheet sheetAndroid = new SpriteSheet(ImageLoader.loadImage("Android.png"));
		iphone = sheetIphone.crop(0, 0, 200, 150);
		android = sheetAndroid.crop(0, 0, 200, 150);
		bg = sheet.crop(0, 0, 1000, 308);

	}
	
}
