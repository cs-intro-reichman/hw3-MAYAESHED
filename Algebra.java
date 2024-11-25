// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2,3));   // 2 + 3
		System.out.println(minus(7,2));  // 7 - 2
		System.out.println(minus(2,7));  // 2 - 7
		System.out.println(times(3,4));  // 3 * 4
		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
		System.out.println(pow(5,3));      // 5^3
		System.out.println(pow(3,5));      // 3^5
		System.out.println(div(12,3));   // 12 / 3
		System.out.println(div(5,5));    // 5 / 5
		System.out.println(div(25,7));   // 25 / 7
		System.out.println(mod(25,7));   // 25 % 7
		System.out.println(mod(120,6));  // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		while (x2 != 0) {
			if (x2 < 0) {
				x2 ++;
				sum --;
			} else if (x2 > 0) {
				x2 --;
				sum ++;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		while (x2 != 0) {
			if (x2 < 0) {
				sum ++;
				x2 ++;
			} else if (x2 > 0) {
				sum --;
				x2 --;
			}		
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		int positiveX2 = minus(0, x2);
			while (x2 > 0) {
				sum = plus(sum, x1);
				x2 --;
			}
			while (positiveX2 > 0) {
				sum = minus(sum, x1);
				positiveX2 --;
			}
		return sum;
	}
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = 1;
		while (n == 0) {
			return 1;
		}
		while (n > 0) {
			sum =  times(sum, x);
			n --;
		}
		return sum;
	}
	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 == 0) { 	
			System.out.print("NaN ");
			return (-1); // can't divide by 0
		}
		int count = 0;
		int positiveX2 = minus(0, x2);
		int positiveX1 = minus(0, x1);
			if (x1 > 0 && x2 > 0) {
				int sum = x1;
				for (int i = 0; sum >= x2; i ++) {
					sum = minus(sum, x2);
					count ++;
				}
			} else if (x1 > 0 && x2 < 0) {
				int sum = x1;
				for (int i = 0; sum >= positiveX2; i++) {
					sum = minus(sum, positiveX2);
					count --;	
				} 			
			} else if (x1 < 0 && x2 > 0) {
				int sum = positiveX1;
				for (int i = 0; sum >= x2; i ++) {
					sum = minus(sum, x2);
					count --;
				}
			} else if (x1 < 0 && x2 <0) {
				int sum = positiveX1;
				for (int i = 0; sum >= positiveX2; i ++) {
					sum = minus(sum, positiveX2);
					count ++;
				}
			}
		return count;
	}
	

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) { 	
			System.out.print("NaN ");
			return (-1); // can't divide by 0
		}
		int positiveX2 = (x2 < 0) ? minus(0, x2) : x2;
		int positiveX1 =  (x1 < 0) ? minus(0, x1) : x1;
		int sum = positiveX1;
		//positiveX1 minus positiveX2 until sum is equal to modulo
		for (int i = 0; sum >= positiveX2; i ++) {
			sum = minus(sum, positiveX2);
		}
		if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
			sum = minus(0, sum);
			}
		return sum;	
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0) {
			System.out.print( "NaN ");
			return (-1);			
		} else if (x == 0 || x == 1) {
			return x;
		}
		int L = 0; // Lower bound
		int H = x; // Upper bound
		int possibleSqrt = 0;
		while (L <= H) {
			possibleSqrt = div(plus(L, H), 2); // Midlle point
			int sqrtCheck = pow(possibleSqrt, 2);
			if (x == sqrtCheck) {
				return possibleSqrt; // square root was found 
			} else if (x < sqrtCheck) {
				H = minus(possibleSqrt, 1); // reduce upper bound
			} else {
				L = plus(possibleSqrt, 1); // increase lower bound

			}
		}
		return H;
	}	
}