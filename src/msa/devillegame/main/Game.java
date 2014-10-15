package msa.devillegame.main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import msa.devillegame.main.entities.Player1;
import msa.devillegame.main.entities.Player2;
import msa.devillegame.main.gfx.BackgroundImage;
import msa.devillegame.main.gfx.HealthBar;
import msa.devillegame.main.gfx.HealthBarBorders;
import msa.devillegame.main.gfx.ImageLoader;
import msa.devillegame.main.gfx.ImageManager;
import msa.devillegame.main.gfx.SpriteSheet;


//If I didn't extend Canvas (which is only for getBufferStrategy and createBufferStrategy,
//then I could extend KeyListener, and add it to the frame, allowing ESC to close the game.
public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1200, HEIGHT = 600, SCALE = 1;
	public static boolean running = false;
	public Thread gameThread;
	
	private BufferedImage p1SpriteSheet;
	private BufferedImage p2SpriteSheet;

	private ImageManager im;
	
	private static Player1 player1;
	private static Player2 player2;
	private static HealthBar healthBars;
	private static BackgroundImage backgroundImage;
	private static HealthBarBorders healthBarBorders;
	
	private Menu menu;
	
	public static enum STATE{
		MENU,
		GAME
	};
	public static STATE State = STATE.MENU;
	
	public void init(){
		ImageLoader loader = new ImageLoader();
		
		//Prepare sprite sheets (the loading takes some time...)
		p1SpriteSheet = loader.load("/player1/danaSpriteSheet.png");
		p2SpriteSheet = loader.load("/player2/moonSpriteSheet.png");

		SpriteSheet SS1 = new SpriteSheet(p1SpriteSheet);
		SpriteSheet SS2 = new SpriteSheet(p2SpriteSheet);

		im = new ImageManager(SS1, SS2);	

		menu = new Menu();
		
		backgroundImage = new BackgroundImage("res/background.png");
		healthBarBorders = new HealthBarBorders("res/player1/healthBorderP1.png", "res/player2/healthBorderP2.png");
		
		player1 = new Player1(-50, 200, im);
		player2 = new Player2(760, 200, im);
		
		//This KeyListener is only here in case the user clicks on the screen
		this.addKeyListener(new KeyManager());
		this.addMouseListener(new MouseManager());
		
		healthBars = new HealthBar(300, 300);
	}
	
	public synchronized void start() {
		if(running)return;
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public synchronized void stop() {
		if(!running)return;
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		// Credit for this run loop goes to MadProgrammer @ StackOverflow
	    init();
	    final long amountOfTicks = 60;
	    long ns = Math.round(1_000_000_000 / (double)amountOfTicks);

	    int frames = 0;
	    long frameStart = System.currentTimeMillis();

	    while (running) {
	        long startedAt = System.nanoTime();
	        tick();
	        render();
	        long completedAt = System.nanoTime();
	        long duration = completedAt - startedAt;

	        long frameEnd = System.currentTimeMillis();
	        if (frameEnd - frameStart >= 1000) {
	            System.out.println(frames);    //Take this out for final version
	            frames = 0;
	            frameStart = System.currentTimeMillis();
	        } else {
	            frames++;
	        }

	        long rest = ns - duration;
	        if (rest > 0) {
	            rest = TimeUnit.MILLISECONDS.convert(rest, TimeUnit.NANOSECONDS);
	            try {
	                Thread.sleep(rest);
	            } catch (InterruptedException ex) {
	            }
	        }
	    }
	    stop();
	}
	
	public void tick() {
		if(State == STATE.GAME)
		{
			player1.tick();
			player2.tick();
		}
	}
	
	public void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3); //Use 5 at most
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		//RENDER HERE
		if(State == STATE.GAME)
		{
			backgroundImage.render(g);	//do I really want to re-render the background every time?
			player1.render(g);
			player2.render(g);
			healthBars.render(g);
			healthBarBorders.render(g); //same concern here
		}
		else if(State == STATE.MENU)
		{
			menu.render(g);
		}
		//END RENDER
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args)
	{
		JLabel controlKeyPanel;
		
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame("DeVille Side Scroller");
		frame.setResizable(false);
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		frame.setLayout(new BorderLayout());
		
		String htmlButtonGuide = "<html>Player 1<br>----------<br>A  -  Left<br>D  -  Right<br>W  -  Jump<br>C  -  Attack<br>V  -  Fire<br><br><br>Player2<br>----------<br>L  -  Left<br>'  -  Right<br>P  -  Jump<br>&#8592   -   Attack<br>&#8595  -  Fire<br><br>esc -   Exit</html>";
		controlKeyPanel = new JLabel(htmlButtonGuide);
		
		frame.add(controlKeyPanel, BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		
		frame.setVisible(true);
		
		//this may be bad; allows Key input without having to click on screen.
		frame.addKeyListener(new KeyManager()); 
		
		game.start();
		//Program seems to continue running after ESC
	}
	
	public static Player1 getPlayer1() {
		return player1;
	}
	
	public static Player2 getPlayer2() {
		return player2;
	}
}
