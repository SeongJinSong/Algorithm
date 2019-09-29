package test;

public class CloneTest {
	public static void main(String[] args) {
		int[] a = new int[10];
		a[0]=1; a[1]=2;
		
		int[] b = a.clone();
		b[0]=3;
		
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
}
