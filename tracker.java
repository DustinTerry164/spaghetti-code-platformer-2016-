package fox;

public class tracker {
	
	int object_number;
	public String direction = "?";
	double speed = 0;
	
	public void track(int a, String d,double speed){
		object_number = a;
		direction = d;
		this.speed = speed;
	}

	
	
	public void reset(){
		object_number = -1;
		direction = "?";
	}
	
	public boolean is_being_used(){
		if(object_number != -1){
			return true;
		}else return false;
		
	}
	public String get_direction(){
		return direction;
	}
	public double get_speed(){
		return speed;
	}


}
