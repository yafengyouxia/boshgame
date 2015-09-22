package com.sz5z.crontab;

import com.sz5z.crontab.job.AccessProcesslogJob;

//java -cp $CLASSPATH:.:/home/yelin.g/app/mm3x/lib/* com.sz5z.crontab.CrontabServer
//java -cp .;E:\app\MM3.0\lib\* com.sz5z.crontab.CrontabServer
//nohup java -Xms1024m  -Xmx2048m -cp .:/home/sswitch/app/mm3x/lib/*  com.sz5z.crontab.CrontabServer &
public class CrontabServer {

	public static void main( String args [] ) {
		
		//tomcat日志分析日志同步
		new Thread( new  AccessProcesslogJob( 30000L, 2*3600*1000L ) ).start();
		
		//1. 检查通道上量是否达到上限或无量
		//2. 重启头一天非手动关闭的配置
		//new Thread( new  TroneAlarmJob( 10*1000L, 1200*1000L ) ).start();
		
		//检查垫付通道上量是否达到上限，是否停量
		//new Thread( new  DFTroneAlarmJob( 30000L, 120*1000L ) ).start();
		
		//检查2分钟内是否有计费数据
		//new Thread( new  SystemAlarmJob( 30000L, 120*1000L ) ).start();
		
		//每隔一小时统计销统
		//new Thread( new  StatMobileNumJob( 20000L, 6*3600*1000L ) ).start();
		
		
		/**********************************************************************************/
		
		
//		Timer timer = new Timer();
//		
//		//同步短信猫数据到销统和数据表中
//		timer.schedule( new  SmsCatProcessJob(), 30000L, 120000L );	
//		
//		//tomcat日志分析日志同步
//		timer.schedule( new  AccessProcesslogJob(), 30000L, 2*3600*1000L );
//		
//		//1. 检查通道上量是否达到上限或无量
//		//2. 重启头一天非手动关闭的配置
//		timer.schedule( new  TroneAlarmJob(), 10*1000L, 1200*1000L );
//		
//		//检查垫付通道上量是否达到上限，是否停量
//		timer.schedule( new  DFTroneAlarmJob(), 30000L, 120*1000L );
//		
//		//检查2分钟内是否有计费数据
//		timer.schedule( new  SystemAlarmJob(), 30000L, 120*1000L );
//		
//		//每隔一小时统计销统
//		timer.schedule( new  StatMobileNumJob(), 20000L, 6*3600*1000L );
	}
}