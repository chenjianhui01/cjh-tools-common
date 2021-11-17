package com.cjh;

import com.cjh.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
