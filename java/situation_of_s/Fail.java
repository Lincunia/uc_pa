/*
import java.util.Scanner;
public class Caso {
  public static void main(String[] args) {
    int opcion = 0;
    boolean salir = false;

    while (!salir) {
      mostrarMenu();
      opcion = validar(opcion, "\nIntroduzca opciÃ³n (1-3): ");
      System.out.printf("\n");
      switch (opcion) {
                case 1 -> {
                    int cantidadVocales=validar(opcion,"\nDigite: ");
                    ConteoVocale(cantidadVocales);
                }
                case 2 -> {
                    int numero1=validar(opcion,"\ndigite un nujmero: ");//cuidado debemos dar f7 para poder entarr a la funcion o procedimiento
                    tablaDel8(numero1);
                }
                case 3 -> {
                    salir=true;
                    System.out.println("Gracias por su atencion. \n");
                }
            }
        }
       
    }
   
     
    private static   void mostrarMenu()
    {
        System.out.printf("\n>>> MENÃš DE OPCIONES <<<");
        System.out.printf("\n1. Void.");
        System.out.printf("\n2. Funciones.");
        System.out.printf("\n3. Salir.");
    }
   
    public static void ConteoVocale(String cad)
    {
        int cantidadVocales = 0, cantidadNumeros = 0;
         for (int i = 0; i<cad.length(); i++) {
           char car = cad.charAt(i);
           if (car == 'a' || car == 'e' || car == 'e' || car == 'o' || car == 'u') {
               cantidadVocales++;
           }
           if (car == '1' || car == '2' || car == '3' || car == '4' || car == '5') {
               cantidadNumeros++;
           }
    }
        System.out.println("La cantidad de vocales es: " +cantidadVocales);
        System.out.println("La cantidad de numeros es: "+ cantidadNumeros);
    }
   
   
  public static void repeticion(String cadena,String caracter)
    {
    char car = caracter.charAt(0);
      int cantidadRepeticiones = 0;
      for (int i = 0 ; i < cadena.length() ; i++) {
          char aux = cadena.charAt(i);
          if (aux == car) {
              cantidadRepeticiones++;
          }
      }
        System.out.println("La cantidad de repeticiones es: " +cantidadRepeticiones);
    } 

public static int validar(int tamano,String texto) {
        Scanner entrada = new Scanner(System.in);
        boolean re = false;
        while (!re) {
            try {
                System.out.println(texto);
                tamano = entrada.nextInt();
                while (tamano <=0 ) {
                    System.out.println("ERROR / en la digitacion, el nÃºmero debe estar entre 1 y 5");
                    System.out.println(texto);
                    tamano = entrada.nextInt();
                }
                re = true;
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Error / en digitacion, "+texto);
                entrada.nextLine();
            }
        }
        return tamano;
    }
   
    public static void imprimir (int numero,String texto)
   {
       System.out.printf(texto);
       System.out.printf("%d ", numero);
        System.out.printf("\n");
}
     
   
    public static void imprimir (int tabla,int contador,int  resultado)
    {
            System.out.printf("%d * %d = %d\n",tabla, contador, resultado);
}
    
}
*/
