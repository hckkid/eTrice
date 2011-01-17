package org.eclipse.etrice.ui.behavior.dialogs;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.etrice.core.room.DetailCode;

public class DetailCodeToString extends Converter {

	public DetailCodeToString() {
		super(DetailCode.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof DetailCode) {
			String result = "";
			for (String cmd : ((DetailCode) fromObject).getCommands()) {
				result += cmd+"\n";
			}
			return result;
		}
		return null;
	}
}
