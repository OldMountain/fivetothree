package com.nxd.ftt.util;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * 单例模式
 *
 * @author luhangqi
 * @date 2018/10/18
 */
public class Singleton {

    private static ExecutorService executorService = null;

    private Singleton() {
    }

    /**
     * 获取ExecutorService单例
     *
     * @return
     */
    public static ExecutorService getExecutorServiceInstance() {
        if (executorService == null) {
            getExecutorServiceSingleton();
        }
        new Thread().start();
        return executorService;
    }

    private static ExecutorService getExecutorServiceSingleton() {
        synchronized (Singleton.class) {
            if (executorService == null) {
                ThreadFactory namedThreadFactory = new BasicThreadFactory.Builder().namingPattern("browser-pool-%d").daemon(false).build();
                executorService = new ThreadPoolExecutor(1, 1,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
            }
        }
        return executorService;
    }

}
