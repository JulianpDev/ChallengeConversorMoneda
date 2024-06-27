package com.julito.alurachallenge.principal;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.julito.alurachallenge.modelos.ConvertidorMoneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String mensaje = """
                * * * * * * * * * * * * * * * * * * * * * * * * *
                Sea bienvenido(a) al Conversor de Moneda Alura
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                * * * * * * * * * * * * * * * * * * * * * * * *""";
        Scanner teclado = new Scanner(System.in);
        ConvertidorMoneda convertidorMoneda = new ConvertidorMoneda();
        while (true){
            String divisa1 = "", divisa2 = "";
            System.out.println(mensaje);
            int opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    divisa1 = "USD";
                    divisa2 = "ARS";
                    break;
                case 2:
                    divisa1 = "ARS";
                    divisa2 = "USD";
                    break;
                case 3:
                    divisa1 = "USD";
                    divisa2 = "BRL";
                    break;
                case 4:
                    divisa1 = "BRL";
                    divisa2 = "USD";
                    break;
                case 5:
                    divisa1 = "USD";
                    divisa2 = "COP";
                    break;
                case 6:
                    divisa1 = "COP";
                    divisa2 = "USD";
                    break;
            }
            if (opcion == 7) break;
            System.out.print("Ingrese el valor que desea convertir: ");
            double montoAConvertir = teclado.nextDouble();
            double valorMonedaAConvertir = convertidorMoneda.conversionDeMoneda(divisa1, divisa2, montoAConvertir);
            String mensajeFinal = String.format("El valor %.2f [%s] corresponde al valor final de =>>>> %.2f [%s]", montoAConvertir, divisa1, valorMonedaAConvertir, divisa2);
            System.out.println(mensajeFinal);
        }
        System.out.println("El programa ha finalizado!!!!!");
    }
}
