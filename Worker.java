package aleksa;

public class Worker implements Runnable {
	private String S[];
	private String T[];
	private int n, m;
	private int l,r;
	private int brojac = 0;
	
	public Worker(String[] s, String[] t, int n, int m, int l, int r) {
		super();
		S = s;
		T = t;
		this.n = n;
		this.m = m;
		this.l = l;
		this.r = r;
	}


	@Override
	public void run() {
		for(int i = l; i <= r; i++) {
			for(int j = 0; j < m; j++) {
				if(S[i] == T[j]) {
					brojac++;
				}
			}
		}
	}


	/**
	 * @return the brojac
	 */
	public int getBrojac() {
		return brojac;
	}


	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}


	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}


	/**
	 * @return the m
	 */
	public int getM() {
		return m;
	}


	/**
	 * @param m the m to set
	 */
	public void setM(int m) {
		this.m = m;
	}
	
	

}
