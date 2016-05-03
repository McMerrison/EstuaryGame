public class PowerBar extends GameObject {
		private int powerfluc; //the power that fluctuates on every tick
		private int power; // the power that the player chooses using the space bar.
		private boolean power_flag; // Used to determine if powerfluc bar is going up or down
		private boolean stop_flag;
	
		public PowerBar(double xPosition, double yPosition, double xVelocity,
				double yVelocity, GameState gameState) {
			super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		
			power = -1;
			powerfluc = 0;
			power_flag = true;
			stop_flag = false;
		}

	
		public void setPowerFluc(){
			if (!stop_flag) {
				if(power_flag){
					powerfluc++;
					if(powerfluc >= 100){
						power_flag = false;
					}
				}
				else{
					powerfluc--;
					if(powerfluc <= 0){
						power_flag = true;
					}
				}
			}
		}

		public void updateState(){
			setPowerFluc();
		}
	
		public int getPowerFluc(){
			return powerfluc;
		}
	
		public void setPowerFluc(int x){
			powerfluc = x;
		}
	
		// this is called when the player releases the space bar
		public void setPower(){
			power = powerfluc;
		}
	
		public int getPower(){
			return power;
		}
	
		public void setStop() {
			stop_flag = !stop_flag;
		}
		public void defaultPower(){
			power = -1;
			this.setPowerFluc(0);
			power_flag = true;
		}
	}