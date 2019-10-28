package ingsw.mat.unical.it.ProductFactory;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width, height;
	public Button b,b2,b3;
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		b=new Button("AndroidPhone");
		b2=new Button("Iphone");  
		b3=new Button("Rimuovi");  
		b.setBounds(475,500,100,30); 
		b2.setBounds(475,550,100,30);  
		b3.setBounds(475,600,100,30);  
		frame.add(b);  
		frame.add(b2);
		frame.add(b3);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));

		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas(){
		return canvas;
	}


}
