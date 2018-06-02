package me.recenthg.Kits;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Gaara implements Listener {
	
	public static ArrayList<String> cooldown = new ArrayList<String>();
	
	@EventHandler
	public void BlockA(EntityChangeBlockEvent e) {
		if (blocos.contains(e.getEntity().getUniqueId())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void Clicar(final PlayerInteractEvent e) {
		if (Habilidade.getAbility(e.getPlayer()).equals("Gaara") && e.getPlayer().getInventory().getItemInHand().getType().equals(Material.SANDSTONE)) {
			e.setCancelled(true);
		}
	}
	
	private List<UUID> blocos = new ArrayList<>();
	
	@EventHandler
	public void Clicar(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equals("Gaara") && p.getInventory().getItemInHand().getType().equals(Material.SANDSTONE)) {
			if (Main.estados == Estado.ANDAMENTO) {
				if (e.getRightClicked() instanceof Player) {
					if (!cooldown.contains(p.getName())) {
						cooldown.add(p.getName());
						final Player t = (Player)e.getRightClicked();
						p.sendMessage("§aVoce usou seu kit no " + t.getDisplayName());
						new BukkitRunnable() {
							
							Location[] oldLoc = null;
							Location[] Loc = new Location[6];
							int contador = ~-0;
							
							@SuppressWarnings("deprecation")
							@Override
							public void run() {
								if (p.getName() != null && e.getRightClicked() != null && p.isOnline() && ((Player)e.getRightClicked()).isOnline()) {
									if (++contador != 3) {
										if (oldLoc != null) {
											for (Location old : oldLoc)
												old.getBlock().setType(Material.AIR);
												int x = p.getLocation().getBlockX(), y = t.getLocation().getBlockY(), z = t.getLocation().getBlockZ();
												Location loc = new Location(t.getWorld(), x + 0.5, y + 4 + contador, z + 0.5);
												t.teleport(loc);
												
												Loc[0] = t.getLocation().add(0, -1, 0);
												Loc[1] = t.getLocation().add(1, 0, 0);
												Loc[2] = t.getLocation().add(-1, 0, 0);
												Loc[3] = t.getLocation().add(0, 0, 1);
												Loc[4] = t.getLocation().add(0, 0, -1);
												Loc[5] = t.getLocation().add(0, 2, 0);
												for (Location locais : Loc)
													locais.getBlock().setType(Material.SANDSTONE);
												oldLoc = Loc;
										} else {
											Loc[5].add(0, -1, 0);
											for (Location old : oldLoc)
												old.getBlock().setType(Material.AIR);
											for (Location Locais : Loc) {
												FallingBlock bloco = Locais.getBlock().getWorld().spawnFallingBlock(Locais, Material.SAND, (byte) 0x0);
												blocos.add(bloco.getUniqueId());
											}
											e.getRightClicked().setFallDistance(-10);
											e.getRightClicked().getWorld().createExplosion(Loc[5], 1.0F, true);
											cancel();
										}
									} else {
										for (Location loc : Loc)
											loc.getBlock().setType(Material.AIR);
										if (oldLoc != null) {
											for (Location old : oldLoc)
												old.getBlock().setType(Material.AIR);
										}
										cancel();
									}
								}
								
							}
						}.runTaskTimer(Main.instance, 0, 7L);
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
							
							@Override
							public void run() {
								if (cooldown.contains(p.getName())) {
									cooldown.remove(p.getName());
									p.sendMessage("§aSeu kit esta pronto");
								}
								
							}
						}, 20*20);
					} else {
						p.sendMessage("§6» §7Kit em cooldown !");
					}
				}
			}
		}
	}

}
