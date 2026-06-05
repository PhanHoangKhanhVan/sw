import com.system.model.*;
import com.system.service.*;

public class Main {
    public static void main(String[] args) {
        SubscriptionManager manager = new SubscriptionManager();

        Website testSite = new Website();
        testSite.url = "vgu.edu.vn";
        testSite.oldContent = "Version 1";
        testSite.currentContent = "Version 12";

        //Tạo ra một người nhận thông báo qua Email cụ thể
        SMSNotification smsMe = new SMSNotification();
        smsMe.SMS = "1234";

        //Gắn người nhận này vào danh sách theo dõi của Website
        testSite.attach(smsMe); 


        // Người dùng chọn chiến lược so sánh HTML
        testSite.setStrategy(new CompareHtmlContent()); 

        manager.addWebsite(testSite);
        manager.checkUpdates(); // Hệ thống sẽ chạy và tự động so sánh theo kiểu HTML!
    }
}