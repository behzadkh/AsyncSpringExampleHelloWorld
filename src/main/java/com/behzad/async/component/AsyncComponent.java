package com.behzad.async.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by behzad on 5/25/17.
 */
//@Component
    @Repository
public class AsyncComponent implements AsyncComponentInf{

    @Async
    @Override
    public void callMe(CompletableFuture<String> p ){
        try {
            // simulate  some work 
            TimeUnit.SECONDS.sleep(5);
            p.complete("AsyncComponent ----- it is done by threadName:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
