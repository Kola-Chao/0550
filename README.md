### 项目基础技术和内容介绍
- 使用Rxjava + Retrofit + OkHttp 的网络请求框架。包括了请求的加载框、加载框被取消或者Act被destroy时自动取消请求防止报view空指针、请求数据的缓存处理（有网络时和没网络时）没网络时在有效期内自动加载缓存数据。有网络时默认自动缓存 可自定义该请求是否缓存
- 使用了lottie来实现一些非常炫酷的效果（没有json文件，目前只是实现了官方提供的效果）
- 项目中也用到了Bmob来做后台请求（了解用）
- 同时也用到了一些常用的优秀开源框架 ORM :GreenDao  注解 ：butterknife
