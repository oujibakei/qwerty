package com.bestdata.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

/**
 * 发送短信相关业务
 *
 * @author chenyuanheng
 * @version 1.0
 */
@Slf4j
@Component
@SpringBootTest
public class ALiShortMessageUtil {

    @Value("${short-message.sms-accesskey-id}")
    private String accesskeyId ;
    @Value("${short-message.sms-accesskey-secret}")
    private String accesskeySecret ;
    @Value("${short-message.sms-template-id}")
    private String templateId ;

    /**
     * 发送短信相关业务
     *
     * @author chenyuanheng
     * @version 1.0
     */
    @Test
    public void sendSms() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accesskeyId, accesskeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        // 电话号
        request.putQueryParameter("PhoneNumbers", "15040172875");
        // 短信签名
        request.putQueryParameter("SignName", "系统");
        request.putQueryParameter("TemplateCode", templateId);
        request.putQueryParameter("TemplateParam", "{\"name\":\"" + "好好" + "\"}");

//        request.putQueryParameter("PhoneNumbers", phone);
//        request.putQueryParameter("SignName", signName);// 理论上 可配置
//        request.putQueryParameter("TemplateCode", temlateCode);
//        request.putQueryParameter("TemplateParam", "{\"name\":\"" + content + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info(response.getData());
//            return response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


}
