package com.fara;

import java.util.concurrent.atomic.AtomicInteger;

public class Consumer {
	
	AtomicInteger sum = new AtomicInteger(0);

	public Consumer() {
		
	}
	
	
	public void message(int kub, int kvad, int simpl){
		
		synchronized (sum) {
			sum.addAndGet(kub);
			sum.addAndGet(kvad);
			sum.addAndGet(simpl);
		}
		System.out.println("Текущая сумма - "+ sum);
	}

}
