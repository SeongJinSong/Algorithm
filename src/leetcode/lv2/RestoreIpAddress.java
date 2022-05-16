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
        tokenize(new ArrayList<>(), "", s);
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
