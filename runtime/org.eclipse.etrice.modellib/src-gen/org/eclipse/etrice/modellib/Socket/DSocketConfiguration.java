package org.eclipse.etrice.modellib.Socket;



public class DSocketConfiguration {
	//--------------------- attributes
	protected String serverName;protected int portNumber;protected int protocol;protected boolean checkCookie;protected int mode;
	//--------------------- attribute setters and getters
	public void setServerName (String serverName) {
		 this.serverName = serverName;
	}
	public String getServerName () {
		return serverName;
	}public void setPortNumber (int portNumber) {
		 this.portNumber = portNumber;
	}
	public int getPortNumber () {
		return portNumber;
	}public void setProtocol (int protocol) {
		 this.protocol = protocol;
	}
	public int getProtocol () {
		return protocol;
	}public void setCheckCookie (boolean checkCookie) {
		 this.checkCookie = checkCookie;
	}
	public boolean getCheckCookie () {
		return checkCookie;
	}public void setMode (int mode) {
		 this.mode = mode;
	}
	public int getMode () {
		return mode;
	}
	//--------------------- operations
	
	// default constructor
	public DSocketConfiguration() {
	}
	
	// deep copy
	public DSocketConfiguration deepCopy() {
		DSocketConfiguration copy = new DSocketConfiguration();
		copy.serverName = serverName;
		copy.portNumber = portNumber;
		copy.protocol = protocol;
		copy.checkCookie = checkCookie;
		copy.mode = mode;
		return copy;
	}
};
