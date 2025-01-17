package com.example.designpatternstate.matter;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActivityService {
    
    private static Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<>();

    public static void init(String activityId, Enum<Status> status) {
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);   
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setStatus(status);
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        statusMap.put(activityId, status);
    }

    public static ActivityInfo queryActivityInfo(String activityId) {
        // 模拟查询活动信息
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setStatus(statusMap.get(activityId));
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        return activityInfo;
    }

    public static Enum<Status> queryActivityStatus(String activityId) {
        return statusMap.get(activityId);
    }
    
    public static synchronized void execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(activityId))) return;
        statusMap.put(activityId, afterStatus);
    }
}
