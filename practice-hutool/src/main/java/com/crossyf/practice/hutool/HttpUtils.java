package com.crossyf.practice.hutool;
import cn.hutool.core.lang.Console;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.*;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by YangFan.
 * @date 2019/11/12
 * 功能:
 */
public class HttpUtils {

    public static void main(String[] args) {
        //HTTPUtil get post
        String result = HttpUtil.get("www.baidu.com");
//        Console.log(result);

        Map<String, Object> param = new HashMap<>();
        param.put("userName","admin11");
        param.put("passWd", "111111q");
        JSONObject jsonObject = JSONUtil.parseFromMap(param);
        String result2 = HttpUtil.post("http://127.0.0.1:83/guoxn-login-web/login",param);
        Console.log(result2);

        String jsonStr = JSONUtil.toJsonStr(jsonObject);
        String result3 = HttpRequest.post("http://127.0.0.1:83/guoxn-login-web/login").header(Header.CONTENT_TYPE,"application/json")
                .form(jsonStr).execute().body();
        Console.log(result3);

    }
}
