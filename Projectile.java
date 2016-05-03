
public class Projectile extends GameObject {

	
	int xEnd;
	int yEnd;
	boolean isVisible = true;
	
	Projectile(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateState() {
		
	}

	public void setEnd(int j) {
		// TODO Auto-generated method stub
		
	}

	public Projectile checkCollision() {
		// TODO Auto-generated method stub
		return null;
	}

}
