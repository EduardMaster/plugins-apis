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
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ 
/*    */ public class Stomper
/*    */   implements Listener, CommandExecutor
/*    */ {
/*    */   double damage;
/* 26 */   public static ArrayList<Player> stomper = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 30 */     Player p = e.getEntity();
/*    */     
/* 32 */     stomper.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 36 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 38 */     stomper.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 43 */     Player jogador = (Player)sender;
/* 44 */     if (label.equalsIgnoreCase("stomper")) {
/* 45 */       if (jogador.hasPermission("kit.stomper"))
/*    */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 49 */           jogador.sendMessage("§4§lKIT §cVocê já está usando um kit!");
/*    */         }
/*    */         else
/*    */         {
/* 53 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 58 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVocê nao possui este kit");
/*    */       }
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public void giveKit(Player p)
/*    */   {
/* 66 */     p.getInventory().clear();
/* 67 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 68 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 69 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Você selecionou §cStomper");
Scoreboard.iscoriboard(p);
KitAPI.setKit(p, "Stomper");
KitAPI.darsopa(p);
/* 74 */     stomper.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void EntityDamage(EntityDamageEvent e)
/*    */   {
/* 80 */     if ((e.getEntity() instanceof Player))
/*    */     {
/* 82 */       Player p = (Player)e.getEntity();
/* 83 */       if ((stomper.contains(p)) &&
/* 84 */         (e.getCause() == EntityDamageEvent.DamageCause.FALL) &&
/* 85 */         (e.getDamage() > 4.0D))
/*    */       {
/* 87 */         e.setCancelled(true);
/* 88 */         p.damage(4.0D);
/* 89 */         for (Entity ent : p.getNearbyEntities(3.5D, 3.5D, 3.5D)) {
/* 90 */           if ((ent instanceof Player))
/*    */           {
/* 92 */             Player t = (Player)ent;
{
/* 93 */             if (!t.isSneaking()) {
/* 94 */               t.damage(e.getDamage(), p);
/*    */             } else {
/* 96 */               t.damage(e.getDamage() / 6.0D, p);
/*    */             }
/* 98 */             if (t.isDead()) {
/* 99 */               t.sendMessage("§4§lKIT §7Você Foi Stompado Por §6" + p.getName());
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }
}


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Stomper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */