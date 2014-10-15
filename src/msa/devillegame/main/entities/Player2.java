package msa.devillegame.main.entities;


import java.awt.Graphics;

import msa.devillegame.main.Game;
import msa.devillegame.main.gfx.Animation;
import msa.devillegame.main.gfx.ImageManager;

public class Player2 {

	int x2, y2; //made public to package
	private ImageManager im;
	public boolean left2 = false, right2 = false, jump2 = false, attack2 = false, shoot2 = false;
	public boolean left2Interrupted = false, right2Interrupted = false;
	public boolean leftClearFromP1 = true, rightClearFromP1 = true, topClearFromP1 = true;
	private int speed = 6;
	public double counter2 = 4;
	public static String directionFacing2 = "left";
	public static String p1RelativePosition = "left";
	
	private Animation P2AttackLeftAnimation;
	private Animation P2WalkLeftAnimation;
	private Animation P2JumpLeftAnimation;
	
	
	public Player2(int x, int y, ImageManager im) {
		this.x2 = x;
		this.y2 = y;
		this.im = im;
		
		P2AttackLeftAnimation = new Animation(im.player2AttackLeft, 30);
		P2WalkLeftAnimation = new Animation(im.player2WalkLeft, 50);
		P2JumpLeftAnimation = new Animation(im.player2JumpLeft, 20);
	}
	
	public void tick() {
		
		/* Determine what side opponent is on */
		if(x2 - Game.getPlayer1().x1 > 0)
			p1RelativePosition = "left";
		else if(Game.getPlayer1().x1 - x2 > 0)
			p1RelativePosition = "right";
		else
			p1RelativePosition = "same";

		/* Determine if player2 can move left or right */
		if(Math.abs(Game.getPlayer1().x1 - x2) < 40 && directionFacing2 == "left" && p1RelativePosition == "left" && Math.abs(Game.getPlayer1().y1 - y2) < 280)
			leftClearFromP1 = false;
		else
			leftClearFromP1 = true;
		
		if(Math.abs(Game.getPlayer1().x1 - x2) < 40 && directionFacing2 == "right" && p1RelativePosition == "right" && Math.abs(Game.getPlayer1().y1 - y2) < 280)
			rightClearFromP1 = false;
		else
			rightClearFromP1 = true;
		
		//move left/right/up
		if(left2)
		{
			if(x2 >= -140)
			{
				if(leftClearFromP1)
				{
					x2 -= speed;
				}
			}
		}	
		if(right2)
		{
			if(x2 <= 870)
			{
				if(rightClearFromP1)
				{
					x2 += speed;
				}
			}
		}
		
		if(jump2)
		{
			/*if(y2 >= -100)
			{
				counter2 += 0.2;
				y2 = y2 - (int) ((Math.sin(counter2) + Math.cos(counter2))*15);
				
				if(counter2 == 7)
				{
					counter2 = 4;
				}
			}*/
			if(y2 >= -100 && topClearFromP1)
			{

				y2 = -100;
			}
		}
		else
		{
			y2 += 10;
		}
		
		//keep character above floor
        if(y2 > 200) y2 = 200;
        
        //no need for walking when in the air
        if(y2 != 200 && !jump2)
        {
        	
        }
		
		P2AttackLeftAnimation.tick();
		P2WalkLeftAnimation.tick();
		P2JumpLeftAnimation.tick();
	}
	
	public void render(Graphics g) {
		
		if(attack2)
		{
			if(directionFacing2 == "left")
				P2AttackLeftAnimation.render(g, x2, y2, 400 * Game.SCALE, 400 * Game.SCALE);
			else if(directionFacing2 == "right")
				P2AttackLeftAnimation.render(g, x2+400, y2, -400 * Game.SCALE, 400* Game.SCALE);
		}
		else if(left2 && right2) // I don't this this case ever happens
		{
			if(directionFacing2 == "left")
				g.drawImage(im.player2IdleLeft, x2, y2, 400 * Game.SCALE, 400 * Game.SCALE, null);
			else if(directionFacing2 == "right")
				g.drawImage(im.player2IdleRight, x2, y2, 400 * Game.SCALE, 400* Game.SCALE, null);
		}
		else if(left2)
		{
			P2WalkLeftAnimation.render(g, x2, y2, 400 * Game.SCALE, 400 * Game.SCALE);
		}
		else if(right2)
		{
			P2WalkLeftAnimation.render(g, x2+400, y2, -400 * Game.SCALE, 400 * Game.SCALE);
		}
		else if(jump2)
		{
			if(directionFacing2 == "left")
			{
				P2JumpLeftAnimation.render(g, x2, y2, 400 * Game.SCALE, 400 * Game.SCALE);
			}
			else if(directionFacing2 == "right") //never put a semicolon here ever again. FUCK.
			{
				P2JumpLeftAnimation.render(g, x2+400, y2, -400 * Game.SCALE, 400 * Game.SCALE);
			}
		}
		else
		{
			if(directionFacing2 == "left")
				g.drawImage(im.player2IdleLeft, x2, y2, 400 * Game.SCALE, 400 * Game.SCALE, null);
			else if(directionFacing2 == "right")
				g.drawImage(im.player2IdleLeft, x2+400, y2, -400 * Game.SCALE, 400* Game.SCALE, null);
		}
	}
}
