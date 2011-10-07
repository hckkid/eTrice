package room.basic.service.timing;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;

//--------------------- begin user code
		import java.util.TimerTask;
	//--------------------- end user code


public class PTimeout {
	// message IDs
	// TODO: separate class for message IDs: class MSG{public static volatile int MSG_MIN = 0; ...} -> better structure
	// error if msgID <= MSG_MIN
	public static final int MSG_MIN = 0;   
	//IDs for outgoing messages
	public static final int OUT_timeoutTick = 1;
	//IDs for incoming messages
	public static final int IN_Start = 2;
	public static final int IN_Kill = 3;
	//error if msgID >= MSG_MAX
	public static final int MSG_MAX = 4;  

	//--------------------- begin user code
			static protected class FireTimeoutTask extends TimerTask {
			
						private int time;
						private int id;
						private PTimeoutPort port;
			
						public FireTimeoutTask(int time, int id, PTimeoutPort port) {
							this.time = time;
							this.id = id;
							this.port = port;
						}
			
						@Override
						public void run() {
							port.timeout(id);
						}
						
						public int getTime() {
							return time;
						}
						
						public int getId() {
							return id;
						}
					}
					
					static protected class TimeoutData {
						int time;
						int id;
						public TimeoutData(int time, int id) {
							this.time = time;
							this.id = id;
						}
					}
		//--------------------- end user code

	private static String messageStrings[] = {"MIN", "timeoutTick", "Start","Kill","MAX"};

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
	static public class PTimeoutPort extends PortBase {
		//--------------------- begin user code
				private FireTimeoutTask task = null;
							
							public TimerTask getTask() { return task; }
			//--------------------- end user code
		// constructors
		public PTimeoutPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTimeoutPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
					switch (msg.getEvtId()) {
						case IN_Start:
						{
							//regular PortClass handle start
											EventWithDataMessage dataMsg = (EventWithDataMessage) msg;
											TimeoutData td = (TimeoutData)dataMsg.getData();
											task = new FireTimeoutTask(td.time, td.id, this);
											getActor().receiveEvent(this, IN_Start, td.time);
						}
						break;
						case IN_Kill:
						{
							//regular PortClass handle kill
											EventWithDataMessage dataMsg = (EventWithDataMessage) msg;
											int id = (Integer)dataMsg.getData();
											if (task!=null && task.getId()==id) {
												task.cancel();
											}
						}
						break;
						default:
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
					}
				}
		}
	
		//--------------------- attributes
		//--------------------- operations
		public void timeout (Integer id){
				//regular PortClass Operation timeout
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(),
									getPeerAddress(), messageStrings[OUT_timeoutTick]);
				
							getPeerMsgReceiver().receive(
									new EventWithDataMessage(getPeerAddress(), OUT_timeoutTick, id));
		}
		
		// sent messages
		public void timeoutTick ()
		{
			if (messageStrings[ OUT_timeoutTick] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_timeoutTick]);
			}
			if (getPeerAddress()!=null)
			getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_timeoutTick));
			}
	}
	
	// replicated port class
	static public class PTimeoutPortRepl {
		private ArrayList<PTimeoutPort> ports;
		private int replication;
	
		public PTimeoutPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PTimeout.PTimeoutPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTimeoutPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimeoutPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void timeoutTick ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).timeoutTick()
				;
			}
		}
	}
	
	// interface for port class
	public interface IPTimeoutPort{
		// incoming messages
		 public void Start (int time_ms)
		;
	 public void Kill ()
		;
	}
	
	// port class
	static public class PTimeoutConjPort extends PortBase {
		//--------------------- begin user code
				private int currentId = 0;
							private boolean active = false;
			//--------------------- end user code
		// constructors
		public PTimeoutConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTimeoutConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
					switch (msg.getEvtId()) {
						case OUT_timeoutTick:
						{
							//conjugate PortClass handle timeout
											EventWithDataMessage dataMsg = (EventWithDataMessage) msg;
											int id = (Integer)dataMsg.getData();
											if (active && id==currentId) {
												active = false;
												getActor().receiveEvent(this, msg.getEvtId(), null);
											}
						}
						break;
						default:
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
					}
				}
		}
	
		//--------------------- attributes
		//--------------------- operations
		
		// sent messages
		public void Start (int time_ms)
		{
				//conjugate PortClass handle start
							if (active)
								return;
								
							active = true;
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(),
									getPeerAddress(), messageStrings[IN_Start]);
				
							getPeerMsgReceiver()
									.receive(
											new EventWithDataMessage(getPeerAddress(),
													IN_Start, new TimeoutData(time_ms, ++currentId)));
		}
		public void Kill ()
		{
				//conjugate PortClass kill
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(),
									getPeerAddress(), messageStrings[IN_Kill]);
				
							if (active) {
								active = false;
								getPeerMsgReceiver().receive(
										new EventWithDataMessage(getPeerAddress(), IN_Kill, new Integer(currentId)));
							}
		}
	}
	
	// replicated port class
	static public class PTimeoutConjPortRepl {
		private ArrayList<PTimeoutConjPort> ports;
		private int replication;
	
		public PTimeoutConjPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PTimeout.PTimeoutConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTimeoutConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimeoutConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void Start (int time_ms)
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).Start( time_ms)
				;
			}
		}
		public void Kill ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).Kill()
				;
			}
		}
	}
	
	// interface for port class
	public interface IPTimeoutConjPort{
		// outgoing messages
		 public void timeoutTick ()
		;
	}
}
