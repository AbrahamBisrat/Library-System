package business;

public class Utils {
	public static final String ADMIN = "admin";
	public static final String LIBRARIAN = "librarian";
	public static final String DUAL_ROLE = "dual";
	
	// Define color constants
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_RED = "\u001B[31m";
	public static final String TEXT_GREEN = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_BLUE = "\u001B[34m";
	public static final String TEXT_PURPLE = "\u001B[35m";
	public static final String TEXT_CYAN = "\u001B[36m";
	public static final String TEXT_WHITE = "\u001B[37m";

	// Implementation
	
	public static void main(String[] args) {
		System.out.println(TEXT_RED + "This text is red!" + TEXT_RESET);
		
	}
}
