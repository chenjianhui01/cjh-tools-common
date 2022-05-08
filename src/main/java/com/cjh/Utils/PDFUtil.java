package com.cjh.Utils;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import sun.plugin2.message.GetAppletMessage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: chenJianHui
 * @date: 2021/12/17 10:31
 */
public class PDFUtil {

    public static String extractImagesFromPDF(String fileName, String savePath) {
        String picUrl = null;
        try {
            // 读取本地的pdf文件
            PdfDocument pdf = new PdfDocument();
            pdf.loadFromFile("/Users/chenjianhui/Desktop/052002000211-55324530.pdf");

            // 获取到pdf中的图片
            int index = 0;
            //遍历PDF每一页

            for (int i= 0;i< pdf.getPages().getCount(); i ++){
                //获取PDF页面
                PdfPageBase page = pdf.getPages().get(i);
                //使用extractImages方法获取指定页上图片
                for (BufferedImage image : page.extractImages()) {
                    //指定输出图片名称
                    File output = new File( String.format("Image_%d.png", index++));
                    //将图片保存为PNG格式
                    ImageIO.write(image, "PNG", output);
                }
            }
            // 把图片上传到oss，生成一个链接
            return picUrl;
        } catch (Exception e) {
//            LOGGER.error("从pdf中获取图片出现异常!", e);
            System.out.println("从pdf中获取图片出现异常!");
        }
        return picUrl;
    }

    public void getPicture(String urlStr) throws Exception {

    }

    /**
     * dpi越大转换后越清晰，相对转换速度越慢
     */
    private static final Integer DPI = 100;

    /**
     * 转换后的图片类型
     */
    private static final String IMG_TYPE = "png";

    /**
     * PDF转图片
     *
     * @param fileContent PDF文件的二进制流
     * @return 图片文件的二进制流
     */
    public static List<byte[]> pdfToImage() throws IOException {
        List<byte[]> result = new ArrayList<>();
        File file = new File("/Users/chenjianhui/Desktop/052002000211-55324530.pdf");
//        Files.getfile
        byte[] readAllBytes = Files.readAllBytes(file.toPath());
        try (PDDocument document = PDDocument.load(readAllBytes)) {
            PDFRenderer renderer = new PDFRenderer(document);
            for (int i = 0; i < document.getNumberOfPages(); ++i) {
                BufferedImage bufferedImage = renderer.renderImageWithDPI(i, DPI);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, IMG_TYPE, out);
                result.add(out.toByteArray());
            }
        }
        return result;
    }

    public void getPicture() {

    }


    public static void pdf2p() {
        File file = new File("/Users/chenjianhui/Desktop/052002000211-55324530.pdf");
        try {
            PDDocument doc = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for(int i=0; i<pageCount; i++){
                BufferedImage image = renderer.renderImage(i, 2.5f);
//           BufferedImage image = renderer.renderImageWithDPI(i,296);
                ImageIO.write(image,"PNG",new File("/Users/chenjianhui/Desktop/"+i+".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
