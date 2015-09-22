package com.zsyj.fee.schedule;

import org.junit.Test;

public class CodeLimitDayAlarmTest {

	@Test
	public void test()
	{
		CodeLimitDayAlarmTask alarmTask = new CodeLimitDayAlarmTask( 0, 0 );
		alarmTask.work();
	}
}
