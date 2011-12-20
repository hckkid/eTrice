package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StateMachine;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.core.room.TypedID;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.LanguageExtensions;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.ProcedureHelpers;
import org.eclipse.etrice.generator.java.gen.StateMachineGen;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ActorClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private JavaExtensions stdExt;
  
  @Inject
  private LanguageExtensions languageExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private StateMachineGen stateMachineGen;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    for (final ExpandedActorClass xpac : _xpActorClasses) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        String _generationTargetPath = this.languageExt.getGenerationTargetPath(_actorClass);
        ActorClass _actorClass_1 = xpac.getActorClass();
        String _path = this.languageExt.getPath(_actorClass_1);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _javaFileName = this.stdExt.getJavaFileName(_actorClass_2);
        String file = _javaFileName;
        String _operator_plus_1 = StringExtensions.operator_plus("generating ActorClass implementation \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        ActorClass _actorClass_3 = xpac.getActorClass();
        StringConcatenation _generate = this.generate(root, xpac, _actorClass_3);
        this.fileAccess.generateFile(file, _generate);
      }
    }
  }
  
  public StringConcatenation generate(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _package = this.languageExt.getPackage(ac);
    _builder.append(_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.Address;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.IRTObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<RoomModel> _referencedModels = root.getReferencedModels(ac);
      for(final RoomModel model : _referencedModels) {
        _builder.append("import ");
        String _name = model.getName();
        _builder.append(_name, "");
        _builder.append(".*;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      EList<ProtocolClass> _referencedProtocols = root.getReferencedProtocols(ac);
      for(final ProtocolClass pc : _referencedProtocols) {
        _builder.append("import ");
        String _package_1 = this.languageExt.getPackage(pc);
        _builder.append(_package_1, "");
        _builder.append(".");
        String _name_1 = pc.getName();
        _builder.append(_name_1, "");
        _builder.append(".*;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    DetailCode _userCode1 = ac.getUserCode1();
    StringConcatenation _UserCode = this.helpers.UserCode(_userCode1);
    _builder.append(_UserCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    {
      boolean _isAbstract = ac.isAbstract();
      if (_isAbstract) {
        _builder.append("abstract ");
      }
    }
    _builder.append("class ");
    String _name_2 = ac.getName();
    _builder.append(_name_2, "");
    _builder.append(" extends ");
    {
      ActorClass _base = ac.getBase();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_base, null);
      if (_operator_notEquals) {
        ActorClass _base_1 = ac.getBase();
        String _name_3 = _base_1.getName();
        _builder.append(_name_3, "");
      } else {
        _builder.append("ActorClassBase");
      }
    }
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    DetailCode _userCode2 = ac.getUserCode2();
    StringConcatenation _UserCode_1 = this.helpers.UserCode(_userCode2);
    _builder.append(_UserCode_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//--------------------- ports");
    _builder.newLine();
    {
      List<Port> _endPorts = this.languageExt.getEndPorts(ac);
      for(final Port ep : _endPorts) {
        _builder.append("\t");
        _builder.append("protected ");
        String _portClassName = this.languageExt.getPortClassName(ep);
        _builder.append(_portClassName, "	");
        _builder.append(" ");
        String _name_4 = ep.getName();
        _builder.append(_name_4, "	");
        _builder.append(" = null;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("//--------------------- saps");
    _builder.newLine();
    {
      EList<SAPRef> _strSAPs = ac.getStrSAPs();
      for(final SAPRef sap : _strSAPs) {
        _builder.append("\t");
        _builder.append("protected ");
        String _portClassName_1 = this.languageExt.getPortClassName(sap);
        _builder.append(_portClassName_1, "	");
        _builder.append(" ");
        String _name_5 = sap.getName();
        _builder.append(_name_5, "	");
        _builder.append(" = null;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("//--------------------- services");
    _builder.newLine();
    {
      EList<ServiceImplementation> _serviceImplementations = ac.getServiceImplementations();
      for(final ServiceImplementation svc : _serviceImplementations) {
        _builder.append("\t");
        _builder.append("protected ");
        String _portClassName_2 = this.languageExt.getPortClassName(svc);
        _builder.append(_portClassName_2, "	");
        _builder.append(" ");
        SPPRef _spp = svc.getSpp();
        String _name_6 = _spp.getName();
        _builder.append(_name_6, "	");
        _builder.append(" = null;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//--------------------- interface item IDs");
    _builder.newLine();
    {
      List<Port> _endPorts_1 = this.languageExt.getEndPorts(ac);
      for(final Port ep_1 : _endPorts_1) {
        _builder.append("\t");
        _builder.append("protected static final int IFITEM_");
        String _name_7 = ep_1.getName();
        _builder.append(_name_7, "	");
        _builder.append(" = ");
        int _interfaceItemLocalId = xpac.getInterfaceItemLocalId(ep_1);
        int _operator_plus = IntegerExtensions.operator_plus(((Integer)_interfaceItemLocalId), ((Integer)1));
        _builder.append(_operator_plus, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<SAPRef> _strSAPs_1 = ac.getStrSAPs();
      for(final SAPRef sap_1 : _strSAPs_1) {
        _builder.append("\t");
        _builder.append("protected static final int IFITEM_");
        String _name_8 = sap_1.getName();
        _builder.append(_name_8, "	");
        _builder.append(" = ");
        int _interfaceItemLocalId_1 = xpac.getInterfaceItemLocalId(sap_1);
        int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)_interfaceItemLocalId_1), ((Integer)1));
        _builder.append(_operator_plus_1, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<ServiceImplementation> _serviceImplementations_1 = ac.getServiceImplementations();
      for(final ServiceImplementation svc_1 : _serviceImplementations_1) {
        _builder.append("\t");
        _builder.append("protected static final int IFITEM_");
        SPPRef _spp_1 = svc_1.getSpp();
        String _name_9 = _spp_1.getName();
        _builder.append(_name_9, "	");
        _builder.append(" = ");
        SPPRef _spp_2 = svc_1.getSpp();
        int _interfaceItemLocalId_2 = xpac.getInterfaceItemLocalId(_spp_2);
        int _operator_plus_2 = IntegerExtensions.operator_plus(((Integer)_interfaceItemLocalId_2), ((Integer)1));
        _builder.append(_operator_plus_2, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    EList<Attribute> _attributes = ac.getAttributes();
    StringConcatenation _Attributes = this.helpers.Attributes(_attributes);
    _builder.append(_Attributes, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    EList<Operation> _operations = ac.getOperations();
    StringConcatenation _Operations = this.helpers.Operations(_operations);
    _builder.append(_Operations, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//--------------------- construction");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_10 = ac.getName();
    _builder.append(_name_10, "	");
    _builder.append("(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){");
    _builder.newLineIfNotEmpty();
    {
      ActorClass _base_2 = ac.getBase();
      boolean _operator_equals = ObjectExtensions.operator_equals(_base_2, null);
      if (_operator_equals) {
        _builder.append("\t\t");
        _builder.append("super(parent, name, port_addr[0][0], peer_addr[0][0]);");
        _builder.newLine();
      } else {
        _builder.append("\t\t");
        _builder.append("super(parent, name, port_addr, peer_addr);");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("setClassName(\"");
    String _name_11 = ac.getName();
    _builder.append(_name_11, "		");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      EList<Attribute> _attributes_1 = ac.getAttributes();
      for(final Attribute a : _attributes_1) {
        {
          String _defaultValueLiteral = a.getDefaultValueLiteral();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_defaultValueLiteral, null);
          if (_operator_notEquals_1) {
            _builder.append("\t\t");
            String _name_12 = a.getName();
            _builder.append(_name_12, "		");
            _builder.append(" = ");
            String _defaultValueLiteral_1 = a.getDefaultValueLiteral();
            _builder.append(_defaultValueLiteral_1, "		");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            Type _type = a.getType();
            DataClass _type_1 = _type.getType();
            boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_type_1, null);
            if (_operator_notEquals_2) {
              _builder.append("\t\t");
              String _name_13 = a.getName();
              _builder.append(_name_13, "		");
              _builder.append(" = new ");
              Type _type_2 = a.getType();
              DataClass _type_3 = _type_2.getType();
              String _name_14 = _type_3.getName();
              _builder.append(_name_14, "		");
              _builder.append("();");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// own ports");
    _builder.newLine();
    {
      List<Port> _endPorts_2 = this.languageExt.getEndPorts(ac);
      for(final Port ep_2 : _endPorts_2) {
        _builder.append("\t\t");
        String _name_15 = ep_2.getName();
        _builder.append(_name_15, "		");
        _builder.append(" = new ");
        String _portClassName_3 = this.languageExt.getPortClassName(ep_2);
        _builder.append(_portClassName_3, "		");
        _builder.append("(this, \"");
        String _name_16 = ep_2.getName();
        _builder.append(_name_16, "		");
        _builder.append("\", IFITEM_");
        String _name_17 = ep_2.getName();
        _builder.append(_name_17, "		");
        _builder.append(", ");
        {
          int _multiplicity = ep_2.getMultiplicity();
          boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_multiplicity), ((Integer)1));
          if (_operator_equals_1) {
            _builder.append("0, ");
          }
        }
        _builder.append("port_addr[IFITEM_");
        String _name_18 = ep_2.getName();
        _builder.append(_name_18, "		");
        _builder.append("]");
        {
          int _multiplicity_1 = ep_2.getMultiplicity();
          boolean _operator_equals_2 = ObjectExtensions.operator_equals(((Integer)_multiplicity_1), ((Integer)1));
          if (_operator_equals_2) {
            _builder.append("[0]");
          }
        }
        _builder.append(", peer_addr[IFITEM_");
        String _name_19 = ep_2.getName();
        _builder.append(_name_19, "		");
        _builder.append("]");
        {
          int _multiplicity_2 = ep_2.getMultiplicity();
          boolean _operator_equals_3 = ObjectExtensions.operator_equals(((Integer)_multiplicity_2), ((Integer)1));
          if (_operator_equals_3) {
            _builder.append("[0]");
          }
        }
        _builder.append("); ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("// own saps");
    _builder.newLine();
    {
      EList<SAPRef> _strSAPs_2 = ac.getStrSAPs();
      for(final SAPRef sap_2 : _strSAPs_2) {
        _builder.append("\t\t");
        String _name_20 = sap_2.getName();
        _builder.append(_name_20, "		");
        _builder.append(" = new ");
        String _portClassName_4 = this.languageExt.getPortClassName(sap_2);
        _builder.append(_portClassName_4, "		");
        _builder.append("(this, \"");
        String _name_21 = sap_2.getName();
        _builder.append(_name_21, "		");
        _builder.append("\", IFITEM_");
        String _name_22 = sap_2.getName();
        _builder.append(_name_22, "		");
        _builder.append(", 0, port_addr[IFITEM_");
        String _name_23 = sap_2.getName();
        _builder.append(_name_23, "		");
        _builder.append("][0], peer_addr[IFITEM_");
        String _name_24 = sap_2.getName();
        _builder.append(_name_24, "		");
        _builder.append("][0]); ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("// own service implementations");
    _builder.newLine();
    {
      EList<ServiceImplementation> _serviceImplementations_2 = ac.getServiceImplementations();
      for(final ServiceImplementation svc_2 : _serviceImplementations_2) {
        _builder.append("\t\t");
        SPPRef _spp_3 = svc_2.getSpp();
        String _name_25 = _spp_3.getName();
        _builder.append(_name_25, "		");
        _builder.append(" = new ");
        String _portClassName_5 = this.languageExt.getPortClassName(svc_2);
        _builder.append(_portClassName_5, "		");
        _builder.append("(this, \"");
        SPPRef _spp_4 = svc_2.getSpp();
        String _name_26 = _spp_4.getName();
        _builder.append(_name_26, "		");
        _builder.append("\", IFITEM_");
        SPPRef _spp_5 = svc_2.getSpp();
        String _name_27 = _spp_5.getName();
        _builder.append(_name_27, "		");
        _builder.append(", port_addr[IFITEM_");
        SPPRef _spp_6 = svc_2.getSpp();
        String _name_28 = _spp_6.getName();
        _builder.append(_name_28, "		");
        _builder.append("], peer_addr[IFITEM_");
        SPPRef _spp_7 = svc_2.getSpp();
        String _name_29 = _spp_7.getName();
        _builder.append(_name_29, "		");
        _builder.append("]); ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//--------------------- lifecycle functions");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void init(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("initUser();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void start(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("startUser();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      boolean _overridesStop = this.languageExt.overridesStop(ac);
      boolean _operator_not = BooleanExtensions.operator_not(_overridesStop);
      if (_operator_not) {
        _builder.append("\t");
        _builder.append("public void stop(){");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("stopUser();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void destroy(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("destroyUser();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.newLine();
    {
      StateMachine _stateMachine = ac.getStateMachine();
      boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_stateMachine, null);
      if (_operator_notEquals_3) {
        _builder.append("\t");
        StringConcatenation _genStateMachine = this.stateMachineGen.genStateMachine(xpac, ac);
        _builder.append(_genStateMachine, "	");
        _builder.newLineIfNotEmpty();
      } else {
        boolean _hasStateMachine = xpac.hasStateMachine();
        boolean _operator_not_1 = BooleanExtensions.operator_not(_hasStateMachine);
        if (_operator_not_1) {
          _builder.append("\t");
          _builder.append("//--------------------- no state machine");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("handleSystemEvent(ifitem, evt, data);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void executeInitTransition(){");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
    }
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation msgArgs(final Message msg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      TypedID _data = msg.getData();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_data, null);
      if (_operator_notEquals) {
        TypedID _data_1 = msg.getData();
        String _defaultValue = this.stdExt.defaultValue(_data_1);
        _builder.append(_defaultValue, "");
      }
    }
    return _builder;
  }
}
