package net.mcreator.bimble.procedures;

import java.util.Calendar;

public class MondayDisplayProcedure {
	public static boolean execute() {
		if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == 1) {
			return true;
		}
		return false;
	}
}
