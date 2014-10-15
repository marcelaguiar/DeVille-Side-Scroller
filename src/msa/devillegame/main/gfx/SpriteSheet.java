package msa.devillegame.main.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int col, int row, int w, int h) {
		return sheet.getSubimage(col * 400, row * 400, w, h);
	}
}
