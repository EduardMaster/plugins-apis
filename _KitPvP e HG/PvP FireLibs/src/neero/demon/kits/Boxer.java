/*    */ package neero.demon.kits;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Boxer
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 26 */   public static ArrayList<Player> boxer = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 30 */     Player p = e.getEntity();
/*    */     
/* 32 */     boxer.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 36 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 38 */     boxer.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 43 */     Player jogador = (Player)sender;
/* 44 */     if (label.equalsIgnoreCase("boxer")) {
/* 45 */       if (jogador.hasPermission("kit.boxer"))
/*    */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 49 */           jogador.sendMessage("§4§lKIT§7 Voce ja selecionou um kit !");
/*    */         }
/*    */         else
/*    */         {
/* 53 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 58 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §7Voce nao possue este kit !");
/*    */       }
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public static void giveKit(Player p)
/*    */   {
/* 66 */     p.getInventory().clear();
/* 67 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 68 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 69 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cBoxer!");
KitAPI.setKit(p, "Boxer");
Scoreboard.iscoriboard(p);
KitAPI.darsopa(p);
/* 74 */     boxer.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onUppercut(EntityDamageByEntityEvent e)
/*    */   {
/* 80 */     if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
/*    */     {
/* 82 */       Player p = (Player)e.getEntity();
/* 83 */       Player d = (Player)e.getDamager();
/* 84 */       if (boxer.contains(d))
/*    */       {
/* 86 */         Random r = new Random();
/* 87 */         int rand = r.nextInt(100);
/* 88 */         if ((rand >= 85) && (d.isSneaking()))
/*    */         {
/* 90 */           p.setVelocity(new Vector(0.0D, 1.5D, 0.0D));
/* 91 */           p.sendMessage(ChatColor.RED + "§4§lKIT §7Um boxer está te batendo com a mao!");
/* 92 */           d.sendMessage(ChatColor.GREEN + "§4§lKIT §7Boxeado!");
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Boxer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */