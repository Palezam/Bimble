package net.mcreator.bimble.procedures;

import java.util.Calendar;

public class SaturdayDisplayProcedure {
	public static boolean execute() {
		if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == 7) {
			return true;
		}
		return false;
	}
}
