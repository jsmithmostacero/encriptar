
package datos;

import java.util.ArrayList;


public final class Encriptar {
    
    private final ArrayList<Integer> numeros = new ArrayList<>();
    private ArrayList<Integer> lista = new ArrayList<>();
    private int combinaciones, variables;
    private final String conjunto = "abcdefghijklmnñopqrstuvwxyz0123456789ABCDEFGHIJKLMÑOPQRSTUVWXYZ ";
    private final String texto = "|!¿#$%&/()=?¡¨*][{}]";
    private final char[] abc = conjunto.toCharArray();
    private final char[] tex = texto.toCharArray();
    private final String conjuntoTexto;
    private String cifrado="";
    private String descifrado="";
    private String clave="";
    private int promedio;
    
    
    
    public Encriptar(String conjuntoTexto,String clave) {
        this.conjuntoTexto = conjuntoTexto;
        this.clave = clave;
        encriptar();
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
            //010101
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
        
        variables = 13;
        combinaciones = (int)Math.pow(2,variables);
        
        
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
                if (cont == variables) {
                    msj += tex[0];
                }
            }
            cont = 0;
            
            msj += " ";
        }
        System.out.println(msj);
        char[] c = clave.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
            promedio+=(int)c[i];
        }
        
        promedio=promedio/c.length;
        
//        PRUEBA
//        System.out.println("Promedio : "+promedio);
        
        char[] posiciones = msj.toCharArray();
        
//        PRUEBAS
        System.out.println("Cantidad : "+posiciones.length);
        for (int i = 0; i < posiciones.length; i++) {
            System.out.println((int)posiciones[i]+" : "+posiciones[i]);
        }
        msj="";
        int pos=0;
        for (int i = 0; i < posiciones.length; i++) {
            pos = (int)(posiciones[i])+promedio;
            lista.add(((int)posiciones[i])+promedio);
            
            msj+=(char)(int)lista.get(i);
//            PRUEBA
//            System.oysut.println(pos+" : "+(char)pos);
        }
        
        this.cifrado = msj;
        
        
    }

    public void descifrado(String clave) {
        if(clave.equals(this.clave)){
            int prom=0;
        char[] c = clave.toCharArray();
        for (int i = 0; i < c.length; i++) {
            prom+=(int)c[i];
        }
        prom=prom/c.length;
        cifrado="";
        for (int i = 0; i < lista.size(); i++) {
            cifrado+=(char)(int)(lista.get(i)-prom);
        }
        int nul;
        String x = "";
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
                            valor+=Math.pow(2, variables-1-k);
                    }
                } 
            }
            if(valor==(int)(Math.pow(2, variables-1))){
                valor=0;
            }
            nul = (int)Math.sqrt(valor);
            n.add(nul);
            valor=0;
            
            
        }
        
        for (int i = 0; i < n.size(); i++) {
            descifrado+=abc[n.get(i)];  
        }
        }else{
            descifrado="CLAVE ERRONEA";
        }
        
    }
    


    public String getCifrado() {
        return cifrado;
    }

    public String getDescifrado(String clave) {
        descifrado(clave);
        return descifrado;
    }


}
