package org.example.logica;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L2 {


    public void anyadirLibro(MongoCollection<Document> collection) {
        Scanner sc = new Scanner(System.in);
        Document libro = new Document();

        String respuesta;
        do {


            System.out.print("¿Agregar campo adicional? (s/n/salir): ");
            respuesta = sc.nextLine();
            if (respuesta.equals("s")) {
                System.out.print("Tipo del campo (string, int, obj, lista , fin): ");
                String tipoCampo = sc.nextLine();

                if (tipoCampo.equals("lista")) {
                    anyadirEnLista(libro);
                } else if (tipoCampo.equals("obj")) {
                    anaydirDocumento(libro);
                } else if (tipoCampo.equals("int")) {
                    anayadirInt(libro);

                }else if (tipoCampo.equals("string")) {
                    anaydirString(libro);

                }
            }else {
                respuesta = "fin";
            }
        } while (!respuesta.equals("fin"));

        collection.insertOne(libro);
    }

    public void anaydirString(Document document){
        Scanner sc = new Scanner(System.in);
            System.out.print("Pon nom col: ");
            document.append("titulo", sc.nextLine());

            System.out.print("Pon valor col: ");
            document.append("genero", sc.nextLine());
    }
    public void anayadirInt(Document document){
        Scanner sc = new Scanner(System.in);
        System.out.print("Pon nom col int ");
        document.append("int", sc.nextInt());

        System.out.print("Pon valor col int");
        document.append("int", sc.nextInt());

    }

    public void anaydirDocumento(Document document) {
        Scanner sc = new Scanner(System.in);
        Document document1 = new Document();
        boolean agregarValores = true;

        System.out.print("Nombre del objeto: ");
        String nombreObj = sc.nextLine();

        while (agregarValores) {
            System.out.print("Nombre del campo (escribe 'fin' para terminar): ");
            String nombreCampo = sc.nextLine();

            if (!nombreCampo.equals("fin")) {
                System.out.print("Valor del campo: ");
                String valorCampo = sc.nextLine();
                document1.append(nombreCampo, valorCampo);
            } else {
                agregarValores = false;
            }
        }

        document.append(nombreObj, document1);
    }


    public void anyadirEnLista(Document document){
        Scanner sc = new Scanner(System.in);
        List<String> valoresLista = new ArrayList<>();
        boolean agregarValores = true;
        System.out.print("Nombre de la columna ");
        String nombreCol = sc.nextLine();

        while (agregarValores) {
            System.out.print("Ingrese un valor para la lista (o escriba 'fin' para terminar): ");
            String valorLista = sc.nextLine();
            if (!valorLista.equalsIgnoreCase("fin")) {
                valoresLista.add(valorLista);
            } else {
                agregarValores = false;
            }
        }
        document.append(nombreCol, valoresLista);



    }
}
