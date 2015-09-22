package com.zsyj.fee.schedule;

import org.junit.Test;

public class CodeConversionAlarmTest {

	@Test
	public void test()
	{
		CodeConversionAlarmTask codeConversionAlarmTask = new CodeConversionAlarmTask( 1000, 20000 );
		codeConversionAlarmTask.work();
		
		try {
			Thread.sleep( 10000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
