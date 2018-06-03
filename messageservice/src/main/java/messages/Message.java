package messages;
import java.util.Date;

/**
 * Created by 12 on 02.06.2018.
 */
public class Message {

    private final String messageId;
    private final String userId;
    private final String text;
    private final Date sendTime;

    public Message (String messageId, String userId, String text, Date sendTime){

        this.messageId = messageId;
        this.userId = userId;
        this.text = text;
        this.sendTime = sendTime;


    }

    public String getMessageId(){
        return messageId;
    }

    public String getUserId(){

        return userId;
    }

    public String getText(){
        return text;
    }

    public Date getSendTime(){

        return sendTime;

    }
}


