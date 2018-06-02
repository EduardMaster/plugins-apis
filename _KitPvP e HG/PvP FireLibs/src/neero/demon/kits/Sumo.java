/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Sumo implements Listener, CommandExecutor
/*     */ {
/*  32 */   public static int maça = Material.APPLE.getId();
/*  33 */   public static ArrayList<Player> sumo = new ArrayList();
/*     */   
/*     */   public Plugin plugin;
/*     */   
/*     */   public Sumo(Main plugin)
/*     */   {
/*  39 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  42 */   public ArrayList<String> Cima = new ArrayList();
/*  43 */   ArrayList<String> tempo = new ArrayList();
/*  44 */   private ArrayList<Block> remover = new ArrayList();
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  48 */     Player jogador = (Player)sender;
/*  49 */     if (label.equalsIgnoreCase("sumo")) {
/*  50 */       if (jogador.hasPermission("kit.sumo"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  54 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  58 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  63 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public void giveKit(Player p)
/*     */   {
/*  71 */     p.getInventory().clear();
/*  72 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cSumo!");
KitAPI.setKit(p, "Sumo");
Scoreboard.iscoriboard(p);
/*  73 */     sumo.add(p);
/*  74 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  75 */     ItemStack apple = new ItemStack(Material.APPLE);
/*  77 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  78 */     p.getInventory().addItem(new ItemStack[] { apple });
KitAPI.darsopa(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Morrer(PlayerDeathEvent e)
/*     */   {
/*  87 */     Player p = e.getEntity();
/*  88 */     sumo.remove(p);
/*  89 */     this.tempo.remove(p.getName());
/*  90 */     this.Cima.remove(p.getName());
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Sair(PlayerQuitEvent e)
/*     */   {
/*  96 */     Player p = e.getPlayer();
/*  97 */     sumo.remove(p);
/*  98 */     this.tempo.remove(p.getName());
/*  99 */     this.Cima.remove(p.getName());
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void Clicar(PlayerInteractEvent e)
/*     */   {
/* 106 */     Player p = e.getPlayer();
/*     */     
/* 108 */     if ((p instanceof Player))
/*     */     {
/* 110 */       if (sumo.contains(p)) {
/* 111 */         if (p.getItemInHand().equals(Integer.valueOf(maça))) {
/* 112 */           return;
/*     */         }
/* 114 */         if (!e.getAction().name().contains("RIGHT")) {
/* 115 */           return;
/*     */         }
/* 117 */         if (p.getItemInHand().getTypeId() != maça) {
/* 118 */           return;
/*     */         }
/* 120 */         e.setCancelled(true);
/* 121 */         if (!this.tempo.contains(p.getName()))
/*     */         {
/* 123 */           Location Local = e.getPlayer().getLocation();
/* 124 */           Local = Local.getWorld().getHighestBlockAt(Local).getLocation().add(0.0D, 22.0D, 0.0D);
/* 125 */           for (int x = 0; x <= 0; x++) {
/* 126 */             for (int z = 0; z <= 0; z++)
/*     */             {
/* 128 */               final Block a = Local.add(x, 0.0D, z).getBlock();
/* 129 */               a.setType(Material.BEDROCK);
/* 130 */               e.getPlayer().teleport(Local.add(0.0D, 1.0D, 0.0D));
/* 131 */               this.tempo.add(p.getName());
/* 132 */               this.Cima.add(p.getName());
/* 133 */               Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new Runnable()
/*     */               {
/*     */                 public void run()
/*     */                 {
/* 137 */                   a.setType(Material.AIR);
/* 138 */                   Sumo.this.remover.remove(a);
/*     */                 }
/* 140 */               }, 50L);
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 146 */           p.sendMessage("§4§lKIT §cAguarde mais um pouco para usar sua habilidade !");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Cair(EntityDamageEvent e)
/*     */   {
/* 155 */     if (!(e.getEntity() instanceof Player)) {
/* 156 */       return;
/*     */     }
/* 158 */     final Player p = (Player)e.getEntity();
/* 159 */     if ((e.getCause() == EntityDamageEvent.DamageCause.FALL) && 
/* 160 */       (this.Cima.contains(p.getName())))
/*     */     {
/* 162 */       e.setCancelled(true);
/* 163 */       for (Entity Altura : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
/* 164 */         if ((Altura instanceof Player))
/*     */         {
/* 166 */           Player Pular = (Player)Altura;
/* 167 */           Vector v = p.getLocation().getDirection().multiply(0).setY(2.0D);
/* 168 */           Pular.setVelocity(v);
/*     */         }
/*     */       }
/* 171 */       this.Cima.remove(p.getName());
/* 172 */       e.setDamage(9.0D);
/* 173 */       Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 177 */           Sumo.this.tempo.remove(p.getName());
/*     */         }
/* 179 */       }, 600L);
/*     */       
/* 181 */       return;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Sumo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */