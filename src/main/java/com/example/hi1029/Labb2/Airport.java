package com.example.hi1029.Labb2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Airport {

    public static void main(String[] args) {
        Airport arn = new Airport();
        arn.runSim(5, 10);
        System.out.println("incoming avg wait time: " + arn.getAverageArrWaitTime());
        System.out.println("outgoing avg wait time: " + arn.getAverageDepWaitTime());
        System.out.println("incoming max wait time: " + arn.maxArrWaitTime);
        System.out.println("outgoing max wait time: " + arn.maxDepWaitTime);
    }

    public class Airplane{
        private int timestamp;

        public Airplane(int timestamp){
            this.timestamp = timestamp;
        }

    }

    private int tickrate;
    private int timestamp;

    private int queueTimeLeft;

    private int maxArrWaitTime;
    private int maxDepWaitTime;

    private int totalArrWaitTime;
    private int totalDepWaitTime;

    private int totalArrPlanes;
    private int totalDepPlanes;

    private final Queue<Airplane> incoming;
    private final Queue<Airplane> departing;
    private final Random random;


    public Airport(){
        tickrate = 5;
        queueTimeLeft = 0;
        timestamp = 0;
        incoming = new LinkedList<>();
        departing = new LinkedList<>();
        random = new Random();

        maxArrWaitTime = 0;
        maxDepWaitTime = 0;
        totalArrWaitTime = 0;
        totalDepWaitTime = 0;
        totalArrPlanes = 0;
        totalDepPlanes = 0;
    }

    public void runSim(int tickrate, float years){
        this.tickrate = tickrate;
        int toHour = 60/tickrate;
        int loopCount = (int) (toHour * 24 * 365 * years);

        for (int i = 0; i <= loopCount; i++)
            playTick();
    }

    public void playTick(){
        if(random.nextFloat() <= 0.05){
            incoming.offer(new Airplane(timestamp));
            totalArrPlanes++;
        }
        if(random.nextFloat() <= 0.05){
            departing.offer(new Airplane(timestamp));
            totalDepPlanes++;
        }

        if(queueTimeLeft > 0)
            queueTimeLeft = queueTimeLeft - tickrate;

        if(queueTimeLeft <= 0)
            if(!handleArrival())
                handleDeparture();

        totalArrWaitTime += tickrate * incoming.size();
        totalDepWaitTime += tickrate * departing.size();
        timestamp += tickrate;
    }

    private boolean handleArrival(){
        if(incoming.peek() != null){
            int wait = timestamp - incoming.poll().timestamp;
            if(wait > maxArrWaitTime)
                maxArrWaitTime = wait;
            queueTimeLeft = 20;
            return true;
        }
        return false;
    }

    private void handleDeparture(){
        if(departing.peek() != null){
            var wait = timestamp - departing.poll().timestamp;
            if(wait > maxDepWaitTime)
                maxDepWaitTime = wait;
            queueTimeLeft = 20;
        }
    }

    public float getAverageArrWaitTime(){
        return  (float) totalArrWaitTime / (float) totalArrPlanes;
    }

    public float getAverageDepWaitTime(){
        return (float) totalDepWaitTime / (float) totalDepPlanes;
    }
}
