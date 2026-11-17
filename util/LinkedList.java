package util;

//This class implements the ADT definition of a linked list using the same signatures. Note that we can add extra methods
//here once all of the methods listed in the ADT interface are included.

public class LinkedList<T> implements LinkedListADT<T> {

	private int count; // the current number of elements in the list
	private LinearNode<T> front; // pointer to the first element
	private LinearNode<T> last; // pointer to the last element

	// -----------------------------------------------------------------
	// Creates an empty list.
	// -----------------------------------------------------------------
	public LinkedList() {
		this.count = 0;
		this.last = null;
		this.front = null;
	}

	// Adds one element to the end of this list
	public void add(T element) {
		LinearNode<T> node = new LinearNode<T>(element);

		if (size() == 0) {
			this.last = node; // This is the last and the
			this.front = node; // first node
			this.count++;
		} // end if
		else {
			this.last.setNext(node); // add node to the end of the list
			this.last = node; // now make this the new last node.

			this.count++;
		} // end else
	}

	public void add(T element, int index) {
		LinearNode<T> node = new LinearNode<T>(element);
		LinearNode<T> left = this.front, right = this.front;
		if (this.front == null)
			this.front = this.last = node;
		else if (index == 0) {
			node.setNext(front);
			this.front = node;
		} 
		else {
			for (int i = 0; right != null && i < index; i++) {
				left = right;
				right = right.getNext();
			} // end for
			// After the FOR loop, left will have the address of the element that will go to
			// the left of the new element. right will have the address of the element to go
			// to its right.

			if (right == null) // add element to the end of the list
			{
				last.setNext(node);
				last = node;
			} else { // add to middle of list between the left and right node
				left.setNext(node);
				node.setNext(right);
			}
		} // end the else from the previous slide

		this.count++;
	}

	// Removes and returns the first element from this list

	public T remove() {
		LinearNode<T> temp = null;
		T result = null;
		if (isEmpty()) {
			System.out.println("There are no nodes in the list");
		} // end if
		else {

			result = this.front.getElement();
			temp = this.front;
			this.front = this.front.getNext();
			temp.setNext(null); // dereference the original first element
			count--;
		} // end else
		return result;

	}

	// Returns true if this list contains no elements
	public boolean isEmpty() {
		if (this.front == null)
			return true;
		else
			return false;
	}

	// Returns the number of elements in this list
	public int size() {
		return this.count;
	}

	// Returns a string representation of this list

	public String toString() {
		LinearNode<T> current = null;
		String fullList = "";

		for (current = this.front; current != null; current = current.getNext()) {
			fullList = fullList + "\n" + current.getElement().toString();
		} // end for

		return fullList + "\n";
	}

}
