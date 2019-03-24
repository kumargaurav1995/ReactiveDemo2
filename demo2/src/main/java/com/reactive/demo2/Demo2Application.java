package com.reactive.demo2;


import io.reactivex.Observable;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		userInput().flatMapMaybe(x -> Fibonacci.fibs().elementAt(x))   //.filter(x -> x>500)
				.blockingSubscribe(line -> System.out.println(line)
						,System.out :: println ,() -> System.out.println("DONE"));


		//SpringApplication.run(ReactiveJavaApplication.class, args);
	}
	public static Observable<Integer> userInput(){
		Random random = new Random();
		return Observable.intervalRange(0,20, 500, 500, TimeUnit.MILLISECONDS)
				.concatMap(number -> Observable.just(random.nextInt(20)));


				}
			}






