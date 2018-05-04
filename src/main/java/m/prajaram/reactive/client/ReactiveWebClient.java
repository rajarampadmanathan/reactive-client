package m.prajaram.reactive.client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Hello world!
 *
 */

//@SpringBootApplication
public class ReactiveWebClient {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cl=new CountDownLatch(1);
		//SpringApplication.run(ReactiveWebClient.class, args);
		WebClient webClient = WebClient.create("http://localhost:8080");
		webClient.method(HttpMethod.GET).uri("/users").accept(MediaType.TEXT_EVENT_STREAM).exchange().subscribe(System.out::println,
				System.out::println,()->{});
		
		cl.await();
	}
}
