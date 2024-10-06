package com.spring.transactional_proxy_research.dynamicproxy;

import com.spring.transactional_proxy_research.proxy.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        Class<?> studentInfo = Class.forName("com.spring.transactional_proxy_research.proxy.Student");
//
//        Constructor<?>[] constructors = studentInfo.getConstructors();
//        for(Constructor constructor : constructors) {
//            System.out.println(constructor);
//        }
//        Method[] declaredMethods = studentInfo.getDeclaredMethods();
//        for(Method mthd : declaredMethods) {
//            System.out.println(mthd);
//        }
        Class<?> studentInfo = Student.class;
        Student student = (Student) studentInfo.newInstance();
        Class[] methodArgsType = new Class[] {Integer.class};
        Method attendLesson = studentInfo.getDeclaredMethod("attendLesson", methodArgsType);
        attendLesson.invoke(student, 101);

        Method attendLesson1 = studentInfo.getDeclaredMethod("attendLesson");
        attendLesson1.invoke(student, null);
    }
}
