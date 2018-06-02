package Pedrao.Eventos;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import Pedrao.KitAPI;
import Pedrao.Main;
import Pedrao.Comandos.Kits;
import Pedrao.Comandos.Loja;
import Pedrao.Comandos.StatusM;
import Pedrao.Warps.Warp;

public class Players implements Listener {
	public Main plugin;

	public Players(Main main) {
		this.plugin = main;
	}
	  @EventHandler
	  public void respawnar(final PlayerDeathEvent e) {
	  if(!(e.getEntity() instanceof Player))return;
	  new  BukkitRunnable() {
		@Override
		public void run() {
			e.getEntity().spigot().respawn();
		  }
	  }.runTask(Main.getPlugin());
	 }
	  @EventHandler
	  void aoEntrar(PlayerJoinEvent evento)
	  {
	    final Player jogador = evento.getPlayer();
	    
	    Main.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable()
	    {
	      public void run()
	      {
	        Pedrao.ScoreB.ScoreDoBasic.setScoreBoard(jogador);
	      }
	    }, 0L, 20L);
	  }
	@EventHandler
	public void Entrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.teleport(p.getWorld().getSpawnLocation());
		p.playSound(p.getLocation(), Sound.ANVIL_USE, 10.0F, 0);
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		KitAPI.remove(p);
		Habilidade.removeAbility(p);
		p.getInventory().clear();
		p.sendMessage("§b§lBem-Vindo ao §7{§e§lSoul§f§lPvP§7}");
		Firework f = (Firework) p.getPlayer().getWorld().spawn(p.getPlayer().getLocation(), Firework.class);
		FireworkMeta fm = f.getFireworkMeta();
		fm.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(FireworkEffect.Type.BALL)
				.withColor(Color.RED).withFade(Color.GREEN).build());
		fm.setPower(2);
		f.setFireworkMeta(fm);
		KitAPI.setitem(p, Material.CHEST, "§4§lKits §7(CLICK)", 0, Enchantment.DAMAGE_ALL, 0, false);
		KitAPI.setitem(p, Material.STORAGE_MINECART, "§4§lKitDiario §7(CLICK)", 1, Enchantment.DAMAGE_ALL, 0, false);
		KitAPI.setitem(p, Material.EMERALD, "§4§lLoja §7(CLICK)", 7, Enchantment.DAMAGE_ALL, 0, false);
		KitAPI.setitem(p, Material.COMPASS, "§4§lWarps §7(CLICK)", 8, Enchantment.DAMAGE_ALL, 0, false);
		KitAPI.setitem(p, Material.SKULL_ITEM, "§4§lStatus §7(CLICK)", 4, Enchantment.DAMAGE_ALL, 0, false);
	}

	@EventHandler
	public void Morte(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		KitAPI.remove(p);
		Habilidade.removeAbility(p);
		KitAPI.setitem(p, Material.CHEST, "§4§lKits §7(CLICK)", 0, Enchantment.DAMAGE_ALL, 0, false);
		KitAPI.setitem(p, Material.STORAGE_MINECART, "§4§lKitDiario §7(CLICK)", 1, Enchantment.DAMAGE_ALL, 0, false);
		KitAPI.setitem(p, Material.EMERALD, "§4§lLoja §7(CLICK)", 7, Enchantment.DAMAGE_ALL, 0, false);
		KitAPI.setitem(p, Material.COMPASS, "§4§lWarps §7(CLICK)", 8, Enchantment.DAMAGE_ALL, 0, false);
		KitAPI.setitem(p, Material.SKULL_ITEM, "§4§lStatus §7(CLICK)", 4, Enchantment.DAMAGE_ALL, 0, false);

	}

	@EventHandler
	public void onClickItem4(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (e.getPlayer().getItemInHand().getType() == Material.CHEST)) {
			e.setCancelled(true);
			Kits.guiKits1(p);
		}
	}

	@EventHandler
	public void onClickItem4s(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (e.getPlayer().getItemInHand().getType() == Material.COMPASS)) {
			e.setCancelled(true);
			Warp.guiKits(p);
		}
	}
	
	@EventHandler
	public void onClickItem4SSs(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (e.getPlayer().getItemInHand().getType() == Material.SKULL_ITEM)) {
			e.setCancelled(true);
			StatusM.guiKits1(p);
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.setDeathMessage(null);
		Player p = e.getEntity();
		if ((p.getKiller() instanceof Player)) {
			Player k = p.getKiller();
			Location l = k.getLocation();
			Location lp = p.getLocation();
			p.sendMessage(Main.prefix + "Você foi morto por: " + ChatColor.RED + ChatColor.ITALIC + k.getName());
			k.sendMessage(Main.prefix + "Você matou: " + ChatColor.GREEN + ChatColor.ITALIC + p.getName());
			k.playSound(l, Sound.FIREWORK_LAUNCH, 10.0F, 1.0F);
			p.playSound(lp, Sound.CREEPER_DEATH, 10.0F, 1.0F);
		}
	}

	@EventHandler
	public void onClickItem4ss(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (e.getPlayer().getItemInHand().getType() == Material.EMERALD)) {
			e.setCancelled(true);
			Loja.GuiLojaKit(p);
		}
	}
}