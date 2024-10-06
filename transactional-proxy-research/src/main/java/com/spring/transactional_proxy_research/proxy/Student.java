package com.spring.transactional_proxy_research.proxy;

public class Student implements DailySession{

    private Attendance attendance;

    public Student() {
    }

    public Student(Attendance attendance) {
        this.attendance = attendance;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    @Override
    public void attendLesson() {
        System.out.println("Attending the session...");
    }

    @Override
    public void attendLesson(Integer id) {
        System.out.println("Student with id " + id + " attending the session");
    }
}
