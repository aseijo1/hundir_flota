/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
data 12 xuño 2013 hora 20.39
 */
package hundirflota;

class Posicion{
    
    int x;
    int y;
}

class Barco extends Posicion{
    public int tam;
    public char c='B';
    public int direccion;
    char [] barco = new char[tam];
    
    Barco (int fila, int col, int n, int dir){
        this.tam = n;
        this.x= fila;
        this.y= col;
        this.direccion=dir;
        barco = new char[tam];
        for (int i=0; i< this.barco.length;i++){
            this.barco[i]= c;
        }
    }
    
    void verBarco(){
        System.out.printf("fila %d col %d final %d\t", this.x, this.y, this.barco.length);      
        
        for(int i=0; i< this.barco.length; i++){
            System.out.printf("%c\t", this.barco[i]);            
    }
        System.out.println();
}
}

class Panel{
    
    final int MAX=10;
    char [][] tablero = new char[MAX][MAX];
    
    public Panel(){
        tablero = new char[MAX][MAX];
        for(int i=0; i<this.tablero.length;i++){    
            for(int j=0; j<this.tablero.length-1;j++){
                this.tablero[i][j]= 'x';}
        }
    }
    
    void verPanel(){
        System.out.printf("\t");
        for(int i=0; i<this.tablero.length; i++){System.out.printf("%d\t", i+1);}
        System.out.printf("\n");
        for(int i=0; i<this.tablero.length; i++){    
            for(int j=0; j<this.tablero.length; j++){
                if (j == MAX-1) { System.out.printf("\n");}
                    else {
                    if (j==0){System.out.printf("%d\t", i+1);}
                    System.out.printf("%c\t", this.tablero[i][j]);}
            }
        }
    System.out.println("\n\n");
   }
   
   void situarBarco(Barco barco){
       int fila, col, tam;
       fila = barco.x;
       col= barco.y;
       tam = barco.tam;
       System.out.printf("\nX= %d Y= %d Tamaño %d Dirección %d\n\n", barco.x, barco.y, barco.tam, barco.direccion);
       if (barco.direccion==0){
           for(int i=col-1; i<=tam; i++){
               this.tablero[fila-1][i]='B';
            }
       }
       else {
           for(int i=fila-1; i<=tam; i++){
               this.tablero[i-1][col]='B';
            }
       }
    
    }
}

class HundirFlota{
    
    final int MAX=10;
    //char [][] tablero = new char[MAX][MAX];
    public static void main(String[] args) {
        
        Barco portaaviones = new Barco(2, 2, 5, 0);
        portaaviones.verBarco();
    
        Barco acorazado1 = new Barco(4, 2, 4, 0);
        acorazado1.verBarco();
    
        Barco acorazado2 = new Barco(5, 3, 4, 0);
        acorazado2.verBarco();
        
        Barco fragata1 = new Barco(7, 6, 3, 0);
        fragata1.verBarco();
        
        Barco fragata2 = new Barco(8, 6, 3, 0);
        fragata2.verBarco();
        
        Barco submarino1 = new Barco(8, 7, 2, 0);
        submarino1.verBarco();
        
        Barco submarino2= new Barco(7, 2, 2, 1);
        submarino2.verBarco();
         
        
        
        
        Panel usuario = new Panel();
        System.out.println("Usuario");
        usuario.situarBarco(portaaviones);
        usuario.situarBarco(acorazado1);
        usuario.situarBarco(acorazado2);
        usuario.situarBarco(fragata1);
        usuario.situarBarco(fragata2);
        usuario.situarBarco(submarino2);
        usuario.verPanel();
        
        Panel ordenador = new Panel();
        System.out.println("Ordenador");
        ordenador.verPanel();
        
        
       
    
   }
}

