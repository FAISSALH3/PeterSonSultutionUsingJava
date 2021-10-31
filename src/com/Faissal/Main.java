package com.Faissal;

public class Main {



    public static void main(String[] args) {
        new Thread(new Peterson(0), "Thread - 0").start();
        new Thread(new Peterson(1), "Thread - 1").start();
    }




}

 class Peterson implements Runnable{
    private static boolean[] in = {false  , false};
     private static volatile int turn = -1;

    private final int id ;

     public Peterson(int i) {
         this.id = i;
     }
     public int other(){
         return id == 0 ? 1 : 0;
     }


     @Override
     public void run() {

         synchronized (this){
             in[id]=true ;
             turn = other() ;
             while(in[other()] && turn == other()){
                     System.out.println("[" + id + "] - Waiting...");

                 }

             System.out.println("[" + id + "] - Working ("
                         + ((!in[other()]) ? "other done" : "my turn") + ")");
             in[id] = false;

             }


         }

     }
