package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {

        if (queue.isEmpty()){
            return queue;
        }

        int data = queue.peek();
        queue.remove();

        queue = reverseQueueUsingRecursion(queue);
        queue.add(data);

        return queue;
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {

        if(queue.isEmpty() || k > queue.size() || k <= 0){
            return queue;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< k; i++){
            stack.push(queue.peek());
            queue.remove();
        }

        while(!stack.isEmpty()){
            queue.add(stack.peek());
            stack.pop();
        }

        for(int i =0; i< queue.size() - k; i++){
            queue.add(queue.peek());
            queue.remove();
        }

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
