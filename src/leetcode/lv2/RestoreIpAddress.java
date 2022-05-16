package leetcode.lv2;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    public List<String> result;
    public static void main(String[] args) {
        RestoreIpAddress ria = new RestoreIpAddress();
//        ria.print(ria.restoreIpAddresses("25525511135"));
//        ria.print(ria.restoreIpAddresses("0000"));
        ria.print(ria.restoreIpAddresses("101023"));
    }

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
//        tokenize(new ArrayList<>(), "", s);
        buildIps(0, 0, new StringBuilder(), s);
        return result;
    }

    public void tokenize(List<String> list, String next, String s){
        if(!"".equals(next))list.add(next);
        if(list.size()>4)return;
        else if(list.size()==4 && "".equals(s)){
            result.add(makeResult(list));
        }
        else if(list.size()==4){
            System.out.println("@@ s = " + s);
            return;
        }
        System.out.print("##list.size:"+list.size()+ " | ");
        System.out.print("s = " + s+ " | ");
        print(list);
        for(int i=1;i<4;i++){
            if(s.length()==0||s.length()<i)return;
            String nextString = s.substring(0, i);
            if((nextString.length()>1&&nextString.charAt(0)=='0')||Integer.parseInt(nextString)>255) return;
            System.out.println("$$$list.size:"+list.size()+ " | "+"s="+s+" i="+i+ " next = " + nextString);
            tokenize(new ArrayList<>(list), nextString, s.substring(i));
        }
    }

    public void buildIps(int startIndex, int depth, StringBuilder ip, String s){
        if(depth == 4){
            if(startIndex == s.length()){
                StringBuilder actualIp = new StringBuilder(ip.toString()).deleteCharAt(ip.length() - 1);
                result.add(actualIp.toString());
            }
            return;
        }

        for(int i=0;i<3;i++){
            if(startIndex + i < s.length()){
                String ipPart = s.substring(startIndex, startIndex + i + 1);
                if (ipPart.length() > 1 && ipPart.charAt(0) == '0') {
                    continue;
                }

                if (Integer.parseInt(ipPart) <= 255) {
                    ip.append(ipPart).append('.');

                    buildIps(startIndex+i+1, depth+1, ip, s);
                    ip.delete(ip.length() - ipPart.length() - 1, ip.length());
                }
            }
        }
    }

    public String makeResult(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s).append(".");
        }
        return sb.substring(0, sb.length()-1);
    }

    public void print(List<String> strings){
        for (String s : strings) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
