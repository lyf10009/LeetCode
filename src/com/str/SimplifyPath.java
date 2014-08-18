package com.str;

import java.util.LinkedList;

public class SimplifyPath {
    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     */
    public static void main(String[] args) {
        String path="/a/b/../home/";
        System.out.println(simplifyPath(path));
    }
    
    /**
     * ˼·�Ƚ���ȷ������ά��һ��ջ������ÿһ���飨�ԡ�/����Ϊ�ֽ磩���з�����
     * ���������../�����ʾҪ��һ�㣬��ô���ǽ��г�ջ������
     * ���������./������ͣ����ǰ��ֱ�������������ļ�·����ֱ�ӽ�ջ���ɡ�
     * ������ջ�е�����ת����·�����ɣ������ǰ�ջת�����飬Ȼ��������ӣ���
     * ʱ���ϲ��ᳬ������ɨ�裨һ���ǽ�ջ�õ���·����һ���ǳ�ջ������������
     * ����ʱ�临�Ӷ���O(n)���ռ�����ջ�Ĵ�С��Ҳ��O(n)��
     */
    public static String simplifyPath(String path) {
        if(path == null || path.length()==0)  
        {  
            return "";  
        }  
        LinkedList<String> stack = new LinkedList<String>();  
        StringBuilder res = new StringBuilder();  
        int i=0;  
          
        while(i<path.length())  
        {  
            int index = i;  
            StringBuilder temp = new StringBuilder();  
            while(i<path.length() && path.charAt(i)!='/')  
            {  
                temp.append(path.charAt(i));  
                i++;  
            }  
            if(index!=i)  
            {  
                String str = temp.toString();  
                if(str.equals(".."))  
                {  
                    if(!stack.isEmpty())  
                        stack.pop();  
                }  
                else if(!str.equals("."))  
                {  
                    stack.push(str);  
                }  
            }  
            i++;  
        }  
        if(!stack.isEmpty())  
        {  
            String[] strs = stack.toArray(new String[stack.size()]);  
            for(int j=strs.length-1;j>=0;j--)  
            {  
              res.append("/"+strs[j]);  
            }  
        }  
        if(res.length()==0)  
            return "/";  
        return res.toString();  
    }
}
