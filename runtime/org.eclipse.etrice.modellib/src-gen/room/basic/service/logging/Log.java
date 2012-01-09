package room.basic.service.logging;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class Log {
	// message IDs
	// TODO: separate class for message IDs: class MSG{public static volatile int MSG_MIN = 0; ...} -> better structure
	// error if msgID <= MSG_MIN
	public static final int MSG_MIN = 0;   
	//IDs for outgoing messages
	//IDs for incoming messages
	public static final int IN_open = 1;
	public static final int IN_setLogLevel = 2;
	public static final int IN_close = 3;
	public static final int IN_log = 4;
	public static final int IN_internalLog = 5;
	//error if msgID >= MSG_MAX
	public static final int MSG_MAX = 6;  


	private static String messageStrings[] = {"MIN",  "open","setLogLevel","close","log","internalLog","MAX"};

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
	static public class LogPort extends PortBase {
		// constructors
		public LogPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public LogPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
	static public class LogPortRepl {
		private ArrayList<LogPort> ports;
		private int replication;
	
		public LogPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<Log.LogPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new LogPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public LogPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
	}
	
	
	// port class
	static public class LogConjPort extends PortBase {
		//--------------------- begin user code
			public static final int LOG_LEVEL_LOW = 1;
			public static final int LOG_LEVEL_MEDIUM = 2;
			public static final int LOG_LEVEL_HIGH = 3;
			static int logLevel=0;
			InternalLogData d = new InternalLogData();
		//--------------------- end user code
		// constructors
		public LogConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public LogConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
	
		//--------------------- attributes
		//--------------------- operations
		
		// sent messages
		public void open(String fileName) {
			if (messageStrings[ IN_open] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_open]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_open, fileName));
		}
		public void setLogLevel(int l) {
				logLevel=l;
			if (logLevel > LOG_LEVEL_HIGH) logLevel=LOG_LEVEL_HIGH;
		}
		public void close() {
			if (messageStrings[ IN_close] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_close]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_close));
				}
		public void log(LogData data) {
				long s;
			if (data.logLevel>this.logLevel){
			d.userString=data.userString;
			s=System.currentTimeMillis();
			d.timeStamp=Long.toString(s);
			d.sender=getInstancePath();
			if (getPeerAddress()!=null)
			getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalLog, d));
			}
		}
		public void log(int logLevel, String userString) {
			log(new LogData(logLevel, userString));
		}
		public void internalLog(InternalLogData data) {
			if (messageStrings[ IN_internalLog] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_internalLog]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalLog, data.deepCopy()));
		}
		public void internalLog(String userString, String sender, String timeStamp) {
			internalLog(new InternalLogData(userString, sender, timeStamp));
		}
	}
	
	// replicated port class
	static public class LogConjPortRepl {
		private ArrayList<LogConjPort> ports;
		private int replication;
	
		public LogConjPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<Log.LogConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new LogConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public LogConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void open(String fileName){
			for (int i=0; i<replication; ++i) {
				ports.get(i).open( fileName);
			}
		}
		public void setLogLevel(int l){
			for (int i=0; i<replication; ++i) {
				ports.get(i).setLogLevel( l);
			}
		}
		public void close(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).close();
			}
		}
		public void log(LogData data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).log( data);
			}
		}
		public void internalLog(InternalLogData data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).internalLog( data);
			}
		}
	}
	
}
