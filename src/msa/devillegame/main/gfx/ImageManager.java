package msa.devillegame.main.gfx;

import java.awt.image.BufferedImage;

public class ImageManager {
	
	//Player 1
	public BufferedImage player1IdleLeft, player1IdleRight;
	public BufferedImage [] player1WalkLeft, player1AttackLeft, player1JumpLeft, player1FlashLeft;
	
	//Player 2
	public BufferedImage player2IdleLeft, player2IdleRight;
	public BufferedImage [] player2WalkLeft, player2AttackLeft, player2JumpLeft;

	public ImageManager(SpriteSheet ss1, SpriteSheet ss2) {
		
		/*------------------------------ Player 1 ----------------------------------*/
		//Player 1 Idle images
		player1IdleLeft = ss1.crop(0, 0, 400, 400);
		
		//Player 1 Attack images
		player1AttackLeft = new BufferedImage[12];
			player1AttackLeft[0] = ss1.crop(0, 2, 400, 400);
			player1AttackLeft[1] = ss1.crop(1, 2, 400, 400);
			player1AttackLeft[2] = ss1.crop(2, 2, 400, 400);
			player1AttackLeft[3] = ss1.crop(3, 2, 400, 400);
			player1AttackLeft[4] = ss1.crop(4, 2, 400, 400);
			player1AttackLeft[5] = ss1.crop(5, 2, 400, 400);
			player1AttackLeft[6] = ss1.crop(6, 2, 400, 400);
			player1AttackLeft[7] = ss1.crop(7, 2, 400, 400);
			player1AttackLeft[8] = ss1.crop(8, 2, 400, 400);
			player1AttackLeft[9] = ss1.crop(9, 2, 400, 400);
			player1AttackLeft[10] = ss1.crop(10, 2, 400, 400);
			player1AttackLeft[11] = ss1.crop(11, 2, 400, 400);
		
		//Player 1 Walk images
		player1WalkLeft = new BufferedImage[12];
			player1WalkLeft[0] = ss1.crop(0, 1, 400, 400);
			player1WalkLeft[1] = ss1.crop(1, 1, 400, 400);
			player1WalkLeft[2] = ss1.crop(2, 1, 400, 400);
			player1WalkLeft[3] = ss1.crop(3, 1, 400, 400);
			player1WalkLeft[4] = ss1.crop(4, 1, 400, 400);
			player1WalkLeft[5] = ss1.crop(5, 1, 400, 400);
			player1WalkLeft[6] = ss1.crop(6, 1, 400, 400);
			player1WalkLeft[7] = ss1.crop(7, 1, 400, 400);
			player1WalkLeft[8] = ss1.crop(8, 1, 400, 400);
			player1WalkLeft[9] = ss1.crop(9, 1, 400, 400);
			player1WalkLeft[10] = ss1.crop(10, 1, 400, 400);
			player1WalkLeft[11] = ss1.crop(11, 1, 400, 400);
		
		//Player 1 Jump images
		player1JumpLeft = new BufferedImage[15];
			player1JumpLeft[0] = ss1.crop(0, 0, 400, 400);
			player1JumpLeft[1] = ss1.crop(1, 0, 400, 400);
			player1JumpLeft[2] = ss1.crop(2, 0, 400, 400);
			player1JumpLeft[3] = ss1.crop(3, 0, 400, 400);
			player1JumpLeft[4] = ss1.crop(4, 0, 400, 400);
			player1JumpLeft[5] = ss1.crop(4, 0, 400, 400);
			player1JumpLeft[6] = ss1.crop(5, 0, 400, 400);
			player1JumpLeft[7] = ss1.crop(5, 0, 400, 400);
			player1JumpLeft[8] = ss1.crop(6, 0, 400, 400);
			player1JumpLeft[9] = ss1.crop(7, 0, 400, 400);
			player1JumpLeft[10] = ss1.crop(8, 0, 400, 400);
			player1JumpLeft[11] = ss1.crop(9, 0, 400, 400);
			player1JumpLeft[12] = ss1.crop(10, 0, 400, 400);
			player1JumpLeft[13] = ss1.crop(11, 0, 400, 400);
			player1JumpLeft[14] = ss1.crop(12, 0, 400, 400);
			
		//Player 1 Flash images
		player1FlashLeft = new BufferedImage[7];
			player1FlashLeft[0] = ss1.crop(0, 3, 400, 400);
			player1FlashLeft[1] = ss1.crop(1, 3, 400, 400);
			player1FlashLeft[2] = ss1.crop(2, 3, 400, 400);
			player1FlashLeft[3] = ss1.crop(3, 3, 400, 400);
			player1FlashLeft[4] = ss1.crop(4, 3, 400, 400);
			player1FlashLeft[5] = ss1.crop(5, 3, 400, 400);
			player1FlashLeft[6] = ss1.crop(6, 3, 400, 400);

		
		/*------------------------------ Player 2 ----------------------------------*/
		//Player 2 Idle images
		player2IdleLeft = ss2.crop(0, 0, 400, 400);
		
		//Player 2 Attack Left images
		player2AttackLeft = new BufferedImage[16];
			player2AttackLeft[0] = ss2.crop(0, 0, 400, 400);
			player2AttackLeft[1] = ss2.crop(1 ,0, 400, 400);
			player2AttackLeft[2] = ss2.crop(2 ,0, 400, 400);
			player2AttackLeft[3] = ss2.crop(3 ,0, 400, 400);
			player2AttackLeft[4] = ss2.crop(4 ,0, 400, 400);
			player2AttackLeft[5] = ss2.crop(5 ,0, 400, 400);
			player2AttackLeft[6] = ss2.crop(6 ,0, 400, 400);
			player2AttackLeft[7] = ss2.crop(7 ,0, 400, 400);
			player2AttackLeft[8] = ss2.crop(8 ,0, 400, 400);
			player2AttackLeft[9] = ss2.crop(9 ,0, 400, 400);
			player2AttackLeft[10] = ss2.crop(10 ,0, 400, 400);
			player2AttackLeft[11] = ss2.crop(11 ,0, 400, 400);
			player2AttackLeft[12] = ss2.crop(12 ,0, 400, 400);
			player2AttackLeft[13] = ss2.crop(13 ,0, 400, 400);
			player2AttackLeft[14] = ss2.crop(14 ,0, 400, 400);
			player2AttackLeft[15] = ss2.crop(15 ,0, 400, 400);
		
		//Player 2 Walk Left images
		player2WalkLeft = new BufferedImage[12];
			player2WalkLeft[0] = ss2.crop(0, 1, 400, 400);
			player2WalkLeft[1] = ss2.crop(1, 1, 400, 400);
			player2WalkLeft[2] = ss2.crop(2, 1, 400, 400);
			player2WalkLeft[3] = ss2.crop(3, 1, 400, 400);
			player2WalkLeft[4] = ss2.crop(4, 1, 400, 400);
			player2WalkLeft[5] = ss2.crop(5, 1, 400, 400);
			player2WalkLeft[6] = ss2.crop(6, 1, 400, 400);
			player2WalkLeft[7] = ss2.crop(7, 1, 400, 400);
			player2WalkLeft[8] = ss2.crop(8, 1, 400, 400);
			player2WalkLeft[9] = ss2.crop(9, 1, 400, 400);
			player2WalkLeft[10] = ss2.crop(10, 1, 400, 400);
			player2WalkLeft[11] = ss2.crop(11, 1, 400, 400);
		
			
		//Player 2 Jump Left images
		player2JumpLeft = new BufferedImage[26];
			player2JumpLeft[0] = ss2.crop(0, 2, 400, 400);
			player2JumpLeft[1] = ss2.crop(1, 2, 400, 400);
			player2JumpLeft[2] = ss2.crop(2, 2, 400, 400);
			player2JumpLeft[3] = ss2.crop(3, 2, 400, 400);
			player2JumpLeft[4] = ss2.crop(4, 2, 400, 400);
			player2JumpLeft[5] = ss2.crop(5, 2, 400, 400);
			player2JumpLeft[6] = ss2.crop(6, 2, 400, 400);
			player2JumpLeft[7] = ss2.crop(7, 2, 400, 400);
			player2JumpLeft[8] = ss2.crop(8, 2, 400, 400);
			player2JumpLeft[9] = ss2.crop(9, 2, 400, 400);
			player2JumpLeft[10] = ss2.crop(10, 2, 400, 400);
			player2JumpLeft[11] = ss2.crop(11, 2, 400, 400);
			player2JumpLeft[12] = ss2.crop(12, 2, 400, 400);
			player2JumpLeft[13] = ss2.crop(0, 3, 400, 400);
			player2JumpLeft[14] = ss2.crop(1, 3, 400, 400);
			player2JumpLeft[15] = ss2.crop(2, 3, 400, 400);
			player2JumpLeft[16] = ss2.crop(3, 3, 400, 400);
			player2JumpLeft[17] = ss2.crop(4, 3, 400, 400);
			player2JumpLeft[18] = ss2.crop(5, 3, 400, 400);
			player2JumpLeft[19] = ss2.crop(6, 3, 400, 400);
			player2JumpLeft[20] = ss2.crop(7, 3, 400, 400);
			player2JumpLeft[21] = ss2.crop(8, 3, 400, 400);
			player2JumpLeft[22] = ss2.crop(9, 3, 400, 400);
			player2JumpLeft[23] = ss2.crop(10, 3, 400, 400);
			player2JumpLeft[24] = ss2.crop(11, 3, 400, 400);
			player2JumpLeft[25] = ss2.crop(12, 3, 400, 400);
	}
}
