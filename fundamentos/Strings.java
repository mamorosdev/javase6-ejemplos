package Fonaments;
import java.util.*;

public class Strings {
	
	// Prova d'acces d'Strings
	public static void main(String[] args) {
		
	String s0="a";
	String s1="a";
	String s2 = new String("a");
	
	System.out.println( (s0==s1) );
	System.out.println( (s1==s2) );
	System.out.println( "a"=="a" );
	String a = "a"; 
	System.out.println( (s1==a) );
	
	System.out.print("Arguments consola ");
	for (String s: args) {
		System.out.print(s + " ");
	}
	System.out.println();
	
	// SubString 
	String s = "abc";
	String mod = s.substring(0,2);
	System.out.println( s ); // abc
	System.out.println( mod ); // ab

	// StringBuilder.
	StringBuilder sb = new StringBuilder();
	int i=0;
	for (int j = 0; j < 100; j++) {
		if (i > 9) i = 0;
		sb = sb.append(i);
		i++;
		System.out.println(sb);
	}
	sb = sb.delete(0,60);
	System.out.println(sb); 
	
	Properties p = System.getProperties();
	Enumeration en = p.propertyNames();
	// Iterator it = en.iterator();
	// for () */
	
	System.getProperties().list(System.out); 
	/*
	String ss = "";
	int tempsi = (int) System.currentTimeMillis();
	int i=0;
	for (int j = 0; j < 100; j++) {
		if (i > 9) i = 0;
		ss += i;
		i++;
		System.out.println(ss);
	} 
	int tempsf = (int) System.currentTimeMillis();
	System.out.println(tempsf - tempsi);
	}
	*/
	
	}
}
