package io.github.terickson87.InterviewPracticeJava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

record KeyValue(String key, String value) {}

public class MyHashMap {
    // Probably want to use generics
    // Break potential hash function values into chunks, in each chunk, an array of the objects will go there, and so an equality check can be done later
    ArrayList<LinkedList<KeyValue>> data;
    int numberOfBuckets = 10;

    public MyHashMap() {
        data = new ArrayList<>(numberOfBuckets);

        for (int iBucket = 0; iBucket < numberOfBuckets; iBucket++) {
            this.data.add(iBucket, new LinkedList<>());
        }
    }

    public void set(String key, String value) {
        int hash = hash(key);
        int iBucket = hash % numberOfBuckets;
        LinkedList<KeyValue> bucket = this.data.get(iBucket);
        ListIterator<KeyValue> bucketIterator = bucket.listIterator();
        while (bucketIterator.hasNext()) {
            KeyValue keyValue = bucketIterator.next();
            if (keyValue.key().equals(key)) {
                bucketIterator.remove();
            }
        }
        KeyValue keyValue = new KeyValue(key, value);
        bucket.add(keyValue);
    }

    public KeyValue get(String key) {
        int hash = hash(key);
        int iBucket = hash % numberOfBuckets;
        LinkedList<KeyValue> bucket = this.data.get(iBucket);
        KeyValue retKeyValue = null;
        for (KeyValue keyValue: bucket) {
            if (keyValue.key().equals(key)) {
                retKeyValue = keyValue;
            }
        }
        return retKeyValue;
    }

    public int hash(String key) {
        int hash = 0;
        for (Character c: key.toCharArray()) {
            hash += (int) c;
        }
        return hash;
    }
    
}
