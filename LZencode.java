import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class LZencode {

    public static void main(String[] args) {

    }

    public static void encode() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fis = null;
        BufferedWriter writer = null;
        FileWriter fw = null;
        String fileName = "output";

        byte[] buffer = new byte[System.in.available()];
        try {
            int bytesRead;
            while ((bytesRead = System.in.read(buffer)) > 0) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] bytes = baos.toByteArray();

            for (int i = 0; i < bytes.length; i++) {
                System.out.println(i);
            }

        } catch (Exception x) {
            System.err.println(x);
            x.printStackTrace();
        }

    }
}