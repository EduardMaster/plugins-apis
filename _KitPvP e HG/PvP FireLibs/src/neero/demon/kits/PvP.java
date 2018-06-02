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
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ 
/*    */ public class PvP
/*    */   implements CommandExecutor, Listener
/*    */ {
/* 23 */   public static ArrayList<Player> pvp = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 27 */     Player p = e.getEntity();
/*    */     
/* 29 */     pvp.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 33 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 35 */     pvp.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 40 */     Player jogador = (Player)sender;
/* 41 */     if (label.equalsIgnoreCase("pvp")) {
/* 42 */       if (jogador.hasPermission("kit.pvp"))
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
/* 64 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 65 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 66 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cPvP!");
KitAPI.setKit(p, "PvP");
Scoreboard.iscoriboard(p);
/* 67 */     sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
KitAPI.darsopa(p);
/* 72 */     pvp.add(p);
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\PvP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */