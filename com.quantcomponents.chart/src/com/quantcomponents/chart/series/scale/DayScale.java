/*******************************************************************************
 * Copyright (c) 2013 Luigi Sgro. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Luigi Sgro - initial API and implementation
 ******************************************************************************/
package com.quantcomponents.chart.series.scale;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.quantcomponents.chart.IMark;
import com.quantcomponents.chart.series.TimeScale;
import com.quantcomponents.chart.series.TimeMark;

/**
 * Generates day marks on a time axis
 */
public class DayScale extends TimeScale {

	public DayScale(TimeZone timeZone) {
		super(Calendar.DATE, 1, timeZone, 24L * 60L * 60L * 1000L);
	}

	@Override
	public IMark<Date> previousMark(Date date) {
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		return new TimeMark(this, cal.getTime());
	}

	@Override
	protected TimeScale buildParent(TimeZone timeZone) {
		return new WeekScale(timeZone);
	}

}
