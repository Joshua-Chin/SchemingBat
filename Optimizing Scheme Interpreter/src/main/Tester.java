package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		try {
			String input;
			List<String> in = Arrays.asList(args);
			if (in.size() == 0) {
				System.out
						.println("Scheme Interpreter, version 1.31\n"
								+ "Copyright, Joshua Chin\n"
								+ "Usage: java –jar SchemeInterpreter [-i inputfile|stdin] [-o outputfile][-n max-interations]");
				return;
			}
			if (!in.get(in.indexOf("-i") + 1).equals("stdin")) {
				input = "";
				String name = in.get(in.indexOf("-i") + 1);
				BufferedReader br = new BufferedReader(new FileReader(name));
				StringBuilder sb = new StringBuilder();
				String s;
				while ((s = br.readLine()) != null) {
					sb.append(s+"\n");
				}
				br.close();
				input = sb.toString();
			} else {
				input = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				StringBuilder sb = new StringBuilder();
				String s;
				String end = "" + ((char) 0x01);
				while ((s = br.readLine()) == null || !s.equals(end)) {
					sb.append(s+"\n");
				}
				br.close();
				input = sb.toString();
			}
			if (in.contains("-n")) {
				int max = Integer.parseInt(in.get(in.indexOf("-n") + 1));
				Environment.setmaxcomputations(max);
			}
			input = "(define caar (lambda (x) (car (car x))))\r\n" + 
					"(define cdar (lambda (x) (cdr (car x))))\r\n" + 
					"(define caaar (lambda (x) (car (caar x))))\r\n" + 
					"(define cdaar (lambda (x) (cdr (caar x))))\r\n" + 
					"(define caaaar (lambda (x) (car (caaar x))))\r\n" + 
					"(define cdaaar (lambda (x) (cdr (caaar x))))\r\n" + 
					"(define cadaar (lambda (x) (car (cdaar x))))\r\n" + 
					"(define cddaar (lambda (x) (cdr (cdaar x))))\r\n" + 
					"(define cadar (lambda (x) (car (cdar x))))\r\n" + 
					"(define cddar (lambda (x) (cdr (cdar x))))\r\n" + 
					"(define caadar (lambda (x) (car (cadar x))))\r\n" + 
					"(define cdadar (lambda (x) (cdr (cadar x))))\r\n" + 
					"(define caddar (lambda (x) (car (cddar x))))\r\n" + 
					"(define cdddar (lambda (x) (cdr (cddar x))))\r\n" + 
					"(define cadr (lambda (x) (car (cdr x))))\r\n" + 
					"(define cddr (lambda (x) (cdr (cdr x))))\r\n" + 
					"(define caadr (lambda (x) (car (cadr x))))\r\n" + 
					"(define cdadr (lambda (x) (cdr (cadr x))))\r\n" + 
					"(define caaadr (lambda (x) (car (caadr x))))\r\n" + 
					"(define cdaadr (lambda (x) (cdr (caadr x))))\r\n" + 
					"(define cadadr (lambda (x) (car (cdadr x))))\r\n" + 
					"(define cddadr (lambda (x) (cdr (cdadr x))))\r\n" + 
					"(define caddr (lambda (x) (car (cddr x))))\r\n" + 
					"(define cdddr (lambda (x) (cdr (cddr x))))\r\n" + 
					"(define caaddr (lambda (x) (car (caddr x))))\r\n" + 
					"(define cdaddr (lambda (x) (cdr (caddr x))))\r\n" + 
					"(define cadddr (lambda (x) (car (cdddr x))))\r\n" + 
					"(define cddddr (lambda (x) (cdr (cdddr x))))" + input;
			String out = Main.eval(input);
			out = out.replace('[', '(');
			out = out.replace(']', ')');
			out = out.replaceAll("java.math.", "");
			out = out.replaceAll("java.util.", "");
			out = out.replaceAll("java.lang.", "");
			out = out.replaceAll("LinkedList", "List");
			out = out.replaceAll("BigDecimal", "Real Number");
			out = out.replaceAll("Rounding necessary",
					"Contract violated; Real Number cannot be cast to Integer");
			out=out.substring(112);
			if (in.contains("-o")) {
				String name = in.get(in.indexOf("-o") + 1);
				BufferedWriter bw = new BufferedWriter(new FileWriter(name));
				bw.write(out);
				bw.flush();
				bw.close();
			} else {
				System.out.println(out);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
