package practice;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import account.Account;
import account.DrawThread;

public class MyThread{	
	public static void main(String[] args) {
		Account myAccount = new Account(1000.0, "Test Account");
		new DrawThread("Matthew", myAccount, 800).start();
		new DrawThread("Linda", myAccount, 800).start();
	}	
}


