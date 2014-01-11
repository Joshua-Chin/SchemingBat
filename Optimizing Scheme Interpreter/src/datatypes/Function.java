package datatypes;

import java.util.List;

import main.Environment;

public abstract class Function {

	public abstract Expression invoke(List<Expression> args, Environment e);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	public static void argcheck(int expected, List<Expression> args) {
		if (args.size() != expected) {
			throw new RuntimeException("Invalid number of arguments, expected "
					+ expected + " recieved " + args.size());
		}
	}
}
