package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {
        if (queue.isEmpty())
            return queue;
        int num = queue.poll();
        queue = reverseQueueUsingRecursion(queue);
        queue.add(num);
        return queue;
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {
        List<Integer> list = new LinkedList<>();
        while (k > 0){
            list.add(0, queue.poll());
            k--;
        }
        list.addAll(queue);
        queue = (Queue<Integer>) list;
        return queue;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) {
        return null;
    }

    @Override
    public boolean validParentheses(String parentheses) {
        return false;
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        return null;
    }
}
