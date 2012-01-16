package room.basic.service.logging;




public class LogData {
	
	
	//--------------------- attributes
	protected int logLevel = 0;
	protected String userString = "";
	
	//--------------------- attribute setters and getters
	public void setLogLevel (int logLevel) {
		 this.logLevel = logLevel;
	}
	public int getLogLevel () {
		return this.logLevel;
	}
	public void setUserString (String userString) {
		 this.userString = userString;
	}
	public String getUserString () {
		return this.userString;
	}
	
	//--------------------- operations
	
	// default constructor
	public LogData() {
		super();
		// initialize attributes
		logLevel = 0;
		userString = "";
	}
	
	// constructor using fields
	public LogData(int logLevel, String userString) {
		super();
		this.logLevel = logLevel;
		this.userString = userString;
	}
	
	// deep copy
	public LogData deepCopy() {
		LogData copy = new LogData();
		copy.logLevel = logLevel;
		copy.userString = userString;
		return copy;
	}
};
