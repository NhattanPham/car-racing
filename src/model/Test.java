package model;

import java.util.Random;

public class Test extends Thread{
	@Override
	public void run() {
		while(true) {
			Random rc= new Random();
			int x = rc.nextInt(5);
			System.out.println(x);
			if(x==2) break;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
