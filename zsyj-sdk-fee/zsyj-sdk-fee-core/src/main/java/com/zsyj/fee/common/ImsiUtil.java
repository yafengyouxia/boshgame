package com.zsyj.fee.common;

import org.apache.commons.lang3.StringUtils;

public class ImsiUtil
{
	public static String getPrefixNew( String imsi )
	{
		String mobilePre = "";
        
		if (StringUtils.isBlank(imsi) || imsi.length() < 15 )
        {
        	return mobilePre;
        }
        
        if('9' == imsi.charAt( 0 ))
        {
            imsi = imsi.substring( 1 );
        }
		
		String mcc = imsi.substring( 0, 3 );
		String mnc = imsi.substring( 3, 5 );	//CMCC--00,02,07  CU-01,06   CTelecom-03,05  CTietong-20
		
		String msin = imsi.substring( 5 );
		
		//System.out.println( "mcc:" + mcc + " mnc:" + mnc + " msin:" + msin );
		
		//联通的对应关系  http://blog.sina.com.cn/s/blog_6617106b0100hdzv.html
		if( "46001".startsWith( mcc + mnc ) )
		{
			mobilePre = getPrefixNewByCu( msin );
		}
		else if( "46000".startsWith( mcc + mnc ) || "46002".startsWith( mcc + mnc ) || "46007".startsWith( mcc + mnc ) )
		{
			mobilePre = getPrefixNewByCmcc( mcc + mnc, msin );
		}
		else if( "46003".startsWith( mcc + mnc ) )
		{
			mobilePre = getPrefixNewByCT( mcc + mnc, msin );
		}
		
		return mobilePre;
	}
	
	private static String getPrefixNewByCT( String mccMnc, String msin )
	{
		String mobilePre = "";
		String msin01 = msin.substring(0,2);
		if( "09".equals( msin01 ) )
		{
			mobilePre = "133";
			if( "00".equals( msin.substring(2, 4) ) )
			{
				mobilePre = mobilePre + "01" + msin.substring(4, 6);
			}
			else if( "53".equals( msin.substring(2, 4) ) )
			{
				mobilePre = mobilePre + "98" + msin.substring(4, 6);
			}
			else if( "54".equals( msin.substring(2, 4) ) )
			{
				mobilePre = mobilePre + "99" + msin.substring(4, 6);
			}
			else
			{
				mobilePre = mobilePre + msin.substring(2, 6);
			}
		}
		else if( "6".equals( msin.substring(0,1) ) )
		{
			mobilePre = "153" + msin.substring( 1, 3 ) + msin.substring( 4, 6 );
		}
		
		return mobilePre;
	}
	
	private static String getPrefixNewByCmcc( String mccMnc, String msin )
	{
		String mobilePre = "";
		
		if( "46000".equals( mccMnc ) )
		{
			int msin3 = Integer.valueOf( msin.substring( 3,4 ) );
			if( msin3 >= 5 )
			{
				mobilePre = "13" + msin.substring( 3,4 ) + "0" + msin.substring( 0, 3 );
			}
			else
			{
				msin3 = msin3 + 5;
				mobilePre = "13" + msin3 + msin.substring( 4, 5 ) + msin.substring( 0, 3 );
			}
		}
		else if( "46002".equals( mccMnc ) )
		{
			String msin1 = msin.substring( 0, 1 );
			mobilePre = msin.substring( 1, 5 );
			
			if( "0".equals( msin1 ) )
			{
				mobilePre = "134" + mobilePre;
			}
			else if( "8".equals( msin1 ) )
			{
				mobilePre = "158" + mobilePre;
			}
			else if( "9".equals( msin1 ) )
			{
				mobilePre = "159" + mobilePre;
			}
			else if( "3".equals( msin1 ) )
			{
				mobilePre = "150" + mobilePre;
			}
			else if( "1".equals( msin1 ) )
			{
				mobilePre = "151" + mobilePre;
			}
			else if( "2".equals( msin1 ) )
			{
				mobilePre = "152" + mobilePre;
			}
			else if( "7".equals( msin1 ) )
			{
				mobilePre = "187" + mobilePre;
			}
		}
		else if( "46007".equals( mccMnc ) )
		{
			String msin1 = msin.substring( 0, 1 );
			mobilePre = msin.substring( 1, 5 );
			
			if( "7".equals( msin1 ) )
			{
				mobilePre = "157" + mobilePre;
			}
			else if( "8".equals( msin1 ) )
			{
				mobilePre = "188" + mobilePre;
			}
			else if( "9".equals( msin1 ) )
			{
				mobilePre = "147" + mobilePre;
			}
		}
		
		return mobilePre;
	}
	
	private static String getPrefixNewByCu( String msin )
	{
		String msin4 = msin.substring( 4, 5 );
		String mobilePre = msin.substring( 3, 4 ) + msin.substring( 0, 3 );
		
		if( "0".equals( msin4 ) || "1".equals( msin4 ) )
		{
			mobilePre = "130" + mobilePre;
		}
		else if( "9".equals( msin4 ) )
		{
			mobilePre = "131" + mobilePre;
		}
		else if( "2".equals( msin4 ) )
		{
			mobilePre = "132" + mobilePre;
		}
		else if( "3".equals( msin4 ) )
		{
			mobilePre = "156" + mobilePre;
		}
		else if( "4".equals( msin4 ) )
		{
			mobilePre = "155" + mobilePre;
		}
		else if( "6".equals( msin4 ) )
		{
			mobilePre = "186" + mobilePre;
		}
		else
		{
			//185新增号段暂时不知、可以通过号码实测一下
			mobilePre = "185" + mobilePre;
		}
		
		return mobilePre;
	}
	
	//460 029936510268
    public static String getPrefix(String imsi)
    {
        String str1 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = "56789";
        String str6;
        
        try
        {
            if (StringUtils.isBlank(imsi) || imsi.length() < 12 )
            {
            	return str4;
            }
            
            if('9' == imsi.charAt( 0 ))
            {
                imsi = imsi.substring( 1 );
            }
            
            if (!imsi.startsWith("46000"))
            {
                if (imsi.startsWith("46002"))
                {
                    str5 = imsi.substring(5, 6);
                    str6 = imsi.substring(6, 7);
                    str3 = imsi.substring(7, 8);
                    str2 = imsi.substring(8, 9);
                    str1 = imsi.substring(9, 10);
                    if (str5.equalsIgnoreCase("0"))
                    {
                        StringBuffer localStringBuffer15 = new StringBuffer();
                        localStringBuffer15.append("134");
                        localStringBuffer15.append(str6);
                        localStringBuffer15.append(str3);
                        localStringBuffer15.append(str2);
                        localStringBuffer15.append(str1);
                        str4 = localStringBuffer15.toString();
                    }
                    else if (str5.equalsIgnoreCase("1"))
                    {
                        StringBuffer localStringBuffer21 = new StringBuffer();
                        localStringBuffer21.append("151");
                        localStringBuffer21.append(str6);
                        localStringBuffer21.append(str3);
                        localStringBuffer21.append(str2);
                        localStringBuffer21.append(str1);
                        str4 = localStringBuffer21.toString();
                    }
                    else if (str5.equalsIgnoreCase("2"))
                    {
                        StringBuffer localStringBuffer27 = new StringBuffer();
                        localStringBuffer27.append("152");
                        localStringBuffer27.append(str6);
                        localStringBuffer27.append(str3);
                        localStringBuffer27.append(str2);
                        localStringBuffer27.append(str1);
                        str4 = localStringBuffer27.toString();
                    }
                    else if (str5.equalsIgnoreCase("3"))
                    {
                        StringBuffer localStringBuffer33 = new StringBuffer();
                        localStringBuffer33.append("150");
                        localStringBuffer33.append(str6);
                        localStringBuffer33.append(str3);
                        localStringBuffer33.append(str2);
                        localStringBuffer33.append(str1);
                        str4 = localStringBuffer33.toString();
                    }
                    else if (str5.equalsIgnoreCase("7"))
                    {
                        StringBuffer localStringBuffer39 = new StringBuffer();
                        localStringBuffer39.append("187");
                        localStringBuffer39.append(str6);
                        localStringBuffer39.append(str3);
                        localStringBuffer39.append(str2);
                        localStringBuffer39.append(str1);
                        str4 = localStringBuffer39.toString();
                    }
                    else if (str5.equalsIgnoreCase("8"))
                    {
                        StringBuffer localStringBuffer45 = new StringBuffer();
                        localStringBuffer45.append("158");
                        localStringBuffer45.append(str6);
                        localStringBuffer45.append(str3);
                        localStringBuffer45.append(str2);
                        localStringBuffer45.append(str1);
                        str4 = localStringBuffer45.toString();
                    }
                    else if (str5.equalsIgnoreCase("9"))
                    {
                        StringBuffer localStringBuffer51 = new StringBuffer();
                        localStringBuffer51.append("159");
                        localStringBuffer51.append(str6);
                        localStringBuffer51.append(str3);
                        localStringBuffer51.append(str2);
                        localStringBuffer51.append(str1);
                        str4 = localStringBuffer51.toString();
                    }
                }
                else if (imsi.startsWith("46007"))
                {
                    str5 = imsi.substring(5, 6);
                    str6 = imsi.substring(6, 7);
                    str3 = imsi.substring(7, 8);
                    str2 = imsi.substring(8, 9);
                    str1 = imsi.substring(9, 10);
                    if (str5.equalsIgnoreCase("7"))
                    {
                        StringBuffer localStringBuffer57 = new StringBuffer();
                        localStringBuffer57.append("157");
                        localStringBuffer57.append(str6);
                        localStringBuffer57.append(str3);
                        localStringBuffer57.append(str2);
                        localStringBuffer57.append(str1);
                        str4 = localStringBuffer57.toString();
                    }
                    else if (str5.equalsIgnoreCase("8"))
                    {
                        StringBuffer localStringBuffer63 = new StringBuffer();
                        localStringBuffer63.append("188");
                        localStringBuffer63.append(str6);
                        localStringBuffer63.append(str3);
                        localStringBuffer63.append(str2);
                        localStringBuffer63.append(str1);
                        str4 = localStringBuffer63.toString();
                    }
                    else if (str5.equalsIgnoreCase("9"))
                    {
                        StringBuffer localStringBuffer69 = new StringBuffer();
                        localStringBuffer69.append("147");
                        localStringBuffer69.append(str6);
                        localStringBuffer69.append(str3);
                        localStringBuffer69.append(str2);
                        localStringBuffer69.append(str1);
                        str4 = localStringBuffer69.toString();
                    }
                }
                else if (imsi.startsWith("46001"))
                {
                    str5 = imsi.substring(5, 6);
                    str6 = imsi.substring(6, 7);
                    str3 = imsi.substring(7, 8);
                    str2 = imsi.substring(8, 9);
                    str1 = imsi.substring(9, 10);
                    if ((str1.equalsIgnoreCase("0"))
                            || (str1.equalsIgnoreCase("1")))
                    {
                        StringBuffer localStringBuffer75 = new StringBuffer();
                        localStringBuffer75.append("130");
                        localStringBuffer75.append(str2);
                        localStringBuffer75.append(str5);
                        localStringBuffer75.append(str6);
                        localStringBuffer75.append(str3);
                        str4 = localStringBuffer75.toString();
                    }
                    else if (str1.equalsIgnoreCase("9"))
                    {
                        StringBuffer localStringBuffer81 = new StringBuffer();
                        localStringBuffer81.append("131");
                        localStringBuffer81.append(str2);
                        localStringBuffer81.append(str5);
                        localStringBuffer81.append(str6);
                        localStringBuffer81.append(str3);
                        str4 = localStringBuffer81.toString();
                    }
                    else if (str1.equalsIgnoreCase("2"))
                    {
                        StringBuffer localStringBuffer87 = new StringBuffer();
                        localStringBuffer87.append("132");
                        localStringBuffer87.append(str2);
                        localStringBuffer87.append(str5);
                        localStringBuffer87.append(str6);
                        localStringBuffer87.append(str3);
                        str4 = localStringBuffer87.toString();
                    }
                    else if (str1.equalsIgnoreCase("4"))
                    {
                        StringBuffer localStringBuffer93 = new StringBuffer();
                        localStringBuffer93.append("155");
                        localStringBuffer93.append(str2);
                        localStringBuffer93.append(str5);
                        localStringBuffer93.append(str6);
                        localStringBuffer93.append(str3);
                        str4 = localStringBuffer93.toString();
                    }
                    else if (str1.equalsIgnoreCase("3"))
                    {
                        StringBuffer localStringBuffer99 = new StringBuffer();
                        localStringBuffer99.append("156");
                        localStringBuffer99.append(str2);
                        localStringBuffer99.append(str5);
                        localStringBuffer99.append(str6);
                        localStringBuffer99.append(str3);
                        str4 = localStringBuffer99.toString();
                    }
                    else if (str1.equalsIgnoreCase("6"))
                    {
                        StringBuffer localStringBuffer105 = new StringBuffer();
                        localStringBuffer105.append("186");
                        localStringBuffer105.append(str2);
                        localStringBuffer105.append(str5);
                        localStringBuffer105.append(str6);
                        localStringBuffer105.append(str3);
                        str4 = localStringBuffer105.toString();
                    }
                }
                else
                {
                    str4 = "";
                }
            }
            else
            {
                str4 = imsi.substring(5, 6);
                str6 = imsi.substring(6, 7);
                str3 = imsi.substring(7, 8);
                str2 = imsi.substring(8, 9);
                str1 = imsi.substring(9, 10);
                StringBuffer localStringBuffer8 = new StringBuffer();
                localStringBuffer8.append("13");
                int i = Integer.parseInt(str2) + 5;
                localStringBuffer8.append(i);
                localStringBuffer8.append(str1);
                localStringBuffer8.append(str4);
                localStringBuffer8.append(str6);
                localStringBuffer8.append(str3);
                str4 = localStringBuffer8.toString();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
        if (StringUtils.isBlank(str4)) 
        {
        	str4 = null;	
        }
        
        return str4;
    }
    
    public static void main( String args [] )
    {
    	System.out.println( ImsiUtil.getPrefix("460003006702964") );
    	
    	System.out.println( ImsiUtil.getPrefixNew("460003006702964") );
    }
}
