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
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

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
  
  /**
   * TODO: unify OUT and in an add for loop (also for Java)
   */
  public String outMessageId(final String classname, final String messagename) {
    String _operator_plus = StringExtensions.operator_plus(classname, "_OUT_");
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, messagename);
    return _operator_plus_1;
  }
  
  public String inMessageId(final String classname, final String messagename) {
    String _operator_plus = StringExtensions.operator_plus(classname, "_IN_");
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, messagename);
    return _operator_plus_1;
  }
  
  /**
   * TODO: move specific code elsewhere
   */
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
  
  public String getInstSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, "_Inst.h");
    return _operator_plus;
  }
  
  public StringConcatenation getIncludeGuardString(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_");
    String _upperCase = filename.toUpperCase();
    _builder.append(_upperCase, "");
    _builder.append("_H_");
    return _builder;
  }
  
  public StringConcatenation generateIncludeGuardBegin(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef ");
    StringConcatenation _includeGuardString = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString, "");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    StringConcatenation _includeGuardString_1 = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation generateIncludeGuardEnd(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#endif /* ");
    StringConcatenation _includeGuardString = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString, "");
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String getExecuteChainCode(final ExpandedActorClass ac, final TransitionChain tc) {
    String _executeChain = this.languageGen.getExecuteChain(ac, tc);
    return _executeChain;
  }
}
