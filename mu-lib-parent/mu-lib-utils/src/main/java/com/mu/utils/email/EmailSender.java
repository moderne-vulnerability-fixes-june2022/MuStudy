package com.mu.utils.email;


public interface EmailSender {
	
	void sendEmail(EmailInfo emailInfo);
	
	void sendEmailMime(EmailInfo emailInfo);
	
	void sendEmailWithFile(EmailInfo emailInfo,String filePath);
}
