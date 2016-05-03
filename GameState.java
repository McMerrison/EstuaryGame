import java.awt.image.BufferStrategy;
import java.util.*;

public class GameState {
	int score;
	int trashCount;
	int mittenCount;
	int blueCount;
	boolean hitb;
	boolean hitm;
	int buffb = 0;
	int buffm = 0;
	Projectile projectile;
	Shooter gameShooter;
	final static int frameWidth = 1000;
    final static int frameHeight = 1000;
	Collection<GameObject> gameObjectCollection = new LinkedList<GameObject>();
	Collection<Projectile> trashCollection = new LinkedList<Projectile>();
	
	
	/**
	 * Iterate through game objects and update position for each one based on velocity
	 * Iterate once again and update state (view)
	 * After updates, check for any collisions, add crabs accordingly
	 * Use buffer value (@see buffm buffb) to ensure only one crab is replicated per projectile
	 * Prioritize blue crab
	 * Finally, update gameShooter
	 * 
	 */
	public void update()
	{
		//if (projectile != null) {
			projectile.updatePosition();
			projectile.updateState();
		//}
		for (Projectile trash : trashCollection) 
		{
			trash.updatePosition();
			trash.updateState();
		}
		for (GameObject gameObject : gameObjectCollection)
		{
			gameObject.updatePosition();
		}
		for (GameObject gameObject : gameObjectCollection)
		{
			gameObject.updateState();
			if (gameObject instanceof BlueCrab) {
				if (((Crab) gameObject).checkCollision()) {
					hitb = true;
				}
			}
			if (gameObject instanceof MittenCrab) {
				if (((Crab) gameObject).checkCollision()) {
					hitm = true;
				}
			}
		}
		if (hitb && buffb <= 0) {
			this.add(new BlueCrab(500,500,2,1,this));
			blueCount++;
			buffb = 300;
			buffm = 300;
		}
		if (hitm && buffm <= 0) {
			this.add(new MittenCrab(500,500,1,2,this));
			mittenCount++;
			buffm = 300;
			buffb = 300;
		}
		buffb--;
		buffm--;
		hitb = false;
		hitm = false;
		
		gameShooter.update(); //not a gameObject, so I didn't use updateState
		
		if (mittenCount > 10 || blueCount > 10) {
			System.out.println("Over capacity!");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mittenCount = 0;
			blueCount = 0;
		}

	}
	public void addToScore(int value)
	{
		this.score += value;
	}
	public void addToTrashCount(int value)
	{
		this.trashCount += value;
	}
	public void addToMittenCount(int value)
	{
		this.mittenCount += value;
	}
	public void addToBlueCount(int value)
	{
		this.blueCount += value;
	}
	public void add(GameObject gameObject)
	{
		this.gameObjectCollection.add(gameObject);
	}
	public void addTrash(Projectile projectile)
	{
		this.trashCollection.add(projectile);
	}
	public void remove(GameObject gameObject)
	{
		this.gameObjectCollection.remove(gameObject);
	}
	public void removeTrash(Trash trash)
	{
		this.trashCollection.remove(trash);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTrashCount() {
		return trashCount;
	}
	public void setTrashCount(int trashCount) {
		this.trashCount = trashCount;
	}
	public int getMittenCount() {
		return mittenCount;
	}
	public void setMittenCount(int mittenCount) {
		this.mittenCount = mittenCount;
	}
	public int getBlueCount() {
		return blueCount;
	}
	public void setBlueCount(int blueCount) {
		this.blueCount = blueCount;
	}
	public Collection<GameObject> getGameObjectCollection() {
		return gameObjectCollection;
	}
	public Collection<Projectile> getTrashCollection() {
		return trashCollection;
	}
	public Shooter getShooter(){
		return gameShooter;
	}
	public void setShooter(Shooter newShooter){
		gameShooter = newShooter;
	}
	public void setProjectile(Projectile projectile) {
		this.projectile = projectile;
	}
	public Projectile getProjectile(){
		return projectile;
	}
	
	@Override
	public String toString() {
		return "\nGameState [score=" + score + ", trashCount=" + trashCount + ", mittenCount=" + mittenCount
				+ ", blueCount=" + blueCount + ", gameObjectCollection=" + gameObjectCollection + "]";
	}
	

}
