package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class validateCode extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        req.setCharacterEncoding("UTF-8");
        //[1]创建空白图片
        BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        //[2]获取图片画笔
        Graphics graphics = image.getGraphics();
        Random random = new Random();
        //[3]设置画笔颜色
        graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        //[4]绘制矩形的背景
        graphics.fillRect(0, 0, 100, 30);
        //[5]调用自定义的方法，获取长度为5的字母数字组合的字符串
        String number = getNumber(5);
        HttpSession session = req.getSession();
        session.setAttribute("code", number);
        graphics.setColor(new Color(0, 0, 0));
        graphics.setFont(new Font(number, Font.BOLD, 24));
        //[6]设置颜色字体后，绘制字符串
        graphics.drawString(number, 5, 25);
        //[7]绘制8条干扰线
        for (int i = 0; i < 8; i++) {
            graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            graphics.drawLine(random.nextInt(100), random.nextInt(30), random.nextInt(100), random.nextInt(30));
        }
        OutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        outputStream.close();
    }

    public String getNumber(int size) {
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String number = "";
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            number += string.charAt(random.nextInt(string.length()));
        }
        return number;
    }
}
