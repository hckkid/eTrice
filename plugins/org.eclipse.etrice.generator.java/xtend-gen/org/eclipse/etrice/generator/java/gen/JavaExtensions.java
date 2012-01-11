package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.TransitionChain;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.LanguageGenerator;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Singleton
public class JavaExtensions implements ILanguageExtension {
  @Inject
  private LanguageGenerator languageGen;
  
  public String getTypedDataDefinition(final Message m) {
    String _typedData = this.languageGen.getTypedData(m);
    return _typedData;
  }
  
  public String getJavaFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, ".java");
    return _operator_plus;
  }
  
  public String accessLevelPrivate() {
    return "private ";
  }
  
  public String accessLevelProtected() {
    return "protected ";
  }
  
  public String accessLevelPublic() {
    return "public ";
  }
  
  public String memberAccess() {
    return "this.";
  }
  
  public String selfPointer(final String classname, final int argumentCount) {
    return "";
  }
  
  public String operationScope(final String classname, final boolean isDeclaration) {
    return "";
  }
  
  public String outMessageId(final String classname, final String messagename) {
    String _operator_plus = StringExtensions.operator_plus("OUT_", messagename);
    return _operator_plus;
  }
  
  public String inMessageId(final String classname, final String messagename) {
    String _operator_plus = StringExtensions.operator_plus("IN_", messagename);
    return _operator_plus;
  }
  
  public String getExecuteChainCode(final ExpandedActorClass ac, final TransitionChain tc) {
    String _executeChain = this.languageGen.getExecuteChain(ac, tc);
    return _executeChain;
  }
}
