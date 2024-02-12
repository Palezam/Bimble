package net.mcreator.bimble.procedures;

import java.util.Calendar;

public class TuesdayDisplayProcedure {
	public static boolean execute() {
		if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == 2) {
			return true;
		}
		return false;
	}
}
