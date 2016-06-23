package logic4Fibbonachi;

public class Fibb {
	
	private enum CalcType {
		RECURSION, LOOP
	}
	
	private CalcType calcType;

	public Fibb(CalcType calcType) {
		this.calcType = calcType;
	}
	
	public int fibbLoop (int n) { // more quick way

		if (n < 0) {
			throw new IllegalArgumentException("Not exist");
		}
		
		int [] fibb = new int[n+1];
		
		if (n==0 || n==1) {
			return 1;
		}
		else {
			fibb[0]=1;
			fibb[1]=1;
			for (int i = 2; i <= n; i++) {
				fibb[i] = fibb[i-1] + fibb[i-2];
			}
			
			return fibb[n];
		}

	}


	public int fibbRecursion (int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Not exist");
		}
		if (n==0 || n==1) {
			return 1;
		}
		else {
			
			return fibbRecursion(n-1) + fibbRecursion(n-2);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Fibb fibb = new Fibb(CalcType.RECURSION); 
		String calcType = fibb.calcType.name();
		System.out.println(calcType + " fib(0) = " + fibb.fibbRecursion(0));
		System.out.println(calcType + " fib(1) = " + fibb.fibbRecursion(1));
		System.out.println(calcType + " fib(6) = " + fibb.fibbRecursion(6));
		long start = System.currentTimeMillis();
		System.out.println(calcType + " fib(40) = " + fibb.fibbRecursion(40));
		System.out.println("time = " + (System.currentTimeMillis()-start));
		
		fibb = new Fibb(CalcType.LOOP);
		calcType = fibb.calcType.name();
		System.out.println(calcType + " fib(0) = " +fibb.fibbLoop(0));
		System.out.println(calcType + " fib(1) = " +fibb.fibbLoop(1));
		System.out.println(calcType + " fib(6) = " +fibb.fibbLoop(6));
		start = System.currentTimeMillis();
		System.out.println(calcType + " fib(40) = " + fibb.fibbLoop(40));
		System.out.println("time = " + (System.currentTimeMillis()-start));
		
		
		//fibb.fibbRecursion(fibb.fibbRecursion(-1));
		

	}

}
