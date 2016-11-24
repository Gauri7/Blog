package com.login;




import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class userDetail {
	@PrimaryKey
    @Persistent
    private String userName;
	
	@Persistent
    private String password;

	@Persistent
    private String emailId;
    
	
    

    public userDetail(String userName, String password, String emailId) {
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
   //     this.title = title;
   //     this.content = content;
    }



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


    // Accessors for the fields. JDO doesn't use these, but your application does.

  
}
