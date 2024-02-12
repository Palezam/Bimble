package net.mcreator.bimble.procedures;

import java.util.Calendar;

public class FridayDisplayProcedure {
	public static boolean execute() {
		if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == 6) {
			return true;
		}
		return false;
	}
}
