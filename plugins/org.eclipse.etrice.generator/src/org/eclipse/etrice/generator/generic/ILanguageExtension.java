
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
}