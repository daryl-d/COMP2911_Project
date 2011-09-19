
public class Human implements Player {

	public Human(String name) {
		humanName = name;
	}
	@Override
	public boolean playerHuman() {
		return true;
	}
	
	public String toString() {
		return humanName;
	}
	private String humanName;
}
