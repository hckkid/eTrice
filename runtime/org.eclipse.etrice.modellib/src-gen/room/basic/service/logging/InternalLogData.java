package room.basic.service.logging;




public class InternalLogData {
	
	
	//--------------------- attributes
	protected String timeStamp = "";
	protected String sender = "";
	protected String userString = "";
	
	//--------------------- attribute setters and getters
	public void setTimeStamp (String timeStamp) {
		 this.timeStamp = timeStamp;
	}
	public String getTimeStamp () {
		return this.timeStamp;
	}
	public void setSender (String sender) {
		 this.sender = sender;
	}
	public String getSender () {
		return this.sender;
	}
	public void setUserString (String userString) {
		 this.userString = userString;
	}
	public String getUserString () {
		return this.userString;
	}
	
	//--------------------- operations
	
	// default constructor
	public InternalLogData() {
		// initialize attributes
		timeStamp = "";
		sender = "";
		userString = "";
	}
	
	// deep copy
	public InternalLogData deepCopy() {
		InternalLogData copy = new InternalLogData();
		copy.timeStamp = timeStamp;
		copy.sender = sender;
		copy.userString = userString;
		return copy;
	}
};
