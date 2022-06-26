package cc.xiaobaicz.xtv.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import cc.xiaobaicz.xtv.R
import cc.xiaobaicz.xtv.viewmodel.SplashViewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : FragmentActivity() {

    private val model by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycleScope.launchWhenCreated {
            init()
        }
    }

    // 初始化
    private suspend fun init() {
        model.onInit(this@SplashActivity)
        model.onGotoMainPage(this@SplashActivity)
        finish()
    }

}