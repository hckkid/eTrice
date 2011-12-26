package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class DataClassGen {
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
    EList<DataClass> _usedDataClasses = root.getUsedDataClasses();
    for (final DataClass dc : _usedDataClasses) {
      {
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(dc);
        String _path = this.roomExt.getPath(dc);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        String _cHeaderFileName = this.stdExt.getCHeaderFileName(dc);
        String headerFile = _cHeaderFileName;
        String _operator_plus_1 = StringExtensions.operator_plus("generating DataClass header \'", headerFile);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        StringConcatenation _generateHeaderFile = this.generateHeaderFile(root, dc);
        this.fileAccess.generateFile(headerFile, _generateHeaderFile);
        String _cSourceFileName = this.stdExt.getCSourceFileName(dc);
        String sourceFile = _cSourceFileName;
        String _operator_plus_5 = StringExtensions.operator_plus("generating DataClass source \'", headerFile);
        String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, "\' in \'");
        String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, path);
        String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, "\'");
        this.logger.logInfo(_operator_plus_8);
        this.fileAccess.setOutputPath(path);
        StringConcatenation _generateSourceFile = this.generateSourceFile(root, dc);
        this.fileAccess.generateFile(sourceFile, _generateSourceFile);
      }
    }
  }
  
  public StringConcatenation generateHeaderFile(final Root root, final DataClass dc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef _");
    String _name = dc.getName();
    _builder.append(_name, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define _");
    String _name_1 = dc.getName();
    _builder.append(_name_1, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"../../src/datatypes.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/* TODO: includes only for used DataClasses, also for other models */");
    _builder.newLine();
    {
      HashSet<DataClass> _referencedDataClasses = root.getReferencedDataClasses(dc);
      for(final DataClass dataClass : _referencedDataClasses) {
        {
          String _name_2 = dataClass.getName();
          String _name_3 = dc.getName();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name_2, _name_3);
          if (_operator_notEquals) {
            _builder.append("#include \"");
            String _name_4 = dataClass.getName();
            _builder.append(_name_4, "");
            _builder.append(".h\"");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    DetailCode _userCode1 = dc.getUserCode1();
    StringConcatenation _UserCode = this.helpers.UserCode(_userCode1);
    _builder.append(_UserCode, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("typedef struct {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    DetailCode _userCode2 = dc.getUserCode2();
    StringConcatenation _UserCode_1 = this.helpers.UserCode(_userCode2);
    _builder.append(_UserCode_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    EList<Attribute> _attributes = dc.getAttributes();
    StringConcatenation _Attributes = this.helpers.Attributes(_attributes);
    _builder.append(_Attributes, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("} ");
    String _name_5 = dc.getName();
    _builder.append(_name_5, "");
    {
      DataClass _base = dc.getBase();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_base, null);
      if (_operator_notEquals_1) {
        _builder.append(" /* extends -> inheritance not implemented yet */ ");
        DataClass _base_1 = dc.getBase();
        String _name_6 = _base_1.getName();
        _builder.append(_name_6, "");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// TODO: do we need setters and getters for C and C++ ?");
    _builder.newLine();
    _builder.newLine();
    EList<Operation> _operations = dc.getOperations();
    String _name_7 = dc.getName();
    StringConcatenation _OperationsDeclaration = this.helpers.OperationsDeclaration(_operations, _name_7);
    _builder.append(_OperationsDeclaration, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// deep copy");
    _builder.newLine();
    _builder.append("void ");
    String _name_8 = dc.getName();
    _builder.append(_name_8, "");
    _builder.append("_deepCopy(");
    String _name_9 = dc.getName();
    _builder.append(_name_9, "");
    _builder.append("* source, ");
    String _name_10 = dc.getName();
    _builder.append(_name_10, "");
    _builder.append("* target);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#endif /* _");
    String _name_11 = dc.getName();
    _builder.append(_name_11, "");
    _builder.append("_H_ */");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateSourceFile(final Root root, final DataClass dc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include \"");
    String _cHeaderFileName = this.stdExt.getCHeaderFileName(dc);
    _builder.append(_cHeaderFileName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include <string.h>");
    _builder.newLine();
    _builder.newLine();
    DetailCode _userCode3 = dc.getUserCode3();
    StringConcatenation _UserCode = this.helpers.UserCode(_userCode3);
    _builder.append(_UserCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// TODO: do we need setters and getters for C and C++ ?");
    _builder.newLine();
    _builder.newLine();
    EList<Operation> _operations = dc.getOperations();
    String _name = dc.getName();
    StringConcatenation _OperationsImplementation = this.helpers.OperationsImplementation(_operations, _name);
    _builder.append(_OperationsImplementation, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// deep copy");
    _builder.newLine();
    _builder.append("void ");
    String _name_1 = dc.getName();
    _builder.append(_name_1, "");
    _builder.append("_deepCopy(");
    String _name_2 = dc.getName();
    _builder.append(_name_2, "");
    _builder.append("* source, ");
    String _name_3 = dc.getName();
    _builder.append(_name_3, "");
    _builder.append("* target) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("memcpy(target, source, sizeof(");
    String _name_4 = dc.getName();
    _builder.append(_name_4, "	");
    _builder.append("));");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
}
