package ordersmanagement.controllers;

import ordersmanagement.models.notifications.Notification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("notifications")
public class NotificationsController {
    // TODO: HOW TO ACCESS REPOSITORY EVEN THOUGH ITS INITIALISED IN DISPATCHER
    @GetMapping("/getNotificationsQueue")
    ArrayList<Notification> getQueueContents(){
        return new ArrayList<>();
    }
}
