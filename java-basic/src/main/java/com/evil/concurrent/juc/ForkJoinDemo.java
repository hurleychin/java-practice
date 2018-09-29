package com.evil.concurrent.juc;

import com.evil.util.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author qinhu
 * @date 2018-09-17
 */
public class ForkJoinDemo {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            numbers.add(i);
        }

        // Because I am not specifying the number of threads
        // it will create a thread for each available processor
        ForkJoinPool pool = new ForkJoinPool();
        // Submit the task to the pool, and get what is effectively the Future
        ForkJoinTask<Integer> task = pool.submit(new SummingTask(numbers));
        // Wait for the result
        long start = System.currentTimeMillis();
        int result = task.join();
        long end = System.currentTimeMillis();
        Console.out("fork/join result=" + result + " in " + (end - start) + " ms");

        start = System.currentTimeMillis();
        int singleResult = new SummingTask(numbers).singleCalc();
        end = System.currentTimeMillis();
        Console.out("single result=" + singleResult + " in " + (end - start) + " ms");
    }
}

class SummingTask extends RecursiveTask<Integer> {
    private static final int MAX_BATCH_SIZE =10;
    private final List<Integer> numbers;
    private final int minInclusive, maxExclusive;

    public SummingTask(List<Integer> numbers) {
        this(numbers, 0, numbers.size());
    }

    // This constructor is only used internally as part of the dividing process
    private SummingTask(List<Integer> numbers, int minInclusive, int maxExclusive) {
        this.numbers = numbers;
        this.minInclusive = minInclusive;
        this.maxExclusive = maxExclusive;
    }

    @Override
    protected Integer compute() {
        if (maxExclusive - minInclusive > MAX_BATCH_SIZE) {
            // This is too big for a single batch, so we shall divide into two tasks
            int mid = (minInclusive + maxExclusive) / 2;
            SummingTask leftTask = new SummingTask(numbers, minInclusive, mid);
            SummingTask rightTask = new SummingTask(numbers, mid, maxExclusive);
            // Submit the left hand task as a new task to the same ForkJoinPool
            leftTask.fork();
            // Run the right hand task on the same thread and get the result
            int rightResult = rightTask.compute();
            // Wait for the left hand task to complete and get its result
            int leftResult = leftTask.join();
            // And combine the result
            return leftResult + rightResult;
        } else {
            // This is fine for a single batch, so we will run it here and now
            return singleCalc();
        }
    }

    public Integer singleCalc() {
        int sum = 0;
        for (int i = minInclusive; i < maxExclusive; i++) {
            sum += numbers.get(i);
        }
        return sum;
    }
}
