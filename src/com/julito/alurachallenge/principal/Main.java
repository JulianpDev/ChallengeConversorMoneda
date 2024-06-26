package com.julito.alurachallenge.principal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite su nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Digite su edad: ");
        int edad = teclado.nextInt();
        System.out.println("Su nombre es " + nombre + " y tienes " + edad + " años");
    }
}
