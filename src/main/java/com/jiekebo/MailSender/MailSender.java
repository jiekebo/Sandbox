package com.jiekebo.MailSender;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * MailSender class
 * @author jiekebo
 *
 */
public class MailSender implements Runnable {

	private Socket smtpSocket = null;
	private DataOutputStream os = null;
	private BufferedReader is = null;
	private Date date;
	private boolean mailSent = false;

	/**
	 * Initializing constructor for the MailSender class
	 * @param host Host address
	 * @param port Host port
	 */
	public MailSender(String host, int port) {
		try {
			smtpSocket = new Socket(host, port);
			os = new DataOutputStream(smtpSocket.getOutputStream());
			is = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Check if the mail sender has been initiated correctly.
	 * @return false of the socket connection could not be achieved.
	 */
	public boolean isReady() {
		if (smtpSocket != null && os != null && is != null)
			return true;
		return false;
	}

	/**
	 * Mail Sender method. Follows guidelines in http://www.ietf.org/rfc/rfc2821.txt
	 */
	public void sendMail() {
			try {
				os.writeBytes("HELO\r\n");
				os.writeBytes("MAIL FROM: <jiekebo@gmail.com>\r\n");
				os.writeBytes("RCPT TO: <jiekebo@gmail.com>\r\n");

				os.writeBytes("DATA\r\n");

				os.writeBytes("X-Mailer: Simple mail service\r\n");
				os.writeBytes("DATE: " + date + "\r\n");
				os.writeBytes("From: Jacob Salomonsen <jiekebo@gmail.com>\r\n");
				os.writeBytes("To: Jacob Salomonsen <jiekebo@gmail.com>\r\n");

				String message = "Testing the mail sender.";

				os.writeBytes("Subject: Testing the mail sender\r\n");
				os.writeBytes(message + "\r\n");
				os.writeBytes("\r\n.\r\n");
				os.writeBytes("QUIT\r\n");

				String responseline;
				while ((responseline = is.readLine()) != null) { 
					System.out.println(responseline);
					if (responseline.indexOf("Ok") != -1) {
						mailSent = true;
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Check if mail has been sent
	 * @return true if mail has been sent
	 */
	public boolean isMailSent() {
		return mailSent;
	}

	@Override
	public void run() {
		sendMail();
	}

}
