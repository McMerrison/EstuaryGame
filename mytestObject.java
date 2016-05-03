
public class mytestObject extends GameObject {

	public mytestObject(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void updateState()
	{
		
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
//			if (gameObject != this)
//			{
//				if (magnitude(this.getxPosition()-gameObject.getxPosition(),this.getyPosition()-gameObject.getyPosition()) < 32)
//				{
//					setObjectState(1);
//				}
//			}
		}
	}
	
	

}
