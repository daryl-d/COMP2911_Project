
public class AI implements Player{

	public AI(String name) {
		AIname = name;
	}
	@Override
	public boolean playerHuman() {
		return false;
	}
	
	public String toString() {
		return AIname;
	}
	
	private String AIname;

}
