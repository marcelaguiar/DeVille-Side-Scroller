package msa.devillegame.main.gfx;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HealthBarBorders {
	
	private Image healthBorder1 = null;
	private Image healthBorder2 = null;
	
	public HealthBarBorders(String s1, String s2) {
			healthBorder1 = getImage(s1);
			healthBorder2 = getImage(s2);
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(healthBorder1, 10, 10, 304, 30, null);
		g2.drawImage(healthBorder2, 796, 10, 304, 30, null);
	}
	
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
