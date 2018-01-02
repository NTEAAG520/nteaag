package servlet;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class QRCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String qrcodeContent = req.getParameter("qrcodecontent");
            ByteArrayOutputStream arrayOutputStream = QRCode.from(qrcodeContent).to(ImageType.JPG).stream();
            resp.setContentLength(arrayOutputStream.size());
            OutputStream outputStream = resp.getOutputStream();
            outputStream.write(arrayOutputStream.toByteArray());
            arrayOutputStream.flush();
            arrayOutputStream.close();
    }
}
