package servlet;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class QRCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String qrcodeContent = req.getParameter("qrcodecontent");
            ByteArrayOutputStream arrayOutputStream = QRCode.from(qrcodeContent).to(ImageType.JPG).stream();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("D:\\output.jpg"));
            // Put data in your baos
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
            objectOutputStream.writeObject(qrcodeContent);
            objectOutputStream.flush();
            objectOutputStream.close();
            arrayOutputStream.writeTo(fos);
            arrayOutputStream.flush();
            arrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/jsp/qrcode.jsp");
    }
}
