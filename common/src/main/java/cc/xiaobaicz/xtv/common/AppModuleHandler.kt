package cc.xiaobaicz.xtv.common

import android.app.Application
import android.content.pm.PackageManager

/**
 * App模块处理器
 */
internal class AppModuleHandler {

    /**
     * 模块初始化
     */
    internal fun moduleInitialization(app: Application) {
        val applicationInfo = app.packageManager.getApplicationInfo(app.packageName, PackageManager.GET_META_DATA)
        val metaData = applicationInfo.metaData ?: return
        val classLoader = app.classLoader
        metaData.keySet().forEach { key ->
            if (metaData[key] == "AppModule") {
                try {
                    val appModule = classLoader.loadClass(key).newInstance()
                    if (appModule is AppModule) {
                        appModule.onInitialization(app)
                    }
                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }
        }
    }

}