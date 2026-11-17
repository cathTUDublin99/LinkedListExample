package application;
 
public class Module{ 
	private String name;
	private String code;
	private int credits;
	
	public Module() {
		this.name = "";
		this.code = "";
		this.credits = 0;
	}
	
	public Module(String n, String c, int credits) {
		this.name = n;
		this.code = c;
		this.credits = credits;
	}

	public String getName() {
		return this.name;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setCode(String c) {
		this.code = c;
	}
	
	public void setCredits(int c) {
		this.credits = c;
	}
	
	public boolean equals(Object o)
	{
		Module m = (Module) o;
		if (this.name.equalsIgnoreCase(m.getName()) &&
				this.code.equalsIgnoreCase(m.getCode()) &&
				this.credits == m.getCredits())
			return true;
		else
			return false;
	}
	public String toString() {
		return "The name of the module is " + this.name + "\n"
				+ "The module code is " + this.code + "\n"
				+ "The number of credits are " + this.credits + "\n";
	}
}
