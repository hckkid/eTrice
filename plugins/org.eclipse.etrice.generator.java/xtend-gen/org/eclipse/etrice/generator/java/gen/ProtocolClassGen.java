package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.core.room.TypedID;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ProtocolClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private JavaExtensions stdExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ProtocolClass> _usedProtocolClasses = root.getUsedProtocolClasses();
    for (final ProtocolClass pc : _usedProtocolClasses) {
      {
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(pc);
        String _path = this.roomExt.getPath(pc);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        String _javaFileName = this.stdExt.getJavaFileName(pc);
        String file = _javaFileName;
        String _operator_plus_1 = StringExtensions.operator_plus("generating ProtocolClass implementation \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        StringConcatenation _generate = this.generate(root, pc);
        this.fileAccess.generateFile(file, _generate);
      }
    }
  }
  
  public StringConcatenation generate(final Root root, final ProtocolClass pc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _package = this.roomExt.getPackage(pc);
    _builder.append(_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.Address;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.Message;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.*;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
    _builder.newLine();
    _builder.newLine();
    DetailCode _userCode1 = pc.getUserCode1();
    StringConcatenation _UserCode = this.helpers.UserCode(_userCode1);
    _builder.append(_UserCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    EList<RoomModel> _referencedModels = root.getReferencedModels(pc);
    EList<RoomModel> models = _referencedModels;
    _builder.newLineIfNotEmpty();
    {
      for(final RoomModel model : models) {
        _builder.append("import ");
        String _name = model.getName();
        _builder.append(_name, "");
        _builder.append(".*;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = pc.getName();
    _builder.append(_name_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("// message IDs");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// TODO: separate class for message IDs: class MSG{public static volatile int MSG_MIN = 0; ...} -> better structure");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// error if msgID <= MSG_MIN");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final int MSG_MIN = 0;   ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//IDs for outgoing messages");
    _builder.newLine();
    {
      List<Message> _allOutgoingMessages = this.roomExt.getAllOutgoingMessages(pc);
      for(final Message message : _allOutgoingMessages) {
        _builder.append("\t");
        _builder.append("public static final int OUT_");
        String _name_2 = message.getName();
        _builder.append(_name_2, "	");
        _builder.append(" = ");
        List<Message> _allOutgoingMessages_1 = this.roomExt.getAllOutgoingMessages(pc);
        int _indexOf = _allOutgoingMessages_1.indexOf(message);
        int _operator_plus = IntegerExtensions.operator_plus(((Integer)_indexOf), ((Integer)1));
        _builder.append(_operator_plus, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("//IDs for incoming messages");
    _builder.newLine();
    {
      List<Message> _allIncomingMessages = this.roomExt.getAllIncomingMessages(pc);
      for(final Message message_1 : _allIncomingMessages) {
        _builder.append("\t");
        _builder.append("public static final int IN_");
        String _name_3 = message_1.getName();
        _builder.append(_name_3, "	");
        _builder.append(" = ");
        List<Message> _allIncomingMessages_1 = this.roomExt.getAllIncomingMessages(pc);
        int _indexOf_1 = _allIncomingMessages_1.indexOf(message_1);
        List<Message> _allOutgoingMessages_2 = this.roomExt.getAllOutgoingMessages(pc);
        int _size = _allOutgoingMessages_2.size();
        int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)_indexOf_1), ((Integer)_size));
        int _operator_plus_2 = IntegerExtensions.operator_plus(((Integer)_operator_plus_1), ((Integer)1));
        _builder.append(_operator_plus_2, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("//error if msgID >= MSG_MAX");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final int MSG_MAX = ");
    List<Message> _allOutgoingMessages_3 = this.roomExt.getAllOutgoingMessages(pc);
    int _size_1 = _allOutgoingMessages_3.size();
    List<Message> _allIncomingMessages_2 = this.roomExt.getAllIncomingMessages(pc);
    int _size_2 = _allIncomingMessages_2.size();
    int _operator_plus_3 = IntegerExtensions.operator_plus(((Integer)_size_1), ((Integer)_size_2));
    int _operator_plus_4 = IntegerExtensions.operator_plus(((Integer)_operator_plus_3), ((Integer)1));
    _builder.append(_operator_plus_4, "	");
    _builder.append(";  ");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    DetailCode _userCode2 = pc.getUserCode2();
    StringConcatenation _UserCode_1 = this.helpers.UserCode(_userCode2);
    _builder.append(_UserCode_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String messageStrings[] = {\"MIN\", ");
    {
      List<Message> _allOutgoingMessages_4 = this.roomExt.getAllOutgoingMessages(pc);
      for(final Message m : _allOutgoingMessages_4) {
        _builder.append("\"");
        String _name_4 = m.getName();
        _builder.append(_name_4, "	");
        _builder.append("\",");
      }
    }
    _builder.append(" ");
    {
      List<Message> _allIncomingMessages_3 = this.roomExt.getAllIncomingMessages(pc);
      for(final Message m_1 : _allIncomingMessages_3) {
        _builder.append("\"");
        String _name_5 = m_1.getName();
        _builder.append(_name_5, "	");
        _builder.append("\",");
      }
    }
    _builder.append("\"MAX\"};");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getMessageString(int msg_id) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (msg_id<0 || msg_id>MSG_MAX+1){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// id out of range");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return \"Message ID out of range\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return messageStrings[msg_id];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    StringConcatenation _portClass = this.portClass(pc, ((Boolean)false));
    _builder.append(_portClass, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    StringConcatenation _portClass_1 = this.portClass(pc, ((Boolean)true));
    _builder.append(_portClass_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation portClass(final ProtocolClass pc, final Boolean conj) {
    StringConcatenation _builder = new StringConcatenation();
    String _portClassName = this.roomExt.getPortClassName(pc, conj);
    String name = _portClassName;
    _builder.newLineIfNotEmpty();
    PortClass _portClass = this.roomExt.getPortClass(pc, conj);
    PortClass pclass = _portClass;
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// port class");
    _builder.newLine();
    _builder.append("static public class ");
    _builder.append(name, "");
    _builder.append(" extends PortBase {");
    _builder.newLineIfNotEmpty();
    {
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(pclass, null);
      if (_operator_notEquals) {
        _builder.append("\t");
        DetailCode _userCode = pclass.getUserCode();
        StringConcatenation _UserCode = this.helpers.UserCode(_userCode);
        _builder.append(_UserCode, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("// constructors");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    _builder.append(name, "	");
    _builder.append("(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(actor, name, localId, 0, addr, peerAddress);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DebuggingService.getInstance().addPortInstance(this);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    _builder.append(name, "	");
    _builder.append("(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(actor, name, localId, idx, addr, peerAddress);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DebuggingService.getInstance().addPortInstance(this);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void receive(Message m) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (!(m instanceof EventMessage))");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("EventMessage msg = (EventMessage) m;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("System.out.println(\"unknown\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (messageStrings[msg.getEvtId()] != \"timerTick\"){");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("// TODOTS: model switch for activation");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    {
      boolean _handlesReceive = this.roomExt.handlesReceive(pc, conj);
      if (_handlesReceive) {
        _builder.append("\t\t\t\t");
        _builder.append("switch (msg.getEvtId()) {");
        _builder.newLine();
        {
          List<MessageHandler> _receiveHandlers = this.roomExt.getReceiveHandlers(pc, conj);
          for(final MessageHandler hdlr : _receiveHandlers) {
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("case ");
            Message _msg = hdlr.getMsg();
            String _codeName = this.roomExt.getCodeName(_msg);
            _builder.append(_codeName, "					");
            _builder.append(":");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("{");
            _builder.newLine();
            {
              DetailCode _detailCode = hdlr.getDetailCode();
              EList<String> _commands = _detailCode.getCommands();
              for(final String command : _commands) {
                _builder.append("\t\t\t\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append(command, "						");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("break;");
            _builder.newLine();
          }
        }
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("default:");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t\t\t");
    _builder.append("if (msg instanceof EventWithDataMessage)");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("getActor().receiveEvent(this, msg.getEvtId(), null);");
    _builder.newLine();
    {
      boolean _handlesReceive_1 = this.roomExt.handlesReceive(pc, conj);
      if (_handlesReceive_1) {
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(pclass, null);
      if (_operator_notEquals_1) {
        _builder.append("\t");
        EList<Attribute> _attributes = pclass.getAttributes();
        StringConcatenation _Attributes = this.helpers.Attributes(_attributes);
        _builder.append(_Attributes, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        EList<Operation> _operations = pclass.getOperations();
        StringConcatenation _OperationsImplementation = this.helpers.OperationsImplementation(_operations, name);
        _builder.append(_OperationsImplementation, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// sent messages");
    _builder.newLine();
    {
      List<Message> _outgoing = this.roomExt.getOutgoing(pc, conj);
      for(final Message m : _outgoing) {
        _builder.append("\t");
        StringConcatenation _sendMessage = this.sendMessage(m, conj);
        _builder.append(_sendMessage, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// replicated port class");
    _builder.newLine();
    _builder.append("static public class ");
    _builder.append(name, "");
    _builder.append("Repl {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private ArrayList<");
    _builder.append(name, "	");
    _builder.append("> ports;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private int replication;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    _builder.append(name, "	");
    _builder.append("Repl(IEventReceiver actor, String name, int localId, Address[] addr,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("Address[] peerAddress) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("replication = addr.length;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ports = new ArrayList<");
    String _name = pc.getName();
    _builder.append(_name, "		");
    _builder.append(".");
    _builder.append(name, "		");
    _builder.append(">(replication);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("for (int i=0; i<replication; ++i) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ports.add(new ");
    _builder.append(name, "			");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("actor, name+i, localId, i, addr[i], peerAddress[i]));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int getReplication() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return replication;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int getIndexOf(InterfaceItemBase ifitem){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return ifitem.getIdx();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    _builder.append(name, "	");
    _builder.append(" get(int i) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return ports.get(i);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      if (conj) {
        _builder.append("\t");
        _builder.append("// incoming messages");
        _builder.newLine();
        {
          List<Message> _allIncomingMessages = this.roomExt.getAllIncomingMessages(pc);
          for(final Message m_1 : _allIncomingMessages) {
            _builder.append("\t");
            StringConcatenation _messageSignature = this.messageSignature(m_1);
            _builder.append(_messageSignature, "	");
            _builder.append("{");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("for (int i=0; i<replication; ++i) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("ports.get(i).");
            StringConcatenation _messageCall = this.messageCall(m_1);
            _builder.append(_messageCall, "			");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      } else {
        _builder.append("\t");
        _builder.append("// outgoing messages");
        _builder.newLine();
        {
          List<Message> _allOutgoingMessages = this.roomExt.getAllOutgoingMessages(pc);
          for(final Message m_2 : _allOutgoingMessages) {
            _builder.append("\t");
            StringConcatenation _messageSignature_1 = this.messageSignature(m_2);
            _builder.append(_messageSignature_1, "	");
            _builder.append("{");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("for (int i=0; i<replication; ++i) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("ports.get(i).");
            StringConcatenation _messageCall_1 = this.messageCall(m_2);
            _builder.append(_messageCall_1, "			");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// interface for port class");
    _builder.newLine();
    _builder.append("public interface I");
    _builder.append(name, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    {
      if (conj) {
        _builder.append("\t");
        _builder.append("// outgoing messages");
        _builder.newLine();
        _builder.append("\t");
        {
          List<Message> _allOutgoingMessages_1 = this.roomExt.getAllOutgoingMessages(pc);
          for(final Message m_3 : _allOutgoingMessages_1) {
            _builder.append(" ");
            StringConcatenation _messageSignature_2 = this.messageSignature(m_3);
            _builder.append(_messageSignature_2, "	");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        _builder.append("\t");
        _builder.append("// incoming messages");
        _builder.newLine();
        _builder.append("\t");
        {
          List<Message> _allIncomingMessages_1 = this.roomExt.getAllIncomingMessages(pc);
          for(final Message m_4 : _allIncomingMessages_1) {
            _builder.append(" ");
            StringConcatenation _messageSignature_3 = this.messageSignature(m_4);
            _builder.append(_messageSignature_3, "	");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation messageSignature(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append(" (");
    {
      TypedID _data = m.getData();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_data, null);
      if (_operator_notEquals) {
        TypedID _data_1 = m.getData();
        Type _type = _data_1.getType();
        String _typeName = this.stdExt.typeName(_type);
        _builder.append(_typeName, "");
        _builder.append(" ");
        TypedID _data_2 = m.getData();
        String _name_1 = _data_2.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation messageCall(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(");
    {
      TypedID _data = m.getData();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_data, null);
      if (_operator_notEquals) {
        _builder.append(" ");
        TypedID _data_1 = m.getData();
        String _name_1 = _data_1.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation sendMessage(final Message m, final boolean conj) {
    StringConcatenation _builder = new StringConcatenation();
    String _xifexpression = null;
    if (conj) {
      _xifexpression = "IN";
    } else {
      _xifexpression = "OUT";
    }
    String dir = _xifexpression;
    _builder.newLineIfNotEmpty();
    MessageHandler _sendHandler = this.roomExt.getSendHandler(m, conj);
    MessageHandler hdlr = _sendHandler;
    _builder.newLineIfNotEmpty();
    StringConcatenation _messageSignature = this.messageSignature(m);
    _builder.append(_messageSignature, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    {
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(hdlr, null);
      if (_operator_notEquals) {
        _builder.append("\t");
        {
          DetailCode _detailCode = hdlr.getDetailCode();
          EList<String> _commands = _detailCode.getCommands();
          for(final String command : _commands) {
            _builder.append("\t");
            _builder.append(command, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        _builder.append("\t");
        _builder.append("if (messageStrings[ ");
        _builder.append(dir, "	");
        _builder.append("_");
        String _name = m.getName();
        _builder.append(_name, "	");
        _builder.append("] != \"timerTick\"){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("// TODOTS: model switch for activation");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[");
        _builder.append(dir, "	");
        _builder.append("_");
        String _name_1 = m.getName();
        _builder.append(_name_1, "	");
        _builder.append("]);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (getPeerAddress()!=null)");
        _builder.newLine();
        _builder.append("\t");
        {
          TypedID _data = m.getData();
          boolean _operator_equals = ObjectExtensions.operator_equals(_data, null);
          if (_operator_equals) {
            _builder.append("getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), ");
            _builder.append(dir, "	");
            _builder.append("_");
            String _name_2 = m.getName();
            _builder.append(_name_2, "	");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
          } else {
            _builder.append("getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), ");
            _builder.append(dir, "	");
            _builder.append("_");
            String _name_3 = m.getName();
            _builder.append(_name_3, "	");
            _builder.append(", ");
            TypedID _data_1 = m.getData();
            String _name_4 = _data_1.getName();
            _builder.append(_name_4, "	");
            {
              boolean _operator_and = false;
              TypedID _data_2 = m.getData();
              Type _type = _data_2.getType();
              boolean _isRef = _type.isRef();
              boolean _operator_not = BooleanExtensions.operator_not(_isRef);
              if (!_operator_not) {
                _operator_and = false;
              } else {
                TypedID _data_3 = m.getData();
                Type _type_1 = _data_3.getType();
                DataClass _type_2 = _type_1.getType();
                boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_type_2, null);
                _operator_and = BooleanExtensions.operator_and(_operator_not, _operator_notEquals_1);
              }
              if (_operator_and) {
                _builder.append(".deepCopy()");
              }
            }
            _builder.append("));");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
