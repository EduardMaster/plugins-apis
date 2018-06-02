/*    */ package br.nikao.nametag;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import java.util.LinkedHashMap;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ 
/*    */ public class Array
/*    */ {
/* 11 */   static LinkedHashMap<String, LinkedHashMap<String, String>> groups = null;
/* 12 */   static LinkedHashMap<String, LinkedHashMap<String, String>> config = null;
/* 13 */   static boolean tabListDisabled = false;
/* 14 */   static boolean deathMessageEnabled = false;
/* 15 */   static boolean checkForUpdatesEnabled = false;
/* 16 */   static boolean consolePrintEnabled = false;
/* 17 */   public static String permissions = "";
/* 18 */   public static String name = "";
/* 19 */   public static String type = "";
/* 20 */   public static String version = "";
/* 21 */   public static String link = "";
/*    */   
/*    */   public static void InciarTag() {
/* 24 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */       public void run() {
/* 26 */         LinkedHashMap<String, LinkedHashMap<String, String>> JogadorData2 = new LinkedHashMap();
/*    */         
/* 28 */         if (JogadorData2 != null) {
/* 29 */           for (String JogadorNome : JogadorData2.keySet()) {
/* 30 */             LinkedHashMap<String, String> JogadorData = (LinkedHashMap)JogadorData2.get(JogadorNome);
/* 31 */             String Prefix = (String)JogadorData.get("prefix");
/* 32 */             String Suffix = (String)JogadorData.get("suffix");
/* 33 */             if (Prefix != null) {
/* 34 */               Prefix = NametagUtils.formatColors(Prefix);
/*    */             }
/* 36 */             if (Suffix != null) {
/* 37 */               Suffix = NametagUtils.formatColors(Suffix);
/*    */             }
/* 39 */             NametagManager.Overlap(JogadorNome, Prefix, Suffix);
/*    */           }
/*    */         }
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static void SetarNameTagHard(String Jogador, String Prefix, String Suffix, NameTagChangeEvento.NametagChangeReason Reacão) {
/* 47 */     NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.HARD, Reacão);
/*    */     
/* 49 */     Bukkit.getServer().getPluginManager().callEvent(e);
/* 50 */     if (!e.isCancelled()) {
/* 51 */       NametagManager.Overlap(Jogador, Prefix, Suffix);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void SetarNameTagSoft(String Jogador, String Prefix, String Suffix, NameTagChangeEvento.NametagChangeReason Reacão) {
/* 56 */     NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.SOFT, Reacão);
/* 57 */     Bukkit.getServer().getPluginManager().callEvent(e);
/* 58 */     if (!e.isCancelled()) {
/* 59 */       NametagManager.Overlap(Jogador, Prefix, Suffix);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\Array.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */