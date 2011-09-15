package Blinky;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class BlinkyControlProtocoll {
	// message IDs
	// TODO: separate class for message IDs: class MSG{public static volatile int MSG_MIN = 0; ...} -> better structure
	// error if msgID <= MSG_MIN
	public static final int MSG_MIN = 0;   
	//IDs for outgoing messages
	//IDs for incoming messages
	public static final int IN_start = 1;
	public static final int IN_stop = 2;
	//error if msgID >= MSG_MAX
	public static final int MSG_MAX = 3;  


	private static String messageStrings[] = {"MIN",  "start","stop","MAX"};

	public String getMessageString(int msg_id) {
		if (msg_id<0 || msg_id>MSG_MAX+1){
			// id out of range
			return "Message ID out of range";
		}
		else{
			return messageStrings[msg_id];
		}
	}

	
	// port class
	static public class BlinkyControlProtocollPort extends PortBase {
		// constructors
		public BlinkyControlProtocollPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public BlinkyControlProtocollPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
					System.out.println("unknown");
				else {
					if (messageStrings[msg.getEvtId()] != "timerTick"){
						// TODOTS: model switch for activation
						DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
					}
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
				}
		}
	
		
		// sent messages
	}
	
	// replicated port class
	static public class BlinkyControlProtocollPortRepl {
		private ArrayList<BlinkyControlProtocollPort> ports;
		private int replication;
	
		public BlinkyControlProtocollPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<BlinkyControlProtocoll.BlinkyControlProtocollPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new BlinkyControlProtocollPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public BlinkyControlProtocollPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
	}
	
	// interface for port class
	public interface IBlinkyControlProtocollPort{
		// incoming messages
		 public void start ()
		;
	 public void stop ()
		;
	}
	
	// port class
	static public class BlinkyControlProtocollConjPort extends PortBase {
		// constructors
		public BlinkyControlProtocollConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public BlinkyControlProtocollConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
					System.out.println("unknown");
				else {
					if (messageStrings[msg.getEvtId()] != "timerTick"){
						// TODOTS: model switch for activation
						DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
					}
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
				}
		}
	
		
		// sent messages
		public void start ()
		{
			if (messageStrings[ IN_start] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_start]);
			}
			if (getPeerAddress()!=null)
			getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_start));
			}
		public void stop ()
		{
			if (messageStrings[ IN_stop] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_stop]);
			}
			if (getPeerAddress()!=null)
			getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_stop));
			}
	}
	
	// replicated port class
	static public class BlinkyControlProtocollConjPortRepl {
		private ArrayList<BlinkyControlProtocollConjPort> ports;
		private int replication;
	
		public BlinkyControlProtocollConjPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<BlinkyControlProtocoll.BlinkyControlProtocollConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new BlinkyControlProtocollConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public BlinkyControlProtocollConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void start ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).start()
				;
			}
		}
		public void stop ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).stop()
				;
			}
		}
	}
	
	// interface for port class
	public interface IBlinkyControlProtocollConjPort{
		// outgoing messages
		}
}
