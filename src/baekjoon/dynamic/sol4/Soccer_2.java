package baekjoon.dynamic.sol4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Soccer_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int inputA = Integer.parseInt(bf.readLine());
		int inputB = Integer.parseInt(bf.readLine());

		double pA = (double) inputA / 100;
		double pB = (double) inputB / 100;

		double resA = getProbability(pA);
		double resB = getProbability(pB);
		double res = 1 - resA * resB;
		System.out.println(res);
	}

	public static double getProbability(double p) {
		double res = 0;
		for (int i = 0; i <= 18; i++) {
			if (!isPrimeNum(i)) {
				res += nCr(18, i) * Math.pow(p, i) * Math.pow((1-p), 18 - i);
			}
		}
		return res;
	}

	public static boolean isPrimeNum(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static int nCr(int n, int r) {
		if (n == r || r == 0)
			return 1;
		return nCr(n - 1, r) + nCr(n - 1, r - 1);
	}
}
