/*     */ package br.nikao.comandos;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.outros.Scoreboards;
/*     */ import br.nikao.outros.TagsAPI;
/*     */ import br.nikao.outros.TagsAPI.Tags;
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class Tag implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  18 */     if (!(sender instanceof Player)) {
/*  19 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
/*  20 */       return true;
/*     */     }
/*  22 */     Player p = (Player)sender;
/*  23 */     if (args.length == 0) {
/*  24 */       p.sendMessage(" ");
/*  25 */       p.sendMessage("§cUse /tag <tag> ou /tags para ver todas as tags");
/*  26 */       p.sendMessage(" ");
/*  27 */       return true;
/*     */     }
/*  29 */     if (args[0].equalsIgnoreCase("normal")) {
/*  30 */       p.sendMessage("§eVocê está usando sua tag §7Normal");
/*  31 */       TagsAPI.setTag(p, TagsAPI.Tags.Normal);
/*  32 */       TagsAPI.setarTag(p, "§7");
/*  33 */       Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "Normal");
/*  34 */       Main.getInstance().saveConfig();
/*  35 */       TagsAPI.updateTagTAB(p);
/*  36 */       TagsAPI.UpdateTag(p);
/*  37 */       if (Score.score.contains(p.getName())) {
/*  38 */         return true;
/*     */       }
/*  40 */       Scoreboards.Scores(p);
/*     */       
/*  42 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (args[0].equalsIgnoreCase("vip")) {
/*  47 */       if (p.hasPermission("tag.vip")) {
/*  48 */         p.sendMessage("§eVocê está usando sua tag §aVIP");
/*  49 */         TagsAPI.setTag(p, TagsAPI.Tags.VIP);
/*  50 */         TagsAPI.setarTag(p, "§a§lVIP §a");
/*  51 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "VIP");
/*  52 */         Main.getInstance().saveConfig();
/*  53 */         TagsAPI.updateTagTAB(p);
/*  54 */         TagsAPI.UpdateTag(p);
/*  55 */         if (Score.score.contains(p.getName())) {
/*  56 */           return true;
/*     */         }
/*  58 */         Scoreboards.Scores(p);
/*     */       }
/*     */       else {
/*  61 */         p.sendMessage("§cSem Permissao");
/*     */       }
/*  63 */       return true;
/*     */     }
/*     */     
/*  66 */     if (args[0].equalsIgnoreCase("pro")) {
/*  67 */       if (p.hasPermission("tag.pro")) {
/*  68 */         p.sendMessage("§eVocê está usando sua tag §6Pro");
/*  69 */         TagsAPI.setTag(p, TagsAPI.Tags.Pro);
/*  70 */         TagsAPI.setarTag(p, "§6§lPRO §6");
/*  71 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "Pro");
/*  72 */         Main.getInstance().saveConfig();
/*  73 */         TagsAPI.updateTagTAB(p);
/*  74 */         TagsAPI.UpdateTag(p);
/*  75 */         if (Score.score.contains(p.getName())) {
/*  76 */           return true;
/*     */         }
/*  78 */         Scoreboards.Scores(p);
/*     */       }
/*     */       else {
/*  81 */         p.sendMessage("§cSem Permissao");
/*     */       }
/*  83 */       return true;
/*     */     }
/*     */     
/*  86 */     if (args[0].equalsIgnoreCase("youtuber")) {
/*  87 */       if (p.hasPermission("tag.youtuber")) {
/*  88 */         p.sendMessage("§eVocê está usando sua tag §bYoutuber");
/*  89 */         TagsAPI.setTag(p, TagsAPI.Tags.Youtuber);
/*  90 */         TagsAPI.setarTag(p, "§b§lYT §b");
/*  91 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "Youtuber");
/*  92 */         Main.getInstance().saveConfig();
/*  93 */         TagsAPI.updateTagTAB(p);
/*  94 */         TagsAPI.UpdateTag(p);
/*  95 */         if (Score.score.contains(p.getName())) {
/*  96 */           return true;
/*     */         }
/*  98 */         Scoreboards.Scores(p);
/*     */       }
/*     */       else {
/* 101 */         p.sendMessage("§cSem Permissao");
/*     */       }
/* 103 */       return true;
/*     */     }
/*     */     
/* 106 */     if (args[0].equalsIgnoreCase("coder")) {
/* 107 */       if (p.hasPermission("tag.coder")) {
/* 108 */         p.sendMessage("§eVocê está usando sua tag §3§lCoder");
/* 109 */         TagsAPI.setTag(p, TagsAPI.Tags.Coder);
/* 110 */         TagsAPI.setarTag(p, "§3§lCoder §3");
/* 111 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "Coder");
/* 112 */         Main.getInstance().saveConfig();
/* 113 */         TagsAPI.updateTagTAB(p);
/* 114 */         TagsAPI.UpdateTag(p);
/* 115 */         if (Score.score.contains(p.getName())) {
/* 116 */           return true;
/*     */         }
/* 118 */         Scoreboards.Scores(p);
/*     */       }
/*     */       else {
/* 121 */         p.sendMessage("§cSem Permissao");
/*     */       }
/* 123 */       return true;
/*     */     }
/*     */     
/* 126 */     if (args[0].equalsIgnoreCase("trial")) {
/* 127 */       if (p.hasPermission("tag.trial")) {
/* 128 */         p.sendMessage("§eVocê está usando sua tag §dTrial");
/* 129 */         TagsAPI.setTag(p, TagsAPI.Tags.Trial);
/* 130 */         TagsAPI.setarTag(p, "§d§lTrial §d");
/* 131 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "Trial");
/* 132 */         Main.getInstance().saveConfig();
/* 133 */         TagsAPI.updateTagTAB(p);
/* 134 */         TagsAPI.UpdateTag(p);
/* 135 */         if (Score.score.contains(p.getName())) {
/* 136 */           return true;
/*     */         }
/* 138 */         Scoreboards.Scores(p);
/*     */       }
/*     */       else {
/* 141 */         p.sendMessage("§cSem Permissao");
/*     */       }
/* 143 */       return true;
/*     */     }
/*     */     
/* 146 */     if (args[0].equalsIgnoreCase("mod")) {
/* 147 */       if (p.hasPermission("tag.mod")) {
/* 148 */         p.sendMessage("§eVocê está usando sua tag §5Mod");
/* 149 */         TagsAPI.setTag(p, TagsAPI.Tags.Mod);
/* 150 */         TagsAPI.setarTag(p, "§5§lMOD §5");
/* 151 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "Mod");
/* 152 */         Main.getInstance().saveConfig();
/* 153 */         TagsAPI.updateTagTAB(p);
/* 154 */         TagsAPI.UpdateTag(p);
/* 155 */         if (Score.score.contains(p.getName())) {
/* 156 */           return true;
/*     */         }
/* 158 */         Scoreboards.Scores(p);
/*     */       }
/*     */       else {
/* 161 */         p.sendMessage("§cSem Permissao");
/*     */       }
/* 163 */       return true;
/*     */     }
/*     */     
/* 166 */     if (args[0].equalsIgnoreCase("builder")) {
/* 167 */       if (p.hasPermission("tag.builder")) {
/* 168 */         p.sendMessage("§eVocê está usando sua tag §e§oBuilder");
/* 169 */         TagsAPI.setTag(p, TagsAPI.Tags.Builder);
/* 170 */         TagsAPI.setarTag(p, "§9§lCNT §9");
/* 171 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "Builder");
/* 172 */         Main.getInstance().saveConfig();
/* 173 */         TagsAPI.updateTagTAB(p);
/* 174 */         TagsAPI.UpdateTag(p);
/* 175 */         if (Score.score.contains(p.getName())) {
/* 176 */           return true;
/*     */         }
/* 178 */         Scoreboards.Scores(p);
/*     */       }
/*     */       else {
/* 181 */         p.sendMessage("§cSem Permissao");
/*     */       }
/* 183 */       return true;
/*     */     }
/*     */     
/* 186 */     if (args[0].equalsIgnoreCase("admin")) {
/* 187 */       if (p.hasPermission("tag.admin")) {
/* 188 */         p.sendMessage("§eVocê está usando sua tag §cAdmin");
/* 189 */         TagsAPI.setTag(p, TagsAPI.Tags.Admin);
/* 190 */         TagsAPI.setarTag(p, "§c§lAdmin §c");
/* 191 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "Admin");
/* 192 */         Main.getInstance().saveConfig();
/* 193 */         TagsAPI.updateTagTAB(p);
/* 194 */         TagsAPI.UpdateTag(p);
/* 195 */         if (Score.score.contains(p.getName())) {
/* 196 */           return true;
/*     */         }
/* 198 */         Scoreboards.Scores(p);
/*     */       }
/*     */       else {
/* 201 */         p.sendMessage("§cSem Permissao");
/*     */       }
/* 203 */       return true;
/*     */     }
/*     */     
/* 206 */     if (args[0].equalsIgnoreCase("dono")) {
/* 207 */       if (p.hasPermission("tag.dono")) {
/* 208 */         p.sendMessage("§eVocê está usando sua tag §4§lDono");
/* 209 */         TagsAPI.setTag(p, TagsAPI.Tags.Dono);
/* 210 */         TagsAPI.setarTag(p, "§4§lDono §4");
/* 211 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".Tag", "Dono");
/* 212 */         Main.getInstance().saveConfig();
/* 213 */         TagsAPI.updateTagTAB(p);
/* 214 */         TagsAPI.UpdateTag(p);
/* 215 */         if (Score.score.contains(p.getName())) {
/* 216 */           return true;
/*     */         }
/* 218 */         Scoreboards.Scores(p);
/*     */       }
/*     */       else {
/* 221 */         p.sendMessage("§cSem Permissao");
/*     */       }
/* 223 */       return true;
/*     */     }
/* 225 */     p.sendMessage("§cEssa tag §b" + args[0] + " §cnão existe");
/*     */     
/* 227 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Tag.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */