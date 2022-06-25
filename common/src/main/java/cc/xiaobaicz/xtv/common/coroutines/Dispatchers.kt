package cc.xiaobaicz.xtv.common.coroutines

import cc.xiaobaicz.xtv.common.lang.ThreadPools
import kotlinx.coroutines.asCoroutineDispatcher

/**
 * 协程分发器
 */
object Dispatchers {

    /**
     * IO 分发器
     */
    val io by lazy { ThreadPools.io.asCoroutineDispatcher() }

    /**
     * 任务队列 分发器
     */
    val single by lazy { ThreadPools.single.asCoroutineDispatcher() }

    /**
     * 工作 分发器
     */
    val work by lazy { ThreadPools.work.asCoroutineDispatcher() }

}