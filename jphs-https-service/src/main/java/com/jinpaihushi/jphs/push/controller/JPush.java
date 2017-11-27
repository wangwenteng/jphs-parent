package com.jinpaihushi.jphs.push.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

@Controller
@RequestMapping("/push")
public class JPush {

    //    #用户端的appkey
    @Value("${user_appKey}")
    private String urse_appKey = "29b0358d39b65c2dae9e1bd7";

    @Value("${user_masterSecret}")
    private String urse_masterSecret = "1f35098ecdfc32eea6e2a2b7";

    //极光推送技术难题解决：http://blog.163.com/lujun19888@126/blog/static/30821972201531011362680/
    @Value("${Jpush}")
    private String Jpush = "false";

    public static void main(String[] args) {
        //发送通知
        try {
            //new JPush().jpushTag("您有新的消息123", "18315915926", "00");
            //            new JPush().jpushTag("您有新的消息123", "15210452542", "00");
            new JPush().jpushTag("您有新的消息123123---11100011---", "43382", "00");
            //            new JPush().jpushTag("您有新的消息123123---111010", "43246", "00");
            //new JPush().jpushTag("您有新的消息123", "18605442910", "00");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //new JPush().jpushAlias("您有新的消息1234", "123456", "00");

    }

    /**
     * 发送通知--个推
     * 
     * @param registrationId
     *            设备标识
     * @param alert
     *            推送内容
     */
    @RequestMapping("/push.json")
    @SuppressWarnings("deprecation")
    public void jpushTag(String alert, String tag, String type) throws Exception {

        System.out.println("alert:" + alert);
        System.out.println("tag:" + tag);
        JPushClient jpushClient = new JPushClient(urse_masterSecret, urse_appKey, 3);
        PushPayload payload = null;
        payload = send_NTag(tag, alert, type);
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println(result);

        }
        catch (APIConnectionException e) {
            System.out.println(e);

        }
        catch (APIRequestException e) {
            System.out.println(e);
            System.out.println("Error response from JPush server. Should review and fix it. " + e);
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
            System.out.println("Msg ID: " + e.getMsgId());
        }
    }

    /**
     * 发送通知--群推
     * 
     * @param registrationId
     *            设备标识
     * @param alert
     *            推送内容
     * @return 
     */
    @SuppressWarnings("deprecation")
    public void jpushAlias(String alert, String alias, String type) {

        System.out.println("alert:" + alert);
        System.out.println("alias:" + alias);

        JPushClient jpushClient = new JPushClient(urse_masterSecret, urse_appKey, 3);
        PushPayload payload = null;

        payload = send_NAlias(alias, alert, type);
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println(result);

        }
        catch (APIConnectionException e) {
            System.out.println(e);
        }
        catch (APIRequestException e) {
            System.out.println(e);
            System.out.println("Error response from JPush server. Should review and fix it. " + e);
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
            System.out.println("Msg ID: " + e.getMsgId());
        }
    }

    /**
     * @param alias
     * @param alert
     * @return
     */
    public PushPayload send_NTag(String tag, String alert, String type) throws Exception {
        boolean b = false;
        if (Jpush.equals("true") || Jpush == "true")
            b = true;

        return PushPayload.newBuilder().setPlatform(Platform.android_ios())
                // 必填 推送平台设置
                // .setAudience(Audience.registrationId(registrationId))
                //.setAudience(Audience.alias(alias))
                .setAudience(Audience.tag(tag))
                .setNotification(
                        Notification.newBuilder().setAlert(alert)
                                .addPlatformNotification(AndroidNotification.newBuilder().setTitle("金牌护士")
                                        .addExtra("type", type).build())
                                .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).setSound("sound")
                                        .addExtra("type", type).build())
                                .build())

                /**
                 * 如果目标平台为 iOS 平台 需要在 options 中通过 apns_production 字段来制定推送环境。
                 * True 表示推送生产环境，False 表示要推送开发环境； 如 果不指定则为推送生产环境
                 */
                .setOptions(Options.newBuilder().setApnsProduction(b).build()).build();
    }

    /**
     * @param alias
     * @param alert
     * @return
     */
    public PushPayload send_NAlias(String alias, String alert, String type) {
        boolean b = false;
        if (Jpush.equals("true") || Jpush == "true")
            b = true;

        return PushPayload.newBuilder().setPlatform(Platform.android_ios())
                // 必填 推送平台设置
                // .setAudience(Audience.registrationId(registrationId))
                .setAudience(Audience.alias(alias))
                .setNotification(
                        Notification.newBuilder().setAlert(alert)
                                .addPlatformNotification(AndroidNotification.newBuilder().setTitle("金牌护士")
                                        .addExtra("type", type).build())
                                .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).setSound("sound")
                                        .addExtra("type", type).build())
                                .build())
                /**
                 * 如果目标平台为 iOS 平台 需要在 options 中通过 apns_production 字段来制定推送环境。
                 * True 表示推送生产环境，False 表示要推送开发环境； 如 果不指定则为推送生产环境
                 */
                .setOptions(Options.newBuilder().setApnsProduction(b).build()).build();
    }

}
