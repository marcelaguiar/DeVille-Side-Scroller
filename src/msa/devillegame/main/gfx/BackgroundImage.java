package msa.devillegame.main.gfx;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundImage {
	
	private Image background = null;

	
	public BackgroundImage(String s) {
			background = getImage(s);
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(background, 0, -27, 1200, 600, null); //Change x & y to adjust background image position
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
