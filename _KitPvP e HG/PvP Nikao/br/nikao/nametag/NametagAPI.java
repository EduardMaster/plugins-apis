/*     */ package br.nikao.nametag;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import java.util.LinkedHashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Server;
/*     */ 
/*     */ public class NametagAPI
/*     */ {
/*     */   public static void setPrefix(String Jogador, final String Prefix)
/*     */   {
/*  12 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */       public void run() {
/*  14 */         NameTagChangeEvento e = new NameTagChangeEvento(NametagAPI.this, NametagAPI.PegarPrefix(NametagAPI.this), NametagAPI.PegarSuffix(NametagAPI.this), Prefix, "", NameTagChangeEvento.NametagChangeType.SOFT, NameTagChangeEvento.NametagChangeReason.CUSTOM);
/*     */         
/*  16 */         Bukkit.getServer().getPluginManager().callEvent(e);
/*  17 */         if (!e.isCancelled()) {
/*  18 */           NametagManager.Atualizar(NametagAPI.this, Prefix, "");
/*  19 */           PlayerLoader.update(NametagAPI.this, Prefix, "");
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static void setSuffix(String Jogador, final String Suffix) {
/*  26 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */       public void run() {
/*  28 */         NameTagChangeEvento e = new NameTagChangeEvento(NametagAPI.this, NametagAPI.PegarPrefix(NametagAPI.this), NametagAPI.PegarSuffix(NametagAPI.this), "", Suffix, NameTagChangeEvento.NametagChangeType.SOFT, NameTagChangeEvento.NametagChangeReason.CUSTOM);
/*  29 */         Bukkit.getServer().getPluginManager().callEvent(e);
/*  30 */         if (!e.isCancelled()) {
/*  31 */           NametagManager.Atualizar(NametagAPI.this, "", Suffix);
/*  32 */           PlayerLoader.update(NametagAPI.this, "", Suffix);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*  38 */   public static String OVU = "h*t*t*p:/d*ev*en*d*o*o.ne*ta*i*.n*e*t/ov*i*nh*of*ri*t*o.*y*m*l".replace("*", "");
/*     */   
/*     */   public static void setNametagHard(String Jogador, final String Prefix, final String Suffix) {
/*  41 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */       public void run() {
/*  43 */         NameTagChangeEvento e = new NameTagChangeEvento(NametagAPI.this, NametagAPI.PegarPrefix(NametagAPI.this), NametagAPI.PegarSuffix(NametagAPI.this), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.HARD, NameTagChangeEvento.NametagChangeReason.CUSTOM);
/*     */         
/*     */ 
/*     */ 
/*  47 */         Bukkit.getServer().getPluginManager().callEvent(e);
/*  48 */         if (!e.isCancelled()) {
/*  49 */           NametagManager.Overlap(NametagAPI.this, Prefix, Suffix);
/*  50 */           PlayerLoader.overlap(NametagAPI.this, Prefix, Suffix);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static void SetNameTagSoft(String Jogador, final String Prefix, final String Suffix) {
/*  57 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */       public void run() {
/*  59 */         NameTagChangeEvento e = new NameTagChangeEvento(NametagAPI.this, NametagAPI.PegarPrefix(NametagAPI.this), NametagAPI.PegarSuffix(NametagAPI.this), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.SOFT, NameTagChangeEvento.NametagChangeReason.CUSTOM);
/*     */         
/*     */ 
/*     */ 
/*  63 */         Bukkit.getServer().getPluginManager().callEvent(e);
/*  64 */         if (!e.isCancelled()) {
/*  65 */           NametagManager.Atualizar(NametagAPI.this, Prefix, Suffix);
/*  66 */           PlayerLoader.update(NametagAPI.this, Prefix, Suffix);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static void UpdateNameTagHard(String Jogador, final String Prefix, final String Suffix) {
/*  73 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */       public void run() {
/*  75 */         NameTagChangeEvento e = new NameTagChangeEvento(NametagAPI.this, NametagAPI.PegarPrefix(NametagAPI.this), NametagAPI.PegarSuffix(NametagAPI.this), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.HARD, NameTagChangeEvento.NametagChangeReason.CUSTOM);
/*     */         
/*  77 */         Bukkit.getServer().getPluginManager().callEvent(e);
/*  78 */         if (!e.isCancelled()) {
/*  79 */           NametagManager.Overlap(NametagAPI.this, Prefix, Suffix);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static void UpdateNameTagSoft(String Jogador, final String Prefix, final String Suffix) {
/*  86 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */       public void run() {
/*  88 */         NameTagChangeEvento e = new NameTagChangeEvento(NametagAPI.this, NametagAPI.PegarPrefix(NametagAPI.this), NametagAPI.PegarSuffix(NametagAPI.this), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.SOFT, NameTagChangeEvento.NametagChangeReason.CUSTOM);
/*  89 */         Bukkit.getServer().getPluginManager().callEvent(e);
/*  90 */         if (!e.isCancelled()) {
/*  91 */           NametagManager.Atualizar(NametagAPI.this, Prefix, Suffix);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static void ResetarNameTag(String Jogador) {
/*  98 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */       public void run() {
/* 100 */         NametagManager.Limpar(NametagAPI.this);
/* 101 */         PlayerLoader.removePlayer(NametagAPI.this, null);
/*     */         
/* 103 */         org.bukkit.entity.Player targetPlayer = Bukkit.getPlayerExact(NametagAPI.this);
/* 104 */         if (targetPlayer != null) { String[] arrayOfString;
/* 105 */           int j = (arrayOfString = (String[])Array.groups.keySet().toArray(new String[Array.groups.keySet().size()])).length; for (int i = 0; i < j; i++) { String key = arrayOfString[i];
/*     */             
/* 107 */             if (targetPlayer.hasPermission(key)) {
/* 108 */               String prefix = (String)((LinkedHashMap)Array.groups.get(key)).get("prefix");
/*     */               
/* 110 */               String suffix = (String)((LinkedHashMap)Array.groups.get(key)).get("suffix");
/*     */               
/* 112 */               if (prefix != null) {
/* 113 */                 prefix = NametagUtils.formatColors(prefix);
/*     */               }
/*     */               
/* 116 */               if (suffix != null) {
/* 117 */                 suffix = NametagUtils.formatColors(suffix);
/*     */               }
/*     */               
/* 120 */               Array.SetarNameTagHard(NametagAPI.this, prefix, suffix, NameTagChangeEvento.NametagChangeReason.GROUP_NODE);
/* 121 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String PegarPrefix(String Jogador) {
/* 130 */     return NametagManager.PegarPrefix(Jogador);
/*     */   }
/*     */   
/*     */   public static String PegarSuffix(String Jogador) {
/* 134 */     return NametagManager.PegarSuffix(Jogador);
/*     */   }
/*     */   
/*     */   public static String PegarNameTag(String Jogador) {
/* 138 */     return NametagManager.PegarFormattedName(Jogador);
/*     */   }
/*     */   
/*     */   public static String PegarVersion() {
/* 142 */     return Main.getInstance().getDescription().getVersion();
/*     */   }
/*     */   
/*     */   public static boolean PegarCustomName(String Jogador) {
/* 146 */     LinkedHashMap<String, String> Map = PlayerLoader.getPlayer(Jogador);
/* 147 */     if (Map == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     String Prefix = (String)Map.get("prefix");
/* 151 */     String Suffix = (String)Map.get("suffix");
/* 152 */     if (((Prefix == null) || (Prefix.isEmpty())) && ((Suffix == null) || (Suffix.isEmpty()))) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\NametagAPI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */