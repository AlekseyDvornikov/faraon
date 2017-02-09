/**
 * 
 */
package test;

import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author advornikov
 *
 */
public class t1 {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		 ExecutorService executor = Executors.newFixedThreadPool(2);
		 Thread.sleep(10000);
	     executor.shutdownNow();

	}
	
	class DataProvider implements Runnable {

	    private String userId;
	    
	    public DataProvider(DataProvider dataProvider) {
	        
	    }

	    public synchronized String getLogin() {
	        return userId;
	    }

	    @Override
	    public void run() {
	        while (true) {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                return;
	            }
	            userId = UUID.randomUUID().toString();
	        }
	    }
	}
	
	class DataConsumer implements Runnable {
	    private DataProvider dataProvider;

	    public DataConsumer(DataProvider dataProvider) {
	        this.dataProvider = dataProvider;
	    }

	    @Override
	    public void run() {
	        while (true) {
	            try {
	                Thread.sleep(2500);
	            } catch (InterruptedException e) {
	                return;
	            }
	            System.out.println(dataProvider.getLogin());
	        }
	    }
	}

}
