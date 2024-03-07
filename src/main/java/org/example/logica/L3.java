//package org.example.logica;
//
//import com.mongodb.client.MongoCollection;
//import org.bson.Document;
//
//import java.util.Scanner;
//
//public class L3 {
//
//    public void anyadirLibro(MongoCollection<Document> collection) {
//        Scanner sc = new Scanner(System.in);
//        Document libro = new Document();
//
//        String respuesta;
//        do {
//            System.out.print("Pon título: ");
//            libro.append("titulo", sc.nextLine());
//
//            System.out.print("Pon género: ");
//            libro.append("genero", sc.nextLine());
//
//            System.out.print("¿Agregar campo adicional? (s/n/salir): ");
//            respuesta = sc.nextLine();
//            if (respuesta.equals("s")) {
//                System.out.print("Tipo del campo (string, int, obj, lista , fin): ");
//                String tipoCampo = sc.nextLine();
//
//                if (tipoCampo.equals("lista")) {
//                    anyadirEnLista(libro);
//                } else if (tipoCampo.equals("obj")) {
//                    anaydirDocumento(libro);
//                }
//            }else{
//
//            }
//        } while (!respuesta.equals("fin"));
//
//        collection.insertOne(libro);
//    }
//}
