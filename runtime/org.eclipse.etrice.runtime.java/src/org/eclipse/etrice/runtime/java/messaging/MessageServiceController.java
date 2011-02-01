package org.eclipse.etrice.runtime.java.messaging;

import java.util.ArrayList;
import java.util.List;


public class MessageServiceController {

	public MessageServiceController(/*IRTObject parent*/){
		// TODOTS: Who is parent of MessageServices and Controller?
		// this.parent = parent;
		messageServiceList = new ArrayList<MessageService>();
	}

	public void addMsgSrv(MessageService msgSrv){
		// TODOTS: Who is parent of MessageServices ?
		assert(msgSrv.getAddress().threadID == messageServiceList.size());
		messageServiceList.add(msgSrv);
	}
	
	public MessageService getMessageService(int threadID){
		assert(threadID < messageServiceList.size());
		return messageServiceList.get(threadID);
	}


	
	public void start() {
		// start all message services
		for (MessageService msgSrv : messageServiceList){
			msgSrv.start();
			// TODOTS: start in order of priorities
		}
		running = true;
	}

	public void stop() {
		terminate();
		waitTerminate();
	}

	private void terminate() {
		if (!running){
			return;
		}
		running = false;
		
		// terminate all message services
		for (MessageService msgSrv : messageServiceList){
			msgSrv.terminate();
			// TODOTS: stop in order of priorities
		}
	}

	private void waitTerminate() {
		for (MessageService msgSrv : messageServiceList){
			try {
				msgSrv.join();
				} 
			catch (InterruptedException e1) {
			}
		}
	}
	
	private List<MessageService> messageServiceList = null;
//	private IRTObject parent = null;
	private boolean running = false;
}
