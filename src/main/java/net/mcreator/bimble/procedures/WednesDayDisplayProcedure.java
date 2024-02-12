package net.mcreator.bimble.procedures;

import java.util.Calendar;

public class WednesDayDisplayProcedure {
	public static boolean execute() {
		if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == 3) {
			return true;
		}
		return false;
	}
}
