package room.basic.service.timing;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;

//--------------------- begin user code
	import java.util.TimerTask;
//--------------------- end user code


public class PTimer {
	// message IDs
	// TODO: separate class for message IDs: class MSG{public static volatile int MSG_MIN = 0; ...} -> better structure
	// error if msgID <= MSG_MIN
	public static final int MSG_MIN = 0;   
	//IDs for outgoing messages
	public static final int OUT_timerTick = 1;
	//IDs for incoming messages
	public static final int IN_Start = 2;
	public static final int IN_Kill = 3;
	//error if msgID >= MSG_MAX
	public static final int MSG_MAX = 4;  

	//--------------------- begin user code
		static protected class FireTimerTask extends TimerTask {
		
					private int time;
					private int id;
					private PTimerPort port;
		
					public FireTimerTask(int time, int id, PTimerPort port) {
						this.time = time;
						this.id = id;
						this.port = port;
					}
		
					@Override
					public void run() {
						port.timer(id);
					}
					
					public int getTime() {
						return time;
					}
					
					public int getId() {
						return id;
					}
				}
				
				static protected class TimerData {
					int time;
					int id;
					public TimerData(int time, int id) {
						this.time = time;
						this.id = id;
					}
				}
	//--------------------- end user code

	private static String messageStrings[] = {"MIN", "timerTick", "Start","Kill","MAX"};

	public String getMessageString(int msg_id) {
		if (msg_id<MSG_MIN || msg_id>MSG_MAX+1){
			// id out of range
			return "Message ID out of range";
		}
		else{
			return messageStrings[msg_id];
		}
	}

	
	// port class
	static public class PTimerPort extends PortBase {
		//--------------------- begin user code
			private FireTimerTask task = null;
						
						public TimerTask getTask() { return task; }
		//--------------------- end user code
		// constructors
		public PTimerPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTimerPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
											TimerData td = (TimerData)dataMsg.getData();
											task = new FireTimerTask(td.time, td.id, this);
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
		public void timer(Integer id) {
			//regular PortClass Operation timer
						DebuggingService.getInstance().addMessageAsyncOut(getAddress(),
								getPeerAddress(), messageStrings[OUT_timerTick]);
			
						getPeerMsgReceiver().receive(
								new EventWithDataMessage(getPeerAddress(), OUT_timerTick, id));
		}
		
		// sent messages
		public void timerTick ()
		{
			if (messageStrings[ OUT_timerTick] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_timerTick]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_timerTick));
				}
	}
	
	// replicated port class
	static public class PTimerPortRepl {
		private ArrayList<PTimerPort> ports;
		private int replication;
	
		public PTimerPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PTimer.PTimerPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTimerPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimerPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void timerTick ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).timerTick()
				;
			}
		}
	}
	
	
	// port class
	static public class PTimerConjPort extends PortBase {
		//--------------------- begin user code
			private int currentId = 0;
						private boolean active = false;
		//--------------------- end user code
		// constructors
		public PTimerConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTimerConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
						case OUT_timerTick:
						{
							//conjugate PortClass handle timer
											EventWithDataMessage dataMsg = (EventWithDataMessage) msg;
											int id = (Integer)dataMsg.getData();
											if (active && id==currentId) {
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
													IN_Start, new TimerData(time_ms, ++currentId)));
		}
		public void Kill ()
		{
				//conjugate PortClass kill
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(),
									getPeerAddress(), messageStrings[IN_Kill]);
				
							if (active) {
								active = false;
								getPeerMsgReceiver().receive(
										new EventWithDataMessage(getPeerAddress(), IN_Kill, currentId));
							}
		}
	}
	
	// replicated port class
	static public class PTimerConjPortRepl {
		private ArrayList<PTimerConjPort> ports;
		private int replication;
	
		public PTimerConjPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PTimer.PTimerConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTimerConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimerConjPort get(int i) {
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
	
}
