package com.gwm.sweethouse.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CheckCodeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置content-type消息头，告诉浏览器， 
        //返回的数据类型 
        response.setContentType("image/jpeg"); 
        // 图片的内存映像 
        BufferedImage image = 
            new BufferedImage(60, 20, 
                BufferedImage.TYPE_INT_RGB); 
        // 获得画笔对象 
        Random r = new Random(); 
        Graphics g = image.getGraphics(); 
        g.setColor( 
                new Color(r.nextInt(255), 
                        r.nextInt(255), r.nextInt(255))); 
        g.fillRect(0, 0, 60, 20); 
        g.setColor(new Color(0,0,0)); 
        String number = String.valueOf( 
                r.nextInt(99999)); 
        HttpSession session=request.getSession();
        session.setAttribute("number",number);
        g.drawString(number, 5, 15); 
 
        // 压缩成jpeg格式 
        OutputStream os = response 
        .getOutputStream(); 
        JPEGImageEncoder encoder = 
            JPEGCodec.createJPEGEncoder(os); 
        // 把BufferedImage对象中的图像信息编码后 
        // 向创建该对象(encoder)时指定的输出流输出 
        encoder.encode(image); 
	}
}
