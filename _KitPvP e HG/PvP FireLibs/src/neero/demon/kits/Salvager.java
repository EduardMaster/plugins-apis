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
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Salvager
/*     */   implements Listener, CommandExecutor
/*     */ {
/*  28 */   public static ArrayList<Player> salvager = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  32 */     Player p = e.getEntity();
/*     */     
/*  34 */     salvager.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  38 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  40 */     salvager.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  45 */     Player jogador = (Player)sender;
/*  46 */     if (label.equalsIgnoreCase("salvager")) {
/*  47 */       if (jogador.hasPermission("kit.salvager"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  51 */           jogador.sendMessage("ß4ßlKIT ß7Voce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  55 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  60 */         jogador.sendMessage(ChatColor.RED + "ß4ßlKIT ß7Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  63 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  68 */     p.getInventory().clear();
/*  69 */     p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce escolheu ßcSalvager!");
KitAPI.setKit(p, "Salvager");Scoreboard.iscoriboard(p);
/*  70 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  71 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  72 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS) });
KitAPI.darsopa(p);
/*  77 */     salvager.add(p);
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void onCompassClick(PlayerInteractEvent e)
/*     */   {
/*  84 */     Player p = e.getPlayer();
/*  85 */     if (!salvager.contains(p)) {
/*  86 */       return;
/*     */     }
/*  88 */     if (p.getItemInHand().getType() != Material.COMPASS) {
/*  89 */       return;
/*     */     }
/*  91 */     if (p.getItemInHand().getAmount() < 2)
/*     */     {
/*  93 */       p.sendMessage(ChatColor.RED + "ß4ßlKIT ß7Voce precisa de mais 1 b˙ssola!");
/*  94 */       return;
/*     */     }
/*  96 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
/*     */     {
/*  98 */       int itemsleft = p.getItemInHand().getAmount();
/*  99 */       p.getItemInHand().setAmount(itemsleft - 1);
/* 100 */       Random r = new Random();
/* 101 */       int rand = r.nextInt(100);
/* 102 */       if (rand > 99)
/*     */       {
/* 104 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou 1 bota de couro!");
/* 105 */         p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
/*     */       }
/* 107 */       else if (rand > 98)
/*     */       {
/* 109 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou 1 capacete de couro!");
/* 110 */         p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
/*     */       }
/* 112 */       else if (rand > 88)
/*     */       {
/* 114 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou um arco!");
/* 115 */         p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BOW) });
/*     */       }
/* 117 */       else if (rand > 78)
/*     */       {
/* 119 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou 10 flechas!");
/* 120 */         p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 10) });
/*     */       }
/* 122 */       else if (rand > 68)
/*     */       {
/* 124 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou o efeito Resistencia!");
/* 125 */         p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 900, 0));
/*     */       }
/* 127 */       else if (rand > 58)
/*     */       {
/* 129 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou o efeito Velocidade!");
/* 130 */         p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 900, 0));
/*     */       }
/* 132 */       else if (rand > 48)
/*     */       {
/* 134 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou 2 b√∫ssola!");
/* 135 */         p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS, 2) });
/*     */       }
/* 137 */       else if (rand > 38)
/*     */       {
/* 139 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce nao salvou nada :'(!");
/*     */       }
/* 141 */       else if (rand > 28)
/*     */       {
/* 143 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou 5 sopas!");
/* 144 */         p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 5) });
/*     */       }
/* 146 */       else if (rand > 18)
/*     */       {
/* 148 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou uma ma√ßa dourada!");
/* 149 */         p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GOLDEN_APPLE) });
/*     */       }
/* 151 */       else if (rand > 8)
/*     */       {
/* 153 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou uma Ender Pearl!");
/* 154 */         p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL) });
/*     */       }
/*     */       else
/*     */       {
/* 158 */         p.sendMessage(ChatColor.GREEN + "ß4ßlKIT ß7Voce salvou o efeito For√ßa!");
/* 159 */         p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 900, 0));
/*     */       }
/* 161 */       p.updateInventory();
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void kill(PlayerDeathEvent e)
/*     */   {
/* 168 */     Player p = e.getEntity();
/* 169 */     if ((p.getKiller() instanceof Player))
/*     */     {
/* 171 */       Player k = p.getKiller();
/* 172 */       if (salvager.contains(k)) {
/* 173 */         k.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS) });
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Salvager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */