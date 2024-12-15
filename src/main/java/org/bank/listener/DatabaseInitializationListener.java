package org.bank.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import org.bank.database.DatabaseInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

@WebListener
public class DatabaseInitializationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseInitializer.main(new String[]{});
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Clean up JDBC drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        AbandonedConnectionCleanupThread.checkedShutdown();
    }
}