import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class BlueCrabHandler extends Handler{


	Image image;
	
	BlueCrabHandler(GameScreen gameScreen,GameState gameState) {
		super(gameScreen,gameState);
		try{
			image = ImageIO.read(new File("img/crab_1.png")).getScaledInstance(100, 100, Image.SCALE_FAST);	
		}
		catch(IOException e)
		{
			
		}
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g) {
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof BlueCrab)
			{
				g.drawImage( image, (int)gameObject.xPosition, (int)gameObject.yPosition, new Color(0,0,0,0), null);
			}
		}
	}

}
