package org.eclipse.etrice.generator.doc.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Documentation;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.base.IRoomGenerator;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class DocGen implements IRoomGenerator {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<RoomModel> _models = root.getModels();
    for (final RoomModel model : _models) {
      {
        String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
        String path = _docGenerationTargetPath;
        String _name = model.getName();
        String _operator_plus = StringExtensions.operator_plus(_name, ".tex");
        String file = _operator_plus;
        String _operator_plus_1 = StringExtensions.operator_plus("generating LaTeX documentation: \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        StringConcatenation _generateModelDoc = this.generateModelDoc(root, model);
        this.fileAccess.generateFile(file, _generateModelDoc);
      }
    }
  }
  
  public StringConcatenation generateModelDoc(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\documentationclass[titlepage]{article}");
    _builder.newLine();
    String _name = model.getName();
    _builder.append(_name, "");
    _builder.newLineIfNotEmpty();
    StringConcatenation _generateAllActorClassDocs = this.generateAllActorClassDocs(root, model);
    _builder.append(_generateAllActorClassDocs, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\end{document}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateAllActorClassDocs(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ActorClass> _actorClasses = model.getActorClasses();
      for(final ActorClass ac : _actorClasses) {
        StringConcatenation _generateActorClassDoc = this.generateActorClassDoc(root, ac);
        _builder.append(_generateActorClassDoc, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation generateActorClassDoc(final Root root, final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\subsection{");
    String _name = ac.getName();
    _builder.append(_name, "");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    String _irgendwas = this.irgendwas(root, ac);
    _builder.append(_irgendwas, "");
    _builder.newLineIfNotEmpty();
    Documentation _docu = ac.getDocu();
    StringConcatenation _generateDocText = this.generateDocText(_docu);
    _builder.append(_generateDocText, "");
    _builder.newLineIfNotEmpty();
    String _name_1 = ac.getName();
    _builder.append(_name_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation generateDocText(final Documentation doc) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(doc, null);
      if (_operator_notEquals) {
        _builder.append("Documentation: ");
        EList<String> _text = doc.getText();
        String _join = IterableExtensions.join(_text, " ///// ");
        _builder.append(_join, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String irgendwas(final Root root, final ActorClass ac) {
    String _name = ac.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, ".bla");
    return _operator_plus;
  }
}
