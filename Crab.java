import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Crab extends GameObject {
	
	final static int crabUpperBound = 400;
	final static int crabLowerBound = 600;

	Crab(double xPosition, double yPositionition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPositionition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

	public void updateState() {
		if (xPosition > GameState.frameWidth)
		{
			xVelocity = - Math.abs(xVelocity);
		}
		if (xPosition < 0)
		{
			xVelocity = Math.abs(xVelocity);
		}
		if (yPosition > crabLowerBound)
		{
			yVelocity = - Math.abs(yVelocity);
		}
		if (yPosition < crabUpperBound) 
		{
			yVelocity = Math.abs(yVelocity);
		}
	}
	
	/**
	 * Checks if crab collided with projectile.
	 * @return 
	 * @return true if within a certain hitbox, false otherwise.
	 */
	public boolean checkCollision() {
			if (getGameState().projectile instanceof Food && Math.abs(this.xPosition - getGameState().projectile.xPosition) < 50 && Math.abs(this.yPosition - getGameState().projectile.yPosition) < 50) {
				System.out.println("Collision!");
				getGameState().projectile.isVisible = false;
				return true;
			}
		return false;
	}

}
