package com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.bean.UndirectedGraphNode;

public class CloneGraph {
    /**
     * ����ͼ
     * @param args
     */
    public static void main(String[] args) {

    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>(); // BFS�õ�queue
        // HashMap<node, clonednode> ��ԭʼnode���临��Ʒ
        Map<UndirectedGraphNode, UndirectedGraphNode> map =
                new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode retClone = new UndirectedGraphNode(node.label); // ���ڵ�ĸ���
        map.put(node, retClone); // �Ѹ��ڵ���临��Ʒ����map
        queue.offer(node); //�����ڵ���������

        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll(); // ��ǰ�������
            UndirectedGraphNode curClone = map.get(cur); // ��ǰ�������ĸ���Ʒ���ض���map���Ϊ��ǰ���neighbor���Ѿ�������

            //������ǰԭʼ���������neighbor
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                //��ÿһ��neighbor�����жϣ���Ϊ�е�neighbor�Ѿ������ƣ��е�û��
                if (map.containsKey(neighbor)) {
                    //֮ǰ�Ѿ������ƹ���neighbor,��ֱ�Ӵ�map��ȡ��neighborclone
                    UndirectedGraphNode neighborclone = map.get(neighbor);
                    //��curClone��Ӹ��Ƶ�neighbor
                    curClone.neighbors.add(neighborclone);
                } else {
                    //�����neighborû�б����ƹ������½�
                    UndirectedGraphNode neighborclone = new UndirectedGraphNode(neighbor.label);
                    //�洢��map��
                    map.put(neighbor, neighborclone);
                    //������ӵ�������Ϊ�˽����ı���
                    queue.offer(neighbor);
                    curClone.neighbors.add(neighborclone);
                }
            }
        }
        return retClone;
    }
}
