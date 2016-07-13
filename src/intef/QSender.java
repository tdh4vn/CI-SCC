package intef;

/**
 * Created by hungtran on 7/12/16.
 */
public interface QSender {
    void addQPressListener(QPressListener q);
    void notifyAll(String msg);
}
