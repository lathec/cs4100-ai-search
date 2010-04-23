package datastructure;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Artificial Intelligence A Modern Approach (3rd Edition): pg 80.<br>
 * 
 * Last-in, first-out or LIFO queue (also known as a stack), which pops the newest element of the queue;
 */

/**
 * (Copied and modified from AIMA code original authors credited below.)
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public class LastInFirstOutQueue<E> extends LinkedList<E> implements Queue<E> {
	private static final long serialVersionUID = 1;

	public LastInFirstOutQueue() {
		super();
	}

	public LastInFirstOutQueue(Collection<? extends E> c) {
		super(c);
	}

	public boolean isEmpty() {
		return 0 == size();
	}

	@Override
	public E pop() {
		return poll();
	}

	public Queue<E> insert(E element) {
		if(offer(element)) {
			return this;
		}
		return null;
	}

	@Override
	public boolean add(E e) {
		addFirst(e);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return addAll(0, c);
	}

	@Override
	public boolean offer(E e) {
		return offerFirst(e);
	}
}