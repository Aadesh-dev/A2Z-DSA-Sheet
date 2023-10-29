class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    if(rear != 100001) {
            arr[rear++] = x;
        }
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		if(front != rear) {
            rear--;
            int element = arr[0];
            for(int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            return element;
        }
        return -1; 
	} 
}

//Optimal:
public class Solution {
    class Queue {
        int front, rear, size;
        int []arr;

        Queue() {
            front = 0;
            rear = 0;
            size = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            if(size != 100001) {
                arr[rear % 100001] = e;
                rear++;
                size++;
            }
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if(front != rear) {
                int element = arr[front % 100001];
                front++;
                size--;
                return element;
            }
            return -1; 
        }
    }
}
//https://www.youtube.com/watch?v=M6GnoUDpqEE&ab_channel=takeUforward