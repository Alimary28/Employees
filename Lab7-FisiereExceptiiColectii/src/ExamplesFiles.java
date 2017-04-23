import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
/**
 * Created by Vaio on 20.11.2016.
 */
public class ExamplesFiles {
    private void newStyle () throws IOException{

        Path path = Paths.get(".","password.txt");

        Charset charset = Charset.forName("UTF-8");

        List<String> lines = Files.readAllLines(path,charset);

        for(String str : lines){
            System.out.println(str);
        }


               /* sau ca si mai jos cu un for normal */
//        for(int i =0;i<lines.size();i++) {
//            System.out.println(lines.get(i));
//        }
    }

    /* acelasi lucru in versiuni mai vechi de java, de pe vremea lui Ionel :) */
    private void  oldStyleReadFIle() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("passwords.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } catch (Exception io) {
            io.printStackTrace();
        } finally {

            try {
                if(br!=null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        ExamplesFiles ef = new ExamplesFiles();
        // ef.oldStyleReadFIle();

        try {
            ef.newStyle();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
