package util;

public class Permutation {
	public static void main(String[] args) {
		String[] input = {"*", "-", "+"};
		visited = new boolean[input.length];
		String[] output = new String[input.length];
		per(input, output, 0, 3);
	}
	public static boolean[] visited;
	static void per(String[] input, String[] output, int depth, int r) {
		if(depth==r) {
			for(String s : output) System.out.print(s+" ");
			System.out.println();
			return;
		}
		for(int i=0;i<input.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				output[depth] = input[i];
				per(input, output, depth + 1, r);
				visited[i]=false;
			}
		}
	}
}
