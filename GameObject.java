import java.lang.*;

public abstract class GameObject {
	double xPosition;
	double yPosition;
	double xVelocity;
	double yVelocity;
	GameState gameState;
	protected int objectState = 0;
	protected double objectStateTime = 0;
	
	GameObject(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState)
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.gameState = gameState;
	}
	
	abstract public void updateState();
	
	public void selfDestruct()
	{
		gameState.remove(this);
	}
	
	public void rotateDirection(double cosineAngle, double sineAngle)
	{
		double speed = getSpeed(); //end velocity must have the same end speed
		double bufferXVelocity = xVelocity;
		xVelocity = xVelocity * cosineAngle - yVelocity * sineAngle;
		yVelocity = bufferXVelocity * sineAngle + yVelocity * cosineAngle;
		
		//Correction for any math inaccuracies
		double correction = speed / magnitude(xVelocity,yVelocity);
		xVelocity = xVelocity * correction;
		yVelocity = yVelocity * correction;
		
	}
	
	public double magnitude(double x, double y)
	{
		return Math.sqrt(x*x + y*y);
	}
	
	public double getSpeed()
	{
		return magnitude(xVelocity,yVelocity);
	}
	
	public void translatePosition(double x, double y)
	{
		xPosition += x;
		yPosition += y;
	}
	
	
	// Do not override, this will handle position update
	// for every subclass of GameObject
	public void updatePosition()
	{
		xPosition += xVelocity;
		yPosition += yVelocity;
	}
	
	
	public double getxPosition() {
		return xPosition;
	}
	

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	public int getObjectState() {
		return objectState;
	}

	public void setObjectState(int objState) {
		this.objectState = objState;
	}

	public double getObjectStateTime() {
		return objectStateTime;
	}

	public void setObjectStateTime(double objectStateTime) {
		this.objectStateTime = objectStateTime;
	}
	


	public GameState getGameState() {
		return gameState;
	}
	

	public void setVelocity(double x, double y)
	{
		xVelocity = x;
		yVelocity = y;
	}
	
	public void addVeloction(double x, double y)
	{
		xVelocity += x;
		yVelocity += y;
	}

	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}

	@Override
	public String toString() {
		return "\n" + super.toString() + " GameObject [xPosition=" + xPosition + ", yPosition=" + yPosition + ", xVelocity=" + xVelocity
				+ ", yVelocity=" + yVelocity + ", objectState=" + objectState + ", objectStateTime="
				+ objectStateTime + "]";
	}
   
	
}
