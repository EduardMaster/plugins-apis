/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import java.util.Random;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class TeleporteKitsAleatorios
/*    */ {
/*    */   public static void random(Player p)
/*    */   {
/* 17 */     World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("Warps.KitPos1World"));
/* 18 */     double x = Main.getInstance().getConfig().getDouble("Warps.KitPos1X");
/* 19 */     double y = Main.getInstance().getConfig().getDouble("Warps.KitPos1Y");
/* 20 */     double z = Main.getInstance().getConfig().getDouble("Warps.KitPos1Z");
/*    */     
/* 22 */     World w2 = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("Warps.KitPos2World"));
/* 23 */     double x2 = Main.getInstance().getConfig().getDouble("Warps.KitPos2X");
/* 24 */     double y2 = Main.getInstance().getConfig().getDouble("Warps.KitPos2Y");
/* 25 */     double z2 = Main.getInstance().getConfig().getDouble("Warps.KitPos2Z");
/*    */     
/* 27 */     World w3 = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("Warps.KitPos3World"));
/* 28 */     double x3 = Main.getInstance().getConfig().getDouble("Warps.KitPos3X");
/* 29 */     double y3 = Main.getInstance().getConfig().getDouble("Warps.KitPos3Y");
/* 30 */     double z3 = Main.getInstance().getConfig().getDouble("Warps.KitPos3Z");
/*    */     
/* 32 */     World w4 = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("Warps.KitPos4World"));
/* 33 */     double x4 = Main.getInstance().getConfig().getDouble("Warps.KitPos4X");
/* 34 */     double y4 = Main.getInstance().getConfig().getDouble("Warps.KitPos4Y");
/* 35 */     double z4 = Main.getInstance().getConfig().getDouble("Warps.KitPos4Z");
/*    */     
/* 37 */     World w5 = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("Warps.KitPos5World"));
/* 38 */     double x5 = Main.getInstance().getConfig().getDouble("Warps.KitPos5X");
/* 39 */     double y5 = Main.getInstance().getConfig().getDouble("Warps.KitPos5Y");
/* 40 */     double z5 = Main.getInstance().getConfig().getDouble("Warps.KitPos5Z");
/*    */     
/* 42 */     Random pos = new Random();
/*    */     
/* 44 */     int number = pos.nextInt(10);
/* 45 */     switch (number) {
/*    */     case 0: 
/* 47 */       p.teleport(new Location(w, x, y, z));
/* 48 */       break;
/*    */     case 1: 
/* 50 */       p.teleport(new Location(w2, x2, y2, z2));
/* 51 */       break;
/*    */     case 2: 
/* 53 */       p.teleport(new Location(w3, x3, y3, z3));
/* 54 */       break;
/*    */     case 3: 
/* 56 */       p.teleport(new Location(w4, x4, y4, z4));
/* 57 */       break;
/*    */     case 4: 
/* 59 */       p.teleport(new Location(w5, x5, y5, z5));
/* 60 */       break;
/*    */     case 5: 
/* 62 */       p.teleport(new Location(w2, x, y5, z3));
/* 63 */       break;
/*    */     case 6: 
/* 65 */       p.teleport(new Location(w3, x4, y, z2));
/* 66 */       break;
/*    */     case 7: 
/* 68 */       p.teleport(new Location(w2, x3, y5, z));
/* 69 */       break;
/*    */     case 8: 
/* 71 */       p.teleport(new Location(w, x2, y4, z3));
/* 72 */       break;
/*    */     case 9: 
/* 74 */       p.teleport(new Location(w5, x, y3, z2));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\TeleporteKitsAleatorios.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */