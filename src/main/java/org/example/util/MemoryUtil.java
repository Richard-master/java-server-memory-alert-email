package org.example.util;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class MemoryUtil {

    public static double getMemoryUsagePercentage() {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long totalMemory = osBean.getTotalPhysicalMemorySize();
        long freeMemory = osBean.getFreePhysicalMemorySize();
        long usedMemory = totalMemory - freeMemory;

        double memoryUsagePercentage = (double) usedMemory / totalMemory * 100.0;
        return memoryUsagePercentage;
    }

    public static void main(String[] args) {
        double memoryUsage = getMemoryUsagePercentage();
        System.out.println("Memory Usage Percentage: " + memoryUsage + "%");
    }
}
