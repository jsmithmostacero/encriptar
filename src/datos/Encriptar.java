
package datos;

import java.util.ArrayList;


public class Encriptar {
    
    private final ArrayList<Integer> numeros = new ArrayList<>();
    private int combinaciones, variables;
    private final String conjunto = "abcdefghijklmnñopqrstuvwxyz ";
    private final String texto = "|!#$%&/()=";
    private final char[] abc = conjunto.toCharArray();
    private final char[] tex = texto.toCharArray();
    private String conjuntoTexto;
    private String cifrado="";
    private String descifrado="";

    public Encriptar(String conjuntoTexto) {
        this.conjuntoTexto = conjuntoTexto;
        encriptar();
        descifrado();
    }
    
    public void posicion() {

        char[] palabra = conjuntoTexto.toCharArray();

        for (int i = 0; i < palabra.length; i++) {
            for (int j = 0; j < abc.length; j++) {
                if (abc[j] == palabra[i]) {
                    numeros.add((j * j));
                }
            }
        }

    }

    public String retornaValor(int p, int cantidad) {
        String msj = "";
        int c = 0, cont1 = 0;
        for (int i = 0; i < combinaciones; i++) {
            if (c == p) {
                msj = "1";
                cont1++;
                if (cont1 == p) {
                    c = 0;
                    cont1 = 0;
                }
            } else {
                msj = "0";
                c++;
            }
            if (i == cantidad) {
                return msj;
            }
        }
        return msj;
    }

    public ArrayList<String> generarTabla() {
        ArrayList<String> combi = new ArrayList<>();
        combinaciones = 1024;
        variables = 10;
        String msj = "";
        int v = 0;
        for (int i = 0; i < combinaciones; i++) {

            for (int j = 0; j < variables; j++) {
                v = (int) Math.pow(2, (variables - 1 - j));
                msj += retornaValor(v, i);
            }
            combi.add(msj);
            msj = "";
        }
        return combi;
    }

    public String binario(int pos) {
        ArrayList<String> combinacion = generarTabla();
        return combinacion.get(numeros.get(pos));
    }

    public void encriptar() {
        posicion();
        int cont = 0;
        ArrayList<String> combinacion = generarTabla();
        String msj = "";
        char[] combi = null;
        for (int i = 0; i < numeros.size(); i++) {
            String c;
            c = combinacion.get(numeros.get(i));
            combi = c.toCharArray();
            for (int j = 0; j < combi.length; j++) {

                if (combi[j] == '1') {
                    msj += tex[j];
                } else {
                    cont++;
                }
                if (cont == 10) {
                    msj += tex[0];
                }
            }
            cont = 0;
            msj += " ";
        }
        this.cifrado = msj;
    }

    public void descifrado() {
        int nul;
        boolean estado = false;
        String x = "", com = "";
        ArrayList<String> muestra = new ArrayList<>();
        ArrayList<Integer> n = new ArrayList<>();
        char[] criptado = cifrado.toCharArray();

        for (int i = 0; i < criptado.length; i++) {
            if (criptado[i] == ' ') {
                muestra.add(x);
                x = "";
            } else {
                x += criptado[i];
            }
        }
        
        
        for (int i = 0; i < muestra.size(); i++) {
            int valor=0;
            char[] ele = muestra.get(i).toCharArray();
            
            for (int j = 0; j < ele.length; j++) {
                for (int k = 0; k < tex.length; k++) {
                    if (ele[j] == tex[k]) {
                            valor+=Math.pow(2, 9-k);
                    }
                } 
            }
            if(valor==512){
                valor=0;
            }
            nul = (int)Math.sqrt(valor);
            n.add(nul);
            valor=0;
            
            
        }
        
        for (int i = 0; i < n.size(); i++) {
            descifrado+=abc[n.get(i)];  
        }
    }

    public String getCifrado() {
        return cifrado;
    }

    public void setCifrado(String cifrado) {
        this.cifrado = cifrado;
    }

    public String getDescifrado() {
        return descifrado;
    }

    public void setDescifrado(String descifrado) {
        this.descifrado = descifrado;
    }
    
    

}
