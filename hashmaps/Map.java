package hashmaps;

import java.util.ArrayList;

public class Map<K, V> {
	ArrayList<MapNode<K, V>> buckets;
	int count;
	int numBuckets;
	public Map() {
		buckets = new ArrayList<>();
		numBuckets = 5;
		for(int i = 0; i<numBuckets; i++) {
			buckets.add(null);
		}
	}
	public double loadFactor() {
		return (1.0*count)/numBuckets;
	}
	// Insert Method
	public void insert(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> temp = head;
		while(temp != null) {
			if(temp.key.equals(key)) {
				temp.value = value;
				return;
			}
			temp = temp.next;
		}
		MapNode<K, V> newNode = new MapNode<>(key, value);
		newNode.next = head;
		buckets.set(bucketIndex, newNode);
		count++;
		double loadFactor = loadFactor();
		if(loadFactor >= 0.7) {
			reHash();
		}
	}
	// Double capacity
	private void reHash() {
		ArrayList<MapNode<K, V>> oldBuckets = buckets;
		buckets = new ArrayList<>();
		int prevNumBuckets = numBuckets;
		numBuckets = 2*numBuckets;
		for(int i = 0; i<numBuckets; i++) {
			buckets.add(null);
		}
		count = 0;
		for(int i = 0; i<prevNumBuckets; i++) {
			MapNode<K, V> head = oldBuckets.get(i);
			while(head != null) {
				K key = head.key;
				V value = head.value;
				insert(key, value);
				head = head.next;
			}
		}
	}
	// getKeyIndex Method
	private int getBucketIndex(K key) {
		int index = key.hashCode();
		return index%numBuckets;
	}
	// Get Value Method
	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> temp = head;
		while(temp != null) {
			if(temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;
		}
		return null;
	}
	// Delete Method
	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> curr = buckets.get(bucketIndex);
		MapNode<K, V> prev = null, fwd = curr;
		while(fwd != null) {
			fwd = fwd.next;
			if(curr.key.equals(key)) {
				V val = curr.value;
				if(prev == null) {
					buckets.set(bucketIndex, fwd);
				}
				else {
					prev.next = fwd;
				}
				count--;
				return val;
			}
			prev = curr;
			curr = fwd;
		}
		return null;
	}
	// Size Method
	public int size() {
		return count;
	}
}
