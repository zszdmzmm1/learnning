package day0707.postFetching;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Properties;

@AllArgsConstructor
@Getter
@Setter
public class ItemListElements {
    private String qqEmail;
    private String password; //授权码
    private String toEmail;


    public String getElementsString(List<Elements> itemlist){
        StringBuilder msg = new StringBuilder();
        for (Elements s : itemlist) {
            msg.append(s.html()).append("<br>").append(s.attr("abs:href")).append("<br>");
        }
        return msg.toString();
    }

    public void sentMessage(List<Elements> itemlist) {
        String msg = getElementsString(itemlist);
        try {
            getEmail("已发现：", msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void getEmail(String title, String msg) throws Exception {
        System.out.println("正在为您发送消息......");
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.qq.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(qqEmail, password);
            }
        });
        Message message = new MimeMessage(session);
        // who you are
        message.setFrom(new InternetAddress(qqEmail));
        // send to ...
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

        message.setSubject(title);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

        System.out.println("信息发送成功......");
    }
}