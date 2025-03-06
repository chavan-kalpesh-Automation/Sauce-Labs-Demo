package sauce_Labs_Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report_Utility {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports getInstance() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/Report.html");
		reporter.config().setReportName("Report For Automation Practice");
		extentReports.attachReporter(reporter);
		return extentReports;
	}
}
