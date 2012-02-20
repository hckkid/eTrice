package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Annotation;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.c.gen.StateMachineGen;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private CExtensions stdExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  @Inject
  private StateMachineGen stateMachineGen;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    for (final ExpandedActorClass xpac : _xpActorClasses) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(_actorClass);
        ActorClass _actorClass_1 = xpac.getActorClass();
        String _path = this.roomExt.getPath(_actorClass_1);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _cHeaderFileName = this.stdExt.getCHeaderFileName(_actorClass_2);
        String _operator_plus_1 = StringExtensions.operator_plus("generating ActorClass header \'", _cHeaderFileName);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        ActorClass _actorClass_3 = xpac.getActorClass();
        String _cHeaderFileName_1 = this.stdExt.getCHeaderFileName(_actorClass_3);
        ActorClass _actorClass_4 = xpac.getActorClass();
        StringConcatenation _generateHeaderFile = this.generateHeaderFile(root, xpac, _actorClass_4);
        this.fileAccess.generateFile(_cHeaderFileName_1, _generateHeaderFile);
        boolean _hasBehaviorAnnotation = this.hasBehaviorAnnotation(xpac, "BehaviorManual");
        if (_hasBehaviorAnnotation) {
          ActorClass _actorClass_5 = xpac.getActorClass();
          String _name = _actorClass_5.getName();
          String _operator_plus_5 = StringExtensions.operator_plus("omitting ActorClass source for \'", _name);
          String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, "\' since @BehaviorManual is specified");
          this.logger.logInfo(_operator_plus_6);
        } else {
          {
            ActorClass _actorClass_6 = xpac.getActorClass();
            String _cSourceFileName = this.stdExt.getCSourceFileName(_actorClass_6);
            String _operator_plus_7 = StringExtensions.operator_plus("generating ActorClass source \'", _cSourceFileName);
            String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, "\' in \'");
            String _operator_plus_9 = StringExtensions.operator_plus(_operator_plus_8, path);
            String _operator_plus_10 = StringExtensions.operator_plus(_operator_plus_9, "\'");
            this.logger.logInfo(_operator_plus_10);
            this.fileAccess.setOutputPath(path);
            ActorClass _actorClass_7 = xpac.getActorClass();
            String _cSourceFileName_1 = this.stdExt.getCSourceFileName(_actorClass_7);
            ActorClass _actorClass_8 = xpac.getActorClass();
            StringConcatenation _generateSourceFile = this.generateSourceFile(root, xpac, _actorClass_8);
            this.fileAccess.generateFile(_cSourceFileName_1, _generateSourceFile);
          }
        }
      }
    }
  }
  
  public boolean hasBehaviorAnnotation(final ExpandedActorClass xpac, final String annotation) {
      ActorClass _actorClass = xpac.getActorClass();
      EList<Annotation> _annotations = _actorClass.getAnnotations();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_annotations, null);
      if (_operator_notEquals) {
        ActorClass _actorClass_1 = xpac.getActorClass();
        EList<Annotation> _annotations_1 = _actorClass_1.getAnnotations();
        final Function1<Annotation,Boolean> _function = new Function1<Annotation,Boolean>() {
            public Boolean apply(final Annotation e) {
              String _name = e.getName();
              boolean _operator_equals = ObjectExtensions.operator_equals(_name, annotation);
              return ((Boolean)_operator_equals);
            }
          };
        Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_annotations_1, _function);
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_findFirst, null);
        if (_operator_notEquals_1) {
          return true;
        }
      }
      return false;
  }
  
  public StringConcatenation generateHeaderFile(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @author generated by eTrice");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Header File of ActorClass ");
    String _name = xpac.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    String _name_1 = xpac.getName();
    StringConcatenation _generateIncludeGuardBegin = this.stdExt.generateIncludeGuardBegin(_name_1);
    _builder.append(_generateIncludeGuardBegin, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"etDatatypes.h\"");
    _builder.newLine();
    _builder.append("#include \"etMessage.h\"");
    _builder.newLine();
    _builder.newLine();
    {
      HashSet<DataClass> _referencedDataClasses = root.getReferencedDataClasses(ac);
      for(final DataClass dataClass : _referencedDataClasses) {
        _builder.append("#include \"");
        String _name_2 = dataClass.getName();
        _builder.append(_name_2, "");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
      for(final ProtocolClass pc : _referencedProtocolClasses) {
        _builder.append("#include \"");
        String _name_3 = pc.getName();
        _builder.append(_name_3, "");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    DetailCode _userCode1 = ac.getUserCode1();
    StringConcatenation _userCode = this.helpers.userCode(_userCode1);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("typedef struct ");
    String _name_4 = xpac.getName();
    _builder.append(_name_4, "");
    _builder.append(" ");
    String _name_5 = xpac.getName();
    _builder.append(_name_5, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* const part of ActorClass (ROM) */");
    _builder.newLine();
    _builder.append("typedef struct ");
    String _name_6 = xpac.getName();
    _builder.append(_name_6, "");
    _builder.append("_const {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("const ");
    String _name_7 = xpac.getName();
    _builder.append(_name_7, "	");
    _builder.append("* actor;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("/* Ports */");
    _builder.newLine();
    {
      List<Port> _endPorts = this.roomExt.getEndPorts(ac);
      for(final Port ep : _endPorts) {
        _builder.append("\t");
        _builder.append("const ");
        String _portClassName = this.roomExt.getPortClassName(ep);
        _builder.append(_portClassName, "	");
        _builder.append(" ");
        String _name_8 = ep.getName();
        _builder.append(_name_8, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("} ");
    String _name_9 = xpac.getName();
    _builder.append(_name_9, "");
    _builder.append("_const;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* variable part of ActorClass (RAM) */");
    _builder.newLine();
    _builder.append("struct ");
    String _name_10 = xpac.getName();
    _builder.append(_name_10, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("const ");
    String _name_11 = xpac.getName();
    _builder.append(_name_11, "	");
    _builder.append("_const* constData;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    List<Attribute> _allAttributes = this.roomExt.getAllAttributes(ac);
    StringConcatenation _attributes = this.helpers.attributes(_allAttributes);
    _builder.append(_attributes, "	");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasNonEmptyStateMachine = this.roomExt.hasNonEmptyStateMachine(xpac);
      if (_hasNonEmptyStateMachine) {
        _builder.append("\t");
        StringConcatenation _genDataMembers = this.stateMachineGen.genDataMembers(xpac, ac);
        _builder.append(_genDataMembers, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_12 = xpac.getName();
    _builder.append(_name_12, "");
    _builder.append("_init(");
    String _name_13 = xpac.getName();
    _builder.append(_name_13, "");
    _builder.append("* self);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("void ");
    String _name_14 = xpac.getName();
    _builder.append(_name_14, "");
    _builder.append("_ReceiveMessage(void* self, void* ifitem, const etMessage* msg);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    DetailCode _userCode2 = ac.getUserCode2();
    StringConcatenation _userCode_1 = this.helpers.userCode(_userCode2);
    _builder.append(_userCode_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _name_15 = xpac.getName();
    StringConcatenation _generateIncludeGuardEnd = this.stdExt.generateIncludeGuardEnd(_name_15);
    _builder.append(_generateIncludeGuardEnd, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateSourceFile(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @author generated by eTrice");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Source File of ActorClass ");
    String _name = xpac.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#include \"");
    String _cHeaderFileName = this.stdExt.getCHeaderFileName(xpac);
    _builder.append(_cHeaderFileName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"etActor.h\"");
    _builder.newLine();
    _builder.append("#include \"etLogger.h\"");
    _builder.newLine();
    _builder.append("#include \"etMSCLogger.h\"");
    _builder.newLine();
    _builder.newLine();
    {
      EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
      for(final ProtocolClass pc : _referencedProtocolClasses) {
        _builder.append("#include \"");
        String _cHeaderFileName_1 = this.stdExt.getCHeaderFileName(pc);
        _builder.append(_cHeaderFileName_1, "");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    DetailCode _userCode3 = xpac.getUserCode3();
    StringConcatenation _userCode = this.helpers.userCode(_userCode3);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* interface item IDs */");
    _builder.newLine();
    String _genInterfaceItemConstants = this.genInterfaceItemConstants(xpac, ac);
    _builder.append(_genInterfaceItemConstants, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _hasNonEmptyStateMachine = this.roomExt.hasNonEmptyStateMachine(xpac);
      if (_hasNonEmptyStateMachine) {
        StringConcatenation _genStateMachine = this.stateMachineGen.genStateMachine(xpac, ac);
        _builder.append(_genStateMachine, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("void ");
    String _name_1 = xpac.getName();
    _builder.append(_name_1, "");
    _builder.append("_init(");
    String _name_2 = xpac.getName();
    _builder.append(_name_2, "");
    _builder.append("* self){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
    String _name_3 = xpac.getName();
    _builder.append(_name_3, "	");
    _builder.append("\", \"init\")");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasNonEmptyStateMachine_1 = this.roomExt.hasNonEmptyStateMachine(xpac);
      if (_hasNonEmptyStateMachine_1) {
        _builder.append("\t");
        StringConcatenation _genInitialization = this.stateMachineGen.genInitialization(xpac, ac);
        _builder.append(_genInitialization, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_4 = xpac.getName();
    _builder.append(_name_4, "");
    _builder.append("_ReceiveMessage(void* self, void* ifitem, const etMessage* msg){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
    String _name_5 = xpac.getName();
    _builder.append(_name_5, "	");
    _builder.append("\", \"ReceiveMessage\")");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasNonEmptyStateMachine_2 = this.roomExt.hasNonEmptyStateMachine(xpac);
      if (_hasNonEmptyStateMachine_2) {
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(&msg[1]));");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
}
