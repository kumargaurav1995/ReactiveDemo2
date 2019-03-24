package com.reactive.demo2;


import io.reactivex.Observable;

import static java.lang.Thread.sleep;

public class Fibonacci {
    static Observable<Integer> fibs(){
        return Observable.create( subscriber -> {
            int prev =0;
            int current = 1;
             subscriber.onNext(0);
             subscriber.onNext(1);
             while (!subscriber.isDisposed()){
                 int oldPrev = prev;
                 prev = current;
                 current += oldPrev;
                 subscriber.onNext(current);
             sleep(200);}
//subscriber.onError(new RuntimeException("Wow Exception"));
subscriber.onComplete();
subscriber.onNext(7879);
        });

    }
}
