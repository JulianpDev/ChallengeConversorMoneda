package com.julito.alurachallenge.modelos;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertidorMoneda {

    private double buscarPrecioMoneda (String monedaA, String monedaB){
        try {
            // Construyendo el HttpClient (cliente)
            HttpClient client = HttpClient.newHttpClient();

            // Construyento la HttpRequest (petición)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/2c1e77f445024a12556af8d0/latest/" + monedaA))
                    .build();

            // Construyendo la HttpResponse (respuesta)
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = response.body();
            // System.out.println(jsonString);
            JsonObject jsonParseString = JsonParser.parseString(jsonString).getAsJsonObject();
            double valorMonedaAConvertir = Double.parseDouble(jsonParseString.get("conversion_rates").getAsJsonObject().get(monedaB).getAsString());
            return valorMonedaAConvertir;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double conversionDeMoneda(String monedaA, String monedaB, double montoAConvertir){
        double valorMonedaAConvertir = buscarPrecioMoneda(monedaA, monedaB);
        double monedaConvertida = montoAConvertir * valorMonedaAConvertir;
        return monedaConvertida;
    }
}
