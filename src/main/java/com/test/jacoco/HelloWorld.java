package com.test.jacoco;

import java.util.*;


public class HelloWorld {
    public HelloWorld() {

    }

    public String Method1() {
        return "Hello World";
    }

    public int Method2(int a, int b) {
        return a + b;
    }
    
    public int Method3(int a, int b, int c){
    	if((a>5&&b<0)||c>0) {
    		System.out.println("Condition 1");
    	}
    	else if(a<5 && c<-2 ) {
    		System.out.println("Condition 2");
    	}
    	else {
    		System.out.println("Condition 3");
    	}
    	return 0;
    }
    public int Method4(int a, int b, int c, int d, float e) {
    	if(a == 0) {
    		return 0;
    	}
    	int x = 0;
    	if((a == b) || ((c == d) && (bug(a)))) {
    		 x = 1; 
    	}
    	e = 1/x;
    	return 0;
    }
    public boolean bug(int a) {
		return a == 5;
	}
    
    public boolean isTriangle(int a, int b, int c) {
    	/**
    	 * TODO: You need to complete this method to determine whether  a
    	 * triangle is formed or not when given the input edge a, b and c.
    	 */
		return a > 0 && b > 0 && c > 0 &&
				(a + b > c) &&
				(a + c > b) &&
				(b + c > a);
    }

    private boolean ifValidDay(int month, int day, boolean bigYear){
        if(month <= 0 || month > 12 || day <= 0 || day > 31){
            return false;
        }
        if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
            return false;
        }
        if(!bigYear && month == 2 && day > 28){
            return false;
        }
        return true;
    }
    public boolean isBirthday(int year, int month, int day) {
    	/**
    	 * TODO: You need to complete this method to determine whether a 
    	 * legitimate date of birth between 1990/01/01 and 2019/10/01 is 
    	 * formed or not when given the input year, month and day.
    	 */

		Set<Integer> bigYear = new HashSet<Integer>();
		for(int i = 1990; i < 2019; i++){
			if(((i % 100 != 0) && (i % 4 == 0)) || ((i % 400 == 0))){
				bigYear.add(i);
			}
		}

		if(year < 1990 || year > 2019){
		    return false;
        }
		if(year != 2019){
		    return ifValidDay(month, day, bigYear.contains(year));
        }else{
		    if (month > 10){
		        return false;
            }else if(month == 10){
		        return day == 1;
            }else{
		        return ifValidDay(month, day, false);
            }
        }

    }
    public Double miniCalculator(double a, double b, char op) {
    	/**
    	 * TODO: You need to complete this method to form a small calculator which 
    	 * can calculate the formula: "a op b", the op here can be four basic  
    	 * operation: "+","-","*","/". 
    	 */
    	double result = 0.0;
    	switch (op){
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/': result = a / b; break;
            default: break;
        }
    	return result;
    }
    
}
