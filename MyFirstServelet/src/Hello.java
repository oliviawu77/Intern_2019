import java.util.*;

public class Hello {
    private Map<String, String> messages;
    private Map<String, String> password;

    public Hello() {
        messages = new HashMap<>(); //�]�m�ӧO�ϥΪ̪��T��
        messages.put("Olivia", "Hello! Ms.");
        messages.put("Freddy", "Hi! Mr.");
        messages.put("Nick", "Hi! Mr.");
        password = new HashMap<>(); //�]�m�ӧO�ϥΪ̪��K�X
        password.put("Olivia", "pkpkpkok123");
        password.put("Freddy", "rock");
        password.put("Nick", "sport");   
    }
    
    public String getPassword(String user) {	//�z�L�ӨϥΪ̪��W�r�h map �̭��j�M�L���K�X
        return password.get(user);
    }
     
    public boolean userIsExist(String user) {	//�T�{�ϥΪ̬O�_�s�b�A�s�b�~�|�^�� True
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
