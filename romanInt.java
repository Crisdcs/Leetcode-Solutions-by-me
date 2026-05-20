//https://leetcode.com/problems/roman-to-integer/description/
// @author: Crisdcs

import java.util.HashMap;
import java.util.Scanner;

public class romanInt {

    public int numRomano(String romano) {
        // se crea un hashmap con los valores de los numeros romanos
        var romanPrincipal = new HashMap<Character, Integer>();
        romanPrincipal.put('I', 1);
        romanPrincipal.put('V', 5);
        romanPrincipal.put('X', 10);
        romanPrincipal.put('L', 50);
        romanPrincipal.put('C', 100);
        romanPrincipal.put('D', 500);
        romanPrincipal.put('M', 1000);

        // se crea un array con los valores de los numeros romanos ingresados
        char[] roman = romano.toCharArray();

        int siRomano, operacion, resultado;
        siRomano = operacion = resultado = 0;

        //Se eliminan letra que no sean numeros romanos para evitar errores
        for (char i : roman) {
            if(romanPrincipal.containsKey(i)){
                siRomano++;
            }
        }

        /*Si no se encuentran numeros romanos en la cadena, entonces no es un numero romano, pero si sí se encuentra
        al menos uno se realiza la operacion*/
        if(siRomano==0){
            System.out.println("No es numero romano");
        }else{
            //Se declara el nuevo vector dependiendo de la cadena original
            int[] newRomano = new int[siRomano];

            int j=0;

            //Copia del vector excluyendo letras que no sean romanos
            for (char i : roman) {
                if(romanPrincipal.containsKey(i)){
                    newRomano[j] = romanPrincipal.get(i);
                    j++;
                }
            }

            //Ciclo con logica para hacer la operacion de numeros romanos
            for (int i = 0; i < newRomano.length; i++) { //De 0 hasta el tamaño del vector
                int valorActual = newRomano[i]; //variable temporal a la posicion actual del vector
                if (i + 1 < newRomano.length && valorActual < newRomano[i + 1]) {
                    //Condicion indice + 1 < al tamaño del vector Y valor actual < al vector en una posicion delante
                    operacion -= valorActual;
                } else { //Si es mayor o igual, se suma
                    operacion += valorActual;
                }
            }
        }

        if(operacion>=1 && operacion<4000){
            return operacion;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        romanInt br = new romanInt();
        String nr;
        nr = l.next();
        System.out.println(br.numRomano(nr));
        l.close();
    }
}