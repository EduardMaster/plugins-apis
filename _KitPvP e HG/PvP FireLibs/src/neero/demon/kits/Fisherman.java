/*    */ package neero.demon.kits;
/*    */ 
/*    */ import java.util.ArrayList;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerFishEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Fisherman
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 25 */   public static ArrayList<Player> fisherman = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 29 */     Player p = e.getEntity();
/*    */     
/* 31 */     fisherman.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 35 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 37 */     fisherman.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 42 */     Player jogador = (Player)sender;
/* 43 */     if (label.equalsIgnoreCase("fisherman")) {
/* 44 */       if (jogador.hasPermission("kit.fisherman"))
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
/*    */   public void giveKit(Player p)
/*    */   {
/* 65 */     p.getInventory().clear();
/* 66 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cFisherman!");
KitAPI.setKit(p, "Fisherman");
Scoreboard.iscoriboard(p);
/* 67 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 68 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 69 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FISHING_ROD) });
KitAPI.darsopa(p);
/* 74 */     fisherman.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerHitFishingrodscorpion(PlayerFishEvent event)
/*    */   {
/* 80 */     if (Neo.neo.contains(event.getCaught()))
/*    */     {
/* 82 */       event.setCancelled(true);
/* 83 */       return;
/*    */     }
/* 85 */     Player player = event.getPlayer();
/* 86 */     if ((fisherman.contains(player)) && ((event.getCaught() instanceof Player)))
/*    */     {
/* 88 */       Player caught = (Player)event.getCaught();
/* 89 */       if (player.getItemInHand().getType() == Material.FISHING_ROD)
/*    */       {
/* 91 */         Location loc = player.getLocation();
/* 92 */         caught.teleport(loc);
/*    */         try
/*    */         {
/* 95 */           player.getItemInHand().setDurability((short)0);
/*    */         }
/*    */         catch (Exception localException) {}
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Fisherman.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */