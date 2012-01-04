package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.LanguageGenerator;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Singleton
public class TypeHelpers {
  @Inject
  private LanguageGenerator languageGen;
  
  public String defaultValue(final DataType dt) {
    if ((dt instanceof PrimitiveType)) {
      String _defaultValueLiteral = ((PrimitiveType) dt).getDefaultValueLiteral();
      return _defaultValueLiteral;
    } else {
      String _name = dt.getName();
      String _operator_plus = StringExtensions.operator_plus("new ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "()");
      return _operator_plus_1;
    }
  }
  
  public String defaultValue(final VarDecl a) {
    DataType _type = a.getType();
    String _defaultValue = this.defaultValue(_type);
    return _defaultValue;
  }
  
  public String getTypedDataDefinition(final Message m) {
    String _typedData = this.languageGen.getTypedData(m);
    return _typedData;
  }
}
