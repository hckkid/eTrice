
package org.eclipse.etrice.generator.generic;

import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.core.room.FreeType;
import org.eclipse.etrice.core.room.TypedID;
import org.eclipse.etrice.core.room.Message;



public interface ILanguageExtension{
	String toType(PrimitiveType prim);
	String typeName(Type type);
	String freeTypeName(FreeType type);

	String defaultValue(PrimitiveType prim);
	String defaultValue(TypedID a);
	String getTypedDataDefinition(Message m);
	
	/** 
	 * unification of access level for all Languages before each member 
	 * @return e.g. "private " for Java, nothing for C and C++ (no access level before the individual member) 
	 */
	String accessLevelPrivate();
	/** 
	 * unification of access level for all Languages before each member 
	 * @return e.g. "protected " for Java, nothing for C and C++ (no access level before the individual member) 
	 */
	String accessLevelProtected();
	/** 
	 * unification of access level for all Languages before each member 
	 * @return e.g. "public " for Java, nothing for C and C++ (no access level before the individual member)
	 */
	String accessLevelPublic();
	
	// Strings for member access
	
	/** 
	 * unification of member access for different languages
	 * @return e.g. "this." for Java and C++ or "self->" for C
	 */
	String memberAccess(); 	 
	
	/** 
	 * self pointer for building class mechanism in C, 
	 * e.g. MyClass_function1(MyClass *self, int32 argument1)
	 * @return "classname *self, " for C / for Java and C++ nothing
	 */
	String selfPointer(String classname, int argumentCount);
	
	/** 
	 * language specific scoping string for operations
	 * e.g. nothing in Java (only inside class declaration), nothing and classname:: for C++ and classname_ for C
	 * @return "classname *self, " for C / for Java and C++ nothing
	 */
	String operationScope(String classname, boolean isDeclaration);
	
	String outMessageId(String classname, String messagename);
	String inMessageId(String classname, String messagename);
	
	
}