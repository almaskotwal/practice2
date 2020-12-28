package seleniumPractice;

public class practiceMixed {

	 static String name;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				System.out.println(example());
				
				int a = 1000;
				int b = 100;
				
				if(a==b) {
					System.out.println("they are the equal");
				} else {
					System.out.println("they are not equal");
				}
				
				
				String x = "abc";
				String y = "abc";
				
				if(x.equals(y)) {
					System.out.println("it is equal");
				} else {
					System.out.println("it is not equal");
				}
	}
	
	public static String example() {
		name = "mahmood";
		return name;
}
}