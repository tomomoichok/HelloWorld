package lesson3;

public class ExceptionOpt {
	public static void main(String[] args) {
		try {
			String str = null;
			System.out.println(str.equals(""));
		} catch (Exception e) {
			System.out.println(e);
//
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
//
//			Exception ex  = new Exception("my exception");
//			System.out.println(ex.getMessage());
//
//			Exception ex1  = new Exception("my exception",e);
//			System.out.println(ex1);
		}

	}
}
