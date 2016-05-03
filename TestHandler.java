
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static java.lang.System.out;

public class TestHandler extends Handler implements ActionListener, KeyListener {

	JButton testButton;
	boolean red = true;
	
	public TestHandler(GameScreen gameScreen,GameState gameState) {
		
		super(gameScreen,gameState);
		
		//adds a button to game
		testButton = new JButton("Click me");
		gameScreen.add(testButton,BorderLayout.SOUTH);
		
		testButton.addActionListener(this);
		gameScreen.addKeyListener(this);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void  paint(Graphics g)
	{
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof TestObject)
			{
				if (red)
				{
					g.setColor(Color.RED);
				}
				else
				{
					g.setColor(Color.BLUE);
				}
				/*
				if (testButton.getModel().isRollover())
				{
					g.setColor(Color.YELLOW);
				}
				*/
				g.fillOval((int)gameObject.getxPosition(),(int)gameObject.getyPosition(),32,32);
			}

		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		red = !red;
		
		//After the user clicks on a button, the Screen needs to gain focus again for keypresses and mouseclicks
		gameScreen.requestFocusInWindow();
	}
	
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		red = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("test handler keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
	}

}
