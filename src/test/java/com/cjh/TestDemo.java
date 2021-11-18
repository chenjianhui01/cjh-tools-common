package com.cjh;

import com.cjh.Utils.TimeUtils;
import com.cjh.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description:
 * @author: chenJianHui
 * @date: 2021/11/15 16:01
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestDemo.class)
public class TestDemo {

    @Test
    public void HelloTest() {
        log.info("日志：Hello world");
        System.out.println("Hello world");
    }

    @Test
    public void StudentTest() {
        Student student = new Student();
        student.setName("cjh");
        System.out.println(student.toString());
    }

    @Test
    public void TimeTest() throws ParseException {
        Date from = TimeUtils.stringTimeFormat("2021-10-11 12:23:54");
        System.out.println(from);
        Date to = TimeUtils.stringTimeFormat("2021-10-11 20:23:54");
        System.out.println(to);
        long gap = to.getTime() - from.getTime();
        long hour = gap / (60 * 60 * 1000) + 1;
        System.out.println(hour);
    }

}
