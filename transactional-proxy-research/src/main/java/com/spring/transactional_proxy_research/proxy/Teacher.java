package com.spring.transactional_proxy_research.proxy;

import java.util.Date;

public class Teacher {
    public static void main(String[] args) {
        DailySession dailySession = new StudentProxy(new Attendance(new Date(), true));
        dailySession.attendLesson();
    }
}
