/*    */ package neero.demon.kits;
/*    */ 
/*    */ import java.util.ArrayList;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ public class Poseidon
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 28 */   public static ArrayList<Player> poseidon = new ArrayList();
/*    */   
/*    */   @EventHandler
/* 31 */   public void deathe(PlayerDeathEvent e) { Player p = e.getEntity();
/*    */     
/* 33 */     poseidon.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 37 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 39 */     poseidon.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 44 */     Player jogador = (Player)sender;
/* 45 */     if (label.equalsIgnoreCase("poseidon")) {
/* 46 */       if (jogador.hasPermission("kit.poseidon"))
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
/* 59 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*    */       }
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public static void giveKit(Player p)
/*    */   {
/* 67 */     p.getInventory().clear();
/* 68 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cPoseidon!");
KitAPI.setKit(p, "Poseidon");
Scoreboard.iscoriboard(p);
/* 69 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 70 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/* 75 */     poseidon.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerMove(PlayerMoveEvent e)
/*    */   {
/* 81 */     Player p = e.getPlayer();
/* 82 */     if (!poseidon.contains(p)) {
/* 83 */       return;
/*    */     }
/* 85 */     World w = p.getLocation().getWorld();
/* 86 */     double x = p.getLocation().getX();
/* 87 */     double y = p.getLocation().getY();
/* 88 */     double z = p.getLocation().getZ();
/* 89 */     Location water = new Location(w, x, y, z);
/* 90 */     if ((water.getBlock().getType() == Material.STATIONARY_WATER) || (water.getBlock().getType() == Material.WATER))
/*    */     {
/* 92 */       p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
/* 93 */       p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60, 1));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Poseidon.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */