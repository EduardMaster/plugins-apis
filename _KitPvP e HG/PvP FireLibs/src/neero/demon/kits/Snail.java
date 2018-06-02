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
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Snail
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 27 */   public static ArrayList<Player> snail = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 31 */     Player p = e.getEntity();
/*    */     
/* 33 */     snail.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 37 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 39 */     snail.remove(p);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 45 */     Player jogador = (Player)sender;
/* 46 */     if (label.equalsIgnoreCase("snail")) {
/* 47 */       if (jogador.hasPermission("kit.snail"))
/*    */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 51 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*    */         }
/*    */         else
/*    */         {
/* 55 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 60 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*    */       }
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public void giveKit(Player p)
/*    */   {
/* 68 */     p.getInventory().clear();
/* 69 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 70 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 71 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cSnail!");
KitAPI.setKit(p, "Snail");
Scoreboard.iscoriboard(p);
KitAPI.darsopa(p);
/* 76 */     snail.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onSlow(EntityDamageByEntityEvent e)
/*    */   {
/* 82 */     if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
/*    */     {
/* 84 */       Player p = (Player)e.getEntity();
/* 85 */       Player d = (Player)e.getDamager();
/* 86 */       if (snail.contains(d))
/*    */       {
/* 88 */         Random r = new Random();
/* 89 */         int rand = r.nextInt(100);
/* 90 */         if (rand >= 67) {
/* 91 */           p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 1));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Snail.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */