package functions.lists;

import java.util.LinkedList;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Append extends Function {

	@SuppressWarnings("unchecked")
	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		List<Expression> out = new LinkedList<>();
		for (Expression ex : args) {
			out.addAll((List<Expression>) ex.eval(e).value());
		}
		return new Atom(out);
	}

}
