/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerDropItemEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Gladiator
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Plugin plugin;
/*     */   
/*     */   public Gladiator(Main plugin)
/*     */   {
/*  43 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  46 */   public boolean generateGlass = true;
/*  47 */   public HashMap<String, Location> oldl = new HashMap();
/*  48 */   public static HashMap<String, String> fighting = new HashMap();
/*  49 */   public HashMap<Integer, ArrayList<Location>> blocks = new HashMap();
/*  50 */   public HashMap<Player, Location> localizacao = new HashMap();
/*  51 */   public HashMap<Location, Block> bloco = new HashMap();
/*  52 */   public HashMap<Integer, String[]> players = new HashMap();
/*  53 */   public HashMap<String, Integer> tasks = new HashMap();
/*  54 */   int nextID = 0;
/*     */   public int id1;
/*     */   public int id2;
/*     */   
/*     */   @EventHandler
/*     */   public void qdoMorre(PlayerDeathEvent e) {
/*  60 */     Player p = e.getEntity();
/*     */     
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void OnGladiatorKit(PlayerInteractEntityEvent event)
/*     */   {
/*  69 */     final Player p = event.getPlayer();
/*  70 */     if ((event.getRightClicked() instanceof Player))
/*     */     {
/*  72 */       final Player r = (Player)event.getRightClicked();
/*  73 */       if ((p.getItemInHand().getType() == Material.IRON_FENCE) && /*  56 */         (!(KitAPI.getkit(p) == ("Nenhum"))))
/*     */       {
/*  75 */         event.setCancelled(true);
/*  76 */         Location loc = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 70, p.getLocation().getBlockZ());
/*  77 */         this.localizacao.put(p, loc);
/*  78 */         this.localizacao.put(r, loc);
/*  79 */         Location loc2 = new Location(p.getWorld(), p.getLocation().getBlockX() + 8, p.getLocation().getBlockY() + 73, p.getLocation().getBlockZ() + 8);
/*  80 */         Location loc3 = new Location(p.getWorld(), p.getLocation().getBlockX() - 8, p.getLocation().getBlockY() + 73, p.getLocation().getBlockZ() - 8);
/*  81 */         if ((fighting.containsKey(p.getName())) || (fighting.containsKey(r.getName())))
/*     */         {
/*  83 */           event.setCancelled(true);
/*  84 */           p.sendMessage(ChatColor.RED + "§4§lKIT §7Voce ja esta em combate!");
/*  85 */           return;
/*     */         }
/*  87 */         Integer currentID = Integer.valueOf(this.nextID);
/*  88 */         this.nextID += 1;
/*  89 */         ArrayList<String> list = new ArrayList();
/*  90 */         list.add(p.getName());
/*  91 */         list.add(r.getName());
/*  92 */         this.players.put(currentID, (String[])list.toArray(new String[1]));
/*  93 */         this.oldl.put(p.getName(), p.getLocation());
/*  94 */         this.oldl.put(r.getName(), r.getLocation());
/*  95 */         if (this.generateGlass)
/*     */         {
/*  97 */           List<Location> cuboid = new ArrayList();
/*  98 */           cuboid.clear();
/*     */           int bZ;
/* 100 */           for (int bX = -10; bX <= 10; bX++) {
/* 101 */             for (bZ = -10; bZ <= 10; bZ++) {
/* 102 */               for (int bY = -1; bY <= 10; bY++)
/*     */               {
/* 104 */                 Block b = loc.clone().add(bX, bY, bZ).getBlock();
/* 105 */                 if (!b.isEmpty())
/*     */                 {
/* 107 */                   event.setCancelled(true);
/* 108 */                   p.sendMessage(ChatColor.RED + "§4§lKIT §7Voce nao pode criar sua arena aqui");
/* 109 */                   return;
/*     */                 }
/* 111 */                 if (bY == 10) {
/* 112 */                   cuboid.add(loc.clone().add(bX, bY, bZ));
/* 113 */                 } else if (bY == -1) {
/* 114 */                   cuboid.add(loc.clone().add(bX, bY, bZ));
/* 115 */                 } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
/* 116 */                   cuboid.add(loc.clone().add(bX, bY, bZ));
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/* 121 */           for (Location loc1 : cuboid)
/*     */           {
/* 123 */             loc1.getBlock().setType(Material.GLASS);
/* 124 */             this.bloco.put(loc1, loc1.getBlock());
/*     */           }
/* 126 */           loc2.setYaw(135.0F);
/* 127 */           p.teleport(loc2);
/* 128 */           loc3.setYaw(-45.0F);
/* 129 */           r.teleport(loc3);
/* 130 */           p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
/* 131 */           r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
/* 132 */           p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce desafiou um jogador! Voce tem 5 segundos de invencibilidade!");
/* 133 */           p.sendMessage(ChatColor.AQUA + "§4§lKIT §7Caso nao tenha nenhum vencedor depois de 4 minutos, voce voltara ao seu local de origem!");
/* 134 */           r.sendMessage(ChatColor.RED + "§4§lKIT §7Voce foi desafiado! Voce tem 5 segundos de invencibilidade!");
/* 135 */           r.sendMessage(ChatColor.AQUA + "§4§lKIT §7Caso nao tenha nenhum vencedor depois de 4 minutos, voce voltara ao seu local de origem!");
/* 136 */           fighting.put(p.getName(), r.getName());
/* 137 */           fighting.put(r.getName(), p.getName());
/* 140 */           this.id2 = Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 144 */               if ((Gladiator.fighting.containsKey(p.getName())) && (((String)Gladiator.fighting.get(p.getName())).equalsIgnoreCase(r.getName())) && (Gladiator.fighting.containsKey(r.getName())) && (((String)Gladiator.fighting.get(r.getName())).equalsIgnoreCase(p.getName())))
/*     */               {
/* 146 */                 p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
/* 147 */                 r.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
/*     */               }
/*     */             }
/* 150 */           }, 2400L);
/* 151 */           this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 155 */               if ((Gladiator.fighting.containsKey(p.getName())) && (((String)Gladiator.fighting.get(p.getName())).equalsIgnoreCase(r.getName())) && (Gladiator.fighting.containsKey(r.getName())) && (((String)Gladiator.fighting.get(r.getName())).equalsIgnoreCase(p.getName())))
/*     */               {
/* 157 */                 Gladiator.fighting.remove(p.getName());
/* 158 */                 Gladiator.fighting.remove(r.getName());
/* 161 */                 p.teleport((Location)Gladiator.this.oldl.get(p.getName()));
/* 162 */                 r.teleport((Location)Gladiator.this.oldl.get(r.getName()));
/* 163 */                 Gladiator.this.oldl.remove(p.getName());
/* 164 */                 Gladiator.this.oldl.remove(r.getName());
/* 165 */                 p.sendMessage(ChatColor.RED + "§4§lKIT §7Nao houve nenhum vencedor, voce foi teleportado para o seu lugar de origem!");
/* 166 */                 r.sendMessage(ChatColor.RED + "§4§lKIT §7Nao houve nenhum vencedor, voce foi teleportado para o seu lugar de origem!");
/* 167 */                 Location loc = (Location)Gladiator.this.localizacao.get(p);
/* 168 */                 List<Location> cuboid = new ArrayList();
/*     */                 int bZ;
/* 170 */                 for (int bX = -10; bX <= 10; bX++) {
/* 171 */                   for (bZ = -10; bZ <= 10; bZ++) {
/* 172 */                     for (int bY = -1; bY <= 10; bY++) {
/* 173 */                       if (bY == 10) {
/* 174 */                         cuboid.add(loc.clone().add(bX, bY, bZ));
/* 175 */                       } else if (bY == -1) {
/* 176 */                         cuboid.add(loc.clone().add(bX, bY, bZ));
/* 177 */                       } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
/* 178 */                         cuboid.add(loc.clone().add(bX, bY, bZ));
/*     */                       }
/*     */                     }
/*     */                   }
/*     */                 }
/* 183 */                 for (Location loc1 : cuboid)
/*     */                 {
/* 185 */                   loc1.getBlock().setType(Material.AIR);
/* 186 */                   ((Block)Gladiator.this.bloco.get(loc1)).setType(Material.AIR);
/*     */                 }
/*     */               }
/*     */             }
/* 190 */           }, 4800L);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteractGlad(PlayerInteractEvent e)
/*     */   {
/* 199 */     Player p = e.getPlayer();
/* 200 */     if ((p.getItemInHand().getType() == Material.IRON_FENCE) && /*  56 */          (!(KitAPI.getkit(p) == ("Nenhum"))))
/*     */     {
/* 202 */       e.setCancelled(true);
/* 203 */       p.updateInventory();
/* 204 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler(priority=EventPriority.HIGHEST)
/*     */   public void onDrop(PlayerDropItemEvent e)
/*     */   {
/* 212 */     Player p = e.getPlayer();
/* 213 */     if ((p.getItemInHand().getType() == Material.IRON_FENCE) && (!(KitAPI.getkit(p) == ("Nenhum"))))
/*     */     {
/* 215 */       e.setCancelled(true);
/* 216 */       p.updateInventory();
/* 217 */       p.sendMessage(ChatColor.RED + "§4§lKIT §7Voce nao pode dropar este item!");
/* 218 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler(priority=EventPriority.MONITOR)
/*     */   public void onPlyaerInteract(final PlayerInteractEvent e)
/*     */   {
/* 225 */     if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && (e.getClickedBlock().getType() == Material.GLASS) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (fighting.containsKey(e.getPlayer().getName())))
/*     */     {
/* 227 */       e.setCancelled(true);
/* 228 */       e.getClickedBlock().setType(Material.GLASS);
/* 229 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 233 */           if (Gladiator.fighting.containsKey(e.getPlayer().getName())) {
/* 234 */             e.getClickedBlock().setType(Material.GLASS);
/*     */           }
/*     */         }
/* 237 */       }, 30L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler(priority=EventPriority.MONITOR)
/*     */   public void onBlockBreak(final BlockBreakEvent e)
/*     */   {
/* 244 */     if ((e.getBlock().getType() == Material.GLASS) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (fighting.containsKey(e.getPlayer().getName())))
/*     */     {
/* 246 */       e.setCancelled(true);
/* 247 */       e.getBlock().setType(Material.GLASS);
/* 248 */       Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 252 */           if ((e.getPlayer().getGameMode() != GameMode.CREATIVE) && (Gladiator.fighting.containsKey(e.getPlayer().getName()))) {
/* 253 */             e.getBlock().setType(Material.GLASS);
/*     */           }
/*     */         }
/* 256 */       }, 30L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler(priority=EventPriority.HIGHEST)
/*     */   public void onPlayerLeft(PlayerQuitEvent e)
/*     */   {
/* 263 */     Player p = e.getPlayer();
/* 264 */     if (fighting.containsKey(p.getName()))
/*     */     {
/* 266 */       Player t = Bukkit.getServer().getPlayer((String)fighting.get(p.getName()));
/* 267 */       fighting.remove(t.getName());
/* 268 */       fighting.remove(p.getName());
/* 271 */       Location old = (Location)this.oldl.get(t.getName());
/* 272 */       t.teleport(old);
/* 273 */       t.sendMessage(ChatColor.RED + "§4§lKIT §7O jogador " + p.getName() + " deslogou-se!");
/* 274 */       Bukkit.getScheduler().cancelTask(this.id1);
/* 275 */       Bukkit.getScheduler().cancelTask(this.id2);
/* 276 */       t.removePotionEffect(PotionEffectType.WITHER);
/* 277 */       Location loc = (Location)this.localizacao.get(p);
/* 278 */       List<Location> cuboid = new ArrayList();
/*     */       int bZ;
/* 280 */       for (int bX = -10; bX <= 10; bX++) {
/* 281 */         for (bZ = -10; bZ <= 10; bZ++) {
/* 282 */           for (int bY = -1; bY <= 10; bY++) {
/* 283 */             if (bY == 10) {
/* 284 */               cuboid.add(loc.clone().add(bX, bY, bZ));
/* 285 */             } else if (bY == -1) {
/* 286 */               cuboid.add(loc.clone().add(bX, bY, bZ));
/* 287 */             } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
/* 288 */               cuboid.add(loc.clone().add(bX, bY, bZ));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 293 */       for (Location loc1 : cuboid)
/*     */       {
/* 295 */         loc1.getBlock().setType(Material.AIR);
/* 296 */         ((Block)this.bloco.get(loc1)).setType(Material.AIR);
/*     */       }
/* 298 */       for (Location loc1 : cuboid)
/*     */       {
/* 300 */         loc1.getBlock().setType(Material.AIR);
/* 301 */         ((Block)this.bloco.get(loc1)).setType(Material.AIR);
/*     */       }
/* 303 */       for (Location loc1 : cuboid)
/*     */       {
/* 305 */         loc1.getBlock().setType(Material.AIR);
/* 306 */         ((Block)this.bloco.get(loc1)).setType(Material.AIR);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler(priority=EventPriority.HIGHEST)
/*     */   public void onDeathGladiator(PlayerDeathEvent e)
/*     */   {
/* 315 */     Player p = e.getEntity();
/* 316 */     if (fighting.containsKey(p.getName()))
/*     */     {
/* 318 */       Player k = Bukkit.getServer().getPlayer((String)fighting.get(p.getName()));
/* 319 */       Location old = (Location)this.oldl.get(p.getName());
/* 320 */       k.teleport(old);
/* 321 */       k.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce ganhou a batalha contra " + p.getName() + ChatColor.GREEN + "!");
/* 322 */       Bukkit.getScheduler().cancelTask(this.id1);
/* 323 */       Bukkit.getScheduler().cancelTask(this.id2);
/* 324 */       k.removePotionEffect(PotionEffectType.WITHER);
/* 325 */       k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
/* 326 */       fighting.remove(k.getName());
/* 327 */       fighting.remove(p.getName());
/* 330 */       Location loc = (Location)this.localizacao.get(p);
/* 331 */       List<Location> cuboid = new ArrayList();
/* 332 */       cuboid.clear();
/*     */       int bZ;
/* 334 */       for (int bX = -10; bX <= 10; bX++) {
/* 335 */         for (bZ = -10; bZ <= 10; bZ++) {
/* 336 */           for (int bY = -1; bY <= 10; bY++) {
/* 337 */             if (bY == 10) {
/* 338 */               cuboid.add(loc.clone().add(bX, bY, bZ));
/* 339 */             } else if (bY == -1) {
/* 340 */               cuboid.add(loc.clone().add(bX, bY, bZ));
/* 341 */             } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
/* 342 */               cuboid.add(loc.clone().add(bX, bY, bZ));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 347 */       for (Location loc1 : cuboid)
/*     */       {
/* 349 */         loc1.getBlock().setType(Material.AIR);
/* 350 */         if (this.bloco.containsKey(loc1)) {
/* 351 */           ((Block)this.bloco.get(loc1)).setType(Material.AIR);
/*     */         }
/*     */       }
/* 354 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/* 360 */     Player jogador = (Player)sender;
/* 361 */     if (label.equalsIgnoreCase("gladiator")) {
/* 362 */       if (jogador.hasPermission("kit.gladiator"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/* 366 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/* 370 */           giveKit(jogador);
/*     */         }
/*     */       }
/*     */       else {
/* 374 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/* 377 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/* 382 */     p.getInventory().clear();
/* 383 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cGladiator!");
KitAPI.setKit(p, "Gladiator");
Scoreboard.iscoriboard(p);
/* 384 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 385 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 386 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_FENCE) });
KitAPI.darsopa(p);
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Gladiator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */