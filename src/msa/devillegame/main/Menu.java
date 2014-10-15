package msa.devillegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu {
	
	public Rectangle playButton = new Rectangle(150, 10, 230, 140);

	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.drawImage(getImage("res/menuBackground.png"), 0, 0, null);
		
		g.setColor(Color.black);
		
		g2d.draw(playButton);
		
	}
	
	//Maybe I should make use of my image loader class instead?
	public Image getImage(String path) {
		
		Image tempImage = null;
		
		File image2 = new File(path);
		try {
			tempImage = ImageIO.read(image2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempImage;
	}
}
