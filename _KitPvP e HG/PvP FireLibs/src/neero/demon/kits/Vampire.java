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
/*    */ public class Vampire
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 27 */   public static ArrayList<Player> vampire = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 31 */     Player p = e.getEntity();
/*    */     
/* 33 */     vampire.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 37 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 39 */     vampire.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 44 */     Player jogador = (Player)sender;
/* 45 */     if (label.equalsIgnoreCase("vampire")) {
/* 46 */       if (jogador.hasPermission("kit.vampire"))
/*    */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 50 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*    */         }
/*    */         else
/*    */         {
/* 54 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 59 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*    */       }
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public static void giveKit(Player p)
/*    */   {
/* 67 */     p.getInventory().clear();
/* 68 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cVampire!");
KitAPI.setKit(p, "Vampire");
 Scoreboard.iscoriboard(p);
/* 69 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 70 */     p.getInventory().addItem(new ItemStack[] { sword });
				KitAPI.darsopa(p);
/* 75 */     vampire.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onvampireDamage(EntityDamageByEntityEvent e)
/*    */   {
/* 81 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*    */     {
/* 83 */       Player d = (Player)e.getDamager();
/* 84 */       if (!vampire.contains(d)) {
/* 85 */         return;
/*    */       }
/* 87 */       Random r = new Random();
/* 88 */       int rand = r.nextInt(100);
/* 89 */       if (rand <= 10)
/*    */       {
/* 91 */         d.sendMessage(ChatColor.DARK_RED + "§4§lKIT §7BLOOD");
/* 92 */         d.removePotionEffect(PotionEffectType.SPEED);
/* 93 */         d.removePotionEffect(PotionEffectType.REGENERATION);
/* 94 */         d.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
/* 95 */         d.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Vampire.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */