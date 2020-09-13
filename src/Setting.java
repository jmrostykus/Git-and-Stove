
public enum Setting {
	Off ("---"), LOW ("--+"), MEDIUM ("-++"), HIGH ("+++");
	private String value;
	
	Setting (String givenValue){
		value = givenValue;
	}
	
	public String toString() {
		return value;
	}
}
