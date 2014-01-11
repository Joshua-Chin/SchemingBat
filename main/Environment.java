package main;

import java.util.HashMap;
import java.util.Map;

import builtins.Version;
import datatypes.Atom;
import datatypes.Expression;
import functions.Cond;
import functions.Define;
import functions.If;
import functions.Lambda;
import functions.booleanoperators.And;
import functions.booleanoperators.Not;
import functions.booleanoperators.Or;
import functions.comparators.Eq;
import functions.comparators.Gt;
import functions.comparators.GtEq;
import functions.comparators.IsEqual;
import functions.comparators.Lt;
import functions.comparators.LtEq;
import functions.lists.Append;
import functions.lists.Car;
import functions.lists.Cdr;
import functions.lists.Cons;
import functions.lists.ListFunc;
import functions.math.Abs;
import functions.math.Div;
import functions.math.Minus;
import functions.math.Mul;
import functions.math.Plus;
import functions.math.integer.Modulo;
import functions.math.integer.Remainder;
import functions.math.integer.Quotient;
import functions.math.special.Expt;
import functions.math.special.Sqrt;
import functions.misc.IsEven;
import functions.misc.IsList;
import functions.misc.IsNull;
import functions.misc.Length;

/**
 * 
 * @author Joshua-
 * 
 *         Provides the primary execution environment for the interpreter. This
 *         retains all references to global and local variables. This limits the
 *         maximum number of computations to a fixed number
 */
public class Environment implements Cloneable {

	private static int computations = 0;
	private static int maxcomputations = 100000;
	private final static Map<String, Expression> globals;
	private final Map<String, Expression> locals;

	static {
		globals = new HashMap<>();
		
		globals.put("else", new Atom(Boolean.TRUE));
		
		globals.put("version", new Version());

		globals.put("*", new Atom(new Mul()));
		globals.put("/", new Atom(new Div()));
		globals.put("+", new Atom(new Plus()));
		globals.put("-", new Atom(new Minus()));
		globals.put("abs", new Atom(new Abs()));
		
		globals.put("modulo", new Atom(new Modulo()));
		globals.put("remainder", new Atom(new Remainder()));
		globals.put("quotient", new Atom(new Quotient()));
		
		globals.put("sqrt", new Atom(new Sqrt()));
		globals.put("expt", new Atom(new Expt()));
		
		globals.put("and", new Atom(new And()));
		globals.put("or", new Atom(new Or()));
		globals.put("not", new Atom(new Not()));

		globals.put("define", new Atom(new Define()));
		globals.put("lambda", new Atom(new Lambda()));
		globals.put("if", new Atom(new If()));
		globals.put("cond", new Atom(new Cond()));
		
		globals.put("equal?", new Atom(new IsEqual()));
		globals.put("=", new Atom(new Eq()));
		globals.put(">", new Atom(new Gt()));
		globals.put("<", new Atom(new Lt()));
		globals.put(">=", new Atom(new GtEq()));
		globals.put("<=", new Atom(new LtEq()));

		globals.put("cons", new Atom(new Cons()));
		globals.put("car", new Atom(new Car()));
		globals.put("cdr", new Atom(new Cdr()));
		globals.put("append", new Atom(new Append()));
		globals.put("list", new Atom(new ListFunc()));
		
		globals.put("null?", new Atom(new IsNull()));
		globals.put("list?", new Atom(new IsList()));
		globals.put("length", new Atom(new Length()));
		globals.put("even?", new Atom(new IsEven()));
	}

	public Environment() {
		locals = new HashMap<>();
	}

	public Environment(Map<String, Expression> locals) {
		this.locals = locals;
	}

	public static void addglobal(String s, Expression e) {
		globals.put(s, e);
	}

	public void add(String s, Expression e) {
		locals.put(s, e);
	}

	/**
	 * This should only be called by the {@link Expression} base class.
	 */
	public static void logcomputation() {
		computations++;
		if (computations >= maxcomputations) {
			throw new RuntimeException("Maximum computations reached");
		}
	}

	public static void setmaxcomputations(int max) {
		maxcomputations = max;
	}

	public Expression value(String name) {
		if (locals.containsKey(name)) {
			return locals.get(name);
		} else if (globals.containsKey(name)) {
			return globals.get(name);
		} else {
			throw new RuntimeException("Undefined variable name: " + name);
		}
	}

	@Override
	public Environment clone() {
		return new Environment(new HashMap<>(locals));
	}
	
	@Override
	public String toString() {
		return "locals:"+locals.toString()+" globals:"+globals.toString();
	}
}
