package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.Import;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.java.gen.ProcedureHelpers;
import org.eclipse.etrice.generator.java.gen.StdExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class DataClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private StdExtensions stdExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<DataClass> _usedDataClasses = root.getUsedDataClasses();
    for (final DataClass dc : _usedDataClasses) {
      {
        String _generationTargetPath = this.stdExt.getGenerationTargetPath(dc);
        String _path = this.stdExt.getPath(dc);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        String _fileName = this.stdExt.getFileName(dc);
        String file = _fileName;
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
    String _package = this.stdExt.getPackage(dc);
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
    {
      EList<Import> _imports = dc.getImports();
      int _size = _imports.size();
      boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
      if (_operator_greaterThan) {
        _builder.append("// user imports");
        _builder.newLine();
        {
          EList<Import> _imports_1 = dc.getImports();
          for(final Import imp : _imports_1) {
            _builder.append("import ");
            String _importedNamespace = imp.getImportedNamespace();
            _builder.append(_importedNamespace, "");
            _builder.append(".*;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
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
    EList<Attribute> _attributes = dc.getAttributes();
    StringConcatenation _Attributes = this.helpers.Attributes(_attributes);
    _builder.append(_Attributes, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    EList<Attribute> _attributes_1 = dc.getAttributes();
    StringConcatenation _AttributeSettersGetters = this.helpers.AttributeSettersGetters(_attributes_1);
    _builder.append(_AttributeSettersGetters, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    EList<Operation> _operations = dc.getOperations();
    StringConcatenation _Operations = this.helpers.Operations(_operations);
    _builder.append(_Operations, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// default constructor");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_3 = dc.getName();
    _builder.append(_name_3, "	");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_2 = dc.getAttributes();
      for(final Attribute a : _attributes_2) {
        {
          String _defaultValueLiteral = a.getDefaultValueLiteral();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_defaultValueLiteral, null);
          if (_operator_notEquals_1) {
            _builder.append("\t\t");
            {
              int _size_1 = a.getSize();
              boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size_1), ((Integer)0));
              if (_operator_equals) {
                String _name_4 = a.getName();
                _builder.append(_name_4, "		");
                _builder.append(" = ");
                String _defaultValueLiteral_1 = a.getDefaultValueLiteral();
                _builder.append(_defaultValueLiteral_1, "		");
                _builder.append(";");
              }
            }
            _builder.newLineIfNotEmpty();
          } else {
            Type _type = a.getType();
            DataClass _type_1 = _type.getType();
            boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_type_1, null);
            if (_operator_notEquals_2) {
              _builder.append("\t\t");
              String _name_5 = a.getName();
              _builder.append(_name_5, "		");
              _builder.append(" = new ");
              Type _type_2 = a.getType();
              DataClass _type_3 = _type_2.getType();
              String _name_6 = _type_3.getName();
              _builder.append(_name_6, "		");
              _builder.append("();");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
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
    String _name_7 = dc.getName();
    _builder.append(_name_7, "	");
    _builder.append(" deepCopy() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _name_8 = dc.getName();
    _builder.append(_name_8, "		");
    _builder.append(" copy = new ");
    String _name_9 = dc.getName();
    _builder.append(_name_9, "		");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_3 = dc.getAttributes();
      for(final Attribute a_1 : _attributes_3) {
        {
          Type _type_4 = a_1.getType();
          DataClass _type_5 = _type_4.getType();
          boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_type_5, null);
          if (_operator_notEquals_3) {
            _builder.append("\t\t");
            _builder.append("copy.");
            String _name_10 = a_1.getName();
            _builder.append(_name_10, "		");
            _builder.append(" = ");
            String _name_11 = a_1.getName();
            _builder.append(_name_11, "		");
            _builder.append(".deepCopy();");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t");
            {
              int _size_2 = a_1.getSize();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_size_2), ((Integer)0));
              if (_operator_equals_1) {
                _builder.append("copy.");
                String _name_12 = a_1.getName();
                _builder.append(_name_12, "		");
                _builder.append(" = ");
                String _name_13 = a_1.getName();
                _builder.append(_name_13, "		");
                _builder.append(";");
              } else {
                _builder.append("for (int i=0;i<");
                int _size_3 = a_1.getSize();
                _builder.append(_size_3, "		");
                _builder.append(";i++){copy.");
                String _name_14 = a_1.getName();
                _builder.append(_name_14, "		");
                _builder.append("[i]=");
                String _name_15 = a_1.getName();
                _builder.append(_name_15, "		");
                _builder.append("[i];}");
              }
            }
            _builder.newLineIfNotEmpty();
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
