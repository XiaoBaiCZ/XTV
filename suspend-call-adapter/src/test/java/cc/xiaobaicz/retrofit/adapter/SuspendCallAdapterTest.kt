package cc.xiaobaicz.retrofit.adapter

import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET

class SuspendCallAdapterTest {

    interface Api {
        @GET("/")
        fun index(): SuspendCall<ResponseBody>
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.baidu.com/")
        .addCallAdapterFactory(SuspendCallAdapterFactory())
        .build()

    @Test
    fun testSuspendCallAdapter() {
        runBlocking {
            val api = retrofit.create<Api>()
            val (data, throwable) = api.index().call()
            if (throwable != null) {
                throwable.printStackTrace()
                return@runBlocking
            }
            data?.apply {
                println(data.string())
            }
        }
    }

}