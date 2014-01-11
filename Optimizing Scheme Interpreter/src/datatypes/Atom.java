package datatypes;

import java.util.List;

import main.Environment;
/**
 * 
 * @author Joshua
 *
 *
 *Atom is the simplest expression, representing a single object
 */
public class Atom extends Expression {

	private final Object o;
	public String linenumber="";
	
	public Atom(Object obj) {
		o = obj;
	}

	@Override
	public Atom simplify(Environment e) {
		return this;
	}

	public Object value() {
		return o;
	}

	@Override
	public String toString() {
		if(o==null){
			return "";
		}else if(o instanceof List){
			return o.toString().replaceAll(",", "");
		}else{
			return o.toString();
		}
	}

	@Override
	public String linenumber() {
		return linenumber;
	}

}
