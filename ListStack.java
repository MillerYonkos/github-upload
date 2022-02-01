import java.util.EmptyStackException;

/*
 * 	Works like a backwards linking LinkedList
 * 	Top always points to the first index in the LinkedList
 * 	New values are pushed in the first index and everything else is "shifted down" (just some pointer changes)
 */
public class ListStack implements BKStack
{
	private ListStackNode top = new ListStackNode(); //storing the top value of the stack
	
	public boolean isEmpty()
	{
		return (top.getNext() == null); //If top isnt pointing to anything, the stack is empty
	}
	public void push(double d)
	{
		ListStackNode pushed = new ListStackNode(top.getNext(), d); //points to the second most recent value as its next
		top.setNext(pushed); //top now points to the newest entry in the stack
	}
	public double pop()
	{
		try {
			ListStackNode popee = top.getNext();  //saving the top node from the stack
			top.setNext(top.getNext().getNext()); //removing pointers to the popped node
			return popee.getValue();			  //returning the popped nodes value
		}
		catch(NullPointerException e) {	//catching and throwing a NullPointer exception
			System.out.println("ERROR: Attempt to pop from empty stack");
			throw new EmptyStackException();		//throwing an EmptyStackException instead
		}
	}
	public double peek()
	{
		try {
			return top.getNext().getValue(); //returning the top nodes value
		}
		catch(NullPointerException e) {	//catching a NullPointer exception
			System.out.println("ERROR: Attempt to peek at empty stack");
			throw new EmptyStackException();        //throwing an EmptyStackException instead
		}
	}
	
	public class ListStackNode
	{
		private ListStackNode next; //ListStackNode has reference to the next ListStackNode, making it a linkedlist
		private double value;		//stores a double value
		
		/*
		 * Standard initializations for ListStackNode
		 */
		public ListStackNode()
		{
			next = null;
			value = 0;
		}
		public ListStackNode(ListStackNode n, double v)
		{
			next = n;
			value = v;
		}
		
		/*
		 * Standard getters and setters for next and value
		 */
		public ListStackNode getNext()
		{
			return this.next;
		}
		public void setNext(ListStackNode n)
		{
			this.next = n;
		}
		public double getValue()
		{
			return this.value;
		}
		public void setValue(double v)
		{
			this.value = v;
		}
	}
}
