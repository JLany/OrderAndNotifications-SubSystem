package ordersmanagement.controllers;

import ordersmanagement.models.notifications.Notification;
import ordersmanagement.utility.NotificationDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/notifications")
public class NotificationsController {
    private final NotificationDispatcher notificationDispatcher;

    @Autowired
    public NotificationsController(NotificationDispatcher notificationDispatcher){
        this.notificationDispatcher = notificationDispatcher;
    }
    @GetMapping("/getNotificationsQueue")
    List<Notification> getQueueContents(){
        return notificationDispatcher.getContentsOfQueue();
    }

    @GetMapping("/getMostNotifiedEmail")
    String getMostNotifiedEmail(){
        return notificationDispatcher.getMostNotifiedEmail();
    }

    @GetMapping("/getMostNotifiedPhoneNumber")
    String getMostNotifiedPhoneNumber(){
        return notificationDispatcher.getMostNotifiedPhoneNumber();
    }

    @GetMapping("/getMostUsedTemplate")
    String getMostUsedTemplate(){
        return notificationDispatcher.getMostUsedTemplate();
    }
}
