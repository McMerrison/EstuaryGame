	public class Arrow extends GameObject {
		private int directfluc = 0;
		private int direction = -1;
		private boolean arrow_flag = true; // Used to determine if arrow is rotating left or right
		private boolean stop_flag;
		
		public Arrow(double xPosition, double yPosition, double xVelocity,
				double yVelocity, GameState gameState) {
			super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		}
		
		public void setDirectFluc(){
			if (!stop_flag) {
				if(arrow_flag){
					directfluc++;
					if(directfluc >= 180){
						arrow_flag = false;
					}
				}
				else{
					directfluc--;
					if(directfluc <= 0){
						arrow_flag = true;
					}
				}
			}
		}

		public void updateState(){
			setDirectFluc();
		}
		
		public int getDirection(){
			return direction;
		}
		
		public void setDirection(){
			direction = directfluc;
		}
		
		public int getDirectFluc(){
			return directfluc;
		}
		
		public void setDirectFluc(int x){
			directfluc = x;
		}
		
		public void setStop() {
			stop_flag = !stop_flag;
		}
		public void defaultDirection(){
			//direction = -1;
			//this.setDirectFluc(0);
			//arrow_flag = true;
		}
	}