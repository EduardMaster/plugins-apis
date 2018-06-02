/*    */ package br.nikao.outros;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class KitsAleatorios
/*    */ {
/*    */   public static String Kit()
/*    */   {
/*    */     ArrayList<String> lista;
/* 10 */     (lista = new ArrayList()).add("PvP");
/* 11 */     lista.add("Kangaroo");
/* 12 */     lista.add("Archer");
/* 13 */     lista.add("Viper");
/* 14 */     lista.add("Snail");
/* 15 */     lista.add("Fisherman");
/* 16 */     lista.add("Stomper");
/* 17 */     lista.add("Viking");
/* 18 */     lista.add("Ninja");
/* 19 */     lista.add("Specialist");
/* 20 */     lista.add("Turtle");
/* 21 */     lista.add("Grandpa");
/* 22 */     lista.add("Urgal");
/* 23 */     lista.add("Poseidon");
/* 24 */     lista.add("Resouper");
/* 25 */     lista.add("Anchor");
/* 26 */     lista.add("Camel");
/* 27 */     lista.add("Frosty");
/* 28 */     lista.add("Grappler");
/* 29 */     lista.add("Hulk");
/* 30 */     lista.add("Switcher");
/* 31 */     lista.add("Launcher");
/* 32 */     lista.add("Endermage");
/* 33 */     lista.add("Fireman");
/* 34 */     lista.add("Reaper");
/* 35 */     lista.add("Ryu");
/* 36 */     lista.add("Magma");
/* 37 */     lista.add("Spiderman");
/* 38 */     lista.add("Deshfire");
/* 39 */     lista.add("Critical");
/* 40 */     lista.add("Thor");
/* 41 */     lista.add("Forcefield");
/* 42 */     lista.add("Timelord");
/* 43 */     lista.add("QuickDropper");
/*    */     
/* 45 */     return (String)lista.get(new java.util.Random().nextInt(lista.size()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\KitsAleatorios.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */