package msa.devillegame.main.gfx;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;



public class HealthBar {
	
	int healthP1;
	int healthP2;
	
	public void render(Graphics g) {
		paintComponent(g); //figure out why this isn't optimal code.
	}
	
	//Constructor
	public HealthBar(int healthP1, int healthP2) {
		this.healthP1 = healthP1;
		this.healthP2 = healthP2;
	}

	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		//Player 1 health bar
		g2.setColor(Color.RED);
		Rectangle redBarP1 = new Rectangle(12, 10, 300, 30);
		g2.fill(redBarP1);
		
		g2.setColor(Color.GREEN);
		Rectangle greenBarP1 = new Rectangle(12 + (300 - healthP1), 10, healthP1, 30);
		g2.fill(greenBarP1);
		
		//Player 2 health bar
		g2.setColor(Color.RED);
		Rectangle redBarP2 = new Rectangle(798, 10, 300, 30);
		g2.fill(redBarP2);
		
		g2.setColor(Color.GREEN);
		Rectangle greenBarP2 = new Rectangle(798, 10, healthP2, 30);
		g2.fill(greenBarP2);
	}
}
