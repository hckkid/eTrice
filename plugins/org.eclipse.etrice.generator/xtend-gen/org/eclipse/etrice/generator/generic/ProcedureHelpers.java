package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.FreeType;
import org.eclipse.etrice.core.room.FreeTypedID;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ProcedureHelpers {
  @Inject
  private ILanguageExtension languageExt;
  
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
            _builder.append("protected ");
            {
              Type _type = attribute.getType();
              String _ext = _type.getExt();
              boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_ext, null);
              if (_operator_notEquals) {
                Type _type_1 = attribute.getType();
                String _ext_1 = _type_1.getExt();
                _builder.append(_ext_1, "");
              } else {
                Type _type_2 = attribute.getType();
                String _typeName = this.languageExt.typeName(_type_2);
                _builder.append(_typeName, "");
              }
            }
            _builder.append(" ");
            String _name = attribute.getName();
            _builder.append(_name, "");
            _builder.append(";");
          } else {
            _builder.append("protected ");
            Type _type_3 = attribute.getType();
            String _typeName_1 = this.languageExt.typeName(_type_3);
            _builder.append(_typeName_1, "");
            _builder.append("[] ");
            String _name_1 = attribute.getName();
            _builder.append(_name_1, "");
            {
              String _defaultValueLiteral = attribute.getDefaultValueLiteral();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(_defaultValueLiteral, null);
              if (_operator_equals_1) {
                _builder.append(" =new ");
                Type _type_4 = attribute.getType();
                String _typeName_2 = this.languageExt.typeName(_type_4);
                _builder.append(_typeName_2, "");
                _builder.append("[");
                int _size_1 = attribute.getSize();
                _builder.append(_size_1, "");
                _builder.append("];");
              } else {
                _builder.append(" = ");
                String _defaultValueLiteral_1 = attribute.getDefaultValueLiteral();
                _builder.append(_defaultValueLiteral_1, "");
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
  
  public StringConcatenation AttributeSettersGetters(final List<Attribute> attribs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attribute setters and getters");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        _builder.append("public void set");
        String _name = attribute.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name);
        _builder.append(_firstUpper, "");
        _builder.append(" (");
        {
          Type _type = attribute.getType();
          String _ext = _type.getExt();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_ext, null);
          if (_operator_notEquals) {
            _builder.append(" ");
            Type _type_1 = attribute.getType();
            String _ext_1 = _type_1.getExt();
            _builder.append(_ext_1, "");
          } else {
            Type _type_2 = attribute.getType();
            String _typeName = this.languageExt.typeName(_type_2);
            _builder.append(_typeName, "");
          }
        }
        {
          int _size = attribute.getSize();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)0));
          if (_operator_notEquals_1) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("this.");
        String _name_2 = attribute.getName();
        _builder.append(_name_2, "	 ");
        _builder.append(" = ");
        String _name_3 = attribute.getName();
        _builder.append(_name_3, "	 ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.append("public ");
        {
          Type _type_3 = attribute.getType();
          String _ext_2 = _type_3.getExt();
          boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_ext_2, null);
          if (_operator_notEquals_2) {
            _builder.append(" ");
            Type _type_4 = attribute.getType();
            String _ext_3 = _type_4.getExt();
            _builder.append(_ext_3, "");
          } else {
            Type _type_5 = attribute.getType();
            String _typeName_1 = this.languageExt.typeName(_type_5);
            _builder.append(_typeName_1, "");
          }
        }
        {
          int _size_1 = attribute.getSize();
          boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(((Integer)_size_1), ((Integer)0));
          if (_operator_notEquals_3) {
            _builder.append("[]");
          }
        }
        _builder.append(" get");
        String _name_4 = attribute.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_4);
        _builder.append(_firstUpper_1, "");
        _builder.append(" () {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return ");
        String _name_5 = attribute.getName();
        _builder.append(_name_5, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation Operations(final List<Operation> operations) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- operations");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        _builder.append("public ");
        {
          FreeType _returntype = operation.getReturntype();
          boolean _operator_equals = ObjectExtensions.operator_equals(_returntype, null);
          if (_operator_equals) {
            _builder.append("void");
          } else {
            FreeType _returntype_1 = operation.getReturntype();
            String _freeTypeName = this.languageExt.freeTypeName(_returntype_1);
            _builder.append(_freeTypeName, "");
          }
        }
        _builder.append(" ");
        String _name = operation.getName();
        _builder.append(_name, "");
        _builder.append(" (");
        {
          EList<FreeTypedID> _arguments = operation.getArguments();
          boolean hasAnyElements = false;
          for(final FreeTypedID argument : _arguments) {
            if (!hasAnyElements) {
              hasAnyElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            FreeType _type = argument.getType();
            String _freeTypeName_1 = this.languageExt.freeTypeName(_type);
            _builder.append(_freeTypeName_1, "");
            _builder.append(" ");
            String _name_1 = argument.getName();
            _builder.append(_name_1, "");
          }
        }
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          DetailCode _detailCode = operation.getDetailCode();
          EList<String> _commands = _detailCode.getCommands();
          for(final String command : _commands) {
            _builder.append("\t");
            _builder.append(command, "	");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
