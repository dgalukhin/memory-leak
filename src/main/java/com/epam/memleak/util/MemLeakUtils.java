package com.epam.memleak.util;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.lang.management.MemoryUsage;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemLeakUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemLeakUtils.class);
    private static final String PERM_GEN = "PS Perm Gen";

    public static void printHeapSpace() {
        int mb = 1024*1024;
        Runtime runtime = Runtime.getRuntime();

        long used = (runtime.totalMemory() - runtime.freeMemory()) / mb;
        long free = runtime.freeMemory() / mb;
        long total = runtime.totalMemory() / mb;
        long max = runtime.maxMemory() / mb;
        System.out.println("used/free/total/max: " + used + "/" + free + "/" + total + "/" + max);
    }

    public static void printPermGenSpace() {
        Iterator<MemoryPoolMXBean> iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
        while (iter.hasNext())
        {
            MemoryPoolMXBean item = iter.next();
            String name = item.getName();
            if (PERM_GEN.equals(name)) {
                MemoryUsage usage = item.getUsage();
                LOGGER.info("Perm Gen space: {} {}", name, usage);
            }
        }
    }

    public static void printSystemInfo() {
        Iterator<MemoryPoolMXBean> iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
        while (iter.hasNext()) {
            
        }
    }
}
