/*     */ package br.nikao.eventos;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.comandos.Score;
/*     */ import br.nikao.outros.AntiMoveAPI;
/*     */ import br.nikao.outros.KitAPI;
/*     */ import br.nikao.outros.TabAPI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class Entrar implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void Evento(PlayerJoinEvent e)
/*     */   {
/*  27 */     e.setJoinMessage(null);
/*  28 */     final Player p = e.getPlayer();
/*  29 */     if (Main.getInstance().getConfig().getString("Status." + p.getUniqueId()) == null) {
/*  30 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId(), p.getUniqueId());
/*  31 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Nick", p.getName());
/*  32 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Kills", Integer.valueOf(0));
/*  33 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Deaths", Integer.valueOf(0));
/*  34 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".XP", Integer.valueOf(100));
/*  35 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Rank", "BRZ V");
/*  36 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".VC", Integer.valueOf(0));
/*  37 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Tag", "Normal");
/*  38 */       Main.Kills.put(p.getName(), Integer.valueOf(Main.getInstance().getConfig().getInt("Status." + p.getUniqueId() + ".Kills")));
/*  39 */       Main.Deaths.put(p.getName(), Integer.valueOf(Main.getInstance().getConfig().getInt("Status." + p.getUniqueId() + ".Deaths")));
/*  40 */       Main.XP.put(p.getName(), Integer.valueOf(Main.getInstance().getConfig().getInt("Status." + p.getUniqueId() + ".XP")));
/*  41 */       Main.Rank.put(p.getName(), Main.getInstance().getConfig().getString("Status." + p.getUniqueId() + ".Rank"));
/*  42 */       p.kickPlayer("§4§lATENÇÃO\n\n §7Você entrou pela 1° vez no servidor\n§7Estamos gerando suas informaçoes\n\n§cPor favor entre novamente !");
/*     */     }
/*  44 */     Main.Kills.put(p.getName(), Integer.valueOf(Main.getInstance().getConfig().getInt("Status." + p.getUniqueId() + ".Kills")));
/*  45 */     Main.Deaths.put(p.getName(), Integer.valueOf(Main.getInstance().getConfig().getInt("Status." + p.getUniqueId() + ".Deaths")));
/*  46 */     Main.XP.put(p.getName(), Integer.valueOf(Main.getInstance().getConfig().getInt("Status." + p.getUniqueId() + ".XP")));
/*  47 */     Main.Rank.put(p.getName(), Main.getInstance().getConfig().getString("Status." + p.getUniqueId() + ".Rank"));
/*  48 */     br.nikao.outros.KillStreaks.setKillStreak(p);
/*  49 */     TabAPI.AddTab(p);
/*  50 */     AntiMoveAPI.AntiMove1.remove(p.getName());
/*  51 */     AntiMoveAPI.AntiMove2.remove(p.getName());
/*  52 */     p.getInventory().clear();
/*  53 */     p.getInventory().setArmorContents(null);
/*  54 */     p.setGameMode(org.bukkit.GameMode.ADVENTURE);
/*  55 */     p.setMaxHealth(20.0D);
/*  56 */     p.setHealth(20.0D);
/*  57 */     p.setFoodLevel(20);
/*  58 */     p.setLevel(0);
/*  59 */     p.teleport(p.getWorld().getSpawnLocation());
/*  60 */     KitAPI.RemoveKit(p);
/*     */     
/*  62 */     Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */     {
/*     */       public void run() {
/*     */         Player[] arrayOfPlayer;
/*  66 */         int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/*  67 */           if (Score.score.contains(s.getName())) {
/*  68 */             return;
/*     */           }
/*  70 */           br.nikao.outros.Scoreboards.Scores(p);
/*     */         }
/*     */         
/*     */       }
/*     */       
/*  75 */     }, 20L);
/*     */     
/*  77 */     if (Main.getInstance().getConfig().getString("BoasVindas").equals("true")) {
/*  78 */       p.sendMessage(Main.getInstance().getConfig().getString("BoasVindas2").replace("&", "§").replace("{player}", p.getName()));
/*  79 */     } else if (Main.getInstance().getConfig().getString("BoasVindas").equals("false")) {
/*  80 */       return;
/*     */     }
/*     */     
/*  83 */     ItemStack kit = new ItemStack(Material.CHEST);
/*  84 */     ItemMeta kitmeta = kit.getItemMeta();
/*  85 */     kitmeta.setDisplayName("§7» §f§lSeus Kits §8§l(§7§n" + p.getName() + "§8§l)");
/*  86 */     kit.setItemMeta(kitmeta);
/*     */     
/*  88 */     ItemStack warps = new ItemStack(Material.PAPER);
/*  89 */     ItemMeta warpsmeta = warps.getItemMeta();
/*  90 */     warpsmeta.setDisplayName("§7» §f§lWarps");
/*  91 */     warps.setItemMeta(warpsmeta);
/*     */     
/*  93 */     ItemStack loja = new ItemStack(Material.EXP_BOTTLE);
/*  94 */     ItemMeta lojameta = loja.getItemMeta();
/*  95 */     lojameta.setDisplayName("§7» §f§lLoja §8§l(§6§nXP§8§l)");
/*  96 */     loja.setItemMeta(lojameta);
/*     */     
/*  98 */     ItemStack status = new ItemStack(Material.ENCHANTED_BOOK);
/*  99 */     ItemMeta statusmeta = status.getItemMeta();
/* 100 */     statusmeta.setDisplayName("§7» §f§lRegras");
/* 101 */     status.setItemMeta(statusmeta);
/*     */     
/* 103 */     ItemStack caixa = new ItemStack(Material.ENCHANTMENT_TABLE);
/* 104 */     ItemMeta caixameta = caixa.getItemMeta();
/* 105 */     caixameta.setDisplayName("§7» §f§l§nCaixas");
/* 106 */     caixa.setItemMeta(caixameta);
/*     */     
/* 108 */     ItemStack vidro = new ItemStack(Material.IRON_FENCE, 1, (short)15);
/* 109 */     ItemMeta vidrometa = vidro.getItemMeta();
/* 110 */     vidrometa.setDisplayName("§c§lSTOMPA§8§l-§e§lKITS");
/* 111 */     vidro.setItemMeta(vidrometa);
/*     */     
/* 113 */     p.getInventory().setItem(0, status);
/* 114 */     p.getInventory().setItem(2, vidro);
/* 115 */     p.getInventory().setItem(3, warps);
/* 116 */     p.getInventory().setItem(4, kit);
/* 117 */     p.getInventory().setItem(5, loja);
/* 118 */     p.getInventory().setItem(6, vidro);
/* 119 */     p.getInventory().setItem(8, caixa);
/* 120 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Eventos(PlayerInteractEvent e) {
/* 125 */     Player p = e.getPlayer();
/* 126 */     if ((p.getItemInHand().getType() == Material.EXP_BOTTLE) && (KitAPI.getkit(p) == "Nenhum")) {
/* 127 */       e.setCancelled(true);
/* 128 */       p.updateInventory();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\eventos\Entrar.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */