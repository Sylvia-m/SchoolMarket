package com.zjm.schoolmarket.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String basePath = ImageUtil.class.getClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //定义时间格式
    private static final Random r = new Random(); //随机对象
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将 CommonsMultipartFile 转换成 File 类
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IllegalStateException e) {
            logger.error(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 处理缩略图,并返回新生成图片的相对路径：门面照即商品小图
     *
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(File thumbnail, String targetAddr) {
        String realFailName = getRandomFileName();       //随机生成不重名文件
        String extension = getFileExtension(thumbnail);  //获取用户上传文件的扩展名（.jpg/.png）
        makeDirPath(targetAddr);  //创建目录
        String relativeAddr = targetAddr + realFailName + extension;//获取相对路径
        logger.debug("current relativeAddr is:" + relativeAddr);
        String finalPath = PathUtil.getImgBasePath() + relativeAddr;
        File dest = new File(finalPath);//新生成文件路径（相对路径+根路径）
        logger.debug("current complete addr is:" + finalPath);

        //创建缩略图
        try {
            Thumbnails.of(thumbnail).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "zjm.png")), 0.5f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return finalPath;
    }

    /*
     * 创建目标路径所涉及的路径
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdir();
        }
    }

    /*
     * 获取输入文件流的扩展名
     * @param thumbnail
     * @return
     */
    private static String getFileExtension(File cFile) {
        String originalFileName = cFile.getName();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /*
     * 生成随机文件名，当前年月时小时分钟秒钟+五位随机数
     * @return
     */
    public static String getRandomFileName() {
        //获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    //获取classpath的绝对值路径
    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File(basePath + "\\bawei.jpg")).size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "\\zjm.png")), 0.5f)
                .outputQuality(0.8f).toFile(basePath + "\\bawei.jpg");
    }


//    public static void main(String[] args) throws IOException {
//        ImageUtil.image("bawei.jpg","zjm.png");
//    }

//    static void image(String imageName,String waterMark) throws IOException {
//        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        Thumbnails.of(new File(basePath + "\\"+imageName)).size(200, 200)
//                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "\\"+waterMark)), 0.5f)
//                .outputQuality(0.8f).toFile(basePath + "\\"+imageName);
//    }
}
