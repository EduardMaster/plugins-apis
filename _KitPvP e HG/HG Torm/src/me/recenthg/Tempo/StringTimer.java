package me.recenthg.Tempo;

public class StringTimer {
 
 public static String TimerGame(int i){
  
  if(i > 60){
   int minutos = (int)i/60;
   int segundos = i - minutos  * 60;
   return minutos + "m " + segundos + "s";
  }
 return i + "s";
 }

}