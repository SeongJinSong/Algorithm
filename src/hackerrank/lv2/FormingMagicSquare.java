package hackerrank.lv2;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class FormingMagicSquare_ {

	/*
	 * Complete the 'formingMagicSquare' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts 2D_INTEGER_ARRAY s as parameter.
	 */
	//내가 잘못 생각했던 풀이 방향
	public static int formingMagicSquare(List<List<Integer>> s) {
		// Write your code here
		boolean fixed[][] = new boolean[3][3];
		int n = s.size();
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += s.get(i).get(j);
			}
			if (sum == 15) {
				for (int j = 0; j < n; j++) {
					fixed[i][j] = true;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += s.get(j).get(i);
			}
			if (sum == 15) {
				for (int j = 0; j < n; j++) {
					fixed[j][i] = true;
				}
			}
		}
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < n; i++) {
			sum1 += s.get(i).get(i);
			sum2 += s.get(i).get(2 - i);
		}
		if (sum1 == 15) {
			for (int i = 0; i < n; i++) {
				fixed[i][i] = true;
			}
		}
		if (sum2 == 15) {
			for (int i = 0; i < n; i++) {
				fixed[i][2 - i] = true;
			}
		}

		System.out.println();
		return 0;
	}
	
	//솔루션
	static int[][][] magicSquare= {
			{
				{8,1,6},
				{3,5,7},
				{4,9,2}
			},
			{
				{4,3,8},
				{9,5,1},
				{2,7,6}
			},
			{
				{2,9,4},
				{7,5,3},
				{6,1,8}
			},
			{
				{6,7,2},
				{1,5,9},
				{8,3,4}
			},
			{
				{6,1,8},
				{7,5,3},
				{2,9,4}
			},
			{
				{8,3,4},
				{1,5,9},
				{6,7,2}
			},
			{
				{4,9,2},
				{3,5,7},
				{8,1,6}
			},
			{
				{2,7,6},
				{9,5,1},
				{4,3,8}
			}
		};
	public static int formingMagicSquare2(List<List<Integer>> s) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<magicSquare.length;i++) {
			int cost=0;
			for(int j=0;j<s.size();j++) {
				for(int k=0;k<s.get(j).size();k++) {
					cost+=Math.abs(magicSquare[i][j][k]-s.get(j).get(k));
				}
			}
			if(cost<min)min=cost;
		}
		return min;
	}
}

public class FormingMagicSquare {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		List<List<Integer>> s = new ArrayList<>();

		IntStream.range(0, 3).forEach(i -> {
			try {
				s.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = FormingMagicSquare_.formingMagicSquare(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
