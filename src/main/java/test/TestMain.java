package test;


import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class TestMain {
    public static void main(String[] args) {
//        String sql = TableUtils.getCreateTableSQL(Administrator.class);
//        System.out.println(sql);
        File file = new File("D:\\qrtest\\hello.jpg");
        ByteArrayOutputStream arrayOutputStream2 = QRCode.from("Hello World").to(ImageType.PNG).stream();
       byte[] bytes= arrayOutputStream2.toByteArray();
        try {
//            String string = "Hello Alimjan";
//            bytes = string.getBytes();
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}