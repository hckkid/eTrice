package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.FreeType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.core.room.TypedID;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.TransitionChain;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.LanguageGenerator;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Singleton
public class CExtensions implements ILanguageExtension {
  @Inject
  private LanguageGenerator languageGen;
  
  public String toType(final PrimitiveType prim) {
    String _string = prim.toString();
    return _string;
  }
  
  public String typeName(final Type type) {
    String _xifexpression = null;
    DataClass _type = type.getType();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_type, null);
    if (_operator_notEquals) {
      DataClass _type_1 = type.getType();
      String _name = _type_1.getName();
      return _name;
    } else {
      PrimitiveType _prim = type.getPrim();
      String _type_2 = this.toType(_prim);
      _xifexpression = _type_2;
    }
    return _xifexpression;
  }
  
  public String freeTypeName(final FreeType type) {
    String _xifexpression = null;
    String _type = type.getType();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_type, null);
    if (_operator_notEquals) {
      String _type_1 = type.getType();
      return _type_1;
    } else {
      PrimitiveType _prim = type.getPrim();
      String _type_2 = this.toType(_prim);
      _xifexpression = _type_2;
    }
    return _xifexpression;
  }
  
  public String defaultValue(final PrimitiveType prim) {
    String _switchResult = null;
    String _string = prim.toString();
    final String __valOfSwitchOver = _string;
    boolean matched = false;
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"uint8")) {
        matched=true;
        _switchResult = "0";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"uint16")) {
        matched=true;
        _switchResult = "0";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"uint32")) {
        matched=true;
        _switchResult = "0";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"int8")) {
        matched=true;
        _switchResult = "0";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"int16")) {
        matched=true;
        _switchResult = "0";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"int32")) {
        matched=true;
        _switchResult = "0";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"float32")) {
        matched=true;
        _switchResult = "0.0";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"float64")) {
        matched=true;
        _switchResult = "0.0";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"string")) {
        matched=true;
        _switchResult = "\"\"";
      }
    }
    if (!matched) {
      String _string_1 = prim.toString();
      _switchResult = _string_1;
    }
    return _switchResult;
  }
  
  public String defaultValue(final TypedID a) {
    Type _type = a.getType();
    DataClass _type_1 = _type.getType();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_type_1, null);
    if (_operator_notEquals) {
      Type _type_2 = a.getType();
      DataClass _type_3 = _type_2.getType();
      String _name = _type_3.getName();
      String _operator_plus = StringExtensions.operator_plus("new ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "()");
      return _operator_plus_1;
    } else {
      Type _type_4 = a.getType();
      PrimitiveType _prim = _type_4.getPrim();
      String _defaultValue = this.defaultValue(_prim);
      return _defaultValue;
    }
  }
  
  public String getTypedDataDefinition(final Message m) {
    String _typedData = this.languageGen.getTypedData(m);
    return _typedData;
  }
  
  public String accessLevelPrivate() {
    return "";
  }
  
  public String accessLevelProtected() {
    return "";
  }
  
  public String accessLevelPublic() {
    return "";
  }
  
  public String memberAccess() {
    return "self->";
  }
  
  public String selfPointer(final String classname, final int argumentCount) {
    String _xifexpression = null;
    boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)argumentCount), ((Integer)0));
    if (_operator_greaterThan) {
      String _operator_plus = StringExtensions.operator_plus(classname, "* self, ");
      _xifexpression = _operator_plus;
    } else {
      String _operator_plus_1 = StringExtensions.operator_plus(classname, "* self");
      _xifexpression = _operator_plus_1;
    }
    return _xifexpression;
  }
  
  public String operationScope(final String classname, final boolean isDeclaration) {
    String _operator_plus = StringExtensions.operator_plus(classname, "_");
    return _operator_plus;
  }
  
  public String getCHeaderFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, ".h");
    return _operator_plus;
  }
  
  public String getCSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, ".c");
    return _operator_plus;
  }
  
  public String getExecuteChainCode(final ExpandedActorClass ac, final TransitionChain tc) {
    String _executeChain = this.languageGen.getExecuteChain(ac, tc);
    return _executeChain;
  }
}
