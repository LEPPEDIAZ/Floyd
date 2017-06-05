import java.util.Scanner; 

import java.io.BufferedReader;

import java.io.FileReader;


//Christopher Sandoval
//Maria Fernanda Estrada
//Analucia Diaz


public class Main {

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in); 

        int opcion = 0;

        Graph ciudades = new Graph();


        try {

        	 BufferedReader bf = new BufferedReader(new FileReader("C:/Users/chris/Documents/Ecliplse Workspace/Floyd/src/guategrafo.txt")); // Direccion donde se encuentra el archivo



            String line;

            while ((line = bf.readLine()) != null) {

                ciudades.addEdge(line);

            }

        System.out.println("Ruta mas corta en Guatemala." +

        "\n Las ciudades son:" +

        "\n guatemala" +

        "\n tikal" +

        "\n panajachel" +

        "\n retalhuleu" +

        "\n escuintla" +

        "\n riodulce" +

        "\n flores" +

        "\n antigua");



        while (opcion != 5) {

            //Se muestra en pantalla el menu

            System.out.println(

                    "\n1. Distancia entre ciudades\n" +

                    "2. Centro del grafo\n" +

                    "3. Interrupcion de trafico entre ciudades\n" +

                    "4. Establecer ruta entre ciudades\n" +

                    "5. Salir");



            //Se lee la opcion del usuario

            opcion = (int)scan.nextDouble();



            //Codigo para la primera opcion

            if (opcion == 1) {

                System.out.println ("Por favor ingrese el nombre de la ciudad inicial:");

                String city1 = scan.next();

                while (!ciudades.contains(city1)) {

                    System.out.println("La ciudad ingresada no se encuentra registrada.");

                    city1 = scan.next();

                }



                System.out.println("Por favor ingrese el nombre de la ciudad final:");

                String city2 = scan.next();

                while (!ciudades.contains(city2)) {

                    System.out.println("La ciudad ingresada no se encuentra registrada.");

                    city2 = scan.next();

                }



                city1 = city1.toLowerCase();

                city2 = city2.toLowerCase();



                String temp = ciudades.toString(city1, city2);

                if (temp.isEmpty())

                    System.out.println("La distancia mas corta es de " + ciudades.distBetweenNodes(city1, city2) + "KM");

                else

                    System.out.println("La distancia mas corta es de " + ciudades.distBetweenNodes(city1, city2) + "KM y debe pasar por: " + temp);


            } else if (opcion == 3) { 



                System.out.println ("Por favor ingrese el nombre de la primera ciudad:");

                String city1 = scan.next();



                System.out.println ("Por favor ingrese el nombre de la segunda ciudad:");

                String city2 = scan.next();



                city1 = city1.toLowerCase();

                city2 = city2.toLowerCase();


                ciudades.deleteEdge(city1, city2);

                System.out.println ("Interrupción de tráfico entre ciudades establecida.");

            } else if (opcion == 2) { 

                System.out.println("El centro del grafo es: " + ciudades.getCenter());



            } else if (opcion == 4) { 

               

                System.out.println("Por ingrese el nombre de las ciudades y su distancia. (Ej. Ciudad1 Ciudad2 XXX)");

                String line2 = scan.next() + " " + scan.next() + " " + scan.next();


                ciudades.addEdge(line2);

            }

        }
        bf.close();

    }catch(Exception e){
    	
    }finally{
    	scan.close();
    }
}
}
