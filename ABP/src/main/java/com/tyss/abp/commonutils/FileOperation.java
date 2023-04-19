package com.tyss.abp.commonutils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tyss.abp.baseutil.BaseTest;
import com.tyss.abp.reports.ExtentReport;
import com.tyss.abp.util.WebActionUtil;

/**
 * Description : Implements creation of the folder structure for Extent
 * reports,screenshots,deletion of the previously created folder.
 * 
 * @author Manikandan,Ramya R
 */
public class FileOperation {
	FileVariables fileVariables = new FileVariables();

	/**
	 * Description:Implements setting of the path,creation of the folder structure
	 * for Extent reports,screenshot,deletion of the folder.
	 * 
	 * @author  Manikandan,Ramya R
	 */
	public void CreateFiles() {

		fileVariables.setDate(new Date());
		fileVariables.setSdf(new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss"));
		fileVariables.setsDate(fileVariables.getSdf().format(fileVariables.getDate()));
		fileVariables.setsStartTime(fileVariables.getsDate());
		fileVariables.setExtentReportFolderPath(System.getProperty("user.dir") + "/reports");
		fileVariables.setExtentDir(fileVariables.getExtentReportFolderPath() + "/Automation Report- "
				+ WebActionUtil.getCurrentDateTime());
		BaseTest.currentDateAndTime = WebActionUtil.getCurrentDateTime();
		BaseTest.currentDateAndTimeNewFormat = WebActionUtil.getCurrentDateTime1();
		fileVariables.setScreenShotPath(fileVariables.getExtentDir() + "/Screenshots/");
//		BaseTest.getLogger().info("ExtentDir:-" + fileVariables.getExtentDir());

		/* delete extent folder if it exists before running suite */
		WebActionUtil.deleteDirectory(fileVariables.getExtentReportFolderPath());

		try {
			File file = new File(fileVariables.getExtentDir());
			if (!(file.exists())) {
				boolean extentFolderStatus = file.mkdirs();
				if (extentFolderStatus == true) {
					new ExtentReport().initReport(fileVariables.getExtentDir());
				} else {
					WebActionUtil.info("--> Extent Folder not Created");
			}
			}
		} catch (Exception e) {
			WebActionUtil.info("Inside on start catch block" + e.getMessage());
			e.printStackTrace();
		}
		// Setting ScreenShot Report Location
		try {
			File screenShot = new File(FileVariables.getScreenShotPath());
			if (!(screenShot.exists())) {
				boolean screenshotFolderStatus = screenShot.mkdirs();
				if (screenshotFolderStatus == true) {
//					BaseTest.getLogger().info("Screenshot Folder Created");
				}else {
					WebActionUtil.info("Screenshot Folder Not Created");
			
				}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
