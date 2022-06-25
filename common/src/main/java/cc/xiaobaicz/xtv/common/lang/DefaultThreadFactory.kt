package cc.xiaobaicz.xtv.common.lang

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

/**
 * 默认线程工厂
 */
open class DefaultThreadFactory(name: String, private val stackSize: Long = 0L) : ThreadFactory {

    companion object {
        // 工厂数
        private val factoryCountMap = HashMap<String, AtomicInteger>()
    }

    init {
        if (!factoryCountMap.containsKey(name))
            factoryCountMap[name] = AtomicInteger(0)
    }

    // 线程组
    private var threadGroup: ThreadGroup? = System.getSecurityManager()?.threadGroup ?: Thread.currentThread().threadGroup

    // 线程数
    private val threadCount = AtomicInteger(0)

    // 线程名
    private val name = "$name-${factoryCountMap[name]!!.addAndGet(1)}-thread-"

    override fun newThread(r: Runnable?): Thread {
        val name = "$name${threadCount.addAndGet(1)}"
        val thread = Thread(threadGroup, r, name, stackSize)
        // 取消守护线程
        if (thread.isDaemon)
            thread.isDaemon = false
        // 调整优先级为中等
        if (thread.priority != Thread.NORM_PRIORITY)
            thread.priority = Thread.NORM_PRIORITY
        return thread
    }

}