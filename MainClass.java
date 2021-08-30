package aleksa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {
	//private static String S[];
	//private static String T[];
	public static void F(String S[], String T[],int n, int m, int t) {
		Worker[] workers = new Worker[t];
		ExecutorService executor = Executors.newFixedThreadPool(t);
		int d = n / t;
		for(int i = 0; i < t; i++) {
			workers[i] = new Worker(S, T, n, m, i * d, (i == d-1) ? n - 1: (i + 1) * d - 1);
		}
		for(int i = 0; i < t; i++) {
			executor.submit(workers[i]);
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int rez = 0;
		for(int i = 0; i < t; i++) {
			rez+=workers[i].getBrojac();
		}
		System.out.println("Ukupan broj pojavljivanja: " + rez);
	}
	
	public static void main(String[] args) {
		int n = 6;
		int m = 2;
		int t = 2;
		String[] S = new String[n];
		String[] T = new String[m];
		S[0] = "ABC";
		S[1] = "ABC";
		S[2] = "ABC";
		S[3] = "CBE";
		S[4] = "VBA";
		S[5] = "VBA";
		T[0] = "ABC";
		T[1] = "ABC";
		F(S, T, n, m, t);
	}
}
