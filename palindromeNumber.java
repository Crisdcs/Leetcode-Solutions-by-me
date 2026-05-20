
//https://leetcode.com/problems/palindrome-number/description/
// @author: Crisdcs
import java.util.Scanner;

class palindromeNumber {
	public boolean isPalindrome(int x) {
		boolean isP = false;
		if (x < 0) { // si es numero negativo nunca sera polindromo
			isP = false;
		} else {
			int i = 0;
			int ult = 0;

			int v[] = new int[10];
			int u[] = new int[10];
			v[0] = x % 10; // guarda el ultimo digito del entero
			while (x >= 10) {// ciclo para ir guardando los ultimos digitos del entero en una variable
				x = x / 10;
				ult = x % 10;
				v[i + 1] = ult; // se salta una posicion porque la 0 ya está ocupada
				i++;
			}
			int j = 0;
			int l = i;
			while (l >= 0) {// guarda de manera inversa los valores en otro vector
				u[j] = v[l];
				j++;
				l--;
			}
			int cont = 0;
			for (int n = 0; n <= i; n++) {
				if (u[n] == v[n]) {// compara el valor en la posicion del indice
					cont++;// contador
				}
			}
			if (cont == (i + 1)) {// compara el valor del contador con el del indice inicial
				isP = true;
			} else {
				isP = false;
			}
		}
		System.out.println(isP);
		return isP;
	}

	public static void main(String[] args) {
		Scanner l = new Scanner(System.in);
		int n = l.nextInt();
		palindromeNumber pn = new palindromeNumber();
		pn.isPalindrome(n);
		l.close();
	}
}