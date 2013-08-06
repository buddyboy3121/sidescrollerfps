package org.tools;

import java.util.Date;

public final class PlannedEvents {

	/**
	 * Returns the date of christmas.
	 * @return the christmas date.
	 */
	@SuppressWarnings("deprecation")
	public Date getChristmasDate() {
		return new Date(12, 25, 0, 0, 0);
	}

	/**
	 * Returns the date of New Years Eve.
	 * @return the New Years Eve date.
	 */
	@SuppressWarnings("deprecation")
	public Date getNewYearDate() {
		return new Date(1, 1, 0, 0, 0);
	}
	
	/**
	 * Returns the date of easter.
	 * @return the easter date.
	 */
	@SuppressWarnings("deprecation")
	public Date getEasterDate() {
		return new Date(4, 1, 0, 0, 0);
	}
	
}
