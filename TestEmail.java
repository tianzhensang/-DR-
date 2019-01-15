package test;

//需要导入三个包
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;

public class TestEmail {

    @Test
    public void testSendEmail(){
        HtmlEmail email=new HtmlEmail();
		//编码方式，防止网络经浏览器传送后乱码
        email.setCharset("UTF-8");
		//设置邮箱服务器   smtp表示简单传输协议 163可变
        email.setHostName("smtp.163.com");
		//设置登录邮箱的账户名和授权码
        email.setAuthentication("neusoft5566","abcd5566");
        try {
			//发送方
            email.setFrom("neusoft5566@163.com");
			//接收方
            email.addTo("daimi5566@126.com");
			//邮件的标题
            email.setSubject("提示");
			//邮件的正文
            email.setHtmlMsg("<a href='http://www.baidu.com'>dddddd</a>");
			//发送邮件
            String msg=email.send();
            System.out.println(msg);
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
