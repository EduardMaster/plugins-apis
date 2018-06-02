/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Config
/*    */ {
/*    */   public static void getKills(Player p)
/*    */   {
/* 10 */     Main.getInstance().getConfig().getString("Status." + p.getUniqueId() + ".Kills");
/*    */   }
/*    */   
/*    */   public static void getDeaths(Player p) {
/* 14 */     Main.getInstance().getConfig().getString("Status." + p.getUniqueId() + ".Deaths");
/*    */   }
/*    */   
/*    */   public static void getXP(Player p) {
/* 18 */     Main.getInstance().getConfig().getString("Status." + p.getUniqueId() + ".XP");
/*    */   }
/*    */   
/*    */   public static void addKill(Player p, int Kills) {
/* 22 */     Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Kills", Integer.valueOf(Kills));
/*    */   }
/*    */   
/*    */   public static void addDeaths(Player p, int Deaths) {
/* 26 */     Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Deaths", Integer.valueOf(Deaths));
/*    */   }
/*    */   
/*    */   public static void addXP(Player p, int XP) {
/* 30 */     Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".XP", Integer.valueOf(XP));
/*    */   }
/*    */   
/*    */   public static void removeXP(Player p, int i) {
/* 34 */     int value = Main.getInstance().getConfig().getInt("Status." + p.getUniqueId() + ".XP");
/* 35 */     Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".XP", Integer.valueOf(value - i));
/* 36 */     Main.getInstance().saveConfig();
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\Config.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */