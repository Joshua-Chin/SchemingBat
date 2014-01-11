package builtins;

import datatypes.Atom;

public class Version extends Atom {

	public Version() {
		super(
				"Scheme Interpreter, version 1.41\n"
						+ "Copyright, Joshua Chin\n"
						+ "Usage: java –jar SchemeInterpreter [-i inputfile|stdin] [-o outputfile][-n max-interations]");
	}

}
