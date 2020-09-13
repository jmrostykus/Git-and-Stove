
public class Burner {
	
	public static enum Temperature{
		BLAZING ("VERY HOT! DON'T TOUCH"),
		HOT ("CAREFUL"),
		WARM ("warm"),
		COLD ("cooool");
		private String value;
		
		Temperature(String givenValue){
			value = givenValue;
		}
		public String toString() {
			return value;
		}
	}
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer = 0;
	public final static int TIME_DURATION = 2;
	
	//Default constructor should start with an off cold burner
	Burner(){
		myTemperature = Temperature.COLD;
		mySetting = Setting.Off;
	}
	
	//Getter for our temperature variable
	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	//raises the setting one notch unless it is already on high
	public void plusButton() {
		if(mySetting == Setting.Off) {
			mySetting = Setting.LOW;
		}
		else if(mySetting == Setting.LOW) {
			mySetting = Setting.MEDIUM;
		}
		else if(mySetting == Setting.MEDIUM) {
			mySetting = Setting.HIGH;
		}
		timer = 0;
	}
	
	//Lowers this burner's setting one notch unless already off
	public void minusButton() {
		if(mySetting == Setting.HIGH) {
			mySetting = Setting.MEDIUM;
		}
		else if(mySetting == Setting.MEDIUM) {
			mySetting = Setting.LOW;
		}
		else if(mySetting == Setting.LOW) {
			mySetting = Setting.Off;
		}
		timer = 0;
	}

	//Changes the temperature of our burner
	public void updateTemperature() {
		//our burner temp won't change till the time duration has passed
		if(timer < TIME_DURATION -1) {
			timer++;
			return;
		}
		
		//Update our temperature to what our settings where
		if(mySetting == Setting.Off) {
			myTemperature = Temperature.COLD;
		}
		else if(mySetting == Setting.LOW) {
			myTemperature = Temperature.WARM;
		}
		else if(mySetting == Setting.MEDIUM) {
			myTemperature = Temperature.HOT;
		}
		else if(mySetting == Setting.HIGH) {
			myTemperature = Temperature.BLAZING;
		}
		
	}

	//shows the status of the burner
	public void display(){
		System.out.println("[" + mySetting.toString() + "]....." + myTemperature.toString());
	}
	
}
