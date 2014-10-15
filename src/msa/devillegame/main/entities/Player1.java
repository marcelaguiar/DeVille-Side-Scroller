package msa.devillegame.main.entities;


import java.awt.Graphics;

import msa.devillegame.main.Game;
import msa.devillegame.main.gfx.Animation;
import msa.devillegame.main.gfx.ImageManager;

public class Player1 {

	int x1, y1;  //made public to package
	private ImageManager im;
	public boolean left1 = false, right1 = false, jump1 = false, attack1 = false, shoot1 = false;
	public boolean left1Interrupted = false, right1Interrupted = false;
	public boolean leftClearFromP2 = true, rightClearFromP2 = true, topClearFromP2 = true;
	public double counter1 = 4;
	private int speed = 6;
	public static String directionFacing1 = "right";
	public static String p2RelativePosition = "left";

	private Animation P1AttackLeftAnimation;
	private Animation P1WalkLeftAnimation;
	private Animation P1JumpLeftAnimation;
	private Animation P1FlashLeftAnimation;
	
	
	public Player1(int x, int y, ImageManager im) {
		this.x1 = x;
		this.y1 = y;
		this.im = im;
		
		P1AttackLeftAnimation = new Animation(im.player1AttackLeft, 20);
		P1WalkLeftAnimation = new Animation(im.player1WalkLeft, 50);
		P1JumpLeftAnimation = new Animation(im.player1JumpLeft, 50);
		P1FlashLeftAnimation = new Animation(im.player1FlashLeft, 50);
	}
	
	public void tick() {
		// Determine what side opponent is on
		if(Game.getPlayer2().x2 - x1 > 0)
			p2RelativePosition = "right";
		else if(x1 - Game.getPlayer2().x2 > 0)
			p2RelativePosition = "left";
		else
			p2RelativePosition = "same";
		
		//Determine if player1 can move left or right
		if(Math.abs(Game.getPlayer2().x2 - x1) < 40 && directionFacing1 == "left" && p2RelativePosition == "left" && Math.abs(Game.getPlayer2().y2 - y1) < 280)
			leftClearFromP2 = false;
		else
			leftClearFromP2 = true;
		
		if(Math.abs(Game.getPlayer2().x2 - x1) < 40 && directionFacing1 == "right"&& p2RelativePosition == "right" && Math.abs(Game.getPlayer2().y2 - y1) < 280)
			rightClearFromP2 = false;
		else
			rightClearFromP2 = true;
		
		//Check if left, right, and up movements are OK to go
		if(left1)
		{
			if(x1 >= -140)
			{
				if(leftClearFromP2)
				{
					x1 -= speed;
				}
			}
		}	
		if(right1)
		{
			if(x1 <= 870)
			{
				if(rightClearFromP2)
				{
					x1 += speed;
				}
			}
		}
		if(jump1)
		{
			if(y1 >= -100 && topClearFromP2)
			{
				y1 = -100;
			}
		}
		else
		{
			y1 += 10;
		}
		
		//keep character above floor
        if(y1 > 200) y1 = 200;
        
        // Update animation image indexes
		P1WalkLeftAnimation.tick();
		P1AttackLeftAnimation.tick();
		P1JumpLeftAnimation.tick();
		P1FlashLeftAnimation.tick();
	}
	
	public void render(Graphics g) {
		
		if(attack1)
		{
			if(directionFacing1 == "left")
				P1AttackLeftAnimation.render(g, x1, y1, 400 * Game.SCALE, 400 * Game.SCALE);
			else if(directionFacing1 == "right")
				P1AttackLeftAnimation.render(g, x1+400, y1, -400 * Game.SCALE, 400* Game.SCALE);
		}
		else if(left1 && right1) // I don't this this case ever happens
		{
			if(directionFacing1 == "left")
				g.drawImage(im.player2IdleLeft, x1, y1, 400 * Game.SCALE, 400 * Game.SCALE, null);
			else if(directionFacing1 == "right")
				g.drawImage(im.player2IdleRight, x1, y1, 400 * Game.SCALE, 400* Game.SCALE, null);
		}
		else if(left1)
		{
			P1WalkLeftAnimation.render(g, x1, y1, 400 * Game.SCALE, 400 * Game.SCALE);
		}
		else if(right1)
		{
			P1WalkLeftAnimation.render(g, x1+400, y1, -400 * Game.SCALE, 400 * Game.SCALE);
		}
		else if(jump1)
		{
			if(directionFacing1 == "left")
			{
				P1JumpLeftAnimation.render(g, x1, y1, 400 * Game.SCALE, 400 * Game.SCALE);
				P1FlashLeftAnimation.render(g, x1, 200, 400 * Game.SCALE, 400 * Game.SCALE);
			}
			else if(directionFacing1 == "right")
			{
				P1JumpLeftAnimation.render(g, x1+400, y1, -400 * Game.SCALE, 400 * Game.SCALE);
				P1FlashLeftAnimation.render(g, x1+400, 200, -400 * Game.SCALE, 400 * Game.SCALE);
			}
		}
		else
		{
			if(directionFacing1 == "left")
				g.drawImage(im.player1IdleLeft, x1, y1, 400 * Game.SCALE, 400* Game.SCALE, null);
			else if(directionFacing1 == "right")
				g.drawImage(im.player1IdleLeft, x1+400, y1, -400 * Game.SCALE, 400* Game.SCALE, null);
		}
	}
}
