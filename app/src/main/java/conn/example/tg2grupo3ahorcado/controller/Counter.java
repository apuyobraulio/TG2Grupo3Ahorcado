package conn.example.tg2grupo3ahorcado.controller;

import java.util.function.Consumer;

public class Counter extends Thread{

    private int count = 0;
    private final Consumer<Integer> consumer;
    private boolean jugando = true;

    public Counter(Consumer<Integer> consumer){
        this.consumer = consumer;
        start();
    }

    public boolean isRunning(){
        return jugando;
    }

    public Integer finalizar(){
        this.jugando = false;
        return count;
    }

    @Override
    public void run() {
        super.run();
        while (jugando){
            try {
                Thread.sleep(1000);
                consumer.accept(++count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
