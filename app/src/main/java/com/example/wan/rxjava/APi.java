package com.example.wan.rxjava;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;



/**
 * Created by wan on 2018/1/7.
 */

public interface APi {
    //get请求   使用@Query修饰参数
    @GET("user/login")
    Observable<Databean> login(@Query("mobile") String mobile, @Query("password") String password);

//    @GET("user/login")
//    Call<LoginBean> addHead(@Header("mobile") String mobile, @Header("password") String password ());
//
//
//    @Headers({ "X-Foo: Bar",
//            "X-Ping: Pong"
//    })
//    Call<LoginBean> addHead(@Header("mobile") String mobile, @Header("password") String password ());


//    @GET("user/login")
//    Call<LoginBean> login( @QueryMap Map<String ,String>  map);


    //post请求
//    @FormUrlEncoded
//    @POST("user/login")
//    Call<ResponseBody> login(@Field("mobile") String mobile, @Field("password") String password);


    //post请求
//    @FormUrlEncoded
//    @POST("user/login")
//    Call<LoginBean> login(@Field("mobile") String mobile, @Field("password") String password);


    //url，请求一个不同于baseurl的链接
//    @GET
//    Call<LoginBean> login(@Url String password);

    //path 占位符，用来动态拼接url，   参数拼接到  {name}  的地方
//     @GET("/{id}/{name}")
//    Call<ResponseBody> encoded(@Path("id") String id, @Path("name") String name);


    //文件上传方法一
//    @Multipart
//    @POST("file/upload")
//    Call<ResponseBody> uploadImage(@Query("uid") String uid, @Part("file") RequestBody requestBody);


    //方法一和方法二的区别是，方式一把key放到了 @Part("file")中，方式二把key封装到了MultipartBody.Part 中
    //其实本质上还是用的RequestBody， 而RequestBody封装了文件格式和文件 （文件格式是 MediaType0

    //文件上传方法二
//    @Multipart
//    @POST("file/upload")
//    Call<ResponseBody> uploadImageTwo(@Query("uid") String uid, @Part MultipartBody.Part part);
}
