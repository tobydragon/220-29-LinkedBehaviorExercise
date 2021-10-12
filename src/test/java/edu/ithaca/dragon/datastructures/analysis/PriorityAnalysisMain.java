package edu.ithaca.dragon.datastructures.analysis;

import java.util.Random;

import edu.ithaca.dragon.datastructures.priorityqueue.LinkedPQ;
import edu.ithaca.dragon.datastructures.priorityqueue.PriorityQueue;

public class PriorityAnalysisMain {
    public static Random randGen = new Random();

    public static long timeAPut(PriorityQueue<String> pq, int maxPriority){
        int priority = randGen.nextInt(maxPriority);
		long start = System.nanoTime();
		pq.offer("an example string", priority);
		long end = System.nanoTime();
		long runTime = (end - start);
		return runTime;
	}

	public static long averageTimeForAPut(PriorityQueue<String> pq, int numPutsToAverage, int maxPriority){
		long total = 0;
		for (int i=0; i<numPutsToAverage; i++){
			total += timeAPut(pq, maxPriority);
		}
		return total/numPutsToAverage;
	}

    public static void putManyItems(int putCount, PriorityQueue<String> pq, int maxPriority) {
		for (int i=0; i<putCount; i++){
			pq.offer("an example string", randGen.nextInt(maxPriority));
		}
	}

	public static void outputpqPutData(PriorityQueue<String> pq){
		final int numItemsToPutEachTime = 100;
		final int numDataPointsToPrint = 50;
		final int numToAverageOver = 100;
        final int maxPriority = numItemsToPutEachTime*numDataPointsToPrint;

		System.out.println("Items in bag \t time to add a new item");
        for(int i=0; i<numDataPointsToPrint; i++){
            System.out.println(i*numItemsToPutEachTime + " \t\t " + averageTimeForAPut(pq, numToAverageOver, maxPriority));
			putManyItems(numItemsToPutEachTime, pq, maxPriority);
        }
	}
	//-----------------------------
	public static long timeATake(PriorityQueue<String> pq){
		long start = System.nanoTime();
		pq.poll();
		long end = System.nanoTime();
		long runTime = (end - start);
		return runTime;
	}

	public static long averageTimeForATake(PriorityQueue<String> pq, int numTakesToAverage){
		long total = 0;
		for (int i=0; i<numTakesToAverage; i++){
			total += timeATake(pq);
		}
		return total/numTakesToAverage;
	}

	public static void outputpqTakeData(PriorityQueue<String> pq){
		final int numItemsToPutEachTime = 100;
		final int numDataPointsToPrint = 50;
		final int numToAverageOver = 100;
        final int maxPriority = numItemsToPutEachTime*numDataPointsToPrint;


		System.out.println("Items in bag \t time to take a new item");
        for(int i=0; i<numDataPointsToPrint; i++){
			putManyItems(numToAverageOver, pq, maxPriority);
			System.out.println(i*numItemsToPutEachTime + " \t\t " + averageTimeForATake(pq, numToAverageOver));
            putManyItems(numItemsToPutEachTime, pq, maxPriority);
        }
	}

	

    public static void main(String[] args){
        outputpqPutData(new LinkedPQ<>());
		outputpqTakeData(new LinkedPQ<>());
    }

}
