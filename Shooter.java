
public class Shooter {	
	private boolean arrow_or_pb_flag; // tells us if we need to set the arrow or power bar
	private Arrow game_arrow;
	private PowerBar game_powerbar;
	
	public Shooter(GameState game){
		arrow_or_pb_flag = true;
		//game_arrow = new Arrow(GameState.frameWidth / 2 - 50, GameState.frameHeight - 330, 0, 0, game);
		game_arrow = new Arrow(380, 700, 0, 0, game);
		game_powerbar = new PowerBar(GameState.frameWidth/5, GameState.frameHeight - 220, 0, 0, game);
	}
	
	public Arrow getArrow(){
		return game_arrow;
	}
	public PowerBar getPowerBar(){
		return game_powerbar;
	}
	public boolean getFlag(){
		return arrow_or_pb_flag;
	}
	public void changeFlag(){
		if(arrow_or_pb_flag){
			arrow_or_pb_flag = false;
		}
		else{
			arrow_or_pb_flag = true;
		}
		return;
	}
	public void setDefault(){
		game_arrow.defaultDirection();
		game_powerbar.defaultPower();
		return;
	}
	
	public void update() {
		game_arrow.updateState();
		game_powerbar.updateState();
	}	
	
	
}