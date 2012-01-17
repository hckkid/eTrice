package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.TransitionChain;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.LanguageGenerator;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Singleton
public class CExtensions implements ILanguageExtension {
  @Inject
  private LanguageGenerator languageGen;
  
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
  
  public String outMessageId(final String classname, final String messagename) {
    String _operator_plus = StringExtensions.operator_plus("OUT_", classname);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "_");
    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, messagename);
    return _operator_plus_2;
  }
  
  public String inMessageId(final String classname, final String messagename) {
    String _operator_plus = StringExtensions.operator_plus("IN_", classname);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "_");
    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, messagename);
    return _operator_plus_2;
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