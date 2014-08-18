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
     * 思路比较明确，就是维护一个栈，对于每一个块（以‘/’作为分界）进行分析，
     * 如果遇到‘../’则表示要上一层，那么就是进行出栈操作，
     * 如果遇到‘./’则是停留当前，直接跳过，其他文件路径则直接进栈即可。
     * 最后根据栈中的内容转换成路径即可（这里是把栈转成数组，然后依次添加）。
     * 时间上不会超过两次扫描（一次是进栈得到简化路径，一次是出栈获得最后结果），
     * 所以时间复杂度是O(n)，空间上是栈的大小，也是O(n)。
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
