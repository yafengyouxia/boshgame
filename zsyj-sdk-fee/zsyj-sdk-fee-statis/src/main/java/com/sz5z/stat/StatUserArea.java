/**
 * 项目名: mergeData
 * 包名: com.sz5g.mergeDate
 * 文件名: StatUser.java
 * 创建者: hujian
 * 创建时间: 2012-01-20 上午01:59:45
 * 文件描述: TODO
 */
package com.sz5z.stat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.zsyj.database.MainConnectionFactory;
import com.zsyj.database.SlaveConnectionFactory;

/**
 * TODO 统计地区用户数 (fuming).
 *
 * TODO 统计地区用户数程序 (fuming)
 */
public class StatUserArea {
  
  static Logger logger = Logger.getLogger(StatUserArea.class.getName());
  //protected final Log log = LogFactory.getLog(getClass());
  
  private static Hashtable<String,Double> statMap = new Hashtable<String,Double>();
  private static Hashtable<String,Double> statFeeMap = new Hashtable<String,Double>();

  /**
   * TODO 简单描述(一行) (fuming).
   *
   * TODO 详细描述 (fuming) 
   * @param args
   * 0 统计日期时间 like 2009-7-1
   * 1 统计模式 日day 小时hour,小时模式时统计输入时间的前一个小时
   * @throws ParseException 
   */
  public static void main(String[] args) throws ParseException {
    
    logger.debug("test");
    // 
    // TODO Auto-generated method stub
    Calendar cal = Calendar.getInstance();
    
    int countNewUser = 0;
    int countNewFeeUser = 0;
    String timeCondition = "";
    String statTime = args[0];
    SimpleDateFormat sdfYearMonth = new SimpleDateFormat("yyyyMM");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:");
    String yyyyMM = sdfYearMonth.format(sdf.parse(statTime));
    
    String statMethod = args[1];
    if (statMethod.equalsIgnoreCase("month")){
      timeCondition = "where firstvisittime>='"+statTime+"' and firstvisittime<(cast('"+statTime+"' as datetime) + INTERVAL 1 MONTH )";
    }else if(statMethod.equalsIgnoreCase("day")){
      //设置整点
      statTime = statTime.split(" ")[0]+" 00:00:00";
      timeCondition = "where firstvisittime>='"+statTime+"' and firstvisittime<(cast('"+statTime+"' as datetime) + INTERVAL 1 DAY )";
    }else if(statMethod.equalsIgnoreCase("hour")){
      Calendar calLastHour = Calendar.getInstance();
      calLastHour.setTime(sdf.parse(statTime));
      calLastHour.add(Calendar.HOUR_OF_DAY, -1);
      logger.debug(calLastHour.toString());
      statTime = sdf.format(calLastHour.getTime());
      //calHour.setTime(arg0)
      timeCondition = "where firstvisittime>='"+statTime+"00:00' and firstvisittime<(cast('"+statTime+"00:00' as datetime) + INTERVAL 1 HOUR )";
      logger.debug(timeCondition);
    }

    getAreaStat( "select count(*) as tot,areaID,telID,troneType from users "+timeCondition + " group by areaID,telID,troneType");
    getFeeAreaStat( "select count(*) as tot,areaID,telID,troneType from users "+timeCondition + " and mobilenumber<>'13800138000' group by areaID,telID,troneType");
//      countNewUser += getCountBySql(arrDbServer[i],"select count(*) from users "+timeCondition);
//      countNewFeeUser += getCountBySql(arrDbServer[i],"select count(*) from users "+timeCondition+ " and mobileNumber<>'13800138000'");
    System.out.println( countNewUser +" "+countNewFeeUser );      

    Connection con = null;
    PreparedStatement pst = null;
    try{
      con = MainConnectionFactory.getConnection();
      //stmt = con.createStatement();
      String title = "按地区日新增用户";
      String titleFee = "按地区日新增计费用户";
      String timetype = "day";
      if (statMethod.equalsIgnoreCase("month")){
        //stmt.execute(sql);
      }else if(statMethod.equalsIgnoreCase("day")){

        //System.out.println(cal.getTime().toString()+" insert new user of day rows:"+stmt.executeUpdate("insert into stat_total (title,stattime,logtime,timetype,result) values ('日新增用户','"+statTime+"',now(),'day',"+countNewUser+")"));
        //System.out.println(cal.getTime().toString()+" delete new fee user of day rows:"+stmt.executeUpdate("delete from stat_total where title='日新增扣费用户' and stattime='"+statTime+"' and timetype='day'"));
        //System.out.println(cal.getTime().toString()+" insert new fee user of day rows:"+stmt.executeUpdate("insert into stat_total (title,stattime,logtime,timetype,result) values ('日新增扣费用户','"+statTime+"',now(),'day',"+countNewFeeUser+")"));
        //stmt.execute("delete from stat_total where title='日新增用户' and stattime='"+statTime+"' and timetype='day'");
        
      }else if(statMethod.equalsIgnoreCase("hour")){
        title = "按地区小时新增用户";
        titleFee = "按地区小时新增计费用户";
        timetype = "hour";
      }
      insertDb(yyyyMM,title,statTime,statMethod,timetype,statMap);
      insertDb(yyyyMM,titleFee,statTime,statMethod,timetype,statFeeMap);
      
      /*
      pst = con.prepareStatement("delete from stat_detail"+yyyyMM+" where title='"+title+"' and stattime='"+statTime+"' and timetype='"+statMethod+"'");
      logger.info("delete new user of day rows:"+pst.executeUpdate());
      pst = con.prepareStatement("insert into stat_detail"+yyyyMM+" (title,stattime,logtime,timetype,result,param1,param2,param3) values (?,?,now(),?,?,?,?,?)");
      for (UserTroneAreaInfo key : statMap.keySet()) {
        pst.setString(1, title);
        pst.setString(2, statTime);
        pst.setString(3, timetype);
        pst.setDouble(4, statMap.get(key));
        pst.setString(5, key.getAreaCode());
        pst.setString(6, key.getTelCode());
        pst.setString(7, key.getTelecom());
        pst.addBatch();
      }
      logger.info("insert statMap:"+pst.executeBatch().length);
      
      pst = con.prepareStatement("delete from stat_detail"+yyyyMM+" where title='"+title+"' and stattime='"+statTime+"' and timetype='"+statMethod+"'");
      logger.info("delete new user of day rows:"+pst.executeUpdate());
      pst = con.prepareStatement("insert into stat_detail"+yyyyMM+" (title,stattime,logtime,timetype,result,param1,param2,param3) values (?,?,now(),?,?,?,?,?)");
      for (UserTroneAreaInfo key : statMap.keySet()) {
        pst.setString(1, title);
        pst.setString(2, statTime);
        pst.setString(3, timetype);
        pst.setDouble(4, statMap.get(key));
        pst.setString(5, key.getAreaCode());
        pst.setString(6, key.getTelCode());
        pst.setString(7, key.getTelecom());
        pst.addBatch();
      }
      logger.info("insert statMap:"+pst.executeBatch().length);
      */
    }
    catch(Exception e){
      e.printStackTrace();
    }finally {
    	MainConnectionFactory.free(con, null, pst);
    }
  }
  
  private static void getAreaStat(String sql){
    int result = 0;
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String ui = "";
    try{
      con = SlaveConnectionFactory.getConnection();
      stmt = con.createStatement();
      logger.debug(sql);
      rs = stmt.executeQuery(sql);
      while (rs.next()){
        //logger.info(rs.getString("troneType")+" "+rs.getDouble("tot"));
        ui = rs.getString("troneType")+"-"+rs.getString("areaID")+"-"+rs.getString("telID");
        if (statMap.containsKey(ui)){
          statMap.put(ui, statMap.get(ui)+rs.getDouble("tot"));
        }
        else{
          statMap.put(ui, rs.getDouble("tot"));
        }
        result ++;
      }
      logger.info( " statMap result number is:"+result);
    }
    catch(Exception e){
      e.printStackTrace();
    }
    finally {
    	SlaveConnectionFactory.free(con, rs, stmt);
    }
  }

  
  private static void getFeeAreaStat(String sql){
    int result = 0;
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String ui = "";
    try{
      con = SlaveConnectionFactory.getConnection();
      stmt = con.createStatement();
      System.out.println(sql);
      rs = stmt.executeQuery(sql);
      while (rs.next()){
        //logger.info(rs.getString("troneType")+" "+rs.getDouble("tot"));
        ui = rs.getString("troneType")+"-"+(rs.getString("areaID")!=null?rs.getString("areaID"):"0000")+"-"+(rs.getString("telID")!=null?rs.getString("telID"):"00");
        if (statFeeMap.containsKey(ui)){
          statFeeMap.put(ui, statFeeMap.get(ui)+rs.getDouble("tot"));
        }
        else{
          statFeeMap.put(ui, rs.getDouble("tot"));
        }
        result ++;
      }
      logger.info( " statFeeMap result number is:"+result );
    }
    catch(Exception e){
      e.printStackTrace();
    }
    finally {
    	SlaveConnectionFactory.free(con, rs, stmt);
    }
  }

  private static void insertDb(String yyyyMM,String title,String statTime,String statMethod,String timetype,Hashtable<String,Double> tmp){
    Connection con = null;
    PreparedStatement pst = null;
    try{
      con = MainConnectionFactory.getConnection();
      pst = con.prepareStatement("delete from stat_detail"+yyyyMM
          +" where title='"+title+"' and stattime='"+statTime+"' and timetype='"+statMethod+"'");
      logger.info(title+"delete new user of day rows:"+pst.executeUpdate());
      pst = con.prepareStatement("insert into stat_detail"+yyyyMM
          +" (title,stattime,logtime,timetype,result,param1,param2,param3) values (?,?,now(),?,?,?,?,?)");
      for (String key : tmp.keySet()) {
        pst.setString(1, title);
        pst.setString(2, statTime);
        pst.setString(3, timetype);
        pst.setDouble(4, tmp.get(key));
        pst.setString(5, key.split("-")[1]);
        pst.setString(6, key.split("-")[2]);
        pst.setString(7, key.split("-")[0]);
        pst.addBatch();
      }
      logger.info(title+"insert statMap:"+pst.executeBatch().length);
    }
    catch(Exception e){
      e.printStackTrace();
    }finally {
      try {
        pst.close();
      } catch (Exception e) {
      }
      try {
        con.close();
      } catch (Exception e) {
      }
    }
  }
  
}
