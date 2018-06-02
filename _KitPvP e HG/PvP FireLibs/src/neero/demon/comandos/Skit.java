/*     */ package neero.demon.comandos;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ 
/*     */ 
/*     */ public class Skit
/*     */   implements Listener, CommandExecutor
/*     */ {
/*  20 */   public HashMap<String, ItemStack[]> kits = new HashMap();
/*     */   
/*  22 */   public HashMap<String, ItemStack[]> armor = new HashMap();
/*     */   
/*     */   public boolean isInt(String s)
/*     */   {
/*     */     try
/*     */     {
/*  28 */       Integer.parseInt(s);
/*  29 */       return true;
/*     */     }
/*     */     catch (NumberFormatException localNumberFormatException) {}
/*  32 */     return false;
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  37 */     if (!(sender instanceof Player))
/*     */     {
/*  39 */       sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
/*  40 */       return true;
/*     */     }
/*  42 */     Player p = (Player)sender;
/*  43 */     if ((cmd.getName().equalsIgnoreCase("skit")) && (
/*  44 */       (p.hasPermission("fire.skit")) || (p.isOp())))
/*     */     {
/*  46 */       if (args.length == 0)
/*     */       {
/*  48 */         p.sendMessage(ChatColor.AQUA + "Como criar um skit(kit para eventos):");
/*  49 */         p.sendMessage(ChatColor.GRAY + "1º - Monte seu inventario da maneira como quer que os jogadores recebam");
/*  50 */         p.sendMessage(ChatColor.GRAY + "2º - Digite /skit criar <nome>");
/*  51 */         p.sendMessage("");
/*  52 */         p.sendMessage(ChatColor.GREEN + "Como aplicar um skit:");
/*  53 */         p.sendMessage(ChatColor.GRAY + "1º - Digite /skit aplicar <nome> <raio>");
/*  54 */         p.sendMessage(ChatColor.RED + "OBS.:" + ChatColor.GRAY + " O kit precisa ter sido criado previamente!");
/*  55 */         return true;
/*     */       }
/*  57 */       if (args[0].equalsIgnoreCase("criar"))
/*     */       {
/*  59 */         if (args.length == 1)
/*     */         {
/*  61 */           p.sendMessage(ChatColor.AQUA + "Como criar um skit:");
/*  62 */           p.sendMessage(ChatColor.GRAY + "1º - Monte seu inventario da maneira como quer que os jogadores recebam");
/*  63 */           p.sendMessage(ChatColor.GRAY + "2º - Digite /skit criar <nome>");
/*  64 */           return true;
/*     */         }
/*  66 */         String name = args[1];
/*  67 */         this.kits.put(name, p.getInventory().getContents());
/*  68 */         this.armor.put(name, p.getInventory().getArmorContents());
/*  69 */         p.sendMessage(ChatColor.GREEN + "Kit " + args[1] + " criado com sucesso!");
/*  70 */         return true;
/*     */       }
/*  72 */       if (args[0].equalsIgnoreCase("aplicar"))
/*     */       {
/*  74 */         if (args.length <= 2)
/*     */         {
/*  76 */           p.sendMessage(ChatColor.GREEN + "Como aplicar um skit:");
/*  77 */           p.sendMessage(ChatColor.GRAY + "1º - Digite /skit aplicar <nome> <raio>");
/*  78 */           p.sendMessage(ChatColor.RED + "OBS.:" + ChatColor.GRAY + " O kit precisa ter sido criado previamente!");
/*  79 */           return true;
/*     */         }
/*  81 */         String name = args[1];
/*  82 */         if ((!this.kits.containsKey(name)) && (!this.armor.containsKey(name)))
/*     */         {
/*  84 */           p.sendMessage(ChatColor.RED + "Kit " + name + " nao encontrado!");
/*  85 */           return true;
/*     */         }
/*  87 */         if (isInt(args[2]))
/*     */         {
/*  89 */           int numero = Integer.parseInt(args[2]);
/*  90 */           for (Entity ent : p.getNearbyEntities(numero, numero, numero)) {
/*  91 */             if ((ent instanceof Player))
/*     */             {
/*  93 */               Player plr = (Player)ent;
/*  94 */               plr.getInventory().setArmorContents((ItemStack[])this.armor.get(name));
/*  95 */               plr.getInventory().setContents((ItemStack[])this.kits.get(name));
/*     */             }
/*     */           }
/*  98 */           Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Kit " + name + " aplicado para jogadores em um raio de " + numero + " blocos");
/*  99 */           p.sendMessage(ChatColor.GREEN + "Kit " + name + " aplicado para jogadores em um raio de " + numero + " blocos");
/* 100 */           return true;
/*     */         }
/* 102 */         return true;
/*     */       }
/*     */     }
/* 105 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Skit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */