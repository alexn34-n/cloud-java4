package io;

import java.io.*;
import java.net.URISyntaxException;

public class IoUtils {
    public static void main(String[] args) throws URISyntaxException, IOException {
      //  File file=new File(IoUtils.class.getResource("cloud_feb.fxml").toURI());
      //  System.out.println(file);
     //   System.out.println(file.exists());

        //File f1=new File("1.txt");
       // File copy=new File("data/1.txt");

        File f1=new File("logo.gif");
        File copy=new File("data/logo.gif");

        System.out.println(f1.exists());
        System.out.println(copy.exists());
        InputStream is=new FileInputStream(f1);
        OutputStream os=new FileOutputStream(copy,true);
        int ptr=0;
        byte [] buffer=new byte[8192];// сократить время запроса
        while ((ptr= is.read(buffer))!=-1) {
            os.write(buffer,0,ptr);

        }
        os.close();
        is.close();
    }
}
