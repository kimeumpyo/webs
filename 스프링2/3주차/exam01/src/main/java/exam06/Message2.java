package exam06;

public class Message2 {
    public void init() {
        System.out.println("init");
    }
    public void send(String message){
        System.out.println("전송 : " + message);
    }

    public void close(){
        System.out.println("close");
    }
}
