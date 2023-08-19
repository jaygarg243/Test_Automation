package jayashgarg.testComponents;

public class stringtest {
	public static String generateProductXpath1(String product) {
		String xpath = "//div[text()='"+product+"']/parent::a/parent::div/following-sibling::div/button";
		return xpath;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = generateProductXpath1("sauce labs");
		System.out.println(a);
	}

}
