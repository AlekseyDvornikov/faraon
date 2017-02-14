/**
 * 
 */
package com.fara.controller;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.fara.*;

/**
 * @author advornikov
 *
 */
public class ThreadController {
	
   
	


	/**
	 * 
	 */
	public ThreadController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	
	
	static  enum mathOperations {Kubator,Kvadrator,Simplekator};	
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Consumer consumer = new Consumer();
		
		int[] array=  {3,4,2};
		for ( mathOperations oper :  mathOperations.values() ) {
			 executor.submit(new Runnable() {				
				@Override
				public void run() {
					try {
						Constructor constructor = Class.forName("com.fara.entity."+oper.toString()).getConstructor(Integer.TYPE,Consumer.class);
						constructor.newInstance(array[oper.ordinal()], consumer);
					} catch (Exception e) {
						e.printStackTrace();
					} 			
				}
			} );        
	}
}
	
}
