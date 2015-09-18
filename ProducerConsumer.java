package programming;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhanyr
 *用wait和notify写一个生产者消费者例子
 */
public class ProducerConsumer {
	public static void main(String[] args) {
		ProductBuffer buffer = new ProductBuffer();
		List<Object> objects = new ArrayList<Object>();
		buffer.setMax(100);
		buffer.setObjects(objects);
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();
		
	}
}

class Producer implements Runnable{
	private ProductBuffer productBuffer;
	public Producer(ProductBuffer productBuffer) {
		this.productBuffer = productBuffer;
	}
	public void run() {
		while(true){
		synchronized (productBuffer) {
				//如果缓冲区满了，等待
				while(productBuffer.getObjects().size() == productBuffer.getMax()){
					System.out.println("buffer is full,please wait");
					try {
						productBuffer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//没满，生产
				Object object = new Object();
					
				if(productBuffer.getObjects().add(object)){
					System.out.println("produce an object，the buffer length is "+productBuffer.getObjects().size());
				}
				productBuffer.notify();
			}
		}
	}	
}

class Consumer implements Runnable{
	private ProductBuffer productBuffer;
	public Consumer(ProductBuffer productBuffer){
		this.productBuffer = productBuffer;
	}
	public void run() {
		while(true){
		synchronized (productBuffer) {
				//如果缓冲区空了，等待
				while(productBuffer.getObjects().size() == 0){
					System.out.println("buffer is empty,please wait");
					try {
						productBuffer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//没空，消耗
				if(productBuffer.getObjects().remove(0) != null){
					System.out.println("consumer consume an object,the buffer length is "+productBuffer.getObjects().size());
				}
				productBuffer.notify();
			}
		}
	}
	
}

class ProductBuffer {
	private List<Object> objects;
	private int max;
	public List<Object> getObjects() {
		return objects;
	}
	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	

}