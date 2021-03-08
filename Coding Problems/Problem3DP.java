package formalClass;

public class Problem3DP {
	
	public static void main(String[] args) {
		int res = minimumBoxes(23);
		System.out.println(res);
	}
	
	public static int minimumBoxes(int n) {
		int[] M = new int[n + 1];
		M[0] = 0;
		M[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (isSquare(i)) {
				M[i] = 1;
			} else {
				int curMin = Integer.MAX_VALUE;
				for (int j = 1; j < i; j++) {
					curMin = Math.min(curMin, M[i - j] + M[j]);
				}
				M[i] = curMin;
			}
		}
		return M[n];
	}
	
	private static boolean isSquare(int n) {
		for (int i = 0; i < n; i++) {
			if (i * i == n) {
		        return true;
		    }
		}
		return false;
	}
}
