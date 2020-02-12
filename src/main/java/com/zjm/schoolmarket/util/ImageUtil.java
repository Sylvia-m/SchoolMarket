package com.zjm.schoolmarket.util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	//获取classpath的绝对值路径	
	public static void main(String[] args) throws IOException {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		Thumbnails.of(new File("C:\\Users\\12614\\Desktop\\graduatioprogram\\images\\xiaohuangren.jpg")).size(200, 200)
		.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/zjm.png")),0.5f)
		.outputQuality(0.8f).toFile("C:\\Users\\12614\\Desktop\\graduatioprogram\\images\\xiaohuangrennew.jpg");
	}	
}
