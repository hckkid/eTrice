package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
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
  private JavaExtensions stdExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private TypeHelpers typeHelpers;
  
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
        String _javaFileName = this.stdExt.getJavaFileName(dc);
        String file = _javaFileName;
        String _operator_plus_1 = StringExtensions.operator_plus("generating DataClass implementation \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        StringConcatenation _generate = this.generate(root, dc);
        this.fileAccess.generateFile(file, _generate);
      }
    }
  }
  
  public StringConcatenation generate(final Root root, final DataClass dc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _package = this.roomExt.getPackage(dc);
    _builder.append(_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    EList<RoomModel> _referencedModels = root.getReferencedModels(dc);
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
    DetailCode _userCode1 = dc.getUserCode1();
    StringConcatenation _UserCode = this.helpers.UserCode(_userCode1);
    _builder.append(_UserCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = dc.getName();
    _builder.append(_name_1, "");
    {
      DataClass _base = dc.getBase();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_base, null);
      if (_operator_notEquals) {
        _builder.append(" extends ");
        DataClass _base_1 = dc.getBase();
        String _name_2 = _base_1.getName();
        _builder.append(_name_2, "");
      }
    }
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    DetailCode _userCode2 = dc.getUserCode2();
    StringConcatenation _UserCode_1 = this.helpers.UserCode(_userCode2);
    _builder.append(_UserCode_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    EList<Attribute> _attributes = dc.getAttributes();
    StringConcatenation _Attributes = this.helpers.Attributes(_attributes);
    _builder.append(_Attributes, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    EList<Attribute> _attributes_1 = dc.getAttributes();
    String _name_3 = dc.getName();
    StringConcatenation _AttributeSettersGettersImplementation = this.helpers.AttributeSettersGettersImplementation(_attributes_1, _name_3);
    _builder.append(_AttributeSettersGettersImplementation, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    EList<Operation> _operations = dc.getOperations();
    String _name_4 = dc.getName();
    StringConcatenation _OperationsImplementation = this.helpers.OperationsImplementation(_operations, _name_4);
    _builder.append(_OperationsImplementation, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// default constructor");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_5 = dc.getName();
    _builder.append(_name_5, "	");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    EList<Attribute> _attributes_2 = dc.getAttributes();
    StringConcatenation _attributeInitialization = this.helpers.attributeInitialization(_attributes_2);
    _builder.append(_attributeInitialization, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// deep copy");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_6 = dc.getName();
    _builder.append(_name_6, "	");
    _builder.append(" deepCopy() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _name_7 = dc.getName();
    _builder.append(_name_7, "		");
    _builder.append(" copy = new ");
    String _name_8 = dc.getName();
    _builder.append(_name_8, "		");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_3 = dc.getAttributes();
      for(final Attribute a : _attributes_3) {
        {
          DataType _type = a.getType();
          if ((_type instanceof ComplexType)) {
            {
              int _size = a.getSize();
              boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)0));
              if (_operator_equals) {
                _builder.append("\t\t");
                _builder.append("copy.");
                String _name_9 = a.getName();
                _builder.append(_name_9, "		");
                _builder.append(" = ");
                String _name_10 = a.getName();
                _builder.append(_name_10, "		");
                _builder.append(".deepCopy();");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                _builder.append("for (int i=0;i<");
                int _size_1 = a.getSize();
                _builder.append(_size_1, "		");
                _builder.append(";i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("copy.");
                String _name_11 = a.getName();
                _builder.append(_name_11, "			");
                _builder.append("[i] = ");
                String _name_12 = a.getName();
                _builder.append(_name_12, "			");
                _builder.append("[i].deepCopy();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          } else {
            {
              int _size_2 = a.getSize();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_size_2), ((Integer)0));
              if (_operator_equals_1) {
                _builder.append("\t\t");
                _builder.append("copy.");
                String _name_13 = a.getName();
                _builder.append(_name_13, "		");
                _builder.append(" = ");
                String _name_14 = a.getName();
                _builder.append(_name_14, "		");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                _builder.append("for (int i=0;i<");
                int _size_3 = a.getSize();
                _builder.append(_size_3, "		");
                _builder.append(";i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("copy.");
                String _name_15 = a.getName();
                _builder.append(_name_15, "			");
                _builder.append("[i] = ");
                String _name_16 = a.getName();
                _builder.append(_name_16, "			");
                _builder.append("[i];");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("return copy;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }
}
