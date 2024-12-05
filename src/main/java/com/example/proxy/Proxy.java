package com.example.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSONObject;
import com.example.annotation.Retry;
import com.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Proxy {
    @Retry(maxAttempt = 3, interval = 5000)
    public List<User> queryDataList(int i, String queryUrl, String token, int pageNum, Log log) {
        String result = HttpRequest
                .get(queryUrl)
                .header("X-Token", token)
                .form("page", i)
                .form("limit", pageNum)
                .execute()
                .body();
        JSONObject resultJsonObject = JSONObject.parseObject(result);
        int status = resultJsonObject.getIntValue("status");
        if (status != 200) {
            log.error(resultJsonObject.getString("message"));
        }
        return resultJsonObject.getJSONObject("data").getJSONArray("list").toJavaList(User.class);
    }
}
