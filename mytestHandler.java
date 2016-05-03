import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//TODO 

public class mytestHandler extends Handler implements ActionListener, KeyListener {

	JButton testButton;
	JButton BlackButton;
	JButton randomButton;
	boolean red = true;
	String color = "WHITE";
	int randomMode = 1;
	double x = 1;
	double y = 1;
	Random random = new Random();

	public mytestHandler(GameScreen gameScreen, GameState gameState) {

		super(gameScreen,gameState);

		// adds a button to game
		testButton = new JButton("White");
		BlackButton = new JButton("Black");
		randomButton = new JButton("Random");
		gameScreen.add(testButton, BorderLayout.SOUTH);
		gameScreen.add(BlackButton, BorderLayout.SOUTH);
		gameScreen.add(randomButton, BorderLayout.SOUTH);

		testButton.addActionListener(this);
		BlackButton.addActionListener(this);
		randomButton.addActionListener(this);
		gameScreen.addKeyListener(this);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {

		for (GameObject gameObject : getGameState().getGameObjectCollection()) {
			if (gameObject instanceof mytestObject) {
				if (randomMode == 1) {
					if (gameObject.getxVelocity() == 0 || gameObject.getyVelocity() == 0) {
						gameObject.setVelocity(x, y);
					}
					// gameObject.setVelocity(1, 1);
					randomMove(gameObject);
				} else if (randomMode == 2) {

					x = gameObject.getxVelocity();
					y = gameObject.getyVelocity();
					gameObject.setVelocity(0, 0);
					randomMode = 3;

				}

				if (color == "WHITE") {
					g.setColor(Color.WHITE);
					/*
					 * if (testButton.getModel().isRollover()) {
					 * g.setColor(Color.YELLOW); }
					 */
					} else if (color == "BLACK") {
					g.setColor(Color.BLACK);
				}
				g.fillRect((int) gameObject.getxPosition(), (int) gameObject.getyPosition(), 32, 32);
			}

		}
	}

	public void randomMove(GameObject a) {
		if (a.getxPosition() <= 10) {
			a.setxVelocity(random.nextInt(5) + 1);
		} else if (a.getxPosition() >= 500) {
			a.setxVelocity(-(random.nextInt(5) + 1));
		} else if (a.getyPosition() <= 10) {
			a.setyVelocity(random.nextInt(5) + 1);
		} else if (a.getyPosition() >= 500) {
			a.setyVelocity(-(random.nextInt(5) + 1));
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Black") {
			color = "BLACK";
		} else if (e.getActionCommand() == "Random") {

			if (randomMode == 1) {
				randomMode = 2;
			} else if (randomMode == 2) {
				randomMode = 1;
			} else if (randomMode == 3) {
				randomMode = 1;
			}

		} else if (e.getActionCommand() == "White") {
			color = "WHITE";
			
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		for (GameObject gameObject : getGameState().getGameObjectCollection()) {
			if (gameObject instanceof mytestObject) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					gameObject.translatePosition(0, -1);

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					gameObject.translatePosition(0, 1);

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					gameObject.translatePosition(-1, 0);

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					gameObject.translatePosition(1, 0);

				}

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("keyReleased= " + KeyEvent.getKeyText(e.getKeyCode()));
	}

}
