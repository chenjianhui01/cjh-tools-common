package com.cjh;

import com.cjh.Utils.DictUtil;
import com.cjh.Utils.TimeUtils;
import com.cjh.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("查询的小时个数为：" + hour);
    }

    @Test
    public void FileReadTest() {
//        Map<String, String> map = DictUtil.getSmsFailReasonCodeMap();
//        System.out.println(map);

        Map<String, String> smsFailReasonCodeMap;
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(DictUtil.class.getResourceAsStream("/dict/sms_fail_reason.txt"))))  {
            String line;
            smsFailReasonCodeMap=new HashMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() < 1) {
                    continue;
                }
                String[] items = line.trim().split(" ");
                if (items.length == 2) {
                    smsFailReasonCodeMap.put(items[0], items[1]);
                }
            }
        }catch (IOException e) {
            throw new RuntimeException("Error occurred wile loading SMS_FAIL_REASON_CODE_MAP. ", e);
        }
        System.out.println(smsFailReasonCodeMap);

    }
    @Test
    public void Test1129() {
        Long a = 2L;
        Long sum = 1L;
        sum += a != null? a:0L;
        System.out.println(sum);
    }

}
