package com.clone.whatsapp.Utils;

import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

public class SendNotification {



    //81. Create sendNotification function
    public SendNotification (String message, String heading, String notificationKey) {
        try {
            JSONObject notificationContent = new JSONObject(
                    "('contents':{'en':'" + message + "'},"+
                    "'include_player_ids': ['" + notificationKey + "']," +
                    "'headings': {'en': '" + heading + "'}");
            OneSignal.postNotification(notificationContent, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
