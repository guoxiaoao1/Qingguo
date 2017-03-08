package com.qingguo;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by lyt on 2016/12/8.
 */

public class Tools {
    public static boolean check(String userName, String userPassword,String serverAddress) {
        String path="http://"+serverAddress+":8180/qingguo/login.do";
        //将用户名和密码放入HashMap中
        Map<String,String> params=new HashMap<String,String>();
        params.put("userName", userName);
        params.put("passWord", userPassword);
        try {
            return sendGETRequest(path,params,"UTF-8");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public static boolean register(String createUserName, String createUserPassword,String serverAddress){
        String path="http://"+serverAddress+":8180/qingguo/register.do";
        Map<String,String> params=new HashMap<String,String>();
        params.put("createUserName", createUserName);
        params.put("createUserPassword", createUserPassword);
        try {
            return sendGETRequest(path,params,"UTF-8");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }


    public static int getnumber(String serverAddress) {
        String path="http://"+serverAddress+":8180/qingguo/getnumber.do";
        //将用户名和密码放入HashMap中


        try {
            return sendGETRequestInt(path,"UTF-8");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;

    }

    public static String getmethods(String serverAddress,String methods,String nunberName) {
        String path="http://"+serverAddress+":8180/qingguo/"+methods+".do";
        try {
            return sendGETRequestJSON(path,nunberName,"UTF-8");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "timeout";

    }


    private static boolean sendGETRequest(String path, Map<String, String> params,String encode) throws MalformedURLException, IOException {
        StringBuilder url=new StringBuilder(path);
        url.append("?");
        for(Map.Entry<String, String> entry:params.entrySet())
        {
            url.append(entry.getKey()).append("=");
            url.append(URLEncoder.encode(entry.getValue(),encode));
            url.append("&");
        }
        //删掉最后一个&
        url.deleteCharAt(url.length()-1);
        /*HttpURLConnection conn=(HttpURLConnection)new URL(url.toString()).openConnection();*/

        HttpURLConnection conn=(HttpURLConnection)new URL(url.toString()).openConnection();

        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        Boolean bool=false;
        if(conn.getResponseCode()==200)
        {
            InputStream is = conn.getInputStream();
            bool= NetUtils.readString(is).equals("true")?true:false;
        }
        return bool;
    }



    private static int sendGETRequestInt(String path,String encode) throws MalformedURLException, IOException {

        HttpURLConnection conn=(HttpURLConnection)new URL(path).openConnection();

        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        String number="0";
        if(conn.getResponseCode()==200)
        {
            InputStream is = conn.getInputStream();
            number= NetUtils.readString(is);
        }
        return Integer.valueOf(number).intValue();
    }

    private static String sendGETRequestJSON(String path,String numberName,String encode) throws MalformedURLException, IOException {

        StringBuilder url=new StringBuilder(path);

        if (!numberName.equals("")){
            Map<String,String> params=new HashMap<String,String>();
            params.put("numberName", numberName);

            url.append("?");
            for(Map.Entry<String, String> entry:params.entrySet())
            {
                url.append(entry.getKey()).append("=");
                url.append(URLEncoder.encode(entry.getValue(),encode));
                url.append("&");
            }
            //删掉最后一个&
            url.deleteCharAt(url.length()-1);
        }

        HttpURLConnection conn=(HttpURLConnection)new URL(url.toString()).openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        String reader="";
        if(conn.getResponseCode()==200)
        {
            InputStream is = conn.getInputStream();
            reader = NetUtils.readString(is);
        }
        return reader;
    }


}
