package main;

public class Test {
	public static void main(String[] args) {
		System.out.println(Main.eval("(define caar (lambda (x) (car (car x))))\r\n" + 
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
						"(define cddddr (lambda (x) (cdr (cdddr x)))) (+ 1 3)").substring(112));
	}
}
