/*      */ package br.nikao.comandos;
/*      */ 
/*      */ import br.nikao.Main;
/*      */ import br.nikao.outros.KitAPI;
/*      */ import br.nikao.outros.Scoreboards;
/*      */ import br.nikao.outros.TeleporteKitsAleatorios;
/*      */ import java.util.ArrayList;
/*      */ import org.bukkit.command.Command;
/*      */ import org.bukkit.command.CommandExecutor;
/*      */ import org.bukkit.command.CommandSender;
/*      */ import org.bukkit.configuration.file.FileConfiguration;
/*      */ import org.bukkit.entity.Player;
/*      */ 
/*      */ public class Kit implements CommandExecutor
/*      */ {
/*      */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*      */   {
/*   18 */     if (!(sender instanceof Player)) {
/*   19 */       sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
/*   20 */       return true;
/*      */     }
/*   22 */     Player p = (Player)sender;
/*      */     
/*   24 */     if (args.length == 0) {
/*   25 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cUse: /kit <kit> ou /kits");
/*   26 */       return true;
/*      */     }
/*   28 */     if (args[0].equalsIgnoreCase("pvp")) {
/*   29 */       if (p.hasPermission("kit.pvp")) {
/*   30 */         if (KitAPI.getkit(p) == "Nenhum") {
/*   31 */           KitAPI.PvP(p);
/*   32 */           if (Score.score.contains(p.getName())) {
/*   33 */             return true;
/*      */           }
/*   35 */           Scoreboards.Scores(p);
/*      */           
/*   37 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*   39 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*   41 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*   43 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*   46 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §ePvP");
/*   47 */           return true;
/*      */         }
/*   49 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*   50 */         return true;
/*      */       }
/*      */       
/*   53 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*   54 */       return true;
/*      */     }
/*      */     
/*      */ 
/*   58 */     if (args[0].equalsIgnoreCase("archer")) {
/*   59 */       if (p.hasPermission("kit.archer")) {
/*   60 */         if (KitAPI.getkit(p) == "Nenhum") {
/*   61 */           KitAPI.Archer(p);
/*   62 */           if (Score.score.contains(p.getName())) {
/*   63 */             return true;
/*      */           }
/*   65 */           Scoreboards.Scores(p);
/*      */           
/*   67 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*   69 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*   71 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*   73 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*   76 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eArcher");
/*   77 */           return true;
/*      */         }
/*   79 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*   80 */         return true;
/*      */       }
/*      */       
/*   83 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*   84 */       return true;
/*      */     }
/*      */     
/*      */ 
/*   88 */     if (args[0].equalsIgnoreCase("viper")) {
/*   89 */       if (p.hasPermission("kit.viper")) {
/*   90 */         if (KitAPI.getkit(p) == "Nenhum") {
/*   91 */           KitAPI.Viper(p);
/*   92 */           if (Score.score.contains(p.getName())) {
/*   93 */             return true;
/*      */           }
/*   95 */           Scoreboards.Scores(p);
/*      */           
/*   97 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*   99 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  101 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  103 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  106 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eViper");
/*  107 */           return true;
/*      */         }
/*  109 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  110 */         return true;
/*      */       }
/*      */       
/*  113 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  114 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  118 */     if (args[0].equalsIgnoreCase("kangaroo")) {
/*  119 */       if (p.hasPermission("kit.kangaroo")) {
/*  120 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  121 */           KitAPI.Kangaroo(p);
/*  122 */           if (Score.score.contains(p.getName())) {
/*  123 */             return true;
/*      */           }
/*  125 */           Scoreboards.Scores(p);
/*      */           
/*  127 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  129 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  131 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  133 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  136 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eKangaroo");
/*  137 */           return true;
/*      */         }
/*  139 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  140 */         return true;
/*      */       }
/*      */       
/*  143 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  144 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  148 */     if (args[0].equalsIgnoreCase("snail")) {
/*  149 */       if (p.hasPermission("kit.snail")) {
/*  150 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  151 */           KitAPI.Snail(p);
/*  152 */           if (Score.score.contains(p.getName())) {
/*  153 */             return true;
/*      */           }
/*  155 */           Scoreboards.Scores(p);
/*      */           
/*  157 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  159 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  161 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  163 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  166 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eSnail");
/*  167 */           return true;
/*      */         }
/*  169 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  170 */         return true;
/*      */       }
/*      */       
/*  173 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  174 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  178 */     if (args[0].equalsIgnoreCase("anchor")) {
/*  179 */       if (p.hasPermission("kit.anchor")) {
/*  180 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  181 */           KitAPI.Anchor(p);
/*  182 */           if (Score.score.contains(p.getName())) {
/*  183 */             return true;
/*      */           }
/*  185 */           Scoreboards.Scores(p);
/*      */           
/*  187 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  189 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  191 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  193 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  196 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eAnchor");
/*  197 */           return true;
/*      */         }
/*  199 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  200 */         return true;
/*      */       }
/*      */       
/*  203 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  204 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  208 */     if (args[0].equalsIgnoreCase("phantom")) {
/*  209 */       if (p.hasPermission("kit.phantom")) {
/*  210 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  211 */           KitAPI.Phantom(p);
/*  212 */           if (Score.score.contains(p.getName())) {
/*  213 */             return true;
/*      */           }
/*  215 */           Scoreboards.Scores(p);
/*      */           
/*  217 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  219 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  221 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  223 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  226 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §ePhantom");
/*  227 */           return true;
/*      */         }
/*  229 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  230 */         return true;
/*      */       }
/*      */       
/*  233 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  234 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  238 */     if (args[0].equalsIgnoreCase("ninja")) {
/*  239 */       if (p.hasPermission("kit.ninja")) {
/*  240 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  241 */           KitAPI.Ninja(p);
/*  242 */           if (Score.score.contains(p.getName())) {
/*  243 */             return true;
/*      */           }
/*  245 */           Scoreboards.Scores(p);
/*      */           
/*  247 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  249 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  251 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  253 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  256 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eNinja");
/*  257 */           return true;
/*      */         }
/*  259 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  260 */         return true;
/*      */       }
/*      */       
/*  263 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  264 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  268 */     if (args[0].equalsIgnoreCase("thor")) {
/*  269 */       if (p.hasPermission("kit.thor")) {
/*  270 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  271 */           KitAPI.Thor(p);
/*  272 */           if (Score.score.contains(p.getName())) {
/*  273 */             return true;
/*      */           }
/*  275 */           Scoreboards.Scores(p);
/*      */           
/*  277 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  279 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  281 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  283 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  286 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eThor");
/*  287 */           return true;
/*      */         }
/*  289 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  290 */         return true;
/*      */       }
/*      */       
/*  293 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  294 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  298 */     if (args[0].equalsIgnoreCase("timelord")) {
/*  299 */       if (p.hasPermission("kit.timelord")) {
/*  300 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  301 */           KitAPI.Timelord(p);
/*  302 */           if (Score.score.contains(p.getName())) {
/*  303 */             return true;
/*      */           }
/*  305 */           Scoreboards.Scores(p);
/*      */           
/*  307 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  309 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  311 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  313 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  316 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eTimelord");
/*  317 */           return true;
/*      */         }
/*  319 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  320 */         return true;
/*      */       }
/*      */       
/*  323 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  324 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  328 */     if (args[0].equalsIgnoreCase("fisherman")) {
/*  329 */       if (p.hasPermission("kit.fisherman")) {
/*  330 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  331 */           KitAPI.Fisherman(p);
/*  332 */           if (Score.score.contains(p.getName())) {
/*  333 */             return true;
/*      */           }
/*  335 */           Scoreboards.Scores(p);
/*      */           
/*  337 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  339 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  341 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  343 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  346 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eFisherman");
/*  347 */           return true;
/*      */         }
/*  349 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  350 */         return true;
/*      */       }
/*      */       
/*  353 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  354 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  358 */     if (args[0].equalsIgnoreCase("fireman")) {
/*  359 */       if (p.hasPermission("kit.fireman")) {
/*  360 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  361 */           KitAPI.Fireman(p);
/*  362 */           if (Score.score.contains(p.getName())) {
/*  363 */             return true;
/*      */           }
/*  365 */           Scoreboards.Scores(p);
/*      */           
/*  367 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  369 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  371 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  373 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  376 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eFireman");
/*  377 */           return true;
/*      */         }
/*  379 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  380 */         return true;
/*      */       }
/*      */       
/*  383 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  384 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  388 */     if (args[0].equalsIgnoreCase("barbarian")) {
/*  389 */       if (p.hasPermission("kit.barbarian")) {
/*  390 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  391 */           KitAPI.Barbarian(p);
/*  392 */           if (Score.score.contains(p.getName())) {
/*  393 */             return true;
/*      */           }
/*  395 */           Scoreboards.Scores(p);
/*      */           
/*  397 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  399 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  401 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  403 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  406 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eBarbarian");
/*  407 */           return true;
/*      */         }
/*  409 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  410 */         return true;
/*      */       }
/*      */       
/*  413 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  414 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  418 */     if (args[0].equalsIgnoreCase("hulk")) {
/*  419 */       if (p.hasPermission("kit.hulk")) {
/*  420 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  421 */           KitAPI.Hulk(p);
/*  422 */           if (Score.score.contains(p.getName())) {
/*  423 */             return true;
/*      */           }
/*  425 */           Scoreboards.Scores(p);
/*      */           
/*  427 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  429 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  431 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  433 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  436 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eHulk");
/*  437 */           return true;
/*      */         }
/*  439 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  440 */         return true;
/*      */       }
/*      */       
/*  443 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  444 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  448 */     if (args[0].equalsIgnoreCase("urgal")) {
/*  449 */       if (p.hasPermission("kit.urgal")) {
/*  450 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  451 */           KitAPI.Urgal(p);
/*  452 */           if (Score.score.contains(p.getName())) {
/*  453 */             return true;
/*      */           }
/*  455 */           Scoreboards.Scores(p);
/*      */           
/*  457 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  459 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  461 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  463 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  466 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eUrgal");
/*  467 */           return true;
/*      */         }
/*  469 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  470 */         return true;
/*      */       }
/*      */       
/*  473 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  474 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  478 */     if (args[0].equalsIgnoreCase("viking")) {
/*  479 */       if (p.hasPermission("kit.viking")) {
/*  480 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  481 */           KitAPI.Viking(p);
/*  482 */           if (Score.score.contains(p.getName())) {
/*  483 */             return true;
/*      */           }
/*  485 */           Scoreboards.Scores(p);
/*      */           
/*  487 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  489 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  491 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  493 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  496 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eViking");
/*  497 */           return true;
/*      */         }
/*  499 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  500 */         return true;
/*      */       }
/*      */       
/*  503 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  504 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  508 */     if (args[0].equalsIgnoreCase("grandpa")) {
/*  509 */       if (p.hasPermission("kit.grandpa")) {
/*  510 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  511 */           KitAPI.Grandpa(p);
/*  512 */           if (Score.score.contains(p.getName())) {
/*  513 */             return true;
/*      */           }
/*  515 */           Scoreboards.Scores(p);
/*      */           
/*  517 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  519 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  521 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  523 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  526 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eGrandpa");
/*  527 */           return true;
/*      */         }
/*  529 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  530 */         return true;
/*      */       }
/*      */       
/*  533 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  534 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  538 */     if (args[0].equalsIgnoreCase("stomper")) {
/*  539 */       if (p.hasPermission("kit.stomper")) {
/*  540 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  541 */           KitAPI.Stomper(p);
/*  542 */           if (Score.score.contains(p.getName())) {
/*  543 */             return true;
/*      */           }
/*  545 */           Scoreboards.Scores(p);
/*      */           
/*  547 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  549 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  551 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  553 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  556 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eStomper");
/*  557 */           return true;
/*      */         }
/*  559 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  560 */         return true;
/*      */       }
/*      */       
/*  563 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  564 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  568 */     if (args[0].equalsIgnoreCase("camel")) {
/*  569 */       if (p.hasPermission("kit.camel")) {
/*  570 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  571 */           KitAPI.Camel(p);
/*  572 */           if (Score.score.contains(p.getName())) {
/*  573 */             return true;
/*      */           }
/*  575 */           Scoreboards.Scores(p);
/*      */           
/*  577 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  579 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  581 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  583 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  586 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eCamel");
/*  587 */           return true;
/*      */         }
/*  589 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  590 */         return true;
/*      */       }
/*      */       
/*  593 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  594 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  598 */     if (args[0].equalsIgnoreCase("critical")) {
/*  599 */       if (p.hasPermission("kit.critical")) {
/*  600 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  601 */           KitAPI.Critical(p);
/*  602 */           if (Score.score.contains(p.getName())) {
/*  603 */             return true;
/*      */           }
/*  605 */           Scoreboards.Scores(p);
/*      */           
/*  607 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  609 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  611 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  613 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  616 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eCritical");
/*  617 */           return true;
/*      */         }
/*  619 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  620 */         return true;
/*      */       }
/*      */       
/*  623 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  624 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  628 */     if (args[0].equalsIgnoreCase("deshfire")) {
/*  629 */       if (p.hasPermission("kit.deshfire")) {
/*  630 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  631 */           KitAPI.Deshfire(p);
/*  632 */           if (Score.score.contains(p.getName())) {
/*  633 */             return true;
/*      */           }
/*  635 */           Scoreboards.Scores(p);
/*      */           
/*  637 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  639 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  641 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  643 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  646 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eDeshfire");
/*  647 */           return true;
/*      */         }
/*  649 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  650 */         return true;
/*      */       }
/*      */       
/*  653 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  654 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  658 */     if (args[0].equalsIgnoreCase("endermage")) {
/*  659 */       if (p.hasPermission("kit.endermage")) {
/*  660 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  661 */           KitAPI.Endermage(p);
/*  662 */           if (Score.score.contains(p.getName())) {
/*  663 */             return true;
/*      */           }
/*  665 */           Scoreboards.Scores(p);
/*      */           
/*  667 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  669 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  671 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  673 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  676 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eEndermage");
/*  677 */           return true;
/*      */         }
/*  679 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  680 */         return true;
/*      */       }
/*      */       
/*  683 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  684 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  688 */     if (args[0].equalsIgnoreCase("forcefield")) {
/*  689 */       if (p.hasPermission("kit.forcefield")) {
/*  690 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  691 */           KitAPI.ForceField(p);
/*  692 */           if (Score.score.contains(p.getName())) {
/*  693 */             return true;
/*      */           }
/*  695 */           Scoreboards.Scores(p);
/*      */           
/*  697 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  699 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  701 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  703 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  706 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eForceField");
/*  707 */           return true;
/*      */         }
/*  709 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  710 */         return true;
/*      */       }
/*      */       
/*  713 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  714 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  718 */     if (args[0].equalsIgnoreCase("frosty")) {
/*  719 */       if (p.hasPermission("kit.frosty")) {
/*  720 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  721 */           KitAPI.Frosty(p);
/*  722 */           if (Score.score.contains(p.getName())) {
/*  723 */             return true;
/*      */           }
/*  725 */           Scoreboards.Scores(p);
/*      */           
/*  727 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  729 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  731 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  733 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  736 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eFrosty");
/*  737 */           return true;
/*      */         }
/*  739 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  740 */         return true;
/*      */       }
/*      */       
/*  743 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  744 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  748 */     if (args[0].equalsIgnoreCase("grappler")) {
/*  749 */       if (p.hasPermission("kit.grappler")) {
/*  750 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  751 */           KitAPI.Grappler(p);
/*  752 */           if (Score.score.contains(p.getName())) {
/*  753 */             return true;
/*      */           }
/*  755 */           Scoreboards.Scores(p);
/*      */           
/*  757 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  759 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  761 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  763 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  766 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eGrappler");
/*  767 */           return true;
/*      */         }
/*  769 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  770 */         return true;
/*      */       }
/*      */       
/*  773 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  774 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  778 */     if (args[0].equalsIgnoreCase("launcher")) {
/*  779 */       if (p.hasPermission("kit.launcher")) {
/*  780 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  781 */           KitAPI.Launcher(p);
/*  782 */           if (Score.score.contains(p.getName())) {
/*  783 */             return true;
/*      */           }
/*  785 */           Scoreboards.Scores(p);
/*      */           
/*  787 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  789 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  791 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  793 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  796 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eLauncher");
/*  797 */           return true;
/*      */         }
/*  799 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  800 */         return true;
/*      */       }
/*      */       
/*  803 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  804 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  808 */     if (args[0].equalsIgnoreCase("magma")) {
/*  809 */       if (p.hasPermission("kit.magma")) {
/*  810 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  811 */           KitAPI.Magma(p);
/*  812 */           if (Score.score.contains(p.getName())) {
/*  813 */             return true;
/*      */           }
/*  815 */           Scoreboards.Scores(p);
/*      */           
/*  817 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  819 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  821 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  823 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  826 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eMagma");
/*  827 */           return true;
/*      */         }
/*  829 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  830 */         return true;
/*      */       }
/*      */       
/*  833 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  834 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  838 */     if (args[0].equalsIgnoreCase("monk")) {
/*  839 */       if (p.hasPermission("kit.monk")) {
/*  840 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  841 */           KitAPI.Monk(p);
/*  842 */           if (Score.score.contains(p.getName())) {
/*  843 */             return true;
/*      */           }
/*  845 */           Scoreboards.Scores(p);
/*      */           
/*  847 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  849 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  851 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  853 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  856 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eMonk");
/*  857 */           return true;
/*      */         }
/*  859 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  860 */         return true;
/*      */       }
/*      */       
/*  863 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  864 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  868 */     if (args[0].equalsIgnoreCase("poseidon")) {
/*  869 */       if (p.hasPermission("kit.poseidon")) {
/*  870 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  871 */           KitAPI.Poseidon(p);
/*  872 */           if (Score.score.contains(p.getName())) {
/*  873 */             return true;
/*      */           }
/*  875 */           Scoreboards.Scores(p);
/*      */           
/*  877 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  879 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  881 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  883 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  886 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §ePoseidon");
/*  887 */           return true;
/*      */         }
/*  889 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  890 */         return true;
/*      */       }
/*      */       
/*  893 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  894 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  898 */     if (args[0].equalsIgnoreCase("rain")) {
/*  899 */       if (p.hasPermission("kit.rain")) {
/*  900 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  901 */           KitAPI.Rain(p);
/*  902 */           if (Score.score.contains(p.getName())) {
/*  903 */             return true;
/*      */           }
/*  905 */           Scoreboards.Scores(p);
/*      */           
/*  907 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  909 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  911 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  913 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  916 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eRain");
/*  917 */           return true;
/*      */         }
/*  919 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  920 */         return true;
/*      */       }
/*      */       
/*  923 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  924 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  928 */     if (args[0].equalsIgnoreCase("reaper")) {
/*  929 */       if (p.hasPermission("kit.reaper")) {
/*  930 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  931 */           KitAPI.Reaper(p);
/*  932 */           if (Score.score.contains(p.getName())) {
/*  933 */             return true;
/*      */           }
/*  935 */           Scoreboards.Scores(p);
/*      */           
/*  937 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  939 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  941 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  943 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  946 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eReaper");
/*  947 */           return true;
/*      */         }
/*  949 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  950 */         return true;
/*      */       }
/*      */       
/*  953 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  954 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  958 */     if (args[0].equalsIgnoreCase("resouper")) {
/*  959 */       if (p.hasPermission("kit.resouper")) {
/*  960 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  961 */           KitAPI.Resouper(p);
/*  962 */           if (Score.score.contains(p.getName())) {
/*  963 */             return true;
/*      */           }
/*  965 */           Scoreboards.Scores(p);
/*      */           
/*  967 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  969 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/*  971 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/*  973 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/*  976 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eResouper");
/*  977 */           return true;
/*      */         }
/*  979 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/*  980 */         return true;
/*      */       }
/*      */       
/*  983 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/*  984 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  988 */     if (args[0].equalsIgnoreCase("ryu")) {
/*  989 */       if (p.hasPermission("kit.ryu")) {
/*  990 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  991 */           KitAPI.Ryu(p);
/*  992 */           if (Score.score.contains(p.getName())) {
/*  993 */             return true;
/*      */           }
/*  995 */           Scoreboards.Scores(p);
/*      */           
/*  997 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/*  999 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/* 1001 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/* 1003 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/* 1006 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eRyu");
/* 1007 */           return true;
/*      */         }
/* 1009 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/* 1010 */         return true;
/*      */       }
/*      */       
/* 1013 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/* 1014 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1018 */     if (args[0].equalsIgnoreCase("specialist")) {
/* 1019 */       if (p.hasPermission("kit.specialist")) {
/* 1020 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 1021 */           KitAPI.Specialist(p);
/* 1022 */           if (Score.score.contains(p.getName())) {
/* 1023 */             return true;
/*      */           }
/* 1025 */           Scoreboards.Scores(p);
/*      */           
/* 1027 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/* 1029 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/* 1031 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/* 1033 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/* 1036 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eSpecialist");
/* 1037 */           return true;
/*      */         }
/* 1039 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/* 1040 */         return true;
/*      */       }
/*      */       
/* 1043 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/* 1044 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1048 */     if (args[0].equalsIgnoreCase("spiderman")) {
/* 1049 */       if (p.hasPermission("kit.spiderman")) {
/* 1050 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 1051 */           KitAPI.Spiderman(p);
/* 1052 */           if (Score.score.contains(p.getName())) {
/* 1053 */             return true;
/*      */           }
/* 1055 */           Scoreboards.Scores(p);
/*      */           
/* 1057 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/* 1059 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/* 1061 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/* 1063 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/* 1066 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eSpiderman");
/* 1067 */           return true;
/*      */         }
/* 1069 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/* 1070 */         return true;
/*      */       }
/*      */       
/* 1073 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/* 1074 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1078 */     if (args[0].equalsIgnoreCase("switcher")) {
/* 1079 */       if (p.hasPermission("kit.switcher")) {
/* 1080 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 1081 */           KitAPI.Switcher(p);
/* 1082 */           if (Score.score.contains(p.getName())) {
/* 1083 */             return true;
/*      */           }
/* 1085 */           Scoreboards.Scores(p);
/*      */           
/* 1087 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/* 1089 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/* 1091 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/* 1093 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/* 1096 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eSwitcher");
/* 1097 */           return true;
/*      */         }
/* 1099 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/* 1100 */         return true;
/*      */       }
/*      */       
/* 1103 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/* 1104 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1108 */     if (args[0].equalsIgnoreCase("turtle")) {
/* 1109 */       if (p.hasPermission("kit.turtle")) {
/* 1110 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 1111 */           KitAPI.Turtle(p);
/* 1112 */           if (Score.score.contains(p.getName())) {
/* 1113 */             return true;
/*      */           }
/* 1115 */           Scoreboards.Scores(p);
/*      */           
/* 1117 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/* 1119 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/* 1121 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/* 1123 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/* 1126 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eTurtle");
/* 1127 */           return true;
/*      */         }
/* 1129 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/* 1130 */         return true;
/*      */       }
/*      */       
/* 1133 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/* 1134 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1138 */     if (args[0].equalsIgnoreCase("quickdropper")) {
/* 1139 */       if (p.hasPermission("kit.quickdropper")) {
/* 1140 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 1141 */           KitAPI.QuickDropper(p);
/* 1142 */           if (Score.score.contains(p.getName())) {
/* 1143 */             return true;
/*      */           }
/* 1145 */           Scoreboards.Scores(p);
/*      */           
/* 1147 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/* 1149 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/* 1151 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/* 1153 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/* 1156 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eQuickdropper");
/* 1157 */           return true;
/*      */         }
/* 1159 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/* 1160 */         return true;
/*      */       }
/*      */       
/* 1163 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/* 1164 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1168 */     if (args[0].equalsIgnoreCase("c4")) {
/* 1169 */       if (p.hasPermission("kit.c4")) {
/* 1170 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 1171 */           KitAPI.C4(p);
/* 1172 */           if (Score.score.contains(p.getName())) {
/* 1173 */             return true;
/*      */           }
/* 1175 */           Scoreboards.Scores(p);
/*      */           
/* 1177 */           if (Main.getInstance().getConfig().getString("TPKit").equals("true"))
/*      */             try {
/* 1179 */               TeleporteKitsAleatorios.random(p);
/*      */             } catch (Exception e) {
/* 1181 */               p.sendMessage("§cOs teleporte de kits não foram setados");
/*      */             } else {
/* 1183 */             Main.getInstance().getConfig().getString("TPKit").equals("false");
/*      */           }
/*      */           
/* 1186 */           p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §7§lO kit selecionado foi: §eC4");
/* 1187 */           return true;
/*      */         }
/* 1189 */         p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §cVocê já possui um Kit");
/* 1190 */         return true;
/*      */       }
/*      */       
/* 1193 */       p.sendMessage(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l> §c§lSem permissão para pegar este Kit");
/* 1194 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1199 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Kit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */