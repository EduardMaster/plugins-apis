/*     */ package br.nikao.comandos;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class KitPos implements org.bukkit.command.CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
/*     */   {
/*  14 */     if (!(sender instanceof Player)) {
/*  15 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
/*  16 */       return true;
/*     */     }
/*  18 */     Player p = (Player)sender;
/*  19 */     if (args.length == 0) {
/*  20 */       if (p.hasPermission("ng.kitpos")) {
/*  21 */         p.sendMessage("§cUse: /kitpos 1 até 5");
/*  22 */         return true;
/*     */       }
/*  24 */       p.sendMessage("§cSem permissao");
/*  25 */       return true;
/*     */     }
/*     */     
/*  28 */     if (args.length == 1) {
/*  29 */       if (args[0].equalsIgnoreCase("1")) {
/*  30 */         if (p.hasPermission("ng.kitpos")) {
/*  31 */           Main.getInstance().getConfig().set("Warps.KitPos1World", p.getLocation().getWorld().getName());
/*  32 */           Main.getInstance().getConfig().set("Warps.KitPos1X", Double.valueOf(p.getLocation().getX()));
/*  33 */           Main.getInstance().getConfig().set("Warps.KitPos1Y", Double.valueOf(p.getLocation().getY()));
/*  34 */           Main.getInstance().getConfig().set("Warps.KitPos1Z", Double.valueOf(p.getLocation().getZ()));
/*  35 */           Main.getInstance().saveConfig();
/*  36 */           p.sendMessage("§aO teleporte de Kit 1 foi setado com sucesso");
/*  37 */           return true;
/*     */         }
/*  39 */         p.sendMessage("§cSem permissao");
/*  40 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  44 */       if (args[0].equalsIgnoreCase("2")) {
/*  45 */         if (p.hasPermission("ng.kitpos")) {
/*  46 */           Main.getInstance().getConfig().set("Warps.KitPos2World", p.getLocation().getWorld().getName());
/*  47 */           Main.getInstance().getConfig().set("Warps.KitPos2X", Double.valueOf(p.getLocation().getX()));
/*  48 */           Main.getInstance().getConfig().set("Warps.KitPos2Y", Double.valueOf(p.getLocation().getY()));
/*  49 */           Main.getInstance().getConfig().set("Warps.KitPos2Z", Double.valueOf(p.getLocation().getZ()));
/*  50 */           Main.getInstance().saveConfig();
/*  51 */           p.sendMessage("§aO teleporte de Kit 2 foi setado com sucesso");
/*  52 */           return true;
/*     */         }
/*  54 */         p.sendMessage("§cSem permissao");
/*  55 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  59 */       if (args[0].equalsIgnoreCase("3")) {
/*  60 */         if (p.hasPermission("ng.kitpos")) {
/*  61 */           Main.getInstance().getConfig().set("Warps.KitPos3World", p.getLocation().getWorld().getName());
/*  62 */           Main.getInstance().getConfig().set("Warps.KitPos3X", Double.valueOf(p.getLocation().getX()));
/*  63 */           Main.getInstance().getConfig().set("Warps.KitPos3Y", Double.valueOf(p.getLocation().getY()));
/*  64 */           Main.getInstance().getConfig().set("Warps.KitPos3Z", Double.valueOf(p.getLocation().getZ()));
/*  65 */           Main.getInstance().saveConfig();
/*  66 */           p.sendMessage("§aO teleporte de Kit 3 foi setado com sucesso");
/*  67 */           return true;
/*     */         }
/*  69 */         p.sendMessage("§cSem permissao");
/*  70 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  74 */       if (args[0].equalsIgnoreCase("4")) {
/*  75 */         if (p.hasPermission("ng.kitpos")) {
/*  76 */           Main.getInstance().getConfig().set("Warps.KitPos4World", p.getLocation().getWorld().getName());
/*  77 */           Main.getInstance().getConfig().set("Warps.KitPos4X", Double.valueOf(p.getLocation().getX()));
/*  78 */           Main.getInstance().getConfig().set("Warps.KitPos4Y", Double.valueOf(p.getLocation().getY()));
/*  79 */           Main.getInstance().getConfig().set("Warps.KitPos4Z", Double.valueOf(p.getLocation().getZ()));
/*  80 */           Main.getInstance().saveConfig();
/*  81 */           p.sendMessage("§aO teleporte de Kit 4 foi setado com sucesso");
/*  82 */           return true;
/*     */         }
/*  84 */         p.sendMessage("§cSem permissao");
/*  85 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  89 */       if (args[0].equalsIgnoreCase("5")) {
/*  90 */         if (p.hasPermission("ng.kitpos")) {
/*  91 */           Main.getInstance().getConfig().set("Warps.KitPos5World", p.getLocation().getWorld().getName());
/*  92 */           Main.getInstance().getConfig().set("Warps.KitPos5X", Double.valueOf(p.getLocation().getX()));
/*  93 */           Main.getInstance().getConfig().set("Warps.KitPos5Y", Double.valueOf(p.getLocation().getY()));
/*  94 */           Main.getInstance().getConfig().set("Warps.KitPos5Z", Double.valueOf(p.getLocation().getZ()));
/*  95 */           Main.getInstance().saveConfig();
/*  96 */           p.sendMessage("§aO teleporte de Kit 5 foi setado com sucesso");
/*  97 */           return true;
/*     */         }
/*  99 */         p.sendMessage("§cSem permissao");
/* 100 */         return true;
/*     */       }
/*     */     }
/*     */     else {
/* 104 */       p.sendMessage("§cUse: /kitpos 1 até 5");
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\KitPos.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */