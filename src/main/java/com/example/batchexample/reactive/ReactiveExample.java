package com.example.batchexample.reactive;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReactiveExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<String> future = service.submit(() -> {
            System.out.println("future1 : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "complete";
        });
        Future<String> future2 = service.submit(() -> {
            System.out.println("future2 : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "complete2";
        });
        Thread.sleep(10000);
        System.out.println("service : " + Thread.currentThread().getName());
        System.out.println("result : " + future.get());
        System.out.println("result : " + future2.get());

        service.shutdown();
    }
}
