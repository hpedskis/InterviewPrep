package Chapter7;

import java.util.ArrayList;

public class HashTable<K, V> {
	public ArrayList<LinkedListNode<K,V>> LLArray;
	
	public HashTable(ArrayList<LinkedListNode<K,V>> array){
		LLArray = array;
		
	}
	
	public void put (K key, V value){
		LinkedListNode<K,V> node = GetNodeInLL(key); //finds the correct array index and the correct link
		if (node != null){ //if there is already a linked list started there
			node.value = value;
			node.next.prev = node;
			return;
		}
		node = new LinkedListNode<K,V>(key, value); //otherwise, start a new LL
		int index = getKeyHash(key);
		if (LLArray.get(index) != null){
			node.next = LLArray.get(index);	
		}
		LLArray.set(index, node);
	}
	
	public V getValue (K key){
		LinkedListNode<K,V> node = GetNodeInLL(key); //where is it located in the Array
		if (node == null){
			return null;
		}
		return node.value;
		
	}
	public void remove(K key){
		LinkedListNode<K,V> node = GetNodeInLL(key);
		if (node.prev != null){
			node.prev.next = node.next;
		}else{
			int index = getKeyHash(key);
			LLArray.set(index, node.next); //if no previous, set first element to next
		}
		if(node.next != null){
			node.next.prev = node.prev;
		}
	}
	
	public LinkedListNode<K,V> GetNodeInLL(K key){
		int index = getKeyHash(key);
		LinkedListNode<K,V> current = LLArray.get(index);
		while (current != null){
			if (current.key == key){
				return current;
			}
			current = current.next;
		}
		return null;
	}
	public int getKeyHash(K key){
		return Math.abs(key.hashCode() % LLArray.size());
		
	}
	
	
	
	class LinkedListNode<K, V>{
		K key;
		V value;
		LinkedListNode<K, V> next;
		LinkedListNode<K, V> prev;
		
		public LinkedListNode(K key, V value){
			this.key = key;
			this.value = value;
			next = null;
			prev = null;
		}

	}


}
