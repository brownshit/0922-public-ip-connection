import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class public_ip_get {
    public static String get_ip(String Address){

        URL url;
        BufferedReader br = null;
        HttpURLConnection conn;
        String protocol = "GET";

        try {
            url = new URL(Address);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(protocol);
            //MS949
            //UTP-8
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        String line = "0000";
        while(true){
            try {
                if (!((line = br.readLine()) != null)) break;
                //br은 버퍼 리드 인스턴스이다.
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(line);
            String public_ip = "http://"+line+":3000/";
            /**
             * System.out.println(line);
             * System.out.println(line.getClass().getName());
             * **/
            System.out.println(public_ip);
        }
        //System.out.println(br.readLine());
        return line;
    }
    public static void main(String[] args) {
        String mainline = get_ip("https://api.ip.pe.kr/");
        System.out.println(mainline);
    }
}

