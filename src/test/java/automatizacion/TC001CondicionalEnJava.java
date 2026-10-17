package automatizacion;
public class TC001CondicionalEnJava {

      public static void main(String[] args){

        String nombre = "Carlos";
        int edad = 17;
        boolean estudiante = true;

        System.out.println("=== DATOS DE LAS VARIABLES ===");
        System.out.println("Nombre: " + nombre );
        System.out.println("Edad: " + edad  );
        System.out.println("Es estudiante de este grupo: " + estudiante );

         System.out.println("\n=== Ejemplo condicional ===");

         if (edad >= 18) {

            System.out.println(nombre + " Es mayor de edad");
         }else {
            System.out.println(nombre + " Es menor de edad");
         }

          if (estudiante) {

            System.out.println(nombre + " si es estudiante de este grupo ");
         }else {
            System.out.println(nombre + " No es estudiante de este grupo");
         }

         System.out.println("\n=== Ejemplo ciclo for ===");

         for (int i = 0; i <= 5; i++ ){
            System.out.println("interacion for numero: " +i);
         }

         System.out.println("\n=== Ejemplo ciclo while ===");
         int contador = 1;
         while (contador <= 5 ){
            System.out.println("interacion while numero: " + contador);
            contador++;
         }

         System.out.println("\n=== finalizan los ejemplos de java ===");   
      } 
}