package com.jiekebo.MailSender;

public class MailSenderRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MailSender mailThread = new MailSender("localhost", 25);
		if(mailThread.isReady())
			mailThread.run();
	}

}
