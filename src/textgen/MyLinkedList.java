package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {

	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		// Create a head and tail sentinel nodes.
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element)
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		// Create a Node and assign element as the value
		// Refactor the references
		// Increment the size of the linkedlist
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> lastNode = tail.prev;

		lastNode.next = newNode;
		newNode.prev = lastNode;
		newNode.next = tail;
		tail.prev = newNode;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		LLNode<E> current = head.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		if (element == null) {
			throw new NullPointerException();
		}
		// If the index is at the end, append to the last of the list
		if (index == this.size()) {
			add(element);
			return;
		}
		LLNode<E> newNode = new LLNode<>(element);
		LLNode<E> current = head.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		newNode.next = current;
		newNode.prev = current.prev;
		current.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		LLNode<E> current = head.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.next = null;
		current.prev = null;
		size--;

		return current.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> current = head.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		E currentData = current.data;
		current.data = element;
		return currentData;
	}

	@Override
	public String toString() {
		LLNode<E> current = head;
		StringBuilder sb = new StringBuilder();
		int counter = this.size();
		while (counter >= 0 ) {
			sb.append(current.data).append(" -> ");
			current = current.next;
			counter--;
		}
		sb.append("null");
		return sb.toString();

	}
}

class LLNode<E> 
{
	// Recursive definition
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
