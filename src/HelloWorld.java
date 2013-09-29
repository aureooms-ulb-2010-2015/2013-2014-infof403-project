
class HelloWorld{

	public enum Token {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
		THURSDAY, FRIDAY, SATURDAY 
	}
	
	public static void main(String[] args) {
		System.out.println("Hello world!");

		String[] myStringArray = {"a","b","c"};

		System.out.println(myStringArray);

		System.out.println(HelloWorld.Token.SUNDAY);



	}
}