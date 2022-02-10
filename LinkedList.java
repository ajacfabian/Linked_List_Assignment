//Adrien Fabian

public class LinkedList
{
	static Node head;
	static int size = 0;

	class Node
	{
		Object data;
		Node prev;
		Node next;

		Node(Object d)
		{
			data = d;
			next = null;
		}
	}

	public void add(Object new_data)
	{
	    Node new_Node = new Node(new_data);

	    new_Node.next = head;
	    new_Node.prev = null;

	    if (head != null)
	        head.prev = new_Node;

	    head = new_Node;
	}

	public void addFront(Node prev_Node, Object new_data)
	{
	    if (prev_Node != null)
	    {
	    	Node new_node = new Node(new_data);
	   	 	new_node.next = prev_Node.next;
	   	 	prev_Node.next = new_node;
	    	new_node.prev = prev_Node;

	    	if (new_node.next != null)
	    	{
	        	new_node.next.prev = new_node;
			}
			size++;
		}
		else
		{
			System.out.println("A first node is needed to insert after");
		}
	}

	void addEnd(Object new_data)
	{
	    Node new_node = new Node(new_data);
	    Node last = head;
	    new_node.next = null;

	    if (head == null)
	    {
	        new_node.prev = null;
	        head = new_node;
	        return;
	    }

	    while (last.next != null)
	    {
	        last = last.next;
		}

	    last.next = new_node;
	    new_node.prev = last;
	    size++;
	}

	void deleteNode(Node head_ref, Node del)
	{
	    if (head == null || del == null)
	    {
	        return;
	    }

	    if (head == del)
	    {
	        head = del.next;
	    }

	    if (del.next != null)
	    {
	        del.next.prev = del.prev;
	    }

	    if (del.prev != null)
	    {
	        del.prev.next = del.next;
	    }
		size--;
    }

    Node getNode(int index)
    {
		Node location = head;
		int count = 0;
		while(location != null)
		{
			if(count == index)
			{
				return location;
			}
			count++;
			location = location.next;
		}
		assert(false);
		return head;
	}

    Object getData(int index)
    {
		Node location = head;
		int count = 0;
		while(location != null)
		{
			if(count == index)
			{
				return location.data;
			}
			count++;
			location = location.next;
		}
		assert(false);
		return head.data;
	}

	int size()
	{
		return size;
	}

    void printList(Node node)
    {
        while (node != null)
        {
            node = node.next;
            if(node != null)
            {
            	System.out.println(node.data);
			}
        }
    }

	public static void main(String[]args)
	{
		car car1 = new car("Ford", 4);
		car car2 = new car("Ford", 2);
		car car3 = new car("GMC", 2);
		car car4 = new car("RAM", 2);
		car car5 = new car("Chevy", 3);
		plane plane1 = new plane("Boeing", 3, 6);
		plane plane2 = new plane("Piper", 2, 1);
		plane plane3 = new plane("Cessna", 4, 4);

		LinkedList dll = new LinkedList();

		dll.add(head);
		dll.addEnd(car1);
		dll.addFront(head, car2);
		dll.addEnd(car3);
		dll.addEnd(car4);
		dll.addFront(head, car5);

		System.out.println("The list contains " + dll.size() + " items");
		System.out.println();

		System.out.println("The list contains:");
		dll.printList(head);
		System.out.println();

		for(int i = 1; i < dll.size(); i++)
		{
			if(dll.getData(i).toString().contains("Ford"))
			{
				Node deletePoint = (Node) dll.getNode(i);
				dll.deleteNode(head, deletePoint);
				break;
			}
		}

		System.out.println("The first Ford has been deleted");
		System.out.println();

		System.out.println("The list contains " + dll.size() + " items");
		System.out.println();

		System.out.println("The list contains:");
		dll.printList(head);
		System.out.println();

		dll.addFront(head, plane1);
		dll.addFront(head, plane2);
		dll.addFront(head, plane3);

		System.out.println("The list contains:");
		dll.printList(head);
	}
}

class vehicle
{
	private String make;

	public vehicle()
	{
		make = null;
	}

	public vehicle(String mk)
	{
		make = mk;
	}

	public String toString()
	{
	    return "A " + make;
	}
}

class car extends vehicle
{
	private int doors;

	public car(String mk, int dr)
	{
		super(mk);
		doors = dr;
	}

	public String toString()
	{
		return super.toString() + " with " + doors + " doors";
	}
}

class plane extends vehicle
{
	private int doors;
	private int engines;

	public plane(String mk, int dr, int eng)
	{
		super(mk);
		doors = dr;
		engines = eng;
	}

	public String toString()
	{
		return super.toString() + " with " + doors + " doors and " + engines + " engines";
	}
}