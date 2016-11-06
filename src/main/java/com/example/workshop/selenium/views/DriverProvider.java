package com.example.workshop.selenium.views;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Creates and stores per-thread {@link WebDriver} instances.
 *
 * @author Paul Danyliuk
 * @version $Id$
 */
public class DriverProvider {

    private static final long IMPLICIT_TIMEOUT = 0;  // s

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();

    /**
     * Returns the driver for current thread. Creates a new one if there's none.
     * @return web driver instance for this thread
     */
    public static WebDriver getForCurrentThread() {
        if (drivers.get() == null) {
            drivers.set(buildChromeDriver());
        }
        return drivers.get();
    }

    public static WebDriver buildChromeDriver() {
        // Setting some command line switches to start the browser how we need it
        // http://peter.sh/experiments/chromium-command-line-switches/

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "disable-popup-blocking");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);

        // Setting implicit waits
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

}
