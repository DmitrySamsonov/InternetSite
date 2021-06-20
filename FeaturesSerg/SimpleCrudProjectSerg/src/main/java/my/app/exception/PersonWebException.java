package my.app.exception;

import java.util.List;

public class PersonWebException extends RuntimeException {

    private List<String> messageList;



    public PersonWebException(List<String> messageList) {
        this.messageList = messageList;
    }

    public PersonWebException(String message) {
        super(message);
    }

    public PersonWebException() {
    }

    public List<String> getMessageList() {
        return messageList;
    }
}
