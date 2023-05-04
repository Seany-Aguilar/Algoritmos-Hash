package Hash;

import java.util.Arrays;

/* @author Betterlee
 */
public class BHash {

    String[] arreglo;
    int tamanio, contador;

    public BHash(int tam) {
        tamanio = tam;
        arreglo = new String[tam];
        Arrays.fill(arreglo, "-1");
    }

    public void funcionHash(String[] cadenaArreglo, String[] arreglo) {
        int i;
        for (i = 0; i < cadenaArreglo.length; i++) {
            String elemento = cadenaArreglo[i];
            int indiceArreglo = Integer.parseInt(elemento) % 7;
            System.out.println("El indice es: " + indiceArreglo + "Para el elemento o valor: "
                    + elemento);
            while (!"-1".equals(arreglo[indiceArreglo])) {
                indiceArreglo++;
                System.out.println(" Ocurrio una colision con el indice: " + (indiceArreglo - 1)
                        + " Cambiar indice " + indiceArreglo);
                indiceArreglo %= tamanio;
            }
            arreglo[indiceArreglo] = elemento;
        }

    }
//Mostrar la tabla

    public void mostrar() {
        int incremento = 0, i, j;
        for (i = 0; i < 1; i++) {
            incremento += 8;
            for (j = 0; j < 71; j++) {
                System.out.println("-");
            }
            System.out.println(" ");
            for (j = incremento - 8; j < incremento; j++) {
                System.out.println("| %3s " + " " + j);
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) {
                System.out.println("-");
            }
            System.out.println();
        }
        
    }
    public String BuscarClave(String elemento){
            int indiceArreglo = Integer.parseInt(elemento)%7;
            int contador = 0;
            while(!"-1".equals(arreglo [indiceArreglo])){
                if(arreglo [indiceArreglo].equals(elemento)){
                    System.out.println("El elemento" + elemento +
                            "Fue encontrado en el indice" + indiceArreglo);
                    return arreglo[indiceArreglo];
                }
                indiceArreglo ++;
                indiceArreglo %= tamanio;
                contador ++;
                if(contador<=7){
                    break;
                }
            }
        return null;
    }


    public static void main(String[] args) {
       BHash bh= new BHash(8);
       String [] elementos ={"20", "23", "40", "68", "99","13", "33", "04"};
       bh.funcionHash(elementos, bh.arreglo);
       bh.mostrar();
       String buscador = bh.BuscarClave(null);
       if(buscador == null){
           System.out.println("El elemento %d no se encuentra en la tabla" + elementos);
    }
    }
}
