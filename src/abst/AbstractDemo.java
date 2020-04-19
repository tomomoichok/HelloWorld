package abst;

public class AbstractDemo {
	public static void main(String [] args)
	   {
	      /* 以下是不允许的，会引发错误 */
//	      Employee e = new Employee("George W.", "Houston, TX", 43);
		Employee e = (Employee) new Salary("George W.", "Houston, TX", 43, 0);

	      System.out.println("\n Call mailCheck using Employee reference--");
	      e.mailCheck();
	    }
}
