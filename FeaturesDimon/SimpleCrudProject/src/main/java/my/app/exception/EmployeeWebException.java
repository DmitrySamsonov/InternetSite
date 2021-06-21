package my.app.exception;

import java.util.List;

public class EmployeeWebException extends RuntimeException {

    private List<String> messageList;



    public EmployeeWebException(List<String> messageList) {
        this.messageList = messageList;
    }

    public EmployeeWebException(String message) {
        super(message);
    }

    public EmployeeWebException() {
    }

    public List<String> getMessageList() {
        return messageList;
    }
}
