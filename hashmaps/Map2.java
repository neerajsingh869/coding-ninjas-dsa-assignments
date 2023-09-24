package hashmaps;

import java.util.ArrayList;

public class Map2<K, V> {

	ArrayList<MapNode<K, V>> bucketArray;
	int capacity;
	int count;
	
	// constructor to initialize object
	public Map2() {
		capacity = 5;
		bucketArray = new ArrayList<>();
		for (int i = 0; i < capacity; i++) {
			bucketArray.add(null);
		}
		count = 0;
	}
	
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		return hashCode % capacity;
	}
	
	public int size() {
		return count;
	}
	
	public double loadFactor() {
		return (count * 1.0) / capacity;
	}
	
	private void reHash() {
		ArrayList<MapNode<K, V>> prevBucketArray = bucketArray;
		bucketArray = new ArrayList<>();
		capacity = 2 * capacity;
		for (int i = 0; i < capacity; i++) {
			bucketArray.add(null);
		}
		count = 0;
		for (int i = 0; i < prevBucketArray.size(); i++) {
			MapNode<K, V> temp = prevBucketArray.get(i);
			while (temp != null) {
				insert(temp.key, temp.value);
				temp = temp.next;
			}
		}
	}
	
	public void insert(K key, V value) {
		// check if key already exists, if it exists
		// update the value
		int idx = getBucketIndex(key);
		MapNode<K, V> head = bucketArray.get(idx);
		MapNode<K, V> temp = head;
		while (temp != null) {
			if (temp.key.equals(key)) {
				temp.value = value;
				return;
			}
			temp = temp.next;
		}
		// If key doesn't exists, then insert new node 
		// in the front 
		MapNode<K, V> newHead = new MapNode<>(key, value);
		newHead.next = head;
		bucketArray.set(idx, newHead);
		count++;
		
		if (loadFactor() >= 0.7) {
			reHash();
		}
	}
	
	public V delete(K key) {
		// check if key already exists, if it exists
		// update the value
		int idx = getBucketIndex(key);
		MapNode<K, V> head = bucketArray.get(idx);
		MapNode<K, V> temp = head;
		MapNode<K, V> prev = null;
		while (temp != null) {
			if (temp.key.equals(key)) {
				// do something
				V val = temp.value;
				if (prev == null) {
					bucketArray.set(idx, temp.next);
				} else {
					prev.next = temp.next;
					
				}
				count--;
				return val;
			}
			prev = temp;
			temp = temp.next;
		}
		return null;
	}
	
	public V search(K key) {
		int idx = getBucketIndex(key);
		MapNode<K, V> head = bucketArray.get(idx);
		MapNode<K, V> temp = head;
		while (temp != null) {
			if (temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;
		}
		return null;
	}
}
