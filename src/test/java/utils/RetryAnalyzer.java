package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int maxRetryCount = 3;
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (retryCount < maxRetryCount) {
                retryCount++;
                result.setStatus(ITestResult.FAILURE);
                System.out.println("Retrying once again. \n" +
                        "Current retry number is: " + retryCount + ".\n " +
                        "Remaining attempts: " + (maxRetryCount - retryCount));
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
