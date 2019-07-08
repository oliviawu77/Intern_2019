import java.util.*;

public class Hello {
    private Map<String, String> messages;
    private Map<String, String> password;

    public Hello() {
        messages = new HashMap<>(); //設置個別使用者的訊息
        messages.put("Olivia", "Hello! Ms.");
        messages.put("Freddy", "Hi! Mr.");
        messages.put("Nick", "Hi! Mr.");
        password = new HashMap<>(); //設置個別使用者的密碼
        password.put("Olivia", "pkpkpkok123");
        password.put("Freddy", "rock");
        password.put("Nick", "sport");   
    }
    
    public String getPassword(String user) {	//透過該使用者的名字去 map 裡面搜尋他的密碼
        return password.get(user);
    }
     
    public boolean userIsExist(String user) {	//確認使用者是否存在，存在才會回傳 True
    	return messages.containsKey(user);
    }
    
    public void changePassword(String user){
    	password.put(user, "test");   
    }
    
    public void changeMessage(String user){
    	messages.put(user, "You Have Changed Your Welcome Message~");
    }
    
    public String doHello(String user) {
        return String.format("%s %s!", messages.get(user), user);
    }	
}
