class GCD {
    /**
     * greatest common divisor of m and n
     * time complexity: O(n)
     */
    public static int gcd_1(int m, int n){
        int divisor = 1;
        int count = 0;
        for(int i=2; i<m && i<n; i++){
            count++;
            if(m%i == 0 && n%i == 0)
                divisor = i;
            }
            
        return count;
    } 

    /**
     * greatest common divisor of m and n, decrementing from n to 1, breaking when found first divisor (the greatest)
     * time complexity: O(n)
     */
    public static int gcd_2(int m, int n){
    int divisor = 1;
    int count = 0;
        for(int i=n; i>=1; i--){
            count++;
            if(m%i == 0 && n%i == 0){
                divisor = i; 
                break;
            }
    }
    return count;
    }

    /**
     * greatest common divisor of m and n, finding divisors from n/2 to 1, breaking when found first one
     * time complexity: O(n)
     */
    public static int gcd_3(int m, int n) {
        int divisor = 1;
        int count = 0;
        if(m%n == 0) 
                return n;
        for(int i = n/2; i >= 1; i--){
                count++;
                if(m%i == 0 && n%i == 0){
                    
                    divisor=i; 
                    break;
            }
        }
        return count;
    }

    /**
     * greatest common divisor of m and n using Euclid's algorithm, recursively finding gcd of n and m%n till m%n is 0 
     * time complexity: O(logn)
     */
    public static int gcd_4(int m, int n, int count){
        if(m%n == 0) {
            count++;
            return count;
        }
        else {
            count++;
            return gcd_4(n, m%n, count);
        }
    }
    
    /**
     * Main method to compare the performance of the four gcd methods in time and # of iterations.
     */
    public static void main(String[] args) {
        long startTime;
        long stopTime;

        int ran1;
        int ran2;
        
        int temp;
        
        long time1;
        long time2;
        long time3;
        long time4;
        
        
        System.out.println("Comparing the gcd methods using the execution time");
        System.out.println(String.format("%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t", "Number1", "Number2", "gcd_1", "gcd_2", "gcd_3", "gcd_4"));
        for (int i = 0; i < 20; i++) {
            ran1 = (int)(Math.random()*1000001);
            ran2 = (int)(Math.random()*1000001);

            startTime = System.nanoTime();
            temp = gcd_1(ran1, ran2);
            stopTime = System.nanoTime();
            time1 = stopTime-startTime;

            startTime = System.nanoTime();
            temp = gcd_2(ran1, ran2);
            stopTime = System.nanoTime();
            time2 = stopTime-startTime;

            startTime = System.nanoTime();
            temp = gcd_3(ran1, ran2);
            stopTime = System.nanoTime();
            time3 = stopTime-startTime;

            startTime = System.nanoTime();
            temp = gcd_4(ran1, ran2, 0);
            stopTime = System.nanoTime();
            time4 = stopTime-startTime;

            System.out.println(String.format("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t", ran1, ran2, time1, time2, time3, time4));
        }
        
        int it1;
        int it2;
        int it3;
        int it4;

        System.out.println("\nComparing the gcd methods using number of iterations");
        System.out.println(String.format("%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t", "Number1", "Number2", "gcd_1", "gcd_2", "gcd_3", "gcd_4"));
        for (int i = 0; i < 20; i++) {
            ran1 = (int)(Math.random()*1000001);
            ran2 = (int)(Math.random()*1000001);

            it1 = gcd_1(ran1, ran2);

            it2 = gcd_2(ran1, ran2);

            it3 = gcd_3(ran1, ran2);

            it4 = gcd_4(ran1, ran2, 0);
            

            System.out.println(String.format("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t", ran1, ran2, it1, it2, it3, it4));
        }
    }

    /**
     * Differences in algorithm analysis and experimental measuments of performance:
     * The algorithm analysis cooroberates with the experimental measurements of performance.
     * The gcd_4 method is the most efficient in both time complexity and number of iterations.
     * this matches the algorithm analysis of O(logn), which is more efficient than the other methods of O(n).
     * The gcd_1, gcd_2, and gcd_3 methods all have a time complexity of O(n) and have similar performance in the experimental measurements.
     * Even though gcd_3 has a slight optimization by iterating at n/2 times, it does not significantly improve its performance compared to gcd_1 and gcd_2.
     */
}
