/*     */ package neero.demon.comandos;
/*     */ 
/*     */ import neero.demon.utils.Permissions;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ 
/*     */ 
/*     */ public class StaffChat
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*     */   {
/*  19 */     if (commandLabel.equalsIgnoreCase("s"))
/*     */     {
/*  21 */       Player player = (Player)sender;
/*  22 */       if (player.hasPermission(new Permissions().StaffChat)) {
/*  23 */         if (args.length == 0) {
/*  24 */           player.sendMessage(ChatColor.RED + "Usar: " + ChatColor.RED + "/s <mensagem>"); } else { Player[] arrayOfPlayer;
/*  25 */           int j; int i; if (args.length == 1) {
/*  26 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  27 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  28 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0]);
/*     */               }
/*     */             }
/*  37 */           } else if (args.length == 2) {
/*  38 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  39 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  40 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2]);
/*     */               }
/*     */             }
/*  37 */           } else if (args.length == 3) {
/*  38 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  39 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  40 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2]);
/*     */               }
/*     */             }
/*  43 */           } else if (args.length == 4) {
/*  44 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  45 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  46 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3]);
/*     */               }
/*     */             }
/*  49 */           } else if (args.length == 5) {
/*  50 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  51 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  52 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4]);
/*     */               }
/*     */             }
/*  55 */           } else if (args.length == 6) {
/*  56 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  57 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  58 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5]);
/*     */               }
/*     */             }
/*  61 */           } else if (args.length == 7) {
/*  62 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  63 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  64 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6]);
/*     */               }
/*     */             }
/*  67 */           } else if (args.length == 8) {
/*  68 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  69 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  70 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]);
/*     */               }
/*     */             }
/*  73 */           } else if (args.length == 9) {
/*  74 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  75 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  76 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8]);
/*     */               }
/*     */             }
/*  79 */           } else if (args.length == 10) {
/*  80 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  81 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  82 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9]);
/*     */               }
/*     */             }
/*  85 */           } else if (args.length == 11) {
/*  86 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  87 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  88 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10]);
/*     */               }
/*     */             }
/*  91 */           } else if (args.length == 12) {
/*  92 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  93 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/*  94 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11]);
/*     */               }
/*     */             }
/*  97 */           } else if (args.length == 13) {
/*  98 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/*  99 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/* 100 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12]);
/*     */               }
/*     */             }
/* 103 */           } else if (args.length == 14) {
/* 104 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/* 105 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/* 106 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13]);
/*     */               }
/*     */             }
/* 109 */           } else if (args.length == 15) {
/* 110 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/* 111 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/* 112 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14]);
/*     */               }
/*     */             }
/* 115 */           } else if (args.length == 16) {
/* 116 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/* 117 */               if (p.hasPermission(new Permissions().StaffReceiveChat)) {
/* 118 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14] + " " + args[15]);
/*     */               }
/*     */             }
/* 121 */           } else if (args.length == 17) {
/* 122 */             j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player p = arrayOfPlayer[i];
/* 123 */               if (p.hasPermission(new Permissions().StaffReceiveChat))
/* 124 */                 p.sendMessage("§8[§6§lSC§8] " + ChatColor.RESET + player.getName() + " §f§o" + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14] + " " + args[15] + " " + args[16]);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 130 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\StaffChat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */