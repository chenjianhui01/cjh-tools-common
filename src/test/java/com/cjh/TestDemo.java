package com.cjh;

import com.cjh.Utils.DictUtil;
import com.cjh.Utils.PDFUtil;
import com.cjh.Utils.TimeUtils;
import com.cjh.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Test
    public void Test001() throws IOException {
        PDFUtil.extractImagesFromPDF(null, null);
//        String fileName = "test.png";
//        List<byte[]> getDatas = PDFUtil.pdfToImage();
//        for (byte[] getData:getDatas) {
//            File saveDir = new File("/Users/chenjianhui/Desktop");
//            if (!saveDir.exists()) {
//                saveDir.mkdir();
//            }
//            File file = new File(saveDir + File.separator + fileName);
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(getData);
//            if (fos != null) {
//                fos.close();
//            }
//        }
//
////        if (inputStream != null) {
////            inputStream.close();
////        }
    }

    @Test
    public void Test002() throws IOException {
        PDFUtil.pdf2p();
        try {
            File srcFile = new File("/Users/chenjianhui/Desktop/052002000211-55324530.pdf");
            PDDocument document = PDDocument.load(srcFile);
            PDFRenderer renderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); page++) {
                BufferedImage image = renderer.renderImageWithDPI(page, 300, ImageType.RGB);
//                String savename = "Users/chenjianhui/Desktop/" + "asdf" + "_" + page + ".png";
//                ImageIOUtil.writeImage(image, savename, 300);
                ImageIO.write(image,"PNG",new File("/Users/chenjianhui/Desktop/"+"dfdf"+".png"));
            }
            document.close();
        } catch (Exception e) {

        }

    }



}
