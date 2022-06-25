package cc.xiaobaicz.xtv.common.lang

import java.util.concurrent.ExecutorService
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * 线程池
 */
object ThreadPools {

    /**
     * IO 线程池
     */
    val io: ExecutorService by lazy { ThreadPoolExecutor(0, 8, 1, TimeUnit.MINUTES, SynchronousQueue(), DefaultThreadFactory("IO")) }

    /**
     * 任务队列 / 单 线程池
     */
    val single: ExecutorService by lazy { ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, SynchronousQueue(), DefaultThreadFactory("Single")) }

    /**
     * 工作 线程池
     */
    val work: ExecutorService by lazy { ThreadPoolExecutor(2, 8, 5, TimeUnit.MINUTES, SynchronousQueue(), DefaultThreadFactory("Work")) }

}