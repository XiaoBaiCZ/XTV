package cc.xiaobaicz.retrofit.adapter

data class Result<Data>(
    var data: Data? = null,
    var throwable: Throwable? = null,
)
