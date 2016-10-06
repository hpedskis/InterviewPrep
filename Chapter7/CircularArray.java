package Chapter7;

import java.util.Iterator;

public class CircularArray implements Iterable<T>{
	public T[] items;
	public int head = 0;
	
	public CircularArray(int size){
		items = new T[size];
	}
	
	public void rotate(int rotateBy){
		head = convert(rotateBy);
	}
	
	public int convert (int shift) {
		if (shift < 0){
			shift += items.length; //computer returns negative if negative value, so this fixes
			//TODO understand this better 
		}
		return (head + shift) % items.length; //keep wrapping around
	}
	
	public T get (int i){
		return items[convert(i)];
	}
	
	public void set (int i, T item){
		items[convert(i)] = item;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CircularArrayIterator<T>(items);
	}
	private class CircularArrayIterator<T> implements Iterator<T>{
		private int current = 0;
		private T[] items;
		
		public CircularArrayIterator(T[] items){
			this.items = items;
			
		}
		
		@Override
		public boolean hasNext() {
			return current < items.length - 1;
		}

		@Override
		public T next() {
			return items[convert(current)];
		}
		
	}

	
}

class T{
	String name;
	int data;
	
	public T(String name, int data){
		this.name = name;
		this.data = data;
	}
}
