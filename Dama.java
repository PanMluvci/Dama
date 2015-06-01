/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dama;

/**
 *
 * @author Pan_Mluvci
 */
import java.util.*;

public class Dama
{    
    private static int prazdnePole;
    private static int bilaFigurka;
    private static int cernaFigurka;
    private static boolean bilaTah;
    private static boolean hraBezi;
    private static boolean jeBila;
    private static boolean jeCerna;
    private static int x;
    private static int y;
    private static int ven1;
    private static int ven2;
    
    
     public static void main(String[] args){
        bilaTah = false;
        hra();
    }
  
    public static void hra(){
       System.out.println("Hra Dáma 1.0");
       System.out.println("Dodržte všechna pravidla"); 
       bilaFigurka = 1;
       cernaFigurka = 2;
       prazdnePole = 0;
       hraBezi = true;
       jeBila = true;
       jeCerna = true;
       int sachovnice [][] = { 
       {0, 0, 0, 0, 0, 0, 0, 0, 0},
       {0, 1, 0, 1, 0, 1, 0, 1, 0},
       {0, 0, 1, 0, 1, 0, 1, 0, 1},
       {0, 1, 0, 1, 0, 1, 0, 1, 0},
       {0, 0, 0, 0, 0, 0, 0, 0, 0},
       {0, 0, 0, 0, 0, 0, 0, 0, 0},
       {0, 0, 2, 0, 2, 0, 2, 0, 2},
       {0, 2, 0, 2, 0, 2, 0, 2, 0},
       {0, 0, 2, 0, 2, 0, 2, 0, 2},
       };
        
        while(hraBezi){
            System.out.println("  *****************");
            int s = 1;
            for (int i = 1; i < sachovnice.length; i++) {
                System.out.print(s + "| ");
                s++;
                for (int j = 1; j < sachovnice[i].length; j++) {         
                    
                    System.out.print(sachovnice[i][j] + " ");
                    
                }              
                System.out.println("");
            }
            System.out.println("   ---------------");
            System.out.println("   1 2 3 4 5 6 7 8");
            System.out.println("  *****************");
            
            hraBeziDal(sachovnice, jeBila, jeCerna);
            
            if(bilaTah == false){
                bilaTah = !bilaTah;
            }else{if(bilaTah == true){
                    bilaTah = !bilaTah;
                }
            
            }
            
            if(bilaTah == true){
                System.out.println("Na tahu je Bily");
            }
            else{
                if(bilaTah == false)
                    System.out.println("Na tahu je Cerny");
            }
            zadaniTahu(sachovnice, bilaTah);
            
       }
    
    }

    public static void zadaniTahu(int sachovnice[][], boolean bilaTah){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Odkud budeme táhnout? Radek: ");
        int odkudRadek = sc.nextInt();
        
        if(odkudRadek > 8 || odkudRadek < 1){
            System.out.println("Spatne! Zkus to znovu!");
            zadaniTahu(sachovnice, bilaTah);
        }
        
        System.out.println("Odkud budeme táhnout? Sloupec: ");
        int odkudSloupec = sc.nextInt();
        
        if(odkudSloupec > 8 || odkudSloupec < 1){
            System.out.println("Spatne! Zkus to znovu!");
            zadaniTahu(sachovnice, bilaTah);
        }
        
        System.out.println("Kam budeme táhnout? Radek: ");
        int kamRadek = sc.nextInt();
        
        if(kamRadek > 8 || kamRadek < 1){
            System.out.println("Spatne! Zkus to znovu!");
            zadaniTahu(sachovnice, bilaTah);
        }
        
        System.out.println("Kam budeme táhnout? Sloupec: ");
        int kamSloupec = sc.nextInt();
        
        if(kamSloupec > 8 || kamSloupec < 1){
            System.out.println("Spatne! Zkus to znovu!");
            zadaniTahu(sachovnice, bilaTah);
        }
    
        x = odkudRadek;   
        y = odkudSloupec;
             
        bilaFigurka = sachovnice[x][y]; //pohyb figurek
        cernaFigurka = sachovnice[x][y];
        sachovnice[x][y] = prazdnePole; //vytisknuta 0
        
        x = kamRadek;
        y = kamSloupec;
        
        odebraniFig(odkudRadek, odkudSloupec, kamRadek, kamSloupec, sachovnice);
       
        if(bilaTah == true){
            if(sachovnice[x][y] == 0){
                sachovnice [x][y] = bilaFigurka;//tisk figurky pohybujici
            }
        }else{
            if(sachovnice[x][y] == 0){
                sachovnice [x][y] = cernaFigurka;
            }

        }
        bilaTah = !bilaTah;
    }
    
    public static void odebraniFig(int odkudRadek, int odkudSloupec, int kamRadek, int kamSloupec, int sachovnice [][]){
      
        int figVenRadek, figVenSloupec;
        figVenRadek = (odkudRadek + kamRadek) / 2;
        figVenSloupec =  (odkudSloupec + kamSloupec) / 2;
        
        ven1 = figVenRadek;
        ven2 = figVenSloupec;
        
        sachovnice[ven1][ven2] = prazdnePole;//tiskne se 0
        System.out.println("Figurka na pozici " + ven1 + " " + ven2 + " byla odstraněna."); 
    } 
    
    public static void hraBeziDal(int sachovnice[][], boolean jeBila, boolean jeCerna){
     
        for (int i = 0; i < sachovnice.length; i++) {   //kontrola pro konec hry
                for (int j = 1; j < sachovnice[i].length; j++) {         
                     if(i == 1) {
                        jeBila = true;
                    }
                    
                    if (i == 2) {
                        jeCerna = true;
                    }
                    
                    if (jeBila == false || jeCerna == false){
                        System.out.println("Konec hry!");
                        System.exit(1);
                    }
                    
                } 
                    
            }
          
        hraBezi = jeBila && jeCerna;
            
    }
    
}   
