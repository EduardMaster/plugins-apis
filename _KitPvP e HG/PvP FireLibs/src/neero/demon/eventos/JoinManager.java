/*     */ package neero.demon.eventos;

/*     */ import java.util.Map;
import neero.demon.Main;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Damageable;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.event.block.BlockPlaceEvent;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityRegainHealthEvent;
/*     */ import org.bukkit.event.entity.FoodLevelChangeEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*     */ import org.bukkit.event.player.PlayerDropItemEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.event.player.PlayerRespawnEvent;
/*     */ import org.bukkit.event.server.ServerListPingEvent;
/*     */ import org.bukkit.event.weather.WeatherChangeEvent;
/*     */ import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

/*     */
/*     */ public class JoinManager implements Listener
/*     */ {
	/*     */ public static Main plugin;

	/*     */
	/*     */
	/*     */ @EventHandler
	/*     */ public void tp(PlayerJoinEvent e) {
		/* 61 */ Player p = e.getPlayer();
		Location l = p.getWorld().getSpawnLocation();
		p.teleport(l);
		/*     */
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void onMe(PlayerCommandPreprocessEvent event)
	/*     */ {
		/* 74 */ Player p = event.getPlayer();
		/* 75 */ if (event.getMessage().toLowerCase().startsWith("/me"))
		/*     */ {
			/* 77 */ event.setCancelled(true);
			/* 78 */ p.sendMessage("Unknown command. Type /help for help.");
			/*     */ }
		/*     */ }

	@EventHandler
	public void aologin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.sendMessage("§a=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		p.sendMessage("§6Seja Bem-Vindo ao §cExtremePvP.");
		p.sendMessage("§eNosso Objetivo Ã© Fazer VocÃª se Divertir.");
		p.sendMessage("§7Loja: §b§nextreme-kits.tk");
		p.sendMessage("§a=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
		p.setPlayerListName("§7" + p.getName());

	}

	/*     */ @EventHandler
	/*     */ public void canceltele(PlayerMoveEvent e)
	/*     */ {
		/* 85 */ Player p = e.getPlayer();
		/* 86 */ if ((Main.warping.contains(p)) && ((e.getFrom().getBlockX() != e.getTo().getBlockX())
				|| (e.getFrom().getBlockZ() != e.getTo().getBlockZ())))
		/*     */ {
			/* 88 */ Main.warping.remove(p);
			/* 89 */ p.sendMessage("§4§lWARP §c§lTeleporte Cancelado!");
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @SuppressWarnings("deprecation")
	@EventHandler
	/*     */ public void place(BlockPlaceEvent e) {
		/* 95 */ if (e.getBlock().getTypeId() == 272) {
			/* 96 */ e.setCancelled(true);
			/*     */ }
		/* 98 */ if (e.getBlock().getTypeId() == 272) {
			/* 99 */ e.setCancelled(true);
			/*     */ }
		/* 160 */ if (e.getBlock().getTypeId() == 260) {
			/* 102 */ e.setCancelled(true);
			/*     */ }
		/* 104 */ if (e.getBlock().getTypeId() == 154) {
			/* 105 */ e.setCancelled(true);
			/*     */ }
		/* 107 */ if (e.getBlock().getTypeId() == 401) {
			/* 108 */ e.setCancelled(true);
			/*     */ }
		/* 110 */ if (e.getBlock().getTypeId() == 261) {
			/* 111 */ e.setCancelled(true);
			/*     */ }
		/* 113 */ if (e.getBlock().getTypeId() == 373) {
			/* 114 */ e.setCancelled(true);
			/*     */ }
		/* 116 */ if (e.getBlock().getTypeId() == 264) {
			/* 117 */ e.setCancelled(true);
			/*     */ }
		/* 119 */ if (e.getBlock().getTypeId() == 122) {
			/* 160 */ e.setCancelled(true);
			/*     */ }
		/* 122 */ if (e.getBlock().getTypeId() == 345) {
			/* 123 */ e.setCancelled(true);
			/*     */ }
		/* 125 */ if (e.getBlock().getTypeId() == 331) {
			/* 126 */ e.setCancelled(true);
			/*     */ }
		/* 128 */ if (e.getBlock().getTypeId() == 377) {
			/* 129 */ e.setCancelled(true);
			/*     */ }
		/* 131 */ if (e.getBlock().getTypeId() == 347) {
			/* 132 */ e.setCancelled(true);
			/*     */ }
		/* 134 */ if (e.getBlock().getTypeId() == 271) {
			/* 135 */ e.setCancelled(true);
			/*     */ }
		/* 137 */ if (e.getBlock().getTypeId() == 275) {
			/* 138 */ e.setCancelled(true);
			/*     */ }
		/* 140 */ if (e.getBlock().getTypeId() == 19) {
			/* 141 */ e.setCancelled(true);
			/*     */ }
		/* 143 */ if (e.getBlock().getTypeId() == 160) {
			/* 144 */ e.setCancelled(true);
			/*     */ }
		/* 146 */ if (e.getBlock().getTypeId() == 288) {
			/* 147 */ e.setCancelled(true);
			/*     */ }
		/* 149 */ if (e.getBlock().getTypeId() == 381) {
			/* 150 */ e.setCancelled(true);
			/*     */ }
		/* 152 */ if (e.getBlock().getTypeId() == 13) {
			/* 153 */ e.setCancelled(true);
			/*     */ }
		/* 155 */ if (e.getBlock().getTypeId() == 420) {
			/* 156 */ e.setCancelled(true);
			/*     */ }
		/* 158 */ if (e.getBlock().getTypeId() == 77) {
			/* 159 */ e.setCancelled(true);
			/*     */ }
		/* 161 */ if (e.getBlock().getTypeId() == 369) {
			/* 162 */ e.setCancelled(true);
			/*     */ }
		/* 164 */ if (e.getBlock().getTypeId() == 390) {
			/* 165 */ e.setCancelled(true);
			/*     */ }
		/* 167 */ if (e.getBlock().getTypeId() == 346) {
			/* 168 */ e.setCancelled(true);
			/*     */ }
		/* 170 */ if (e.getBlock().getTypeId() == 290) {
			/* 171 */ e.setCancelled(true);
			/*     */ }
		/*     */ }

	/*     */
	/*     */
	/*     */ @SuppressWarnings("deprecation")
	@EventHandler
	/*     */ public void onDropItem(PlayerDropItemEvent e)
	/*     */ {
		/* 179 */ if (e.getItemDrop().getItemStack().getTypeId() == 272) {
			/* 180 */ e.setCancelled(true);
			/*     */ }
		/* 182 */ if (e.getItemDrop().getItemStack().getTypeId() == 260) {
			/* 183 */ e.setCancelled(true);
			/*     */ }
		/* 185 */ if (e.getItemDrop().getItemStack().getTypeId() == 154) {
			/* 186 */ e.setCancelled(true);
			/*     */ }
		/* 188 */ if (e.getItemDrop().getItemStack().getTypeId() == 401) {
			/* 189 */ e.setCancelled(true);
			/*     */ }
		/* 191 */ if (e.getItemDrop().getItemStack().getTypeId() == 261) {
			/* 192 */ e.setCancelled(true);
			/*     */ }
		/* 194 */ if (e.getItemDrop().getItemStack().getTypeId() == 373) {
			/* 195 */ e.setCancelled(true);
			/*     */ }
		/* 197 */ if (e.getItemDrop().getItemStack().getTypeId() == 264) {
			/* 198 */ e.setCancelled(true);
			/*     */ }
		/* 200 */ if (e.getItemDrop().getItemStack().getTypeId() == 122) {
			/* 201 */ e.setCancelled(true);
			/*     */ }
		/* 203 */ if (e.getItemDrop().getItemStack().getTypeId() == 345) {
			/* 204 */ e.setCancelled(true);
			/*     */ }
		/* 206 */ if (e.getItemDrop().getItemStack().getTypeId() == 331) {
			/* 207 */ e.setCancelled(true);
			/*     */ }
		/* 209 */ if (e.getItemDrop().getItemStack().getTypeId() == 377) {
			/* 210 */ e.setCancelled(true);
			/*     */ }
		/* 212 */ if (e.getItemDrop().getItemStack().getTypeId() == 347) {
			/* 213 */ e.setCancelled(true);
			/*     */ }
		/* 215 */ if (e.getItemDrop().getItemStack().getTypeId() == 271) {
			/* 216 */ e.setCancelled(true);
			/*     */ }
		/* 218 */ if (e.getItemDrop().getItemStack().getTypeId() == 275) {
			/* 219 */ e.setCancelled(true);
			/*     */ }
		/* 221 */ if (e.getItemDrop().getItemStack().getTypeId() == 19) {
			/* 222 */ e.setCancelled(true);
			/*     */ }
		/* 224 */ if (e.getItemDrop().getItemStack().getTypeId() == 160) {
			/* 225 */ e.setCancelled(true);
			/*     */ }
		/* 227 */ if (e.getItemDrop().getItemStack().getTypeId() == 288) {
			/* 228 */ e.setCancelled(true);
			/*     */ }
		/* 230 */ if (e.getItemDrop().getItemStack().getTypeId() == 381) {
			/* 231 */ e.setCancelled(true);
			/*     */ }
		/* 233 */ if (e.getItemDrop().getItemStack().getTypeId() == 13) {
			/* 234 */ e.setCancelled(true);
			/*     */ }
		/* 236 */ if (e.getItemDrop().getItemStack().getTypeId() == 420) {
			/* 237 */ e.setCancelled(true);
			/*     */ }
		/* 239 */ if (e.getItemDrop().getItemStack().getTypeId() == 77) {
			/* 240 */ e.setCancelled(true);
			/*     */ }
		/* 242 */ if (e.getItemDrop().getItemStack().getTypeId() == 369) {
			/* 243 */ e.setCancelled(true);
			/*     */ }
		/* 245 */ if (e.getItemDrop().getItemStack().getTypeId() == 390) {
			/* 246 */ e.setCancelled(true);
			/*     */ }
		/* 248 */ if (e.getItemDrop().getItemStack().getTypeId() == 346) {
			/* 249 */ e.setCancelled(true);
			/*     */ }
		/* 251 */ if (e.getItemDrop().getItemStack().getTypeId() == 290) {
			/* 252 */ e.setCancelled(true);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @EventHandler
/*     */   public void inte(PlayerInteractEvent e) {
/* 258 */     Player p = e.getPlayer();
/* 259 */     if ((p.getItemInHand().getType() == Material.CHEST) && (
/* 260 */       (e.getAction() == Action.RIGHT_CLICK_AIR) || 
/* 261 */       (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
/* 262 */       (e.getAction() == Action.LEFT_CLICK_AIR) || 
/* 263 */       (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
/* 264 */       p.chat("/kit");
/*     */     }
/* 266 */     if ((p.getItemInHand().getType() == Material.PAPER) && (
/* 267 */       (e.getAction() == Action.RIGHT_CLICK_AIR) || 
/* 268 */       (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
/* 269 */       (e.getAction() == Action.LEFT_CLICK_AIR) || 
/* 270 */       (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
/* 271 */       p.chat("/warps");
/*     */     }
/* 273 */     if ((p.getItemInHand().getType() == Material.PISTON_BASE) && (
/* 274 */       (e.getAction() == Action.RIGHT_CLICK_AIR) || 
/* 275 */       (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
/* 276 */       (e.getAction() == Action.LEFT_CLICK_AIR) || 
/* 277 */       (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
/* 278 */       p.chat("/extra");
/*     */     }
/* 273 */     if ((p.getItemInHand().getType() == Material.ENDER_CHEST) && (
/* 274 */       (e.getAction() == Action.RIGHT_CLICK_AIR) || 
/* 275 */       (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
/* 276 */       (e.getAction() == Action.LEFT_CLICK_AIR) || 
/* 277 */       (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
/* 278 */       p.chat("/kit2");
/*     */     }
/*     */   }

	@EventHandler
	public void aoentrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		semkit(p);
	}

	/*     */
	/*     */ @SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	/*     */ public static void semkit(Player p) {
		p.getInventory().clear();
		Scoreboard.iscoriboard(p);
		/*     */ KitAPI.setKit(p, "Nenhum");
		/*     */ KitAPI.setKit2(p, "Nenhum");
		/* 287 */ p.setGameMode(GameMode.SURVIVAL);
		/* 288 */ p.getInventory().setArmorContents(null);
		/*     */ KitAPI.setitem(p, Material.CHEST, "§bClasses", 0);
		/* 305 */ KitAPI.setitem(p, Material.ENDER_CHEST, "§bClasses 2 §6[VIP]", 1);
		/* 305 */ KitAPI.setitem(p, Material.THIN_GLASS, "§b§l-", 2);
		/* 305 */ KitAPI.setitem(p, Material.THIN_GLASS, "§b§l-", 3);
		/* 305 */ KitAPI.setitem(p, Material.PISTON_BASE, "§bMenu", 4);
		/* 305 */ KitAPI.setitem(p, Material.THIN_GLASS, "§b§l-", 5);
		/* 305 */ KitAPI.setitem(p, Material.PAPER, "§bWarps", 6);
		/* 305 */ KitAPI.setitem(p, Material.THIN_GLASS, "§b§l-", 7);
		/* 305 */ KitAPI.setitem(p, Material.getMaterial(351), "§bCaixa DiÃ¡ria", 8);
		/*     */ }

	/*     */
	@EventHandler
	/*     */ public void onR(PlayerRespawnEvent e)
	/*     */ {
		Player p = e.getPlayer();
		semkit(p);
	}

	/*     */ @EventHandler
	/*     */ public void onKill(PlayerDeathEvent e)
	/*     */ {
		/* 386 */ Player p = e.getEntity();
		/* 391 */ if ((p.getKiller() instanceof Player))
		/*     */ {
			/* 393 */ Player k = p.getKiller();
			/* 397 */ p.sendMessage(ChatColor.RED + "§4§lMORTE §7VocÃª Morreu Para: " + ChatColor.DARK_RED
					+ ChatColor.ITALIC + k.getName());
			Dinheiro.removeMoney(p, 50);
			/* 398 */ k.sendMessage(
					ChatColor.GREEN + "§4§lKILL §7VocÃª Matou: " + ChatColor.GOLD + ChatColor.ITALIC + p.getName());
			Dinheiro.addMoney(100, k);
			Scoreboard.iscoriboard(k);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @SuppressWarnings("deprecation")
	@EventHandler
	/*     */ public void join(PlayerJoinEvent event)
	/*     */ {
		Player p = event.getPlayer();
		/* 409 */ event.setJoinMessage("§7(§a+§7) §7" + p.getName());
		/* 412 */ event.getPlayer().setHealth(20);
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void quit(PlayerQuitEvent event)
	/*     */ {
		Player p = event.getPlayer();
		/* 420 */ event.setQuitMessage("§7(§c-§7) " + p.getName());
		/*     */ }

	@EventHandler
	public void respawnar(PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player))
			return;
		new BukkitRunnable() {
			@Override
			public void run() {
				e.getEntity().spigot().respawn();
			}
		}.runTask(Main.getPlugin());
	}

	/*     */ @EventHandler
	/*     */ public void hunger(FoodLevelChangeEvent event) {
		/* 425 */ event.setCancelled(true);
		/*     */ }

	@EventHandler
	public void aodropar(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}

	/*     */ @EventHandler(priority = EventPriority.HIGHEST)
	/*     */ public void soup(PlayerInteractEvent event) {
		/* 430 */ Player p = event.getPlayer();
		/* 431 */ if (p.getItemInHand().getType() != Material.MUSHROOM_SOUP) {
			/* 432 */ return;
			/*     */ }
		/* 434 */ Damageable d = p;
		/* 435 */ if (d.getHealth() == d.getMaxHealth()) {
			/* 436 */ return;
			/*     */ }
		/* 438 */ if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
		/*     */ {
			/* 440 */ if (d.getHealth() > d.getMaxHealth() - 7.0D) {
				/* 441 */ d.setHealth(d.getMaxHealth());
				/*     */ } else {
				/* 443 */ d.setHealth(d.getHealth() + 7.0D);
				/*     */ }
			/* 445 */ p.getItemInHand().setAmount(1);
			/* 446 */ p.getItemInHand().setType(Material.BOWL);
			/*     */ }
		/*     */ }

	/*     */
	/* 450 */ @SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<String, Long> timeout = new java.util.HashMap();

	/*     */
	/*     */ @EventHandler
	/*     */ public void chat(AsyncPlayerChatEvent e) {
		/* 454 */ Player p = e.getPlayer();
		/*     */
		/* 456 */ if ((this.timeout.containsKey(p.getName())) &&
		/* 457 */ (((Long) this.timeout.get(p.getName())).longValue() > System.currentTimeMillis()))
		/*     */ {
			/* 459 */ p.sendMessage("§4§lAVISO §cNÃ£o faÃ§a spam!");
			/* 460 */ e.setCancelled(true);
			/* 461 */ return;
			/*     */ }
		/* 463 */ this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void NaoQuebrarNada(BlockBreakEvent e)
	/*     */ {
		/* 469 */ Player p = e.getPlayer();
		/* 470 */ if (p.getGameMode() != GameMode.CREATIVE) {
			/* 471 */ e.setCancelled(true);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void NaoColocarNada(BlockPlaceEvent e)
	/*     */ {
		/* 478 */ Player p = e.getPlayer();
		/* 479 */ if (p.getGameMode() != GameMode.CREATIVE) {
			/* 480 */ e.setCancelled(true);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void rain(WeatherChangeEvent e) {
		/* 486 */ e.setCancelled(true);
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void regen(EntityRegainHealthEvent e) {
		/* 491 */ e.setCancelled(true);
		/*     */ }

	/*     */
	/*     */ @EventHandler(priority = EventPriority.HIGHEST)
	/*     */ public void onHit(EntityDamageByEntityEvent event)
	/*     */ {
		/* 497 */ if (((event.getEntity() instanceof Player)) && ((event.getDamager() instanceof Player)))
		/*     */ {
			/* 499 */ Player p = (Player) event.getDamager();
			/* 500 */ ItemStack[] armor = p.getInventory().getArmorContents();
			/* 501 */ p.getItemInHand().setDurability((short) -p.getItemInHand().getType().getMaxDurability());
			/* 502 */ if (armor.length > 0) {
				/* 503 */ for (int i = 0; i < armor.length; i++) {
					/* 504 */ armor[i].setDurability((short) -armor[i].getType().getMaxDurability());
					/*     */ }
				/*     */ }
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void death(PlayerDeathEvent e)
	/*     */ {
		/* 517 */ e.setDeathMessage(null);
		/*     */ }

	/*     */
	/*     */
	/*     */ @SuppressWarnings("deprecation")
	@EventHandler
	/*     */ public void aoDropar(PlayerDropItemEvent e)
	/*     */ {
		/* 524 */ if (e.getItemDrop().getItemStack().getTypeId() == 267) {
			/* 525 */ e.setCancelled(true);
			/*     */ }
		/* 527 */ if (e.getItemDrop().getItemStack().getTypeId() == 268) {
			/* 528 */ e.setCancelled(true);
			/*     */ }
		/* 530 */ if (e.getItemDrop().getItemStack().getTypeId() == 19) {
			/* 531 */ e.setCancelled(true);
			/*     */ }
		/* 533 */ if (e.getItemDrop().getItemStack().getTypeId() == 352) {
			/* 534 */ e.setCancelled(true);
			/*     */ }
		/* 536 */ if (e.getItemDrop().getItemStack().getTypeId() == 347) {
			/* 537 */ e.setCancelled(true);
			/*     */ }
		/* 539 */ if (e.getItemDrop().getItemStack().getTypeId() == 370) {
			/* 540 */ e.setCancelled(true);
			/*     */ }
		/* 542 */ if (e.getItemDrop().getItemStack().getTypeId() == 272) {
			/* 543 */ e.setCancelled(true);
			/*     */ }
		/* 545 */ if (e.getItemDrop().getItemStack().getTypeId() == 276) {
			/* 546 */ e.setCancelled(true);
			/*     */ }
		/* 548 */ if (e.getItemDrop().getItemStack().getTypeId() == 283) {
			/* 549 */ e.setCancelled(true);
			/*     */ }
		/* 551 */ if (e.getItemDrop().getItemStack().getTypeId() == 261) {
			/* 552 */ e.setCancelled(true);
			/*     */ }
		/* 554 */ if (e.getItemDrop().getItemStack().getTypeId() == 280) {
			/* 555 */ e.setCancelled(true);
			/*     */ }
		/* 557 */ if (e.getItemDrop().getItemStack().getTypeId() == 334) {
			/* 558 */ e.setCancelled(true);
			/*     */ }
		/* 560 */ if (e.getItemDrop().getItemStack().getTypeId() == 401) {
			/* 561 */ e.setCancelled(true);
			/*     */ }
		/* 563 */ if (e.getItemDrop().getItemStack().getTypeId() == 399) {
			/* 564 */ e.setCancelled(true);
			/*     */ }
		/* 566 */ if (e.getItemDrop().getItemStack().getTypeId() == 369) {
			/* 567 */ e.setCancelled(true);
			/*     */ }
		/* 569 */ if (e.getItemDrop().getItemStack().getTypeId() == 54) {
			/* 570 */ e.setCancelled(true);
			/*     */ }
		/* 572 */ if (e.getItemDrop().getItemStack().getTypeId() == 288) {
			/* 573 */ e.setCancelled(true);
			/*     */ }
		/* 575 */ if (e.getItemDrop().getItemStack().getTypeId() == 332) {
			/* 576 */ e.setCancelled(true);
			/*     */ }
		/* 578 */ if (e.getItemDrop().getItemStack().getTypeId() == 346) {
			/* 579 */ e.setCancelled(true);
			/*     */ }
		/* 581 */ if (e.getItemDrop().getItemStack().getTypeId() == 76) {
			/* 582 */ e.setCancelled(true);
			/*     */ }
		/* 584 */ if (e.getItemDrop().getItemStack().getTypeId() == 275) {
			/* 585 */ e.setCancelled(true);
			/*     */ }
		/* 587 */ if (e.getItemDrop().getItemStack().getTypeId() == 90) {
			/* 588 */ e.setCancelled(true);
			/*     */ }
		/* 590 */ if (e.getItemDrop().getItemStack().getTypeId() == 420) {
			/* 591 */ e.setCancelled(true);
			/*     */ }
		/* 593 */ if (e.getItemDrop().getItemStack().getTypeId() == 160) {
			/* 594 */ e.setCancelled(true);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void msgMOTD(ServerListPingEvent ev)
	/*     */ {
		/* 625 */ ev
				.setMotd("      §6§lExtreme§F§lPvP §bž¼ §aServidor de KitPvP\n           §eRemovemos Todo o §6§lLAG");
		/*     */ }
	/*     */
}