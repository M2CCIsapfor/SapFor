package Server;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Login {
	private String login;
	private String password;
	public Login(){}
	public Login(String l, String p){
		login=l;
		password=p;
	}
	
	public String getLogin(){return login;}
	public String getPassword(){return password;}
	
	public void setLogin(String l){login=l;}
	public void setPassword(String p){password=p;}
	
}
