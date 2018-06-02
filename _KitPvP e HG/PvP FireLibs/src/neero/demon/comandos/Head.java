/*    */ package neero.demon.comandos;
/*    */ 
/*    */ import neero.demon.Main;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.inventory.meta.SkullMeta;
/*    */ 
/*    */ public class Head
/*    */   implements CommandExecutor
/*    */ {
/*    */   Main main;
/*    */   
/*    */   public Head(Main plugin)
/*    */   {
/* 21 */     plugin = this.main;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
/*    */   {
/* 26 */     if (!(sender instanceof Player))
/*    */     {
/* 28 */       sender.sendMessage(ChatColor.RED + "comandos para players");
/* 29 */       return true;
/*    */     }
/* 31 */     if ((sender instanceof Player))
/*    */     {
/* 33 */       Player player1 = (Player)sender;
/* 34 */       if ((args.length != 0) && 
/* 35 */         (args.length == 1) && 
/* 36 */         (player1.hasPermission("fire.head")))
/*    */       {
/* 38 */         ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
/* 39 */         skullItem.setDurability((short)3);
/* 40 */         SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
/* 41 */         skullMeta.setOwner(args[0]);
/* 42 */         skullItem.setItemMeta(skullMeta);
/* 43 */         player1.getInventory().addItem(new ItemStack[] { skullItem });
/* 44 */         player1.sendMessage("§e§lEXTREMEPVP §6§l> §7§oVoce pegou uma §c§ohead.");
/*    */       }
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Head.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */