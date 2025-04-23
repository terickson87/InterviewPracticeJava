package io.github.terickson87.InterviewPracticeJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyHashMapTest {
    MyHashMap myHashMap;

    @BeforeEach
    void setup() {
        myHashMap = new MyHashMap();
    }

    @Test
    void testSetAndGet() {
        myHashMap.set("key1", "value1");
        myHashMap.set("key2", "value2");

        assertEquals("value1", myHashMap.get("key1").value());
        assertEquals("value2", myHashMap.get("key2").value());
    }

    @Test
    void testOverwriteValue() {
        myHashMap.set("key1", "value1");
        myHashMap.set("key1", "value2");

        assertEquals("value2", myHashMap.get("key1").value());
    }

    @Test
    void testNonExistentKey() {
        assertNull(myHashMap.get("nonexistent"));
    }

    @Test
    void testAllBucketsUsed() {
        for (int i = 0; i < 20; i++) {
            myHashMap.set("key" + i, "value" + i);
        }

        // Verify that all buckets have at least one entry
        for (int i = 0; i < 20; i++) {
            assertNotNull(myHashMap.get("key" + i));
        }
    }
}
