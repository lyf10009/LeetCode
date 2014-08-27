package com;

import java.util.HashMap;

public class LRUCache {
    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support
     * the following operations: get and set. 
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. 
     * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
     *              it should invalidate the least recently used item before inserting a new item.
     * 
     * LRU��Least Recently Used ��������ʹ���㷨��
     * ���� ����Ϊ 4 3 4 2 3 1 4 2
     * �������3�� ��
     * ���� 4�����ڴ� 4
     * ���� 3�����ڴ� 3 4
     * ֮�� 4�����ڴ� 4 3
     * ֮�� 2�����ڴ� 2 4 3
     * ֮�� 3�����ڴ� 3 2 4
     * ֮�� 1�����ڴ� 1 3 2����Ϊ����ʹ�õ���4�����Զ���4��
     * ֮�� 4�����ڴ� 4 1 3��ԭ��ͬ�ϣ�
     * ��� 2�����ڴ� 2 4 1
     * 
     * ʹ��˫�������mapʵ��
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheList = new CacheNodeList(capacity);
        this.cacheMap = new HashMap<Integer, CacheNode>();
    }

    public int get(int key) {
        CacheNode request = cacheMap.get(key);
        if (request == null) return -1;
        cacheList.shiftToFirst(request);
        return request.val;
    }

    public void set(int key, int value) {
        if (cacheMap.containsKey(key)) {
            CacheNode request = cacheMap.get(key);
            request.val = value;
            cacheList.shiftToFirst(request);
        } else {
            if (cacheMap.size() == capacity) {
                CacheNode node = cacheList.removeLast();
                cacheMap.remove(node.key);
            }
            CacheNode newCache = new CacheNode(key, value);
            cacheList.insertFirst(newCache);
            cacheMap.put(key, newCache);
        }
    }

    private int capacity;
    private CacheNodeList cacheList;
    private HashMap<Integer, CacheNode> cacheMap;

    private class CacheNodeList {
        private CacheNode head;
        private CacheNode tail;

        private CacheNodeList(int capacity) {
            head = new CacheNode(0, 0);
            tail = new CacheNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void insertFirst(CacheNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        private CacheNode removeLast() {
            CacheNode lastNode = tail.prev;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            return lastNode;
        }

        private void shiftToFirst(CacheNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            this.insertFirst(node);
        }
    }
    
    //˫������
    private class CacheNode {
        int key;
        int val;
        CacheNode prev;
        CacheNode next;

        private CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}
