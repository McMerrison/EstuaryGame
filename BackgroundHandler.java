import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundHandler extends Handler {

	Image image;
		
	BackgroundHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen,gameState);
		try{
			image = ImageIO.read(new File("img/bad-background.png"));//.getScaledInstance(1000, 1000, Image.SCALE_FAST);	
		}
		catch(IOException e)
		{
			
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage( image, 0, 0, Color.gray, null);
	}

	
}
