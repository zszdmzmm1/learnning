package day0707.fetchingsecondhandgoods;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Fetching {
    public static void main(String[] args) throws Exception {
        List<Elements> itemList = new ArrayList<>();
        int itemC = 0;
        Boolean isFirst = true;
        A:
        for(int i = 1 ;; i++){
            Document doc = Jsoup.connect("http://bbs.xmfish.com/thread-htm-fid-55-search-all-orderway-postdate-asc-DESC-page-" + i + ".html").get();
            Elements elements = doc.select("tr.tr3:has(a[title=开放主题])");

            File file = new File("src/main/java/day0707/fetchingsecondhandgoods/time.txt");
            byte[] bytes = new byte[1024];
            if(!file.exists()){
                file.createNewFile();
                OutputStream outputStream =new FileOutputStream(file);
                String sLocalDate = LocalDate.now().toString();
                bytes = sLocalDate.getBytes();
                outputStream.write(bytes);
                outputStream.close();
            }
            InputStream inputStream = new FileInputStream(file);
            inputStream.read(bytes);
            inputStream.close();
            String s = new String(bytes);
            for(Element e : elements){
                Elements item = e.select("a[class=subject_t f14]");
                Elements date = e.select("p");
                if(isFirst){
                    OutputStream outputStream = new FileOutputStream(file);
                    outputStream.write(date.html().split("<")[0].getBytes());
                    outputStream.close();
                    isFirst = false;
                }
                if(date.html().compareTo(s) >= 0){
                    System.out.println(item.html());
                    if(item.html().contains("转让")){
                        itemList.add(item);
                    }
                    itemC++;
                }else{
                    System.out.println(itemC);
                    break A;
                }

            }
        }
        Fetching.rebounce(itemList);
    }

    public static void rebounce(List<Elements> item) throws Exception {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.qq.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("**@qq.com", "ecwqgoayrhircagd");
            }
        });

        Message message = new MimeMessage(session);
        // who you are
        message.setFrom(new InternetAddress("from@qq.com"));
        // send to ...
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to@qq.com"));
        int size = item.size();
        message.setSubject("已找到" + size + "个匹配物品");
        String msg = "";
        for(Elements s: item) {
            msg = msg + "<br>" + s.html() + "</br>" + "<br>" + s.attr("abs:href") + "</br>";
        }
        MimeBodyPart mimeBodyPart = new MimeBodyPart();

        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

        System.out.println("Sent message successfully....");
    }
}
