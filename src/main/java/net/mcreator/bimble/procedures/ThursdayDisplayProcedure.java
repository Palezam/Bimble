package net.mcreator.bimble.procedures;

import java.util.Calendar;

public class ThursdayDisplayProcedure {
	public static boolean execute() {
		if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == 5) {
			return true;
		}
		return false;
	}
}
