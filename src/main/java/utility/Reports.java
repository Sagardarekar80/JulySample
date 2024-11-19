package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

		public static ExtentReports createReport()
		{
			ExtentSparkReporter htmlReports = new ExtentSparkReporter("SwagLabTestReports.html");
			ExtentReports reports = new ExtentReports();
			reports.attachReporter(htmlReports);
			reports.setSystemInfo("ProjectName","SwagLab");
			reports.setSystemInfo("Owner", "Arise");
			return reports;
			
		}
			
		
}
