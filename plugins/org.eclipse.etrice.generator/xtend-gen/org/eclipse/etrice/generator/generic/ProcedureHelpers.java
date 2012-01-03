package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ProcedureHelpers {
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  public StringConcatenation UserCode(final DetailCode dc) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(dc, null);
      if (_operator_notEquals) {
        _builder.append("//--------------------- begin user code");
        _builder.newLine();
        {
          EList<String> _commands = dc.getCommands();
          for(final String command : _commands) {
            _builder.append("\t");
            _builder.append(command, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("//--------------------- end user code");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public StringConcatenation Attributes(final List<Attribute> attribs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attributes");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        {
          int _size = attribute.getSize();
          boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)0));
          if (_operator_equals) {
            String _accessLevelProtected = this.languageExt.accessLevelProtected();
            _builder.append(_accessLevelProtected, "");
            DataType _type = attribute.getType();
            String _name = _type.getName();
            _builder.append(_name, "");
            _builder.append(" ");
            String _name_1 = attribute.getName();
            _builder.append(_name_1, "");
            {
              String _defaultValueLiteral = attribute.getDefaultValueLiteral();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(_defaultValueLiteral, null);
              if (_operator_equals_1) {
                _builder.append(" = ");
                DataType _type_1 = attribute.getType();
                String _defaultValue = this._typeHelpers.defaultValue(_type_1);
                _builder.append(_defaultValue, "");
              } else {
                _builder.append(" = ");
                String _defaultValueLiteral_1 = attribute.getDefaultValueLiteral();
                _builder.append(_defaultValueLiteral_1, "");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            String _accessLevelProtected_1 = this.languageExt.accessLevelProtected();
            _builder.append(_accessLevelProtected_1, "");
            DataType _type_2 = attribute.getType();
            String _name_2 = _type_2.getName();
            _builder.append(_name_2, "");
            _builder.append("[] ");
            String _name_3 = attribute.getName();
            _builder.append(_name_3, "");
            {
              String _defaultValueLiteral_2 = attribute.getDefaultValueLiteral();
              boolean _operator_equals_2 = ObjectExtensions.operator_equals(_defaultValueLiteral_2, null);
              if (_operator_equals_2) {
                _builder.append(" = ");
                DataType _type_3 = attribute.getType();
                String _defaultValue_1 = this._typeHelpers.defaultValue(_type_3);
                _builder.append(_defaultValue_1, "");
                _builder.append("[");
                int _size_1 = attribute.getSize();
                _builder.append(_size_1, "");
                _builder.append("];");
              } else {
                _builder.append(" = ");
                String _defaultValueLiteral_3 = attribute.getDefaultValueLiteral();
                _builder.append(_defaultValueLiteral_3, "");
                _builder.append(";");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public StringConcatenation attributeInitialization(final List<Attribute> attribs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      for(final Attribute a : attribs) {
        {
          String _defaultValueLiteral = a.getDefaultValueLiteral();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_defaultValueLiteral, null);
          if (_operator_notEquals) {
            {
              int _size = a.getSize();
              boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)0));
              if (_operator_equals) {
                String _name = a.getName();
                _builder.append(_name, "");
                _builder.append(" = ");
                String _defaultValueLiteral_1 = a.getDefaultValueLiteral();
                _builder.append(_defaultValueLiteral_1, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("for (int i=0;i<");
                int _size_1 = a.getSize();
                _builder.append(_size_1, "");
                _builder.append(";i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _name_1 = a.getName();
                _builder.append(_name_1, "	");
                _builder.append("[i] = ");
                String _defaultValueLiteral_2 = a.getDefaultValueLiteral();
                _builder.append(_defaultValueLiteral_2, "	");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            }
          } else {
            {
              int _size_2 = a.getSize();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_size_2), ((Integer)0));
              if (_operator_equals_1) {
                String _name_2 = a.getName();
                _builder.append(_name_2, "");
                _builder.append(" = ");
                DataType _type = a.getType();
                String _defaultValue = this._typeHelpers.defaultValue(_type);
                _builder.append(_defaultValue, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("for (int i=0;i<");
                int _size_3 = a.getSize();
                _builder.append(_size_3, "");
                _builder.append(";i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _name_3 = a.getName();
                _builder.append(_name_3, "	");
                _builder.append("[i] = ");
                DataType _type_1 = a.getType();
                String _defaultValue_1 = this._typeHelpers.defaultValue(_type_1);
                _builder.append(_defaultValue_1, "	");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public StringConcatenation AttributeSettersGettersDeclaration(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attribute setters and getters");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        StringConcatenation _SetterHeader = this.SetterHeader(attribute, classname);
        _builder.append(_SetterHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        StringConcatenation _GetterHeader = this.GetterHeader(attribute, classname);
        _builder.append(_GetterHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation AttributeSettersGettersImplementation(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attribute setters and getters");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        StringConcatenation _SetterHeader = this.SetterHeader(attribute, classname);
        _builder.append(_SetterHeader, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        String _memberAccess = this.languageExt.memberAccess();
        _builder.append(_memberAccess, "	 ");
        String _name = attribute.getName();
        _builder.append(_name, "	 ");
        _builder.append(" = ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "	 ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        StringConcatenation _GetterHeader = this.GetterHeader(attribute, classname);
        _builder.append(_GetterHeader, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return ");
        String _memberAccess_1 = this.languageExt.memberAccess();
        _builder.append(_memberAccess_1, "	");
        String _name_2 = attribute.getName();
        _builder.append(_name_2, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private StringConcatenation SetterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append("void set");
    String _name = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, 1);
    _builder.append(_selfPointer, "");
    DataType _type = attribute.getType();
    String _name_1 = _type.getName();
    _builder.append(_name_1, "");
    {
      int _size = attribute.getSize();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)0));
      if (_operator_notEquals) {
        _builder.append("[]");
      }
    }
    _builder.append(" ");
    String _name_2 = attribute.getName();
    _builder.append(_name_2, "");
    _builder.append(")");
    return _builder;
  }
  
  private StringConcatenation GetterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    DataType _type = attribute.getType();
    String _name = _type.getName();
    _builder.append(_name, "");
    {
      int _size = attribute.getSize();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)0));
      if (_operator_notEquals) {
        _builder.append("[]");
      }
    }
    _builder.append(" get");
    String _name_1 = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, 0);
    _builder.append(_selfPointer, "");
    _builder.append(")");
    return _builder;
  }
  
  public StringConcatenation OperationsDeclaration(final List<Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- operations");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        StringConcatenation _OperationHeader = this.OperationHeader(operation, classname, true);
        _builder.append(_OperationHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation OperationsImplementation(final List<Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- operations");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        StringConcatenation _OperationHeader = this.OperationHeader(operation, classname, false);
        _builder.append(_OperationHeader, "");
        _builder.append("{");
        _builder.newLineIfNotEmpty();
        {
          DetailCode _detailCode = operation.getDetailCode();
          EList<String> _commands = _detailCode.getCommands();
          for(final String command : _commands) {
            _builder.append("\t");
            _builder.append(command, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private StringConcatenation OperationHeader(final Operation operation, final String classname, final boolean isDeclaration) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    {
      DataType _returntype = operation.getReturntype();
      boolean _operator_equals = ObjectExtensions.operator_equals(_returntype, null);
      if (_operator_equals) {
        _builder.append("void");
      } else {
        DataType _returntype_1 = operation.getReturntype();
        String _name = _returntype_1.getName();
        _builder.append(_name, "");
      }
    }
    _builder.append(" ");
    String _operationScope = this.languageExt.operationScope(classname, isDeclaration);
    _builder.append(_operationScope, "");
    String _name_1 = operation.getName();
    _builder.append(_name_1, "");
    _builder.append(" (");
    EList<VarDecl> _arguments = operation.getArguments();
    int _size = _arguments.size();
    String _selfPointer = this.languageExt.selfPointer(classname, _size);
    _builder.append(_selfPointer, "");
    {
      EList<VarDecl> _arguments_1 = operation.getArguments();
      boolean hasAnyElements = false;
      for(final VarDecl argument : _arguments_1) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        DataType _type = argument.getType();
        String _name_2 = _type.getName();
        _builder.append(_name_2, "");
        _builder.append(" ");
        String _name_3 = argument.getName();
        _builder.append(_name_3, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
}
