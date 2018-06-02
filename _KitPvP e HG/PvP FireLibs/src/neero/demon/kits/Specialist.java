/*     */ package neero.demon.kits;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Specialist
/*     */   implements Listener, CommandExecutor
/*     */ {
/*  25 */   public static ArrayList<Player> specialist = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  29 */     Player p = e.getEntity();
/*     */     
/*  31 */     specialist.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  35 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  37 */     specialist.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  42 */     Player jogador = (Player)sender;
/*  43 */     if (label.equalsIgnoreCase("specialist")) {
/*  44 */       if (jogador.hasPermission("kit.specialist"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  48 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  52 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  57 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  60 */     return false;
/*     */   }
/*     */   
/*     */   public void giveKit(Player p)
/*     */   {
/*  65 */     p.getInventory().clear();
/*  66 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cSpecialist!");
KitAPI.setKit(p, "Specialist");
Scoreboard.iscoriboard(p);
/*  67 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  68 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/*  73 */     specialist.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onSpecalistKill(PlayerDeathEvent e)
/*     */   {
/*  79 */     Player p = e.getEntity();
/*  80 */     Player k = p.getKiller();
/*  81 */     if (specialist.contains(k.getName()))
/*     */     {
/*  84 */       Random r = new Random();
/*  85 */       int rand = r.nextInt(100);
/*  86 */       if (rand > 90)
/*     */       {
/*  88 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
/*  89 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ARTHROPODS);
/*  90 */         k.getItemInHand().removeEnchantment(Enchantment.KNOCKBACK);
/*  91 */         k.getItemInHand().removeEnchantment(Enchantment.FIRE_ASPECT);
/*  92 */         k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 2);
/*  93 */         k.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce encantou Sharpness II!");
/*     */       }
/*  95 */       else if (rand > 80)
/*     */       {
/*  97 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
/*  98 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ARTHROPODS);
/*  99 */         k.getItemInHand().removeEnchantment(Enchantment.KNOCKBACK);
/* 100 */         k.getItemInHand().removeEnchantment(Enchantment.FIRE_ASPECT);
/* 101 */         k.getItemInHand().addEnchantment(Enchantment.FIRE_ASPECT, 2);
/* 102 */         k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 103 */         k.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce encantou Fire II!");
/*     */       }
/* 105 */       else if (rand > 65)
/*     */       {
/* 107 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
/* 108 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ARTHROPODS);
/* 109 */         k.getItemInHand().removeEnchantment(Enchantment.KNOCKBACK);
/* 110 */         k.getItemInHand().removeEnchantment(Enchantment.FIRE_ASPECT);
/* 111 */         k.getItemInHand().addEnchantment(Enchantment.FIRE_ASPECT, 1);
/* 112 */         k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 113 */         k.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce encantou Fire I!");
/*     */       }
/* 115 */       else if (rand > 50)
/*     */       {
/* 117 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
/* 118 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ARTHROPODS);
/* 119 */         k.getItemInHand().removeEnchantment(Enchantment.KNOCKBACK);
/* 120 */         k.getItemInHand().removeEnchantment(Enchantment.FIRE_ASPECT);
/* 121 */         k.getItemInHand().addEnchantment(Enchantment.KNOCKBACK, 2);
/* 122 */         k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 123 */         k.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce encantou Knockback II!");
/*     */       }
/* 125 */       else if (rand > 25)
/*     */       {
/* 127 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
/* 128 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ARTHROPODS);
/* 129 */         k.getItemInHand().removeEnchantment(Enchantment.KNOCKBACK);
/* 130 */         k.getItemInHand().removeEnchantment(Enchantment.FIRE_ASPECT);
/* 131 */         k.getItemInHand().addEnchantment(Enchantment.KNOCKBACK, 2);
/* 132 */         k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 133 */         k.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce encantou Knockback I!");
/*     */       }
/*     */       else
/*     */       {
/* 137 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
/* 138 */         k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ARTHROPODS);
/* 139 */         k.getItemInHand().removeEnchantment(Enchantment.KNOCKBACK);
/* 140 */         k.getItemInHand().removeEnchantment(Enchantment.FIRE_ASPECT);
/* 141 */         k.getItemInHand().addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 1000);
/* 142 */         k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 143 */         k.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce encantou Ruina dos Artropodes 1000!");
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Specialist.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */