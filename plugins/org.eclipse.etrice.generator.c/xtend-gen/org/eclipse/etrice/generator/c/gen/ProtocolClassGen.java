package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
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
  private CExtensions stdExt;
  
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
        String _cHeaderFileName = this.stdExt.getCHeaderFileName(pc);
        String _operator_plus_1 = StringExtensions.operator_plus("generating ProtocolClass header \'", _cHeaderFileName);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        String _cHeaderFileName_1 = this.stdExt.getCHeaderFileName(pc);
        StringConcatenation _generateHeaderFile = this.generateHeaderFile(root, pc);
        this.fileAccess.generateFile(_cHeaderFileName_1, _generateHeaderFile);
        String _cSourceFileName = this.stdExt.getCSourceFileName(pc);
        String _operator_plus_5 = StringExtensions.operator_plus("generating ProtocolClass source \'", _cSourceFileName);
        String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, "\' in \'");
        String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, path);
        String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, "\'");
        this.logger.logInfo(_operator_plus_8);
        this.fileAccess.setOutputPath(path);
        String _cSourceFileName_1 = this.stdExt.getCSourceFileName(pc);
        StringConcatenation _generateSourceFile = this.generateSourceFile(root, pc);
        this.fileAccess.generateFile(_cSourceFileName_1, _generateSourceFile);
      }
    }
  }
  
  public StringConcatenation generateHeaderFile(final Root root, final ProtocolClass pc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef _");
    String _name = pc.getName();
    _builder.append(_name, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define _");
    String _name_1 = pc.getName();
    _builder.append(_name_1, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"etDatatypes.h\"");
    _builder.newLine();
    _builder.newLine();
    DetailCode _userCode1 = pc.getUserCode1();
    StringConcatenation _UserCode = this.helpers.UserCode(_userCode1);
    _builder.append(_UserCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      HashSet<DataClass> _referencedDataClasses = root.getReferencedDataClasses(pc);
      for(final DataClass dataClass : _referencedDataClasses) {
        _builder.append("#include \"");
        String _name_2 = dataClass.getName();
        _builder.append(_name_2, "");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("typedef struct {");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("} ");
    String _name_3 = pc.getName();
    _builder.append(_name_3, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* message IDs */");
    _builder.newLine();
    _builder.append("enum {");
    _builder.newLine();
    _builder.append("\t");
    String _name_4 = pc.getName();
    _builder.append(_name_4, "	");
    _builder.append("_MSG_MIN = 0, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("/* IDs for outgoing messages */");
    _builder.newLine();
    {
      List<Message> _allOutgoingMessages = this.roomExt.getAllOutgoingMessages(pc);
      for(final Message message : _allOutgoingMessages) {
        _builder.append("\t");
        String _name_5 = pc.getName();
        String _name_6 = message.getName();
        String _outMessageId = this.stdExt.outMessageId(_name_5, _name_6);
        _builder.append(_outMessageId, "	");
        _builder.append(" = ");
        List<Message> _allOutgoingMessages_1 = this.roomExt.getAllOutgoingMessages(pc);
        int _indexOf = _allOutgoingMessages_1.indexOf(message);
        int _operator_plus = IntegerExtensions.operator_plus(((Integer)_indexOf), ((Integer)1));
        _builder.append(_operator_plus, "	");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("/* IDs for incoming messages */");
    _builder.newLine();
    {
      List<Message> _allIncomingMessages = this.roomExt.getAllIncomingMessages(pc);
      for(final Message message_1 : _allIncomingMessages) {
        _builder.append("\t");
        String _name_7 = pc.getName();
        String _name_8 = message_1.getName();
        String _inMessageId = this.stdExt.inMessageId(_name_7, _name_8);
        _builder.append(_inMessageId, "	");
        _builder.append(" = ");
        List<Message> _allIncomingMessages_1 = this.roomExt.getAllIncomingMessages(pc);
        int _indexOf_1 = _allIncomingMessages_1.indexOf(message_1);
        List<Message> _allOutgoingMessages_2 = this.roomExt.getAllOutgoingMessages(pc);
        int _size = _allOutgoingMessages_2.size();
        int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)_indexOf_1), ((Integer)_size));
        int _operator_plus_2 = IntegerExtensions.operator_plus(((Integer)_operator_plus_1), ((Integer)1));
        _builder.append(_operator_plus_2, "	");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("/* error if msgID >= MSG_MAX */");
    _builder.newLine();
    _builder.append("\t");
    String _name_9 = pc.getName();
    _builder.append(_name_9, "	");
    _builder.append("_MSG_MAX = ");
    List<Message> _allOutgoingMessages_3 = this.roomExt.getAllOutgoingMessages(pc);
    int _size_1 = _allOutgoingMessages_3.size();
    List<Message> _allIncomingMessages_2 = this.roomExt.getAllIncomingMessages(pc);
    int _size_2 = _allIncomingMessages_2.size();
    int _operator_plus_3 = IntegerExtensions.operator_plus(((Integer)_size_1), ((Integer)_size_2));
    int _operator_plus_4 = IntegerExtensions.operator_plus(((Integer)_operator_plus_3), ((Integer)1));
    _builder.append(_operator_plus_4, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*--------------------- port classes */");
    _builder.newLine();
    StringConcatenation _portClassHeader = this.portClassHeader(pc, ((Boolean)false));
    _builder.append(_portClassHeader, "");
    _builder.newLineIfNotEmpty();
    StringConcatenation _portClassHeader_1 = this.portClassHeader(pc, ((Boolean)true));
    _builder.append(_portClassHeader_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/*--------------------- debug helpers */");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/* get message string for message id */");
    _builder.newLine();
    _builder.append("const char* ");
    String _name_10 = pc.getName();
    _builder.append(_name_10, "");
    _builder.append("_getMessageString(int msg_id);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    DetailCode _userCode2 = pc.getUserCode2();
    StringConcatenation _UserCode_1 = this.helpers.UserCode(_userCode2);
    _builder.append(_UserCode_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif /* _");
    String _name_11 = pc.getName();
    _builder.append(_name_11, "");
    _builder.append("_H_ */");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateSourceFile(final Root root, final ProtocolClass pc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include \"");
    String _cHeaderFileName = this.stdExt.getCHeaderFileName(pc);
    _builder.append(_cHeaderFileName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/*--------------------- port classes */");
    _builder.newLine();
    StringConcatenation _portClassSource = this.portClassSource(pc, ((Boolean)false));
    _builder.append(_portClassSource, "");
    _builder.newLineIfNotEmpty();
    StringConcatenation _portClassSource_1 = this.portClassSource(pc, ((Boolean)true));
    _builder.append(_portClassSource_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/*--------------------- debug helpers */");
    _builder.newLine();
    StringConcatenation _generateDebugHelpersImplementation = this.generateDebugHelpersImplementation(root, pc);
    _builder.append(_generateDebugHelpersImplementation, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation portClass(final ProtocolClass pc, final Boolean conj) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation portClassHeader(final ProtocolClass pc, final Boolean conj) {
    StringConcatenation _builder = new StringConcatenation();
    String _portClassName = this.roomExt.getPortClassName(pc, conj);
    String portClassName = _portClassName;
    _builder.newLineIfNotEmpty();
    PortClass _portClass = this.roomExt.getPortClass(pc, conj);
    PortClass pClass = _portClass;
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("typedef etPort ");
    _builder.append(portClassName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    StringConcatenation _ClassOperationSignature = this.helpers.ClassOperationSignature(portClassName, "MyOperation1", "int a, int b", "void", true);
    _builder.append(_ClassOperationSignature, "");
    _builder.newLineIfNotEmpty();
    StringConcatenation _ClassOperationSignature_1 = this.helpers.ClassOperationSignature(portClassName, "MyOperation2", "", "int", false);
    _builder.append(_ClassOperationSignature_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation portClassSource(final ProtocolClass pc, final Boolean conj) {
    StringConcatenation _builder = new StringConcatenation();
    String _portClassName = this.roomExt.getPortClassName(pc, conj);
    String name = _portClassName;
    _builder.newLineIfNotEmpty();
    PortClass _portClass = this.roomExt.getPortClass(pc, conj);
    PortClass pclass = _portClass;
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation messageSignature(final ProtocolClass pc, final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void ");
    String _name = pc.getName();
    _builder.append(_name, "");
    _builder.append("_");
    String _name_1 = m.getName();
    _builder.append(_name_1, "");
    _builder.append(" (");
    {
      VarDecl _data = m.getData();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_data, null);
      if (_operator_notEquals) {
        VarDecl _data_1 = m.getData();
        DataType _type = _data_1.getType();
        String _name_2 = _type.getName();
        _builder.append(_name_2, "");
        _builder.append(" ");
        VarDecl _data_2 = m.getData();
        String _name_3 = _data_2.getName();
        _builder.append(_name_3, "");
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
      VarDecl _data = m.getData();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_data, null);
      if (_operator_notEquals) {
        _builder.append(" ");
        VarDecl _data_1 = m.getData();
        String _name_1 = _data_1.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation generateDebugHelpersImplementation(final Root root, final ProtocolClass pc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/* TODO: make this optional or different for smaller footprint */");
    _builder.newLine();
    _builder.append("/* message names as strings for debugging (generate MSC) */");
    _builder.newLine();
    _builder.append("static const char* ");
    String _name = pc.getName();
    _builder.append(_name, "");
    _builder.append("_messageStrings[] = {\"MIN\", ");
    {
      List<Message> _allOutgoingMessages = this.roomExt.getAllOutgoingMessages(pc);
      for(final Message m : _allOutgoingMessages) {
        _builder.append("\"");
        String _name_1 = m.getName();
        _builder.append(_name_1, "");
        _builder.append("\",");
      }
    }
    {
      List<Message> _allIncomingMessages = this.roomExt.getAllIncomingMessages(pc);
      for(final Message m_1 : _allIncomingMessages) {
        _builder.append("\"");
        String _name_2 = m_1.getName();
        _builder.append(_name_2, "");
        _builder.append("\", ");
      }
    }
    _builder.append("\"MAX\"};");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("const char* ");
    String _name_3 = pc.getName();
    _builder.append(_name_3, "");
    _builder.append("_getMessageString(int msg_id) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (msg_id<");
    String _name_4 = pc.getName();
    _builder.append(_name_4, "	");
    _builder.append("_MSG_MIN || msg_id>");
    String _name_5 = pc.getName();
    _builder.append(_name_5, "	");
    _builder.append("_MSG_MAX+1){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("/* id out of range */");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"Message ID out of range\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("else{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ");
    String _name_6 = pc.getName();
    _builder.append(_name_6, "		");
    _builder.append("_messageStrings[msg_id];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
