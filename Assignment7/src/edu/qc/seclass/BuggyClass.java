package edu.qc.seclass;

public class BuggyClass {

    public int buggyMethod1(int numberOne, int numberTwo) {

        int sum = numberOne + numberTwo;
        int val = 0;

        int sub = Math.abs(numberOne - numberTwo);
        if (sub / 10 >= 0) {
            System.out.println(sub);
            val = sub;
        }
        
        if (sum / 10 >= 0) {
            sum = sum / 10;
            int d = 100 / sum;
        }

        int mul = numberOne * numberTwo;
        if (mul % 2 == 0) {
            System.out.println("Multiplication of two number is even number");
            val = mul;
        }

        val = mul - (numberOne + numberTwo);
        System.out.println("Value of this number is : " + val);

        return val;
    }

    public int buggyMethod2(int numberOne, int numberTwo) {

        int sum = numberOne + numberTwo;
        int val = 0;

        int sub = Math.abs(numberOne - numberTwo);
        if (sub / 10 >= 0) {
            System.out.println(sub);
            val = sub;
        }
        
  

        int mul = numberOne * numberTwo;
        if (mul % 2 == 0) {
            System.out.println("Multiplication of two number is even number");
            val = mul;
        }
        
        if (sum / 10 >= 0) {
            sum = sum / 10;
            int d = 100 / sum;
        }

        val = mul - (numberOne + numberTwo);
        System.out.println("Value of this number is : " + val);

        return val;
    }
    
    public int buggyMethod3(int numberOne, int numberTwo) {

        int sum = numberOne + numberTwo;
        int val = 0;

        int sub = Math.abs(numberOne - numberTwo);
        if (sub / 10 >= 0) {
            System.out.println(sub);
            val = sub;
        }
        
        if (sum / 10 >= 0) {
            sum = sum / 10;
            int d = 100 / sum;
        }

        int mul = numberOne * numberTwo;
        if (mul % 2 == 0) {
            System.out.println("Multiplication of two number is even number");
            val = mul;
        }

        val = mul - (numberOne + numberTwo);
        System.out.println("Value of this number is : " + val);

        return val;
    }
    
  

   public void buggyMethod4(int a, int b){
	   /*This is impossible because achieving 100% statement coverage 
	    * while also being able to trigger the divisible by 0 error will result in the program 
	    * being terminated before reaching 100% statement coverage. 
	    * When attempting to achieve 100% statement coverage of branches without displaying the issue, 
	    * the error cannot exist simultaneously in branches.
          */
   }
   
   public void buggyMethod5(){
   	 /* After checking all the condition, I come to a conclusion that it is impossible. In short, It is impossible to reach 100% statement coverage when there is an error.
   	  *  Because an existence of an error would interrupt the program preventing the reach of 100% statement coverage.
   	  */
   }
	
}
