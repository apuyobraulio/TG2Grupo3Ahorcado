package conn.example.tg2grupo3ahorcado.controller;

import java.util.function.Consumer;

public class Counter extends Thread{

    int count = 0;
    Consumer<Integer> consumer;

    public Counter(Consumer<Integer> consumer){
        this.consumer = consumer;
        start();
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Thread.sleep(1000);
                count++;
                consumer.accept(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
