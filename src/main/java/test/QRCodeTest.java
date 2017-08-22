package test;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class QRCodeTest {
    public static void main(String[] args) {
        File file = new File("D:\\qrtest\\myQRCcode.jpg");
        ByteArrayOutputStream arrayOutputStream = QRCode.from("Alimjan Tursun Turdi").to(ImageType.GIF).stream();
        byte[] bytes = arrayOutputStream.toByteArray();
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
