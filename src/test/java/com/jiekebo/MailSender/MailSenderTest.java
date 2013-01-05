package com.jiekebo.MailSender;

import junit.framework.TestCase;

import org.junit.Test;

public class MailSenderTest extends TestCase {
	
	public MailSenderTest(String name) {
		super(name);
	}
	
	@Test
	public void testMailSend() {
		MailSender mailThread = new MailSender("localhost", 25);
		if(mailThread.isReady())
			mailThread.run();
		assertTrue(mailThread.isMailSent());
	}
}
