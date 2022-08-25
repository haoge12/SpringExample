package com.xuhao.utlis;

import com.xuhao.aspect.Invoke;
import org.springframework.stereotype.Repository;

@Repository
public class util {
    @Invoke
    public static String encode(String s){
        int arraySize = 131; // 数组大小一般取质数
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) { // 从字符串的左边开始计算
            int letterValue = s.charAt(i);// 将获取到的字符串转换成数字
            int hashCode;
            String result;
            if(letterValue<=99){
                hashCode = letterValue % arraySize;
                result = 0 + String.valueOf(hashCode);
                stringBuilder.append(result);
            }
            else {
                hashCode = letterValue % arraySize;// 防止编码溢出，对每步结果都进行取模运算
                result = String.valueOf(hashCode);
                stringBuilder.append(result);
            }


        }
        return stringBuilder.toString();
    }
    @Invoke
    public static String decode(String s){
        char[] arr = s.toCharArray();
//        StringBuilder stringBuilder = new StringBuilder(s);
//        StringBuffer stringBuffer = new StringBuffer(s);
//        int j;
//        String result = null;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length()-2; i = i + 3){
            if(arr[i] == '0'){
                char result1 = (char)Integer.parseInt(String.valueOf(arr[i + 1]) + String.valueOf(arr[i + 2]));
                stringBuilder.append(result1);
            }
            else{
                char result1= (char)Integer.parseInt(String.valueOf(arr[i])+ String.valueOf(arr[i + 1]) + String.valueOf(arr[i + 2]));
                stringBuilder.append(result1);
            }

        }
        return stringBuilder.toString();
    }
//
//    public static void main(String[] args) {
//        util u = new util();
//        System.out.println(u.decode("akey"));
//        System.out.println(u.encode("097107101121"));
//    }
}
