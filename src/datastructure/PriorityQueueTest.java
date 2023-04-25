package datastructure;

public class PriorityQueueTest {

	public static void main(String[] args) {
		SelfPriorityQueue pq = new SelfPriorityQueue();
		pq.initHeap();
		
		System.out.println("push");
		pq.push(new Item(5));
		pq.push(new Item(1));
		pq.push(new Item(7));
		pq.push(new Item(8));
		pq.push(new Item(3));
		pq.push(new Item(2));
		
		System.out.println("pop");
		System.out.println(pq.pop().data);
	}

}

class Item {
	int data;

	public Item(int data) {
		this.data = data;
	}
}

class SelfPriorityQueue {
	final int MAX_QUEUE_SIZE = 100;
	int heapSize = 0;
	Item[] heap = new Item[MAX_QUEUE_SIZE];
	
	void initHeap() {
		heapSize = 0;
	}
	
	boolean isFull() {
		if (heapSize + 1 > MAX_QUEUE_SIZE) {
			System.out.println("PQ is Full");
			return true;
		}
		return false;
	}
	
	boolean isEmpty() {
		if (heapSize == 0) {
			return true;
		}
		return false;
	}
	
	void show() {
		for(int i=0; i<heapSize; i++) {
			System.out.printf("%d ", heap[i].data);
		}
		System.out.println();
	}
	
	void push(Item item) {
		if (isFull()) {
			return;
		}
		
		int current = heapSize;
		heap[current] = item;
		
		
		while(current > 0 && heap[current].data > heap[(current - 1) / 2].data) {
			Item temp = heap[current];
			heap[current] = heap[(current - 1) / 2];
			heap[(current - 1) / 2] = temp;
			
			current = (current - 1) / 2;
		}
		heapSize += 1;
		
	}
	
	Item pop() {
		if (isEmpty()) {
			return null;
		}
		
		heapSize -= 1;
		
		Item top = heap[0];
		heap[0] = heap[heapSize];
		
		int current = 0;
		
		while(current < heapSize && (current * 2) + 1 < heapSize) {
			int child;
			
			if (current * 2 + 2 >= heapSize) {
				child = current * 2 + 1;
			} else {
				child = heap[current * 2 + 1].data > heap[current * 2 + 2].data ? current * 2 + 1 : current * 2 + 2;
			}
			
			if (heap[current].data > heap[child].data) {
				break;
			}
			
			Item temp = heap[current];
			heap[current] = heap[child];
			heap[child] = temp;
			
			current = child;
		}
		
		return top;
	}
	
	
}