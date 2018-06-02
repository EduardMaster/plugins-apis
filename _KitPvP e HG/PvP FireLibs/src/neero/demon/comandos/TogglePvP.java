/*    */ package neero.demon.comandos;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class TogglePvP implements CommandExecutor, Listener
/*    */ {
/* 17 */   public HashMap<String, ItemStack[]> a = new HashMap();
/* 18 */   public HashMap<String, ItemStack[]> b = new HashMap();
/*    */   
/*    */   public boolean a(String s)
/*    */   {
/*    */     try
/*    */     {
/* 24 */       Integer.parseInt(s);
/* 25 */       return true;
/*    */     }
/*    */     catch (NumberFormatException localNumberFormatException) {}
/* 28 */     return false;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 33 */     if (!(sender instanceof Player))
/*    */     {
/* 35 */       sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
/* 36 */       return true;
/*    */     }
/* 38 */     Player p = (Player)sender;
/* 39 */     if ((cmd.getName().equalsIgnoreCase("togglepvp")) && (
/* 40 */       (p.hasPermission("fire.togglepvp")) || (p.isOp())))
/*    */     {
/* 42 */       if (p.getWorld().getPVP())
/*    */       {
/* 44 */         p.getWorld().setPVP(false);
/* 45 */         Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "O PvP global foi desativado");
/* 46 */         return true;
/*    */       }
/* 48 */       p.getWorld().setPVP(true);
/* 49 */       Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "O PvP global foi ativado");
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\TogglePvP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */