package com.test.module.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.common.io.FileUtils;
import com.test.module.domain.User;

public class FastJsonTest {
    public static void main(String[] args) {
        String jsonText = FileUtils.fileToString("test-module/src/main/resources/user.json");
        JSONObject jsonObject = JSON.parseObject(jsonText);
        System.out.println(jsonObject);
        User user = JSON.parseObject(jsonText, User.class);
        System.out.println(user);
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        // String jsonText = FileUtils.fileToString("test-module/src/main/resources/userArray.json");
        // JSONArray array = JSON.parseArray(jsonText);
        // System.out.println(array);

    }
}
