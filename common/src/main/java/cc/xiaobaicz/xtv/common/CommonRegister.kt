package cc.xiaobaicz.xtv.common

import android.app.Application

/**
 * 基础模块统一注册
 *
 * @see AppModule
 */
object CommonRegister {

    @JvmStatic
    fun register(app: Application) {
        AppModuleHandler().moduleInitialization(app)
    }

}