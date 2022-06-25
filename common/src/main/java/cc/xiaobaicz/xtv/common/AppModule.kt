package cc.xiaobaicz.xtv.common

import android.app.Application

/**
 * App模块，用于模块间初始化
 *
 * 通过配置 Application MetaData 进行模块间初始化（<meta-data android:name="className" value="AppModule"/>）
 */
interface AppModule {
    /**
     * 模块名
     */
    val name: String

    /**
     * 模块初始化，由BaseApp调用
     * @see CommonRegister
     */
    fun onInitialization(app: Application)
}