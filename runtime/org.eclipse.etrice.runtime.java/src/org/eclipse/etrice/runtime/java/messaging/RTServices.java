package org.eclipse.etrice.runtime.java.messaging;

public class RTServices {
	
	private RTServices(){
		messageServiceController = new MessageServiceController();
	}
	
	public static RTServices getInstance(){
		if (instance == null){
			instance = new RTServices();
		}
		return instance;
	}
	
	public MessageServiceController getMsgSrvCtrl(){
		assert(messageServiceController != null);
		return messageServiceController;
	}
	
	private static RTServices instance = null;
	private MessageServiceController messageServiceController = null;
}
