
public class TestObject extends GameObject {

	public TestObject(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void updateState()
	{
		if (xPosition < 0 | yPosition < 0) {
			xVelocity = 0;
			yVelocity = 0;
		}
	}
	
	/**
	 * Checks if projectile collided with trash.
	 * @return 
	 * @return true if within a certain hitbox, false otherwise.
	 */
	public boolean checkCollision() {
		if (Math.abs(this.xPosition - 150) < 10 && Math.abs(this.yPosition - 100) < 50) {
				System.out.println("Collision!");
				return true;
			}
		return false;
	}
	
	

}
