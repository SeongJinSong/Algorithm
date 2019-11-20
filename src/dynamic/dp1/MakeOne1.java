package dynamic.dp1;

import java.util.*;

public class MakeOne1 {
	static int d[];
	static int go3(int n) {
		if(n==1)return 0;
		if(d[n]>0) return d[n];
		if(n%3==0) {
			int tmp =  go3(n/3)+1;
			if(d[n]>tmp&&d[n]!=0)
				d[n] = tmp;
			else if(d[n]==0) {
				d[n] = tmp;
			}
		}
		if(n%2==0) {
			int tmp = go3(n/2)+1;
			if(d[n]>tmp&&d[n]!=0)
				d[n] = tmp;
			else if(d[n]==0) {
				d[n] = tmp;
			}
		}
		if(n-1>=0) {
			int tmp = go3(n-1)+1;
			if(d[n]>tmp&&d[n]!=0)
				d[n] = tmp;
			else if(d[n]==0) {
				d[n] = tmp;
			}
		}
		return d[n];
	}
	static int go(int n) {
		if(n%3==0) {
			if(d[n]+1<d[n/3]&&d[n/3]!=0) {
				d[n/3] = d[n]+1;
				go(n/3);
			}
			else if(d[n/3]==0) {
				d[n/3] = d[n]+1;
				go(n/3);
			}
			if(n/3==1) return d[1];
		}
		if(n%2==0) {
			if(d[n]+1<d[n/2]&&d[n/2]!=0) {
				d[n/2] = d[n]+1;
				go(n/2);
			}
			else if(d[n/2]==0) {
				d[n/2] = d[n]+1;
				go(n/2);
			}
			if(n/2==1) return d[1];
			
		}
		if(n-1>=1) {
			if(d[n]+1<d[n-1]&&d[n-1]!=0) {
				d[n-1] = d[n]+1;
				go(n-1);
			}
			else if(d[n-1]==0) {
				d[n-1] = d[n]+1;
				go(n-1);
			}
			if(n-1==1) return d[1];
		}
		return d[n];
	}
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
//    	test();
		int n = sc.nextInt();
		d=new int[n+1];
		System.out.println(go3(n));
    }
    public static void test(){
    	int j=100;
    	for(int i=20;i<j;i++) {
    		d = new int[i+1];
    		go(i);
    		int t1 = d[1];
    		d = new int[i+1];
    		int t2 = go2(i);
    		if(t1!=t2)System.out.println("i:"+i+" t1:"+t1+" t2:"+t2);
    	}
    }
    public static int go2(int n) {
        if (n == 1) {
            return 0;
        }
        if (d[n] > 0) {
            return d[n];
        }
        d[n] = go2(n-1) + 1;
        if (n%2 == 0) {
            int temp = go2(n/2)+1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }
        if (n%3 == 0) {
            int temp = go2(n/3)+1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }
        return d[n];
    }
}