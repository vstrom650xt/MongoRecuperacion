package org.example.logica;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logica {

    public void anyadirLibro(MongoCollection<Document> collection){

        Scanner sc = new Scanner(System.in);
        Document libro = new Document();
        boolean salir = false;

        do {

            System.out.print("Pon título: ");
            libro.append("titulo", sc.nextLine());

            System.out.print("Pon género: ");
            libro.append("genero", sc.nextLine());

            System.out.print("¿Agregar campo adicional? (s/n/salir): ");
            String respuesta = sc.nextLine();
            if(respuesta.equals("s")) {
                System.out.print("Tipo del campo (string, int, object, lista): ");
                String tipoCampo = sc.nextLine();

                System.out.print("Nombre del campo: ");
                String nombreCampo = sc.nextLine();

                System.out.print("Valor del campo: ");
                String valorCampo = sc.nextLine();

                if (tipoCampo.equals("lista")) {
                    List<String> valoresLista = new ArrayList<>();
                    boolean agregarValores = true;
                    while (agregarValores) {
                        System.out.print("Ingrese un valor para la lista (o escriba 'fin' para terminar): ");
                        String valorLista = sc.nextLine();
                        if (!valorLista.equalsIgnoreCase("fin")) {
                            valoresLista.add(valorLista);
                        } else {
                            agregarValores = false;
                        }
                    }
                    libro.append(nombreCampo, valoresLista);
                } else {
                    libro.append(nombreCampo, valorCampo);
                }

            } else if (respuesta.equals("salir")) {
                salir=true;
            }

        } while (!salir);

        collection.insertOne(libro);
    }
}
