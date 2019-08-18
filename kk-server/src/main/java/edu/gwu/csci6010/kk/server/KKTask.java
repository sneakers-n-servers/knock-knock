package edu.gwu.csci6010.kk.server;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class KKTask implements Runnable{

    private String message;

    public KKTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message + " Printed by " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
