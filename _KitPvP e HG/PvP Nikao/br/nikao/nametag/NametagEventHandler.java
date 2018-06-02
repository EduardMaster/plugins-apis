/*     */ package br.nikao.nametag;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.outros.TagsAPI;
/*     */ import br.nikao.outros.TagsAPI.Tags;
/*     */ import java.io.PrintStream;
/*     */ import java.util.LinkedHashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class NametagEventHandler implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   private void onPlayerJoinEvent(final PlayerJoinEvent Evento)
/*     */   {
/*  20 */     final Player p = Evento.getPlayer();
/*     */     
/*  22 */     Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*  26 */         NametagManager.MandarTeamsParaJogador(p);
/*  27 */         NametagManager.Limpar(p.getName());
/*  28 */         boolean SetarGrupo = true;
/*     */         
/*  30 */         LinkedHashMap<String, String> JogadorData = PlayerLoader.getPlayer(p.getPlayer().getName());
/*  31 */         if (JogadorData != null) {
/*  32 */           String Prefix = (String)JogadorData.get("prefix");
/*  33 */           String Suffix = (String)JogadorData.get("suffix");
/*  34 */           if (Prefix != null) {
/*  35 */             Prefix = NametagUtils.formatColors(Prefix);
/*     */           }
/*  37 */           if (Suffix != null) {
/*  38 */             Suffix = NametagUtils.formatColors(Suffix);
/*     */           }
/*  40 */           if (Array.consolePrintEnabled) {
/*  41 */             System.out.println("Setting prefix/suffix for " + p.getName() + ": " + Prefix + ", " + Suffix + " (user)");
/*     */           }
/*  43 */           NametagManager.Overlap(Evento.getPlayer().getName(), Prefix, Suffix);
/*  44 */           SetarGrupo = false;
/*     */         }
/*     */         
/*  47 */         if (Array.tabListDisabled) {
/*  48 */           String str = "§f" + Evento.getPlayer().getName();
/*  49 */           String tab = "§8";
/*  50 */           for (int t = 0; (t < str.length()) && (t < 16); t++) {
/*  51 */             tab = tab + str.charAt(t);
/*     */           }
/*  53 */           p.setPlayerListName(tab);
/*     */         }
/*  55 */         String str = "§f" + Evento.getPlayer().getName();
/*  56 */         String tab = "§f " + Evento.getPlayer().getName();
/*  57 */         for (int t = 0; (t < str.length()) && (t < 16); t++) {
/*  58 */           tab = tab + str.charAt(t);
/*     */         }
/*     */       }
/*  61 */     }, 1L);
/*  62 */     Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*  66 */         if (p.hasPermission("tag.normal")) {
/*  67 */           TagsAPI.setTag(p, TagsAPI.Tags.Normal);
/*  68 */           TagsAPI.updateTagTAB(p);
/*  69 */           TagsAPI.setarTag(p, "§7");
/*     */         }
/*  71 */         if (p.hasPermission("tag.vip")) {
/*  72 */           TagsAPI.setTag(p, TagsAPI.Tags.VIP);
/*  73 */           TagsAPI.updateTagTAB(p);
/*  74 */           TagsAPI.setarTag(p, "§a§lVIP §a");
/*     */         }
/*  76 */         if (p.hasPermission("tag.pro")) {
/*  77 */           TagsAPI.setTag(p, TagsAPI.Tags.Pro);
/*  78 */           TagsAPI.setarTag(p, "§6§lPro §6");
/*  79 */           TagsAPI.updateTagTAB(p);
/*     */         }
/*  81 */         if (p.hasPermission("tag.youtuber")) {
/*  82 */           TagsAPI.setTag(p, TagsAPI.Tags.Youtuber);
/*  83 */           TagsAPI.setarTag(p, "§b§lYT §b");
/*  84 */           TagsAPI.updateTagTAB(p);
/*     */         }
/*  86 */         if (p.hasPermission("tag.coder")) {
/*  87 */           TagsAPI.setTag(p, TagsAPI.Tags.Coder);
/*  88 */           TagsAPI.setarTag(p, "§3§lDev §3");
/*  89 */           TagsAPI.updateTagTAB(p);
/*     */         }
/*  91 */         if (p.hasPermission("tag.builder")) {
/*  92 */           TagsAPI.setTag(p, TagsAPI.Tags.Builder);
/*  93 */           TagsAPI.setarTag(p, "§9§lBuilder §9");
/*  94 */           TagsAPI.updateTagTAB(p);
/*     */         }
/*  96 */         if (p.hasPermission("tag.trial")) {
/*  97 */           TagsAPI.setTag(p, TagsAPI.Tags.Trial);
/*  98 */           TagsAPI.setarTag(p, "§d§lTrial §d");
/*  99 */           TagsAPI.updateTagTAB(p);
/*     */         }
/* 101 */         if (p.hasPermission("tag.mod")) {
/* 102 */           TagsAPI.setTag(p, TagsAPI.Tags.Mod);
/* 103 */           TagsAPI.setarTag(p, "§5§lMOD §5");
/* 104 */           TagsAPI.updateTagTAB(p);
/*     */         }
/* 106 */         if (p.hasPermission("tag.admin")) {
/* 107 */           TagsAPI.setTag(p, TagsAPI.Tags.Admin);
/* 108 */           TagsAPI.setarTag(p, "§c§lAdmin §c");
/* 109 */           TagsAPI.updateTagTAB(p);
/*     */         }
/* 111 */         if (p.hasPermission("tag.dono")) {
/* 112 */           TagsAPI.setTag(p, TagsAPI.Tags.Dono);
/* 113 */           TagsAPI.setarTag(p, "§4§lDono §4");
/* 114 */           TagsAPI.updateTagTAB(p);
/*     */         }
/* 116 */         if ((p.hasPermission("tag.*")) || (p.isOp())) {
/* 117 */           TagsAPI.setTag(p, TagsAPI.Tags.Dono);
/* 118 */           TagsAPI.setarTag(p, "§4§lDono §4");
/* 119 */           TagsAPI.updateTagTAB(p);
/*     */         }
/*     */         
/*     */       }
/* 123 */     }, 2L);
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\NametagEventHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */