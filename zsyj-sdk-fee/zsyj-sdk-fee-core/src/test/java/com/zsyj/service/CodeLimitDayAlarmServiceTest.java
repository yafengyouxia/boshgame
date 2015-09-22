
package com.zsyj.service;

import org.junit.Test;

import com.zsyj.fee.schedule.CodeLimitDayAlarmTask;

public class CodeLimitDayAlarmServiceTest {

	@Test
	public void test()
	{
		CodeLimitDayAlarmTask codeLimitDayAlarmTask = new CodeLimitDayAlarmTask( 1000, 1000 );
		codeLimitDayAlarmTask.work();
	}
}