import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MittenCrabHandler extends Handler {
	Image image;
	
	MittenCrabHandler(GameScreen gameScreen,GameState gameState) {
		super(gameScreen,gameState);
		try{
			image = ImageIO.read(new File("img/mittencrab1.png")).getScaledInstance(100, 100, Image.SCALE_FAST);	
		}
		catch(IOException e)
		{
			
		}
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g) {
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof MittenCrab)
			{
				g.drawImage( image, (int)gameObject.xPosition, (int)gameObject.yPosition, new Color(0,0,0,0), null);
			}
		}
	}
}
