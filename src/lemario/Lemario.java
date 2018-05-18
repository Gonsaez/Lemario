/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xp
 */
public class Lemario {

    HashMap<String, Boolean> listaLemario = new HashMap();

    public void cargaFicheroLemario() {
        File fichero = new File("src/lemario/lemario.txt");
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                listaLemario.put(linea.toLowerCase(), true);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lemario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lemario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean estaEnElLemario(String palabra) {
            if (listaLemario.containsKey(palabra.toLowerCase())) {
                return true;
            } 
                return false;
            
    }

    public boolean comprobarEscalera(ArrayList <String> matriz) {
        int contador;
        boolean palabra = false;
        for (int i = 0; i < matriz.size() - 1; i++) {
            palabra = estaEnElLemario(matriz.get(0+1));
            
            if(!palabra){
                return false;
            }
            contador = 0;
            if(matriz.get(0+1).length() == matriz.get(0).length()){
                for (int j = 0; j < matriz.get(i).length(); j++) {
                    if (matriz.get(0).charAt(j) != matriz.get(0+1).charAt(j)) {
                        contador++;
                    }
                    if(contador >1){
                        palabra = false;
                    }
                    if(contador == 1){
                        palabra = true;
                    }
                }
        }
        }
        
        return palabra;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> listaLem = new ArrayList();
        Lemario comprobar = new Lemario();
        comprobar.cargaFicheroLemario();
        listaLem.add("PATA");
        listaLem.add("PATO");
        listaLem.add("RATO");
        listaLem.add("RATA");
        
        System.out.println("Compruebo si estan las palabras en el lemario");
        System.out.println("PATA: " + comprobar.estaEnElLemario(listaLem.get(0).toString()));
        System.out.println("PATO: " + comprobar.estaEnElLemario(listaLem.get(0+1).toString()));
        System.out.println("RATO: " + comprobar.estaEnElLemario(listaLem.get(0+2).toString()));
        System.out.println("RATA: " + comprobar.estaEnElLemario(listaLem.get(0+3).toString()));
        System.out.println("-----------------------------");
        
        System.out.println("Compruebo si es escalera");
        System.out.println("ESCALERA: " + comprobar.comprobarEscalera(listaLem));
        
    }

}
