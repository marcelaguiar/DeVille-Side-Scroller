package msa.devillegame.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import msa.devillegame.main.Game.STATE;
import msa.devillegame.main.entities.Player1;
import msa.devillegame.main.entities.Player2;


public class KeyManager implements KeyListener{

	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		if (Game.State == STATE.GAME) {
			
			/*----------------------- Player 1 ---------------------------*/
			if (keyCode == KeyEvent.VK_A) // P1 Move Left
			{
				if (Game.getPlayer1().attack1 && Game.getPlayer1().right1Interrupted)
				{
					Player1.directionFacing1 = "right";
					Game.getPlayer1().right1Interrupted = true;
					Game.getPlayer1().left1Interrupted = true;
				}
				else if (Game.getPlayer1().attack1)
				{
					Game.getPlayer1().attack1 = false;
					Player1.directionFacing1 = "left";
					Game.getPlayer1().left1 = true;
				}
				else if (Game.getPlayer1().right1)
				{
					Player1.directionFacing1 = "right";
					Game.getPlayer1().right1Interrupted = true;
					Game.getPlayer1().left1Interrupted = true;
					Player1.directionFacing1 = "right";
					Game.getPlayer1().right1 = false;
				}
				else if (Game.getPlayer1().left1Interrupted && Game.getPlayer1().right1Interrupted)
				{
					// do nothing
				}
				else if (Game.getPlayer1().left1Interrupted)
				{
					Player1.directionFacing1 = "left";
					Game.getPlayer1().left1 = true;
				}
				else if (Game.getPlayer1().attack1 == false && Game.getPlayer1().right1Interrupted == false)
				{
					Player1.directionFacing1 = "left";
					Game.getPlayer1().left1Interrupted = false;
					Game.getPlayer1().left1 = true;
				}// Maybe have a !attack && !leftint? ^ to counter that
			}

			if (keyCode == KeyEvent.VK_D) // P1 Move Right
			{
				if (Game.getPlayer1().attack1 && Game.getPlayer1().left1Interrupted)
				{
					Player1.directionFacing1 = "left";
					Game.getPlayer1().left1Interrupted = true; // probably don't need this
					Game.getPlayer1().right1Interrupted = true;
				}
				else if (Game.getPlayer1().attack1)
				{
					Game.getPlayer1().attack1 = false;
					Player1.directionFacing1 = "right";
					Game.getPlayer1().right1 = true;
				}
				else if (Game.getPlayer1().left1)
				{
					Player1.directionFacing1 = "left";
					Game.getPlayer1().left1Interrupted = true;
					Game.getPlayer1().right1Interrupted = true;
					Game.getPlayer1().left1 = false;
				}
				else if (Game.getPlayer1().left1Interrupted && Game.getPlayer1().right1Interrupted)
				{
					// do nothing
				}
				else if (Game.getPlayer1().right1Interrupted)
				{
					Player1.directionFacing1 = "right";
					Game.getPlayer1().right1 = true;
				}
				else if (Game.getPlayer1().attack1 == false && Game.getPlayer1().left1Interrupted == false)
				{
					Player1.directionFacing1 = "right";
					Game.getPlayer1().right1Interrupted = false;
					Game.getPlayer1().right1 = true;
				}
			}

			if (keyCode == KeyEvent.VK_C) // P1 Attack
			{
				if (Game.getPlayer1().left1 && Game.getPlayer1().right1) // this never executes?
				{
					Game.getPlayer1().left1Interrupted = true;
					Game.getPlayer1().right1Interrupted = true;
					Game.getPlayer1().left1 = false;
					Game.getPlayer1().right1 = false;
				}
				else if (Game.getPlayer1().left1)
				{
					Game.getPlayer1().left1Interrupted = true;
					Game.getPlayer1().left1 = false;
					Player1.directionFacing1 = "left";
				}
				else if (Game.getPlayer1().right1)
				{
					Game.getPlayer1().right1Interrupted = true;
					Game.getPlayer1().right1 = false;
					Player1.directionFacing1 = "right";
				}

				Game.getPlayer1().attack1 = true;
			}

			if (keyCode == KeyEvent.VK_F) // P1 Shoot
			{
				Game.getPlayer1().shoot1 = true;
			}

			if (keyCode == KeyEvent.VK_W) // P1 Jump
			{
				Game.getPlayer1().jump1 = true;
			}

			/*----------------------- Player 2 ---------------------------*/

			if (keyCode == KeyEvent.VK_L) // P2 Move Left
			{
				if (Game.getPlayer2().attack2 && Game.getPlayer2().right2Interrupted)
				{
					Player2.directionFacing2 = "right";
					Game.getPlayer2().right2Interrupted = true;
					Game.getPlayer2().left2Interrupted = true;
				}
				else if (Game.getPlayer2().attack2)
				{
					Game.getPlayer2().attack2 = false;
					Player2.directionFacing2 = "left";
					Game.getPlayer2().left2 = true;
				}
				else if (Game.getPlayer2().right2)
				{
					Player2.directionFacing2 = "right";
					Game.getPlayer2().right2Interrupted = true;
					Game.getPlayer2().left2Interrupted = true;
					Game.getPlayer2().right2 = false;
				}
				else if (Game.getPlayer2().left2Interrupted && Game.getPlayer2().right2Interrupted)
				{
					// do nothing
				}
				else if (Game.getPlayer2().left2Interrupted)
				{
					Player2.directionFacing2 = "left";
					Game.getPlayer2().left2 = true;
				}
				else if (Game.getPlayer2().attack2 == false && Game.getPlayer2().right2Interrupted == false)
				{
					Player2.directionFacing2 = "left";
					Game.getPlayer2().left2Interrupted = false;
					Game.getPlayer2().left2 = true;
				}// Maybe have a !attack && !leftint? ^ to counter that
			}

			if (keyCode == KeyEvent.VK_QUOTE) // P2 Move Right
			{
				if (Game.getPlayer2().attack2 && Game.getPlayer2().left2Interrupted)
				{
					Player2.directionFacing2 = "left";
					Game.getPlayer2().left2Interrupted = true; // probably don't need this
					Game.getPlayer2().right2Interrupted = true;
				}
				else if (Game.getPlayer2().attack2)
				{
					Game.getPlayer2().attack2 = false;
					Player2.directionFacing2 = "right";
					Game.getPlayer2().right2 = true;
				}
				else if (Game.getPlayer2().left2)
				{
					Player2.directionFacing2 = "left";
					Game.getPlayer2().left2Interrupted = true;
					Game.getPlayer2().right2Interrupted = true;
					Game.getPlayer2().left2 = false;
				}
				else if (Game.getPlayer2().left2Interrupted && Game.getPlayer2().right2Interrupted)
				{
					// do nothing
				}
				else if (Game.getPlayer2().right2Interrupted)
				{
					Player2.directionFacing2 = "right";
					Game.getPlayer2().right2 = true;
				}
				else if (Game.getPlayer2().attack2 == false && Game.getPlayer2().left2Interrupted == false)
				{
					Player2.directionFacing2 = "right";
					Game.getPlayer2().right2Interrupted = false;
					Game.getPlayer2().right2 = true;
				}
			}

			if (keyCode == KeyEvent.VK_LEFT) // P2 Attack
			{
				if (Game.getPlayer2().left2 && Game.getPlayer2().right2) // this never executes?
				{
					Game.getPlayer2().left2Interrupted = true;
					Game.getPlayer2().right2Interrupted = true;
					Game.getPlayer2().left2 = false;
					Game.getPlayer2().right2 = false;
				}
				else if (Game.getPlayer2().left2)
				{
					Game.getPlayer2().left2Interrupted = true;
					Game.getPlayer2().left2 = false;
					Player2.directionFacing2 = "left";
				}
				else if (Game.getPlayer2().right2)
				{
					Game.getPlayer2().right2Interrupted = true;
					Game.getPlayer2().right2 = false;
					Player2.directionFacing2 = "right";
				}

				Game.getPlayer2().attack2 = true;
			}

			if (keyCode == KeyEvent.VK_DOWN) // P2 Shoot
			{
				Game.getPlayer2().shoot2 = true;
			}

			if (keyCode == KeyEvent.VK_P) // P2 Jump
			{
				Game.getPlayer2().jump2 = true;
			}

			if (keyCode == KeyEvent.VK_ESCAPE) // Escape game
			{
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (Game.State == STATE.GAME) {
			/*----------------------------- Player 1 ----------------------------------*/
			if (keyCode == KeyEvent.VK_A) // P1 Move Left
			{
				if (Game.getPlayer1().attack1)
				{
					//
				}
				Game.getPlayer1().left1 = false;
				Game.getPlayer1().left1Interrupted = false;

				if (Game.getPlayer1().right1Interrupted)
				{
					Game.getPlayer1().right1Interrupted = false;
					Game.getPlayer1().right1 = true;
				}
			}
			if (keyCode == KeyEvent.VK_D) // P1 Move Right
			{
				Game.getPlayer1().right1 = false;
				Game.getPlayer1().right1Interrupted = false;

				if (Game.getPlayer1().left1Interrupted)
				{
					Game.getPlayer1().left1Interrupted = false;
					Game.getPlayer1().left1 = true;
				}
			}
			if (keyCode == KeyEvent.VK_C) // P1 Attack
			{
				Game.getPlayer1().attack1 = false;

				if (Game.getPlayer1().left1Interrupted && Game.getPlayer1().right1Interrupted)
				{
					Game.getPlayer1().left1 = false;
					Game.getPlayer1().right1 = false;
					Game.getPlayer1().left1Interrupted = true;
					Game.getPlayer1().right1Interrupted = true;
				}
				else if (Game.getPlayer1().left1Interrupted)
				{
					Game.getPlayer1().left1 = true;
					Game.getPlayer1().left1Interrupted = false;
				}
				else if (Game.getPlayer1().right1Interrupted)
				{
					Game.getPlayer1().right1 = true;
					Game.getPlayer1().right1Interrupted = false;
				}
			}
			if (keyCode == KeyEvent.VK_F) // P1 Shoot
			{
				Game.getPlayer1().shoot1 = false;
			}
			if (keyCode == KeyEvent.VK_W) // P1 Jump
			{
				Game.getPlayer1().jump1 = false;
				Game.getPlayer1().counter1 = 4;
			}

			/*------------------------------ Player 2 -------------------------------*/

			if (keyCode == KeyEvent.VK_L) // P2 Move Left
			{
				if (Game.getPlayer2().attack2)
				{
					//
				}
				Game.getPlayer2().left2 = false;
				Game.getPlayer2().left2Interrupted = false;

				if (Game.getPlayer2().right2Interrupted)
				{
					Game.getPlayer2().right2Interrupted = false;
					Game.getPlayer2().right2 = true;
				}
			}
			if (keyCode == KeyEvent.VK_QUOTE) // P2 Move Right
			{
				Game.getPlayer2().right2 = false;
				Game.getPlayer2().right2Interrupted = false;

				if (Game.getPlayer2().left2Interrupted)
				{
					Game.getPlayer2().left2Interrupted = false;
					Game.getPlayer2().left2 = true;
				}
			}
			if (keyCode == KeyEvent.VK_LEFT) // P2 Attack
			{
				Game.getPlayer2().attack2 = false;

				if (Game.getPlayer2().left2Interrupted && Game.getPlayer2().right2Interrupted)
				{
					Game.getPlayer2().left2 = false;
					Game.getPlayer2().right2 = false;
					Game.getPlayer2().left2Interrupted = true;
					Game.getPlayer2().right2Interrupted = true;
				}
				else if (Game.getPlayer2().left2Interrupted)
				{
					Game.getPlayer2().left2 = true;
					Game.getPlayer2().left2Interrupted = false;
				}
				else if (Game.getPlayer2().right2Interrupted)
				{
					Game.getPlayer2().right2 = true;
					Game.getPlayer2().right2Interrupted = false;
				}
			}
			if (keyCode == KeyEvent.VK_DOWN) // P2 Shoot
			{
				Game.getPlayer2().shoot2 = false;
			}
			if (keyCode == KeyEvent.VK_P) // P2 Jump
			{
				Game.getPlayer2().jump2 = false;
				Game.getPlayer2().counter2 = 4;
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}
	
}
