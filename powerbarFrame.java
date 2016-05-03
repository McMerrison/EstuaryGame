
public class powerbarFrame extends GameObject {

	public powerbarFrame(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void updateState()
	{
		setObjectState(0);
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			
		}
	}
	
	

}
