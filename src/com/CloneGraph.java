package com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.bean.UndirectedGraphNode;

public class CloneGraph {
    /**
     * 复制图
     * @param args
     */
    public static void main(String[] args) {

    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>(); // BFS用的queue
        // HashMap<node, clonednode> 放原始node和其复制品
        Map<UndirectedGraphNode, UndirectedGraphNode> map =
                new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode retClone = new UndirectedGraphNode(node.label); // 根节点的复制
        map.put(node, retClone); // 把根节点和其复制品放入map
        queue.offer(node); //将跟节点添加入队列

        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll(); // 当前处理对象
            UndirectedGraphNode curClone = map.get(cur); // 当前处理对象的复制品，必定在map里，因为在前面的neighbor里已经被创建

            //遍历当前原始对象的所有neighbor
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                //对每一个neighbor进行判断，因为有的neighbor已经被复制，有的没有
                if (map.containsKey(neighbor)) {
                    //之前已经被复制过的neighbor,就直接从map里取出neighborclone
                    UndirectedGraphNode neighborclone = map.get(neighbor);
                    //给curClone添加复制的neighbor
                    curClone.neighbors.add(neighborclone);
                } else {
                    //如果该neighbor没有被复制过，则新建
                    UndirectedGraphNode neighborclone = new UndirectedGraphNode(neighbor.label);
                    //存储到map里
                    map.put(neighbor, neighborclone);
                    //并且添加到队列里为了将来的遍历
                    queue.offer(neighbor);
                    curClone.neighbors.add(neighborclone);
                }
            }
        }
        return retClone;
    }
}
