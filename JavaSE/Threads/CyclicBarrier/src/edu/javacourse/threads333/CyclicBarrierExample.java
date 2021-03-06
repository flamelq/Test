package edu.javacourse.threads333;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3);

        Thread worker1 = new Thread(new edu.javacourse.threads333.Worker(barrier), "worker1");
        Thread worker2 = new Thread(new edu.javacourse.threads333.Worker(barrier), "worker2");
        Thread worker3 = new Thread(new edu.javacourse.threads333.Worker(barrier), "worker3");

        worker1.start();
        worker2.start();
        worker3.start();

    }

}
