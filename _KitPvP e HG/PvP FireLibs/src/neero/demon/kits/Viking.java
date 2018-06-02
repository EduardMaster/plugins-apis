/*    */ package neero.demon.kits;
/*    */ 
/*    */ import java.util.ArrayList;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Viking
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 25 */   public static ArrayList<Player> viking = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 29 */     Player p = e.getEntity();
/*    */     
/* 31 */     viking.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 35 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 37 */     viking.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 42 */     Player jogador = (Player)sender;
/* 43 */     if (label.equalsIgnoreCase("viking")) {
/* 44 */       if (jogador.hasPermission("kit.viking"))
/*    */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 48 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*    */         }
/*    */         else
/*    */         {
/* 52 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 57 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*    */       }
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public static void giveKit(Player p)
/*    */   {
/* 65 */     p.getInventory().clear();
/* 66 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cViking!");
KitAPI.setKit(p, "Viking");
 Scoreboard.iscoriboard(p);
/* 67 */     ItemStack sword = new ItemStack(Material.STONE_AXE);
/* 68 */     sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 69 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/* 74 */     viking.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerDamage(EntityDamageByEntityEvent e)
/*    */   {
/* 80 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*    */     {
/* 82 */       Player d = (Player)e.getDamager();
/* 83 */       if (!viking.contains(d)) {
/* 84 */         return;
/*    */       }
/* 86 */       if (d.getItemInHand().getType() != Material.STONE_AXE) {
/* 87 */         return;
/*    */       }
/* 89 */       e.setDamage(e.getDamage() + 1.0D);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Viking.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */