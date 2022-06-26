package cc.xiaobaicz.xtv.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import cc.xiaobaicz.xtv.ui.AppActivity
import kotlinx.coroutines.delay

class SplashViewModel : BaseViewModel() {

    /**
     * 页面初始化初始化
     */
    suspend fun onInit(context: Context) {
        delay(3000L)
    }

    /**
     * 跳转到首页
     */
    fun onGotoMainPage(activity: Activity) {
        val intent = Intent(activity, AppActivity::class.java)
        activity.startActivity(intent)
    }

}