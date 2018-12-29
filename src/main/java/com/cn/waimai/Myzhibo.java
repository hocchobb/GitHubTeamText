package com.cn.waimai;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Myzhibo {
    @GET("moreAnchor.android?&type=0&index=0")
    Call<JavaBean> getzhibo();
}
