package com.amar.email_body;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormat {
	
	private static boolean update=false;

	
	public static String getFormat(String date)
	{
		String format="";
		String yyyy="",MM="",dd="",HH="",mm="",ss="",SSS="",meridies="";
		String pattern="[0-9]+|[a-z]+";
		boolean set=false,effort=false;
		 Pattern patt = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
	       Matcher matcher = patt.matcher(date);
	       int count=0;   
	       while(matcher.find())
	       { 
	    	   if(matcher.group().length()>=3&&!matcher.group().contains("T"))
	    	   try{Integer.parseInt(matcher.group());}
				catch(NumberFormatException e){set=true;effort=true;} 
	       meridies=matcher.group().toLowerCase();
	       } 
	  
	       matcher.reset();
		while (matcher.find()) {
			
			if (matcher.group().length() == 4 && set==false) {
					yyyy=matcher.group();		
					if(!MM.equals("")) count=2;				} 
			else if (matcher.group().length() >= 3 && set==true) {
				try{
					Integer.parseInt(matcher.group());
					yyyy =matcher.group() ;
				}
				catch(NumberFormatException e){
					MM = getMonth(matcher.group().toLowerCase());
				}
				
				if(!yyyy.equals("")&&!MM.equals("")&&!dd.equals(""))
					{count =2; set=false;}
			} else if (matcher.group().length() <= 2 && set == true) {
				
				try{
					Integer.parseInt(matcher.group());
					dd= matcher.group(); 
					}
				catch(NumberFormatException e){	}
				
				
				
				if(!yyyy.equals("")&&!MM.equals("")&&!dd.equals(""))
					{count =2; set=false;}
						
			} 
			else if(matcher.group().length() <= 2 )
			{try {
				switch(count) {			
			 case 0: if(update==true)dd=matcher.group();else MM=matcher.group();count++;  break;  
			 case 1: if(update==true)MM=matcher.group();else dd=matcher.group();count++;  break; 
			 case 2: if(matcher.group().contains("T")) {effort=true;Integer.parseInt(matcher.group());}
			 else if(effort==false&&!meridies.equals("pm")) {HH=matcher.group();}
			 else if(meridies.equals("pm") && Integer.parseInt(matcher.group())<12)HH=Integer.parseInt(matcher.group())+12+"";		 
			 else HH=matcher.group(); count++; break; 
			 case 3:if(effort==false&&!meridies.equals("am")&&!meridies.equals("pm"))mm=matcher.group();else mm=Integer.parseInt(matcher.group())+""; count++;  break; 
			 case 4:if(effort==false&&!meridies.equals("am")&&!meridies.equals("pm"))ss=matcher.group();else ss=Integer.parseInt(matcher.group())+""; count++;  break;
			 case 5:if(effort==false&&!meridies.equals("am")&&!meridies.equals("pm"))SSS=matcher.group();else SSS=Integer.parseInt(matcher.group())+""; count++;  break;
			    }
			}
			catch(NumberFormatException e) {
				
			}
				
			}
			else if(matcher.group().length() <= 3 )
			{try {
				switch(count) {			
			 case 5:if(effort==false&&!meridies.equals("am")&&!meridies.equals("pm"))SSS=matcher.group();else SSS=Integer.parseInt(matcher.group())+""; count++;  break;
			    }
			}
			catch(NumberFormatException e) {
				
			}
				
			}	
						
		}	   
		
		if(!yyyy.equals("")) {
		if(HH.equals(""))
			HH="00";
		if(mm.equals(""))
			mm="00";
		if(ss.equals(""))
			ss="00";
		if(SSS.equals(""))
			SSS="000";
		if(Integer.parseInt(MM)>12)
			{dd=Integer.parseInt(MM)+Integer.parseInt(dd)+"";  MM=Integer.parseInt(dd)-Integer.parseInt(MM)+""; dd=Integer.parseInt(dd)-Integer.parseInt(MM)+""; }
		
    format= yyyy+"-"+MM+"-"+dd+"T"+HH+":"+mm+":"+ss+"."+SSS+"Z";  
		}	
		else format="";
		 
		if(Integer.parseInt(dd)>=30&&!format.equals("")) {	
			
			
			if(validate(Integer.parseInt(dd),MM)==404)
				format= "";
		}
		
		
		update=false;
		return format;
	}

	

	private static String getMonth(String m)
	{
		switch(m)
		{
		case "january": return "01";
		case "jan": return "01";
		case "february": return "02";
		case "feb": return "02";
		case "march": return "03";
		case "mar": return "03";
		case "april": return "04";
		case "apr": return "04";
		case "may": return "05";
		case "june": return "06";
		case "jun": return "06";
		case "july": return "07";
		case "jul": return "07";
		case "august": return "08";
		case "aug": return "08";
		case "september": return "09";
		case "sep": return "09";
		case "sept": return "09";
		case "october": return "10";
		case "oct": return "10";
		case "november": return "11";
		case "nov": return "11";
		case "december": return "12";
		case "dec": return "12";

		}
		return null;
		
		
		
	}
	
	
	public static DateFormat updateLogic()
	{
		update=true;
		return new DateFormat();
	}
	
	public static int validate(int dd, String MM)
	{
		switch(Integer.parseInt(MM)+"")
		{
		case "1": if(dd<=31)return dd; else dd=404;
		case "2": if(dd<=29)return dd; else dd=404;
		case "3": if(dd<=31)return dd; else dd=404;
		case "4": if(dd<=30)return dd; else dd=404;
		case "5": if(dd<=31)return dd; else dd=404;
		case "6": if(dd<=30)return dd; else dd=404;
		case "7": if(dd<=31)return dd; else dd=404;
		case "8": if(dd<=31)return dd; else dd=404;
		case "9": if(dd<=30)return dd; else dd=404;
		case "10": if(dd<=31)return dd; else dd=404;
		case "11": if(dd<=30)return dd; else dd=404;
		case "12": if(dd<=31)return dd; else dd=404;
		

		}
		return 404;
	}
}
