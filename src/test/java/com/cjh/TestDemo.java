package com.cjh;

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
        System.out.println("Hello world");
    }

}
