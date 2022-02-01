import java.util.EmptyStackException;

public class ArrayStack implements BKStack
{
	private double Arr[] = new double[10]; //starting at arbitrary 10
	private int top = -1; //top of the stack
	
	public boolean isEmpty()
	{
		return (top < 0); //if the top of the stack is at -1, its empty
	}
	public void push(double d)
	{
		if(top == Arr.length-1) //making sure we dont overflow
			addCapacity(Arr);
		Arr[++top] = d;		    //pushing element and incrementing top
	}
	public double pop()
	{
		try {
			double popee = Arr[top];	//saving the top value from the stack
			Arr[top--] = 0; 			//removing the top value and decrementing top
			return popee;				//returning the popped value
		}
		catch(ArrayIndexOutOfBoundsException e){   							//catching an IndexOutOfBounds exception
			System.out.println("ERROR: Attempt to pop from empty stack.");
			throw new EmptyStackException();								//and throwing it as an EmptyStackException
		}
	}
	public double peek()
	{
		try {
			return Arr[top];			//attempting to peek at the top value
		}
		catch(ArrayIndexOutOfBoundsException e) {  //catching an empty stack error
			System.out.println("ERROR: Attempt to peek at empty stack.");
			throw new EmptyStackException();
		}
	}
	public void addCapacity(double array[]) //makes a new array with more capacity
	{
		double larger[] = new double[array.length*2];  //new array
		for(int i=0; i<=top; i++)					   //loops through the range of elements in the old array
			larger[i] = array[i];					   //copying over values
		Arr = larger;								   //swaping in larger array.
	}
}