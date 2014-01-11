package datatypes;

import java.util.HashMap;
import java.util.Map;

import main.Environment;

public class Variable extends Expression {

	public final String name;
	public final int index;
	public String linenumber="";
	private static final Map<String, Integer> fastVariable=new HashMap<>();
	private static int slot=0;
	
	public Variable(String name) {
		if(!fastVariable.containsKey(name)){
			fastVariable.put(name, slot);
			slot++;
		}
		this.name = name;
		this.index=fastVariable.get(name);
	}

	@Override
	public Expression simplify(Environment e) {
		return e.value(name);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public String linenumber() {
		return linenumber;
	}

}
