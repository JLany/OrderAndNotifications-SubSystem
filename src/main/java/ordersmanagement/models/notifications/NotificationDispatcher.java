package ordersmanagement.models.notifications;
import ordersmanagement.repositories.NotificationRepository;
import ordersmanagement.repositories.NotificationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// responsible for all statistics whether in-queue or out of queue
public class NotificationDispatcher {
    NotificationQueue notificationQueue;
    NotificationRepository notificationRepository;

    // Add to queue
    public void dispatchNotification(Notification notification){
        notificationRepository.save(notification);
        notificationQueue.addToQueue(notification);
    }

    public ArrayList<Notification> getContentsOfQueue(){
        return notificationQueue.getQueueContents();

    }
    public String getMostNotifiedEmail(){
        ArrayList<Notification> currentNotifications = (ArrayList<Notification>) notificationRepository.findAll();
        Map<String, Integer> emailCount = new HashMap<>();
        int size = currentNotifications.size();
        for (int i = 0; i < size; i++){
            if (currentNotifications.get(i) instanceof EmailNotification){
                String email = ((EmailNotification) currentNotifications.get(i)).getEmail();
                emailCount.put(email, emailCount.getOrDefault(email, 0)+1);
            }
        }

        String mostUsedEmail = null;
        int maxCount = 0;
        for (Map.Entry<String , Integer> entry:emailCount.entrySet()){
            if (entry.getValue()>maxCount){
                maxCount = entry.getValue();
                mostUsedEmail = entry.getKey();
            }
        }
        return mostUsedEmail;
    }

    public String getMostNotifiedPhoneNumber(){
        ArrayList<Notification> currentNotifications = (ArrayList<Notification>) notificationRepository.findAll();
        Map<String, Integer> phoneCount = new HashMap<>();
        int size = currentNotifications.size();
        for (int i = 0; i < size; i++){
            if (currentNotifications.get(i) instanceof SMSNotification){
                String phoneNumber = ((SMSNotification) currentNotifications.get(i)).getPhoneNumber();
                phoneCount.put(phoneNumber, phoneCount.getOrDefault(phoneNumber, 0)+1);
            }
        }

        String mostUsedPhoneNumber = null;
        int maxCount = 0;
        for (Map.Entry<String , Integer> entry:phoneCount.entrySet()){
            if (entry.getValue()>maxCount){
                maxCount = entry.getValue();
                mostUsedPhoneNumber = entry.getKey();
            }
        }
        return mostUsedPhoneNumber;
    }
    public String getMostUsedTemplate(){
        return "test";
    }
}
