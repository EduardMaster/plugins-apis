/*     */ package neero.demon.kits;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;

import neero.demon.eventos.KitAPI;
/*     */ import net.minecraft.server.v1_7_R4.EntityFishingHook;
/*     */ import net.minecraft.server.v1_7_R4.Item;
/*     */ import net.minecraft.server.v1_7_R4.Items;

/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Test
/*     */   implements Listener, CommandExecutor
/*     */ {
/*  32 */   public static HashMap<Player, EntityFishingHook> rod = new HashMap();
/*  33 */   public static ArrayList<Player> escalador = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  37 */     Player p = e.getEntity();
/*     */     
/*  39 */     rod.remove(p);
/*  40 */     escalador.remove(p);
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  45 */     ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
/*  46 */     sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  47 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  48 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.LEASH) });
/*  49 */     escalador.add(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  54 */     Player jogador = (Player)sender;
/*  55 */     if (label.equalsIgnoreCase("escalador")) {
/*  56 */       if (jogador.hasPermission("kit.escalador"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  60 */           jogador.sendMessage("§c§l§oVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  64 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  69 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onGrappler(PlayerInteractEvent e)
/*     */   {
/*  78 */     Player p = e.getPlayer();
/*  79 */     if (!escalador.contains(p)) {
/*  80 */       return;
/*     */     }
/*  82 */     if (p.getItemInHand().getType() != Material.LEASH) {
/*  83 */       return;
/*     */     }
/*  85 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
/*     */     {
/*  87 */       if (rod.get(p) == null) {
/*  88 */         return;
/*     */       }
/*  90 */       Location to = ((EntityFishingHook)rod.get(p)).getBukkitEntity().getLocation();
/*  91 */       Location lc = p.getLocation();
/*  92 */       double g = -0.08D;
/*  93 */       double d = to.distance(lc);
/*  94 */       double t = d;
/*  95 */       double v_x = (1.0D + 0.07D * t) * (to.getX() - lc.getX()) / t / 1.5D;
/*  96 */       double v_y = (1.0D + 0.03D * t) * (to.getY() - lc.getY()) / t - 0.5D * g * t;
/*  97 */       double v_z = (1.0D + 0.07D * t) * (to.getZ() - lc.getZ()) / t / 1.5D;
/*  98 */       Vector v = p.getVelocity();
/*  99 */       v.setX(v_x);
/* 100 */       v.setY(v_y);
/* 101 */       v.setZ(v_z);
/* 102 */       p.setVelocity(v);
/*     */     }
/* 104 */     if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))
/*     */     {
/* 106 */       if (rod.get(p) != null) {
/* 107 */         ((EntityFishingHook)rod.get(p)).die();
/*     */       }
/* 109 */       rod.remove(p);
/* 110 */       Location loc = p.getLocation();
/*     */       
/* 112 */       Item item = Items.LEASH;
/* 113 */       FishingHook fish = new FishingHook(p, item);
/* 114 */       fish.spawn(p, loc);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Test.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */