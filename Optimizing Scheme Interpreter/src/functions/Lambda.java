package functions;

import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Closure;
import datatypes.Expression;
import datatypes.ExpressionList;
import datatypes.Function;
import datatypes.Variable;

public class Lambda extends Function {

	@Override
	public Expression invoke(List<Expression> args, final Environment e) {
		argcheck(2, args);
		final List<Expression> args1 = ((ExpressionList) args.get(0)).args();
		final Expression body = args.get(1);
		Function out = new Function() {
			Environment env = e.clone();

			@Override
			public Expression invoke(List<Expression> args, Environment e) {
				if (args.size() != args1.size()) {
					throw new RuntimeException("Invalid number of arguments,"
							+ " expected " + args1.size() + " recieved "
							+ args.size());
				}
				for (int i = 0; i < args.size(); i++) {
					String name = ((Variable) args1.get(i)).name;
					env.add(name, new Closure(args.get(i), e));
				}
				return new Closure(body, env);
			}
		};
		return new Atom(out);
	}

}
