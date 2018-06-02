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
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Souper
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 23 */   public static ArrayList<Player> souper = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 27 */     Player p = e.getEntity();
/*    */     
/* 29 */     souper.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 33 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 35 */     souper.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 40 */     Player jogador = (Player)sender;
/* 41 */     if (label.equalsIgnoreCase("souper")) {
/* 42 */       if (jogador.hasPermission("kit.souper"))
/*    */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 46 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*    */         }
/*    */         else
/*    */         {
/* 50 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 55 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*    */       }
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public void giveKit(Player p)
/*    */   {
/* 63 */     p.getInventory().clear();
/* 64 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cSouper!");
KitAPI.setKit(p, "Souper");
Scoreboard.iscoriboard(p);
/* 65 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 66 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/* 71 */     souper.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onSouperKill(PlayerDeathEvent e)
/*    */   {
/* 77 */     Player p = e.getEntity();
/* 78 */     Player d = p.getKiller();
/* 79 */     if (!(d instanceof Player)) {
/* 80 */       return;
/*    */     }
/* 82 */     if (!souper.contains(d)) {
/* 83 */       return;
/*    */     }
/* 85 */     d.getInventory().clear();
/* 86 */     d.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce foi resoupado ao matar um player!");
/* 87 */     d.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
/* 88 */     for (int i = 0; i < 37; i++) {
/* 89 */       d.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Souper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */