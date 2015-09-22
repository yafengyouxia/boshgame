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
 * 按照地市统计
 *
 * TODO 统计地区用户数程序 (fuming)
 */
public class StatServiceCodeArea {
  
  static Logger logger = Logger.getLogger(StatServiceCodeArea.class.getName());
  //protected final Log log = LogFactory.getLog(getClass());
  
  private static Hashtable<String,Double> statMomap = new Hashtable<String,Double>();
  private static Hashtable<String,Double> statMo = new Hashtable<String,Double>();
  private static Hashtable<String,Double> statMr = new Hashtable<String,Double>();
  private static Hashtable<String,Double> statMt = new Hashtable<String,Double>();

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
    String timeConditionUsers = "";
    String timeConditionMomap = "";
    String statTime = args[0];
    SimpleDateFormat sdfYearMonth = new SimpleDateFormat("yyyyMM");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:");
    String yyyyMM = sdfYearMonth.format(sdf.parse(statTime));
    
    String statMethod = args[1];
    if (statMethod.equalsIgnoreCase("month")){
      timeConditionUsers = "where firstvisittime>='"+statTime+"' and firstvisittime<(cast('"+statTime+"' as datetime) + INTERVAL 1 MONTH )";
      timeConditionMomap = "where logtime>='"+statTime+"' and logtime<(cast('"+statTime+"' as datetime) + INTERVAL 1 MONTH )";
      
    }else if(statMethod.equalsIgnoreCase("day")){
      //设置整点
      statTime = statTime.split(" ")[0]+" 00:00:00";
      timeConditionUsers = "where firstvisittime>='"+statTime+"' and firstvisittime<(cast('"+statTime+"' as datetime) + INTERVAL 1 DAY )";
      timeConditionMomap = "where logtime>='"+statTime+"' and logtime<(cast('"+statTime+"' as datetime) + INTERVAL 1 DAY )";
    }else if(statMethod.equalsIgnoreCase("hour")){
      Calendar calLastHour = Calendar.getInstance();
      calLastHour.setTime(sdf.parse(statTime));
      calLastHour.add(Calendar.HOUR_OF_DAY, -1);
      logger.debug(calLastHour.toString());
      statTime = sdf.format(calLastHour.getTime());
      //calHour.setTime(arg0)
      timeConditionUsers = "where firstvisittime>='"+statTime+"00:00' and firstvisittime<(cast('"+statTime+"00:00' as datetime) + INTERVAL 1 HOUR )";
      timeConditionMomap = "where logtime>='"+statTime+"00:00' and logtime<(cast('"+statTime+"00:00' as datetime) + INTERVAL 1 HOUR )";
      logger.debug(timeConditionUsers);
    }

    getMomapStat( "select count(distinct mid,produce) as tot,serviceCode,area_code,tel_code,show_type from moidmapping_log"+yyyyMM+" "+timeConditionMomap + " group by serviceCode,area_code,tel_code,show_type");
    getMoStat( "select sum(price) as tot,serviceCode,area as area_code,feeTime as tel_Code,msgType,msgTitle from smsmo"+yyyyMM+" "+timeConditionMomap + " and (msgType='usermo' or (msgType='fee' and feeStatus=1)) and length(msgTitle)>0 group by serviceCode,area,feeTime,msgType,msgTitle");
    getMtStat( "select sum(price) as tot,serviceCode,area as area_code,title as tel_Code,sendType as show_type from smsmt"+yyyyMM+" "+timeConditionMomap + " and length(sendType)>0 group by serviceCode,area,title,sendType");
      //getFeeAreaStat(arrDbServer[i],"select count(*) as tot,areaID,telID,troneType from users "+timeConditionUsers + " and mobilenumber<>'13800138000' group by areaID,telID,troneType");
//      countNewUser += getCountBySql(arrDbServer[i],"select count(*) from users "+timeCondition);
//      countNewFeeUser += getCountBySql(arrDbServer[i],"select count(*) from users "+timeCondition+ " and mobileNumber<>'13800138000'");
    System.out.println( countNewUser +" "+countNewFeeUser );      

      Connection con = null;
    //PreparedStatement pst = null;
    try{
      con = MainConnectionFactory.getConnection();
      //stmt = con.createStatement();
      String titleMomap = "按地区日通道指令";
      String titleMo = "按地区日通道MO";
      String titleMr = "按地区日通道MR";
      String titleMt = "按地区日通道MT";
      String timetype = "day";
      if (statMethod.equalsIgnoreCase("month")){
        //stmt.execute(sql);
      }else if(statMethod.equalsIgnoreCase("day")){

        //System.out.println(cal.getTime().toString()+" insert new user of day rows:"+stmt.executeUpdate("insert into stat_total (title,stattime,logtime,timetype,result) values ('日新增用户','"+statTime+"',now(),'day',"+countNewUser+")"));
        //System.out.println(cal.getTime().toString()+" delete new fee user of day rows:"+stmt.executeUpdate("delete from stat_total where title='日新增扣费用户' and stattime='"+statTime+"' and timetype='day'"));
        //System.out.println(cal.getTime().toString()+" insert new fee user of day rows:"+stmt.executeUpdate("insert into stat_total (title,stattime,logtime,timetype,result) values ('日新增扣费用户','"+statTime+"',now(),'day',"+countNewFeeUser+")"));
        //stmt.execute("delete from stat_total where title='日新增用户' and stattime='"+statTime+"' and timetype='day'");
        
      }else if(statMethod.equalsIgnoreCase("hour")){
        titleMomap = "按地区小时通道指令";
        titleMo = "按地区小时通道MO";
        titleMr = "按地区小时通道MR";
        titleMt = "按地区小时通道MT";
        timetype = "hour";
      }
      insertDb(yyyyMM,titleMomap,statTime,statMethod,timetype,statMomap);
      insertDb(yyyyMM,titleMo,statTime,statMethod,timetype,statMo);
      insertDb(yyyyMM,titleMr,statTime,statMethod,timetype,statMr);
      insertDb(yyyyMM,titleMt,statTime,statMethod,timetype,statMt);
      //insertDb(yyyyMM,titleFee,statTime,statMethod,timetype,statFeeMap);
      
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
//      try {
//        pst.close();
//      } catch (Exception e) {
//      }
      try {
        con.close();
      } catch (Exception e) {
      }
    }
  }
  
  private static void getMomapStat(String sql){
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
        ui = rs.getString("serviceCode")+"-"+rs.getString("area_code")+"-"+rs.getString("tel_code")+"-"+rs.getString("show_type");
        if (statMomap.containsKey(ui)){
          statMomap.put(ui, statMomap.get(ui)+rs.getDouble("tot"));
        }
        else{
          statMomap.put(ui, rs.getDouble("tot"));
        }
        result ++;
      }
      logger.info( " statMap result number is:"+result );
    }
    catch(Exception e){
      e.printStackTrace();
    }
    finally {
      try {
        rs.close();
      } catch (Exception e) {
      }
      try {
        stmt.close();
      } catch (Exception e) {
      }
      try {
        con.close();
      } catch (Exception e) {
      }
    }
  }
  
  private static void getMtStat(String sql){
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
        ui = rs.getString("serviceCode")+"-"+rs.getString("area_code")+"-"+rs.getString("tel_code")+"-"+rs.getString("show_type");
        if (statMt.containsKey(ui)){
          statMt.put(ui, statMt.get(ui)+rs.getDouble("tot"));
        }
        else{
          statMt.put(ui, rs.getDouble("tot"));
        }
        result ++;
      }
      logger.info( " statMt result number is:"+result );
    }
    catch(Exception e){
      e.printStackTrace();
    }
    finally {
      try {
        rs.close();
      } catch (Exception e) {
      }
      try {
        stmt.close();
      } catch (Exception e) {
      }
      try {
        con.close();
      } catch (Exception e) {
      }
    }
  }
  
  private static void getMoStat( String sql ){
    int resultMo = 0;
    int resultMr = 0;
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
        if (rs.getString("msgType").equalsIgnoreCase("userMo")){
          ui = rs.getString("serviceCode")+"-"+rs.getString("area_code")+"-"+rs.getString("tel_code")+"-"+rs.getString("msgTitle");
          if (statMo.containsKey(ui)){
            statMo.put(ui, statMo.get(ui)+rs.getDouble("tot"));
          }
          else{
            statMo.put(ui, rs.getDouble("tot"));
          }
          resultMo ++;  
        }
        else if (rs.getString("msgType").equalsIgnoreCase("fee")){
          ui = rs.getString("serviceCode")+"-"+rs.getString("area_code")+"-"+rs.getString("tel_code")+"-"+rs.getString("msgTitle");
          if (statMr.containsKey(ui)){
            statMr.put(ui, statMr.get(ui)+rs.getDouble("tot"));
          }
          else{
            statMr.put(ui, rs.getDouble("tot"));
          }
          resultMr ++;
        }
        
        //logger.info(rs.getString("troneType")+" "+rs.getDouble("tot"));
      }
      logger.info( " statMo result number is:"+resultMo+" statMr result number is:"+resultMr );
    }
    catch(Exception e){
      e.printStackTrace();
    }
    finally {
      try {
        rs.close();
      } catch (Exception e) {
      }
      try {
        stmt.close();
      } catch (Exception e) {
      }
      try {
        con.close();
      } catch (Exception e) {
      }
    }
  }

  
//  private static void getFeeAreaStat(String db,String sql){
//    int result = 0;
//    Connection con = null;
//    Statement stmt = null;
//    ResultSet rs = null;
//    String ui = "";
//    try{
//      con = ConnectionFactoryMidSlave01.getConnection(db);
//      stmt = con.createStatement();
//      System.out.println(sql);
//      rs = stmt.executeQuery(sql);
//      while (rs.next()){
//        //logger.info(rs.getString("troneType")+" "+rs.getDouble("tot"));
//        ui = rs.getString("troneType")+"-"+(rs.getString("areaID")!=null?rs.getString("areaID"):"0000")+"-"+(rs.getString("telID")!=null?rs.getString("telID"):"00");
//        if (statFeeMap.containsKey(ui)){
//          statFeeMap.put(ui, statFeeMap.get(ui)+rs.getDouble("tot"));
//        }
//        else{
//          statFeeMap.put(ui, rs.getDouble("tot"));
//        }
//        result ++;
//      }
//      logger.info("db:"+db+" statFeeMap result number is:"+result);
//    }
//    catch(Exception e){
//      e.printStackTrace();
//    }
//    finally {
//      try {
//        rs.close();
//      } catch (Exception e) {
//      }
//      try {
//        stmt.close();
//      } catch (Exception e) {
//      }
//      try {
//        con.close();
//      } catch (Exception e) {
//      }
//    }
//  }

  private static void insertDb(String yyyyMM,String title,String statTime,String statMethod,String timetype,Hashtable<String,Double> tmp){
    Connection con = null;
    PreparedStatement pst = null;
    try{
      con = MainConnectionFactory.getConnection();
      pst = con.prepareStatement("delete from stat_detail"+yyyyMM
          +" where title='"+title+"' and stattime='"+statTime+"' and timetype='"+statMethod+"'");
      logger.info(title+"delete new user of day rows:"+pst.executeUpdate());
      pst = con.prepareStatement("insert into stat_detail"+yyyyMM
          +" (title,stattime,logtime,timetype,result,param1,param2,param3,param4) values (?,?,now(),?,?,?,?,?,?)");
      for (String key : tmp.keySet()) {
        String[] arrayKey = key.split("-");
        if (arrayKey.length==4){
          pst.setString(1, title);
          pst.setString(2, statTime);
          pst.setString(3, timetype);
          pst.setDouble(4, tmp.get(key));
          pst.setString(5, arrayKey[1]);
          pst.setString(6, arrayKey[2]);
          pst.setString(7, arrayKey[0]);
          pst.setString(8, arrayKey[3]);
          pst.addBatch();
        }
        else{
          logger.debug(key);
        }
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
