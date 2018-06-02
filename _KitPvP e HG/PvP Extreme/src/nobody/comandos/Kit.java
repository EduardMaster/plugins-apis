/*     */ package nobody.comandos;
/*     */ 
/*     */ import nobody.eventos.KitAPI;
import nobody.main.Main;

import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class Kit implements org.bukkit.command.CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
/*     */   {
/*  19 */     if (!(sender instanceof Player)) {
/*  20 */       sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
/*  21 */       return true;
/*     */     }
/*  23 */     Player p = (Player)sender;
/*     */     
/*  25 */     World w = Bukkit.getServer().getWorld(Main.getInstance().KitPos.getString("KitPos1World"));
/*  26 */     double x = Main.getInstance().KitPos.getDouble("KitPos1X");
/*  27 */     double y = Main.getInstance().KitPos.getDouble("KitPos1Y");
/*  28 */     double z = Main.getInstance().KitPos.getDouble("KitPos1Z");
/*     */     
/*  30 */     World w2 = Bukkit.getServer().getWorld(Main.getInstance().KitPos.getString("KitPos2World"));
/*  31 */     double x2 = Main.getInstance().KitPos.getDouble("KitPos2X");
/*  32 */     double y2 = Main.getInstance().KitPos.getDouble("KitPos2Y");
/*  33 */     double z2 = Main.getInstance().KitPos.getDouble("KitPos2Z");
/*     */     
/*  35 */     World w3 = Bukkit.getServer().getWorld(Main.getInstance().KitPos.getString("KitPos3World"));
/*  36 */     double x3 = Main.getInstance().KitPos.getDouble("KitPos3X");
/*  37 */     double y3 = Main.getInstance().KitPos.getDouble("KitPos3Y");
/*  38 */     double z3 = Main.getInstance().KitPos.getDouble("KitPos3Z");
/*     */     
/*  40 */     World w4 = Bukkit.getServer().getWorld(Main.getInstance().KitPos.getString("KitPos4World"));
/*  41 */     double x4 = Main.getInstance().KitPos.getDouble("KitPos4X");
/*  42 */     double y4 = Main.getInstance().KitPos.getDouble("KitPos4Y");
/*  43 */     double z4 = Main.getInstance().KitPos.getDouble("KitPos4Z");
/*     */     
/*  45 */     World w5 = Bukkit.getServer().getWorld(Main.getInstance().KitPos.getString("KitPos5World"));
/*  46 */     double x5 = Main.getInstance().KitPos.getDouble("KitPos5X");
/*  47 */     double y5 = Main.getInstance().KitPos.getDouble("KitPos5Y");
/*  48 */     double z5 = Main.getInstance().KitPos.getDouble("KitPos5Z");
/*     */     
/*  50 */     if (args.length == 0) {
/*  51 */       p.sendMessage("§bExtreme§eKits" + " §b» §cUse: /kit <kit> ou /kits");
/*  52 */       return true;
/*     */     }
/*  54 */     if (args[0].equalsIgnoreCase("pvp")) {
/*  55 */       if (p.hasPermission("kit.pvp")) {
/*  56 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  57 */           KitAPI.PvP(p);
/*  58 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6PvP");
/*  59 */           p.setLevel(0);p.teleport(new Location(w4, x4, y4, z4));
/*  60 */           return true;
/*     */         }
/*  62 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/*  63 */         return true;
/*     */       }
/*     */       
/*  66 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/*  67 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  71 */     if (args[0].equalsIgnoreCase("kangaroo")) {
/*  72 */       if (p.hasPermission("kit.kangaroo")) {
/*  73 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  74 */           KitAPI.Kangaroo(p);
/*  75 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Kangaroo");
/*  76 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/*  77 */           return true;
/*     */         }
/*  79 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/*  80 */         return true;
/*     */       }
/*     */       
/*  83 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/*  84 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  88 */     if (args[0].equalsIgnoreCase("archer")) {
/*  89 */       if (p.hasPermission("kit.archer")) {
/*  90 */         if (KitAPI.getkit(p) == "Nenhum") {
/*  91 */           KitAPI.Archer(p);
/*  92 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Archer");
/*  93 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/*  94 */           return true;
/*     */         }
/*  96 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/*  97 */         return true;
/*     */       }
/*     */       
/* 100 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 101 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 105 */     if (args[0].equalsIgnoreCase("viper")) {
/* 106 */       if (p.hasPermission("kit.viper")) {
/* 107 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 108 */           KitAPI.Viper(p);
/* 109 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Viper");
/* 110 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 111 */           return true;
/*     */         }
/* 113 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 114 */         return true;
/*     */       }
/*     */       
/* 117 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 118 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 122 */     if (args[0].equalsIgnoreCase("snail")) {
/* 123 */       if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Snail").equals("true")) || (p.hasPermission("kit.snail"))) {
/* 124 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 125 */           KitAPI.Snail(p);
/* 126 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Snail");
/* 127 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 128 */           return true;
/*     */         }
/* 130 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 131 */         return true;
/*     */       }
/*     */       
/* 134 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 135 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 139 */     if (args[0].equalsIgnoreCase("fisherman")) {
/* 140 */       if (p.hasPermission("kit.fisherman")) {
/* 141 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 142 */           KitAPI.Fisherman(p);
/* 143 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Fisherman");
/* 144 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 145 */           return true;
/*     */         }
/* 147 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 148 */         return true;
/*     */       }
/*     */       
/* 151 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 152 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 156 */     if (args[0].equalsIgnoreCase("stomper")) {
/* 157 */       if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Stomper").equals("true")) || (p.hasPermission("kit.stomper"))) {
/* 158 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 159 */           KitAPI.Stomper(p);
/* 160 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Stomper");
/* 161 */           p.setLevel(0);p.teleport(new Location(w3, x3, y3, z3));
/* 162 */           return true;
/*     */         }
/* 164 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 165 */         return true;
/*     */       }
/*     */       
/* 168 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 169 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 173 */     if (args[0].equalsIgnoreCase("viking")) {
/* 174 */       if (p.hasPermission("kit.viking")) {
/* 175 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 176 */           KitAPI.Viking(p);
/* 177 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Viking");
/* 178 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 179 */           return true;
/*     */         }
/* 181 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 182 */         return true;
/*     */       }
/*     */       
/* 185 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 186 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 190 */     if (args[0].equalsIgnoreCase("ninja")) {
/* 191 */       if (p.hasPermission("kit.ninja")) {
/* 192 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 193 */           KitAPI.Ninja(p);
/* 194 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Ninja");
/* 195 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 196 */           return true;
/*     */         }
/* 198 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 199 */         return true;
/*     */       }
/*     */       
/* 202 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 203 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 207 */     if (args[0].equalsIgnoreCase("specialist")) {
/* 208 */       if (p.hasPermission("kit.specialist")) {
/* 209 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 210 */           KitAPI.Specialist(p);
/* 211 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Specialist");
/* 212 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 213 */           return true;
/*     */         }
/* 215 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 216 */         return true;
/*     */       }
/*     */       
/* 219 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 220 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 224 */     if (args[0].equalsIgnoreCase("turtle")) {
/* 225 */       if (p.hasPermission("kit.turtle")) {
/* 226 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 227 */           KitAPI.Turtle(p);
/* 228 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Turtle");
/* 229 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 230 */           return true;
/*     */         }
/* 232 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 233 */         return true;
/*     */       }
/*     */       
/* 236 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 237 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 241 */     if (args[0].equalsIgnoreCase("grandpa")) {
/* 242 */       if (p.hasPermission("kit.grandpa")) {
/* 243 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 244 */           KitAPI.Grandpa(p);
/* 245 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Grandpa");
/* 246 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 247 */           return true;
/*     */         }
/* 249 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 250 */         return true;
/*     */       }
/*     */       
/* 253 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 254 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 258 */     if (args[0].equalsIgnoreCase("urgal")) {
/* 259 */       if (p.hasPermission("kit.urgal")) {
/* 260 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 261 */           KitAPI.Urgal(p);
/* 262 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Urgal");
/* 263 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 264 */           return true;
/*     */         }
/* 266 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 267 */         return true;
/*     */       }
/*     */       
/* 270 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 271 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 275 */     if (args[0].equalsIgnoreCase("poseidon")) {
/* 276 */       if (p.hasPermission("kit.poseidon")) {
/* 277 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 278 */           KitAPI.Poseidon(p);
/* 279 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Poseidon");
/* 280 */           p.setLevel(0);p.teleport(new Location(w4, x4, y4, z4));
/* 281 */           return true;
/*     */         }
/* 283 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 284 */         return true;
/*     */       }
/*     */       
/* 287 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 288 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 292 */     if (args[0].equalsIgnoreCase("berserker")) {
/* 293 */       if (p.hasPermission("kit.berserker")) {
/* 294 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 295 */           KitAPI.Berserker(p);
/* 296 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Berserker");
/* 297 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 298 */           return true;
/*     */         }
/* 300 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 301 */         return true;
/*     */       }
/*     */       
/* 304 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 305 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 309 */     if (args[0].equalsIgnoreCase("paladino")) {
/* 310 */       if (p.hasPermission("kit.paladino")) {
/* 311 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 312 */           KitAPI.Paladino(p);
/* 313 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Paladino");
/* 314 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 315 */           return true;
/*     */         }
/* 317 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 318 */         return true;
/*     */       }
/*     */       
/* 321 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 322 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 326 */     if (args[0].equalsIgnoreCase("lavaman")) {
/* 327 */       if (p.hasPermission("kit.lavaman")) {
/* 328 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 329 */           KitAPI.Lavaman(p);
/* 330 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Lavaman");
/* 331 */           p.setLevel(0);p.teleport(new Location(w3, x3, y3, z3));
/* 332 */           return true;
/*     */         }
/* 334 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 335 */         return true;
/*     */       }
/*     */       
/* 338 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 339 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 343 */     if (args[0].equalsIgnoreCase("resouper")) {
/* 344 */       if (p.hasPermission("kit.resouper")) {
/* 345 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 346 */           KitAPI.Resouper(p);
/* 347 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Resouper");
/* 348 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 349 */           return true;
/*     */         }
/* 351 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 352 */         return true;
/*     */       }
/*     */       
/* 355 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 356 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 360 */     if (args[0].equalsIgnoreCase("anchor")) {
/* 361 */       if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Anchor").equals("true")) || (p.hasPermission("kit.anchor"))) {
/* 362 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 363 */           KitAPI.Anchor(p);
/* 364 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Anchor");
/* 365 */           p.setLevel(0);p.teleport(new Location(w2, x2, y2, z2));
/* 366 */           return true;
/*     */         }
/* 368 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 369 */         return true;
/*     */       }
/*     */       
/* 372 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 373 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 377 */     if (args[0].equalsIgnoreCase("camel")) {
/* 378 */       if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Camel").equals("true")) || (p.hasPermission("kit.camel"))) {
/* 379 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 380 */           KitAPI.Camel(p);
/* 381 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Camel");
/* 382 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 383 */           return true;
/*     */         }
/* 385 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 386 */         return true;
/*     */       }
/*     */       
/* 389 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 390 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 394 */     if (args[0].equalsIgnoreCase("frosty")) {
/* 395 */       if (p.hasPermission("kit.frosty")) {
/* 396 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 397 */           KitAPI.Frosty(p);
/* 398 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Frosty");
/* 399 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 400 */           return true;
/*     */         }
/* 402 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 403 */         return true;
/*     */       }
/*     */       
/* 406 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 407 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 411 */     if (args[0].equalsIgnoreCase("grappler")) {
/* 412 */       if (p.hasPermission("kit.grappler")) {
/* 413 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 414 */           KitAPI.Grappler(p);
/* 415 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Grappler");
/* 416 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 417 */           return true;
/*     */         }
/* 419 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 420 */         return true;
/*     */       }
/*     */       
/* 423 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 424 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 428 */     if (args[0].equalsIgnoreCase("hulk")) {
/* 429 */       if (p.hasPermission("kit.hulk")) {
/* 430 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 431 */           KitAPI.Hulk(p);
/* 432 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Hulk");
/* 433 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 434 */           return true;
/*     */         }
/* 436 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 437 */         return true;
/*     */       }
/*     */       
/* 440 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 441 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 445 */     if (args[0].equalsIgnoreCase("switcher")) {
/* 446 */       if (p.hasPermission("kit.switcher")) {
/* 447 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 448 */           KitAPI.Switcher(p);
/* 449 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Switcher");
/* 450 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 451 */           return true;
/*     */         }
/* 453 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 454 */         return true;
/*     */       }
/*     */       
/* 457 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 458 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 462 */     if (args[0].equalsIgnoreCase("launcher")) {
/* 463 */       if (p.hasPermission("kit.launcher")) {
/* 464 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 465 */           KitAPI.Launcher(p);
/* 466 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Launcher");
/* 467 */           p.setLevel(0);p.teleport(new Location(w3, x3, y3, z3));
/* 468 */           return true;
/*     */         }
/* 470 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 471 */         return true;
/*     */       }
/*     */       
/* 474 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 475 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 479 */     if (args[0].equalsIgnoreCase("bomber")) {
/* 480 */       if (p.hasPermission("kit.bomber")) {
/* 481 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 482 */           KitAPI.Bomber(p);
/* 483 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Bomber");
/* 484 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 485 */           return true;
/*     */         }
/* 487 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 488 */         return true;
/*     */       }
/*     */       
/* 491 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 492 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 496 */     if (args[0].equalsIgnoreCase("endermage")) {
/* 497 */       if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Endermage").equals("true")) || (p.hasPermission("kit.endermage"))) {
/* 498 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 499 */           KitAPI.Endermage(p);
/* 500 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Endermage");
/* 501 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 502 */           return true;
/*     */         }
/* 504 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 505 */         return true;
/*     */       }
/*     */       
/* 508 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 513 */     if (args[0].equalsIgnoreCase("fireman")) {
/* 514 */       if (p.hasPermission("kit.fireman")) {
/* 515 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 516 */           KitAPI.Fireman(p);
/* 517 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Fireman");
/* 518 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 519 */           return true;
/*     */         }
/* 521 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 522 */         return true;
/*     */       }
/*     */       
/* 525 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 526 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 530 */     if (args[0].equalsIgnoreCase("flash")) {
/* 531 */       if (p.hasPermission("kit.flash")) {
/* 532 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 533 */           KitAPI.Flash(p);
/* 534 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Flash");
/* 535 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 536 */           return true;
/*     */         }
/* 538 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 539 */         return true;
/*     */       }
/*     */       
/* 542 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 543 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 547 */     if (args[0].equalsIgnoreCase("milkman")) {
/* 548 */       if (p.hasPermission("kit.milkman")) {
/* 549 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 550 */           KitAPI.Milkman(p);
/* 551 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Milkman");
/* 552 */           p.setLevel(0);p.teleport(new Location(w2, x2, y2, z2));
/* 553 */           return true;
/*     */         }
/* 555 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 556 */         return true;
/*     */       }
/*     */       
/* 559 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 560 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 564 */     if (args[0].equalsIgnoreCase("ryu")) {
/* 565 */       if (p.hasPermission("kit.ryu")) {
/* 566 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 567 */           KitAPI.Ryu(p);
/* 568 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Ryu");
/* 569 */           p.setLevel(0);p.teleport(new Location(w5, x5, y5, z5));
/* 570 */           return true;
/*     */         }
/* 572 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 573 */         return true;
/*     */       }
/*     */       
/* 576 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 577 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 581 */     if (args[0].equalsIgnoreCase("jellyfish")) {
/* 582 */       if (p.hasPermission("kit.jellyfish")) {
/* 583 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 584 */           KitAPI.JellyFish(p);
/* 585 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6JellyFish");
/* 586 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 587 */           return true;
/*     */         }
/* 589 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 590 */         return true;
/*     */       }
/*     */       
/* 593 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 594 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 598 */     if (args[0].equalsIgnoreCase("c4")) {
/* 599 */       if (p.hasPermission("kit.c4")) {
/* 600 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 601 */           KitAPI.C4(p);
/* 602 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6C4");
/* 603 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 604 */           return true;
/*     */         }
/* 606 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 607 */         return true;
/*     */       }
/*     */       
/* 610 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 611 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 615 */     if (args[0].equalsIgnoreCase("magma")) {
/* 616 */       if (p.hasPermission("kit.magma")) {
/* 617 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 618 */           KitAPI.Magma(p);
/* 619 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Magma");
/* 620 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 621 */           return true;
/*     */         }
/* 623 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 624 */         return true;
/*     */       }
/*     */       
/* 627 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 628 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 632 */     if (args[0].equalsIgnoreCase("spiderman")) {
/* 633 */       if (p.hasPermission("kit.spiderman")) {
/* 634 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 635 */           KitAPI.Spiderman(p);
/* 636 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Spiderman");
/* 637 */           p.setLevel(0);p.teleport(new Location(w5, x5, y5, z5));
/* 638 */           return true;
/*     */         }
/* 640 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 641 */         return true;
/*     */       }
/*     */       
/* 644 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 645 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 649 */     if (args[0].equalsIgnoreCase("deshfire")) {
/* 650 */       if (p.hasPermission("kit.deshfire")) {
/* 651 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 652 */           KitAPI.Deshfire(p);
/* 653 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Deshfire");
/* 654 */           p.setLevel(0);p.teleport(new Location(w3, x3, y3, z3));
/* 655 */           return true;
/*     */         }
/* 657 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 658 */         return true;
/*     */       }
/*     */       
/* 661 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 662 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 666 */     if (args[0].equalsIgnoreCase("sonic")) {
/* 667 */       if (p.hasPermission("kit.sonic")) {
/* 668 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 669 */           KitAPI.Sonic(p);
/* 670 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Sonic");
/* 671 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 672 */           return true;
/*     */         }
/* 674 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 675 */         return true;
/*     */       }
/*     */       
/* 678 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 679 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 683 */     if (args[0].equalsIgnoreCase("critical")) {
/* 684 */       if (p.hasPermission("kit.critical")) {
/* 685 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 686 */           KitAPI.Critical(p);
/* 687 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Critical");
/* 688 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 689 */           return true;
/*     */         }
/* 691 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 692 */         return true;
/*     */       }
/*     */       
/* 695 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 696 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 700 */     if (args[0].equalsIgnoreCase("thor")) {
/* 701 */       if (p.hasPermission("kit.thor")) {
/* 702 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 703 */           KitAPI.Thor(p);
/* 704 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Thor");
/* 705 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 706 */           return true;
/*     */         }
/* 708 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 709 */         return true;
/*     */       }
/*     */       
/* 712 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 713 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 718 */     if (args[0].equalsIgnoreCase("reaper")) {
/* 719 */       if (p.hasPermission("kit.reaper")) {
/* 720 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 721 */           KitAPI.Reaper(p);
/* 722 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Reaper");
/* 723 */           p.setLevel(0);p.teleport(new Location(w4, x4, y4, z4));
/* 724 */           return true;
/*     */         }
/* 726 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 727 */         return true;
/*     */       }
/*     */       
/* 730 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 731 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 735 */     if (args[0].equalsIgnoreCase("boxer")) {
/* 736 */       if (p.hasPermission("kit.boxer")) {
/* 737 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 738 */           KitAPI.Boxer(p);
/* 739 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Boxer");
/* 740 */           p.setLevel(0);p.teleport(new Location(w5, x5, y5, z5));
/* 741 */           return true;
/*     */         }
/* 743 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 744 */         return true;
/*     */       }
/*     */       
/* 747 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 748 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 752 */     if (args[0].equalsIgnoreCase("ebola")) {
/* 753 */       if (p.hasPermission("kit.ebola")) {
/* 754 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 755 */           KitAPI.Ebola(p);
/* 756 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Ebola");
/* 757 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 758 */           return true;
/*     */         }
/* 760 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 761 */         return true;
/*     */       }
/*     */       
/* 764 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 765 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 769 */     if (args[0].equalsIgnoreCase("forcefield")) {
/* 770 */       if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".ForceField").equals("true")) || (p.hasPermission("kit.forcefield"))) {
/* 771 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 772 */           KitAPI.ForceField(p);
/* 773 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Forcefield");
/* 774 */           p.setLevel(0);p.teleport(new Location(w4, x4, y4, z4));
/* 775 */           return true;
/*     */         }
/* 777 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 778 */         return true;
/*     */       }
/*     */       
/* 781 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 782 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 786 */     if (args[0].equalsIgnoreCase("timelord")) {
/* 787 */       if (p.hasPermission("kit.timelord")) {
/* 788 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 789 */           KitAPI.Timelord(p);
/* 790 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Timelord");
/* 791 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 792 */           return true;
/*     */         }
/* 794 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 795 */         return true;
/*     */       }
/*     */       
/* 798 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 799 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 803 */     if (args[0].equalsIgnoreCase("barbarian")) {
/* 804 */       if (p.hasPermission("kit.barbarian")) {
/* 805 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 806 */           KitAPI.Barbarian(p);
/* 807 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Barbarian");
/* 808 */           p.setLevel(0);p.teleport(new Location(w4, x4, y4, z4));
/* 809 */           return true;
/*     */         }
/* 811 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 812 */         return true;
/*     */       }
/*     */       
/* 815 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 816 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 820 */     if (args[0].equalsIgnoreCase("backpacker")) {
/* 821 */       if (p.hasPermission("kit.backpacker")) {
/* 822 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 823 */           KitAPI.Backpacker(p);
/* 824 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Backpacker");
/* 825 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 826 */           return true;
/*     */         }
/* 828 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 829 */         return true;
/*     */       }
/*     */       
/* 832 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 833 */       return true;
/*     */     }
/*     */     
/* 836 */     if (args[0].equalsIgnoreCase("phantom")) {
/* 837 */       if (p.hasPermission("kit.phantom")) {
/* 838 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 839 */           KitAPI.Phantom(p);
/* 840 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Phantom");
/* 841 */           p.setLevel(0);p.teleport(new Location(w5, x5, y5, z5));
/* 842 */           return true;
/*     */         }
/* 844 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 845 */         return true;
/*     */       }
/*     */       
/* 848 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 849 */       return true;
/*     */     }
/*     */     
/* 852 */     if (args[0].equalsIgnoreCase("avatar")) {
/* 853 */       if (p.hasPermission("kit.avatar")) {
/* 854 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 855 */           KitAPI.Avatar(p);
/* 856 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Avatar");
/* 857 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 858 */           return true;
/*     */         }
/* 860 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 861 */         return true;
/*     */       }
/*     */       
/* 864 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 865 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 869 */     if (args[0].equalsIgnoreCase("rain")) {
/* 870 */       if (p.hasPermission("kit.rain")) {
/* 871 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 872 */           KitAPI.Rain(p);
/* 873 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Rain");
/* 874 */           p.setLevel(0);p.teleport(new Location(w3, x3, y3, z3));
/* 875 */           return true;
/*     */         }
/* 877 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 878 */         return true;
/*     */       }
/*     */       
/* 881 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 882 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 886 */     if (args[0].equalsIgnoreCase("quickdropper")) {
/* 887 */       if (p.hasPermission("kit.quickdropper")) {
/* 888 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 889 */           KitAPI.QuickDropper(p);
/* 890 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6QuickDropper");
/* 891 */           p.setLevel(0);p.teleport(new Location(w, x, y, z));
/* 892 */           return true;
/*     */         }
/* 894 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 895 */         return true;
/*     */       }
/*     */       
/* 898 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 899 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 903 */     if (args[0].equalsIgnoreCase("monk")) {
/* 904 */       if (p.hasPermission("kit.monk")) {
/* 905 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 906 */           KitAPI.Monk(p);
/* 907 */           p.sendMessage("§bExtreme§eKits" + " §b» §aVocê pegou o kit: §6Monk");
/* 908 */           p.setLevel(0);p.teleport(new Location(w5, x5, y5, z5));
/* 909 */           return true;
/*     */         }
/* 911 */         p.sendMessage("§bExtreme§eKits" + " §b» §cVocê já pegou um kit !");
/* 912 */         return true;
/*     */       }
/*     */       
/* 915 */       p.sendMessage("§bExtreme§eKits" + " §b» §cVocê não tem esse kit");
/* 916 */       return true;
/*     */     }
/*     */     
/* 919 */     p.sendMessage("§bExtreme§eKits" + " §cEste kit §6" + args[0] + " §cnão existe.");
/* 920 */     return false;
/*     */   }
/*     */ }

