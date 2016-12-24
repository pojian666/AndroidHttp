import java.io.File;import java.io.FileInputStream;import java.io.FileOutputStream;import java.io.IOException;import java.io.InputStreamReader;import java.io.OutputStreamWriter;/** * Created by Yanye on 9/7/2016. */public class RWunite {    public boolean save(String data, String fp, String na) {        try {            File f = new File(fp, na);            if (f.exists()) {                f.delete();            } else {                File f2 = new File(fp);                f2.mkdirs();                f.createNewFile();            }            FileOutputStream fos = new FileOutputStream(f);            OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");            osw.write(data);            osw.flush();            fos.flush();            osw.close();            fos.close();        } catch (IOException e) {            e.printStackTrace();            return false;        }        return true;    }    public String load(String fp2, String na2) {        File f2 = new File(fp2, na2);        if (!f2.exists()) {            return "NoFile";        } else {            try {                FileInputStream fis = new FileInputStream(f2);                InputStreamReader isr = new InputStreamReader(fis, "utf-8");                char[] input = new char[fis.available()];                isr.read(input);                isr.close();                fis.close();                String result = new String(input);                return result;            } catch (IOException e) {                e.printStackTrace();                return "IOError";            }        }    }}
