// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Carter Kennell
// RESOURCES: The resources used for this lab were the provided JavaDoc, tutors in the CSLC, and 
//				the provided starter code from the Instructors of CSCI1620.



package uno.collections.queues;

/**
 * Provides a standard definition of a circular queue (aka, a ring buffer)
 * with a maximum capacity.  All queue operations are guaranteed to complete
 * in constant time. 
 * 
 * @author ckennell
 *
 * @param <E> The type of an individual element stored in the queue.
 */
public class BoundedCircularQueue<E> implements Queue<E>
{
	/**
	 * The array where we will store data in this queue.
	 */
	private E[] values;
	
	/**
	 * The index of the current front item in the queue.
	 */
	private int front;
	
	/**
	 * The index of the current rear item in the queue.	
	 */
	private int rear;
	
	/**
	 * The number of items currently stored in the queue.
	 */
	private int numberOfItems;
	
	/**
	 * Constructs a new, initially empty BoundedCircularQueue with 
	 * a default maximum capacity of 10.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCircularQueue()
	{
		//TODO: Define the method per the provided docs.
		
		values = (E[]) new Queue[10];
		numberOfItems = 0;
	}
	
	/**
	 * Constructs a new, initially empty BoundedCircularQueue.
	 * 
	 * @param capacity The maximum number of items that can be stored 
	 * in this queue.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCircularQueue(int capacity)
	{
		//TODO: Define the method per the provided docs.
		
		values = (E[]) new Queue[capacity];
		numberOfItems = 0;
	}
	
	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty()
	{
		//TODO: Define the method per the provided interface docs.
		
		boolean ret;
		
		if (size() == 0)
		{
			ret = true;
		}
		else
		{
			ret = false;
		}
		
		return ret;
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#size()
	 */
	@Override
	public int size()
	{
		//TODO: Define the method per the provided interface docs.
		
		return numberOfItems;
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#peek()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E peek()
	{
		//TODO: Define the method per the provided interface docs. 
		
		if (size() != 0)
		{
			return values[front];
		}
		else
		{
			throw new IllegalStateException();
		}
		
		//return ret;
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#dequeue()
	 */
	@Override
	public E dequeue()
	{
		//TODO: Define the method per the provided interface docs. 
		int tempFront = 0;
		
		if (size() != 0)
		{
			if (front + 1 == size())
			{
				tempFront = front;
				front = 0;
			}
			else
			{
				tempFront = front;
				front++;
			}
		}
		else
		{
			throw new IllegalStateException();
		}
		
		return values[tempFront];
	}

	/**
	 * Add an item to the rear of this queue.
	 * 
	 * @param item The value to be added to the queue.
	 * @throws IllegalStateException when the queue is full.  
	 * The message will read "Cannot enqueue because queue is already full!"
	 */
	@Override
	public void enqueue(E item)
	{
		//TODO: Define enqueue as described in the docs.  Notice that
		//      this version of enqueue should throw an exception when 
		//      no additional item can be added!
		
		if (!isFull())
		{
			values[rear + 1] = item;
			rear++;
			numberOfItems++;
		}
		else
		{
			throw new IllegalStateException("Cannot enqueue because queue is already full!");
		}
	}

	/**
	 * A method to test whether this BoundedCircularQueue is currently
	 * full.
	 * 
	 * @return true if this queue is full, false if at least one more item 
	 * can be enqueued.
	 */
	public boolean isFull()
	{
		//TODO: Define the method per the provided interface docs.
		boolean ret;
		
		if (numberOfItems == values.length)
		{
			ret = true;
		}
		else
		{
			ret = false;
		}
		
		return ret;
	}
	
	
	
}
