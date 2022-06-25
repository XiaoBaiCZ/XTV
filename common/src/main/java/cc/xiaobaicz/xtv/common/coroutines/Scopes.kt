package cc.xiaobaicz.xtv.common.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * 协程作用域
 */
object Scopes {

    /**
     * IO 作用域
     */
    val io get() = CoroutineScope(SupervisorJob() + Dispatchers.io)

    /**
     * 任务队列 作用域
     */
    val single get() = CoroutineScope(SupervisorJob() + Dispatchers.single)

    /**
     * 工作 作用域
     */
    val work get() = CoroutineScope(SupervisorJob() + Dispatchers.work)

}