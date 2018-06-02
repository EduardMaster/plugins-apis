/*     */ package br.nikao.outros;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.nametag.Array;
/*     */ import br.nikao.nametag.NameTagChangeEvento.NametagChangeReason;
/*     */ import br.nikao.nametag.NametagManager;
/*     */ import br.nikao.nametag.NametagUtils;
/*     */ import br.nikao.nametag.PlayerLoader;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class TagsAPI implements Listener
/*     */ {
/*  20 */   public static HashMap<String, Tags> Tag = new HashMap();
/*     */   
/*     */   public static enum Tags {
/*  23 */     Dono,  Admin,  Mod,  Trial,  Coder,  Youtuber,  Pro,  VIP,  Builder,  Normal;
/*     */   }
/*     */   
/*     */   public static void setTag(Player p, Tags t) {
/*  27 */     switch (t) {
/*     */     case Youtuber: 
/*  29 */       Tag.put(p.getName(), Tags.Normal);
/*  30 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Normal");
/*  31 */       Main.getInstance().saveConfig();
/*  32 */       updateTagTAB(p);
/*  33 */       break;
/*     */     
/*     */     case Trial: 
/*  36 */       Tag.put(p.getName(), Tags.VIP);
/*  37 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "VIP");
/*  38 */       Main.getInstance().saveConfig();
/*  39 */       updateTagTAB(p);
/*  40 */       break;
/*     */     
/*     */     case Pro: 
/*  43 */       Tag.put(p.getName(), Tags.Pro);
/*  44 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Pro");
/*  45 */       Main.getInstance().saveConfig();
/*  46 */       updateTagTAB(p);
/*  47 */       break;
/*     */     
/*     */     case Normal: 
/*  50 */       Tag.put(p.getName(), Tags.Youtuber);
/*  51 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Youtuber");
/*  52 */       Main.getInstance().saveConfig();
/*  53 */       updateTagTAB(p);
/*  54 */       break;
/*     */     
/*     */     case Mod: 
/*  57 */       Tag.put(p.getName(), Tags.Coder);
/*  58 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Coder");
/*  59 */       Main.getInstance().saveConfig();
/*  60 */       updateTagTAB(p);
/*  61 */       break;
/*     */     
/*     */     case Dono: 
/*  64 */       Tag.put(p.getName(), Tags.Trial);
/*  65 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Trial");
/*  66 */       Main.getInstance().saveConfig();
/*  67 */       updateTagTAB(p);
/*  68 */       break;
/*     */     
/*     */     case Coder: 
/*  71 */       Tag.put(p.getName(), Tags.Mod);
/*  72 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Mod");
/*  73 */       Main.getInstance().saveConfig();
/*  74 */       updateTagTAB(p);
/*  75 */       break;
/*     */     
/*     */     case VIP: 
/*  78 */       Tag.put(p.getName(), Tags.Builder);
/*  79 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Builder");
/*  80 */       Main.getInstance().saveConfig();
/*  81 */       updateTagTAB(p);
/*  82 */       break;
/*     */     
/*     */     case Builder: 
/*  85 */       Tag.put(p.getName(), Tags.Admin);
/*  86 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Admin");
/*  87 */       Main.getInstance().saveConfig();
/*  88 */       break;
/*     */     
/*     */     case Admin: 
/*  91 */       Tag.put(p.getName(), Tags.Dono);
/*  92 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Dono");
/*  93 */       Main.getInstance().saveConfig();
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   public static void updateTagTAB(Player p)
/*     */   {
/* 100 */     Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */     {
/*     */ 
/*     */       public void run()
/*     */       {
/* 105 */         switch ((TagsAPI.Tags)TagsAPI.Tag.get(TagsAPI.this.getName())) {
/* 106 */         case Youtuber:  TagsAPI.this.setDisplayName("§7" + TagsAPI.this.getName()); break;
/* 107 */         case Trial:  TagsAPI.this.setDisplayName("§a§lVIP §a" + TagsAPI.this.getName()); break;
/* 108 */         case Pro:  TagsAPI.this.setDisplayName("§6§lPro §6" + TagsAPI.this.getName()); break;
/* 109 */         case Normal:  TagsAPI.this.setDisplayName("§b§lYT §b" + TagsAPI.this.getName()); break;
/* 110 */         case Mod:  TagsAPI.this.setDisplayName("§3§lDev §3" + TagsAPI.this.getName()); break;
/* 111 */         case Dono:  TagsAPI.this.setDisplayName("§d§lTrial §d" + TagsAPI.this.getName()); break;
/* 112 */         case Coder:  TagsAPI.this.setDisplayName("§5§lMOD §5" + TagsAPI.this.getName()); break;
/* 113 */         case VIP:  TagsAPI.this.setDisplayName("§e§lCNT §c" + TagsAPI.this.getName()); break;
/* 114 */         case Builder:  TagsAPI.this.setDisplayName("§c§lAdmin §c" + TagsAPI.this.getName()); break;
/* 115 */         case Admin:  TagsAPI.this.setDisplayName("§4§lDono §4" + TagsAPI.this.getName());
/*     */         }
/*     */       }
/* 118 */     }, 2L); }
/*     */   
/*     */   public static void UpdateTag(Player p) { String str;
/* 121 */     switch ((str = Main.getInstance().getConfig().getString("Status." + p.getUniqueId() + ".Tag")).hashCode()) {case -1955878649:  if (str.equals("Normal")) break; break; case -614687281:  if (str.equals("Youtuber")) {} break; case 77538:  if (str.equals("Mod")) {} break; case 80525:  if (str.equals("Pro")) {} break; case 84989:  if (str.equals("VIP")) {} break; case 2135980:  if (str.equals("Dono")) {} break; case 63116079:  if (str.equals("Admin")) {} break; case 65282053:  if (str.equals("Coder")) {} break; case 81075958:  if (str.equals("Trial")) {} break; case 1895597947:  if (!str.equals("Builder")) {
/* 122 */         return;Tag.put(p.getName(), Tags.Normal);updateTagTAB(p); return;
/* 123 */         Tag.put(p.getName(), Tags.VIP);updateTagTAB(p); return;
/* 124 */         Tag.put(p.getName(), Tags.Pro);updateTagTAB(p); return;
/* 125 */         Tag.put(p.getName(), Tags.Youtuber);updateTagTAB(p); return;
/* 126 */         Tag.put(p.getName(), Tags.Coder);updateTagTAB(p); return;
/* 127 */         Tag.put(p.getName(), Tags.Trial);updateTagTAB(p); return;
/* 128 */         Tag.put(p.getName(), Tags.Mod);updateTagTAB(p);
/* 129 */       } else { Tag.put(p.getName(), Tags.Builder);updateTagTAB(p); return;
/* 130 */         Tag.put(p.getName(), Tags.Admin);updateTagTAB(p); return;
/* 131 */         Tag.put(p.getName(), Tags.Dono);updateTagTAB(p);
/*     */       }
/*     */       break; }
/*     */   }
/*     */   
/*     */   @EventHandler
/* 137 */   public void Chat(AsyncPlayerChatEvent e) { Player p = e.getPlayer();
/* 138 */     e.setFormat(p.getDisplayName() + " §f» §7" + e.getMessage().replace("%", " (porcento) "));
/* 139 */     if (p.hasPermission("ng.chat")) {
/* 140 */       e.setFormat(p.getDisplayName() + " §f» §f" + e.getMessage().replace("%", " (porcento) ").replace("&", "§"));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setarTag(Player p, String tag) {
/* 145 */     String prefix = tag;
/* 146 */     NameTagChangeEvento.NametagChangeReason reason = null;
/* 147 */     reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
/* 148 */     prefix = NametagUtils.formatColors(prefix);
/*     */     
/* 150 */     String suffix = "";
/* 151 */     reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
/* 152 */     suffix = NametagUtils.formatColors(suffix);
/*     */     
/* 154 */     NametagManager.Limpar(p.getName());
/* 155 */     Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
/* 156 */     PlayerLoader.update(p.getName(), prefix, suffix);
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\TagsAPI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */