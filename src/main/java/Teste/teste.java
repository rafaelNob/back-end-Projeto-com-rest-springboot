package Teste;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class teste {

	public static void main(String[] args) {
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		String format = nf.format(new BigDecimal(22));
		double A =22.11111;
		double B = 33.3;
	
		
		
		System.out.println(format);
	}
}
