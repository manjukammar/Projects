package com.tyss.abp.commonutils;


import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Description : Implements creation of file variables required to perform various file operations.
 * @author  Manikandan,Ramya R
 *  
 */
public class FileVariables {
	private static String extentDir;
	private static String screenShotPath;
	private String sStartTime;
	private String extentReportFolderPath;
	private Date date;
	private SimpleDateFormat sdf;
	private String sDate;
	private String hash;
	/**
	 * Description:Gets the  screenshot path 
	 * @author:Sajal,vikas
	 * @param screenShotPath
	 */
	public static String getScreenShotPath() {
		return screenShotPath;
	}
	/**
	 * Description:Sets the  screenshot path 
	 * @author:Sajal,vikas
	 * @param screenShotPath
	 */
	public void setScreenShotPath(String screenShotPath) {
		FileVariables.screenShotPath = screenShotPath;
	}

	/**
	 * Description:Gets start time
	 * @author:Sajal,vikas
	 * @return sStartTime
	 */

	public String getsStartTime() {
		return sStartTime;
	}
	/**
	 * Description:Sets the  start time 
	 * @author:Sajal,vikas
	 * @param sStartTime
	 */
	public void setsStartTime(String sStartTime) {
		this.sStartTime = sStartTime;
	}
	/**
	 * Description:Gets Extent report folder path
	 * @author:Sajal,vikas
	 * @return extentReportFolderPath
	 */
	public String getExtentReportFolderPath() {
		return extentReportFolderPath;
	}
	/**
	 * Description:Sets the  Extent report folder path 
	 * @author:Sajal,vikas
	 * @param extentReportFolderPath
	 */
	public void setExtentReportFolderPath(String extentReportFolderPath) {
		this.extentReportFolderPath = extentReportFolderPath;
	}
	/**
	 * Description:Gets Date
	 * @author:Sajal,vikas
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Description:Sets the  date 
	 * @author:Sajal,vikas
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Description:Gets simple date format
	 * @author:Sajal,vikas
	 * @return sdf
	 */
	public SimpleDateFormat getSdf() {
		return sdf;
	}
	/**
	 * Description:Sets the simple date format
	 * @author:Sajal,vikas
	 * @param sdf
	 */
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	/**
	 * Description:Gets Date
	 * @author:Sajal,vikas
	 * @return sDate
	 */
	public String getsDate() {
		return sDate;
	}
	/**
	 * Description:Sets the date
	 * @author:Sajal,vikas
	 * @param sDate
	 */
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	/**
	 * Description:Gets Hash
	 * @author:Sajal,vikas
	 * @return hash
	 */
	public String getHash() {
		return hash;
	}
	/**
	 * Description Sets the hash
	 * @author:Sajal,vikas
	 * @param  hash
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}
	/**
	 * Description:Gets extent directory
	 * @author:Sajal,vikas
	 * @return extentDir
	 */
	public static String getExtentDir() {
		return extentDir;
	}
	/**
	 * Description:Sets extent dir
	 * @author:Sajal,vikas
	 * @param extentDir
	 */
	public void setExtentDir(String extentDir) {
		this.extentDir = extentDir;
	}
}
