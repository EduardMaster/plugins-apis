package br.com.alpha.APIs;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.google.common.collect.Maps;

@SuppressWarnings({  })
public class BarAPI implements Listener {

	private static int enderdragonId;
	private static Plugin plugin = org.bukkit.Bukkit.getPluginManager().getPlugins()[0];
	private static HashMap<String, BukkitRunnable> toHide = Maps.newHashMap();

	static {
		try {
			Field field = Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getName().split("\\.")[3] + ".Entity").getDeclaredField("entityCount");
			field.setAccessible(true);
			enderdragonId = field.getInt(null);
			field.set(null, Integer.valueOf(enderdragonId + 1));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void removeBar(Player player) {
		removeBar(player, 2);
	}

	public static void removeBar(Player player, int afterTicks) {
		if ((player.hasMetadata("SeesEnderdragon")) && (!toHide.containsKey(player.getName()))) {
			BukkitRunnable runnable = new BukkitRunnable() {
				public void run() {
				}
			};
			runnable.runTaskLater(plugin, afterTicks);
			toHide.put(player.getName(), runnable);
		}
	}

	private static void sendSpawnPacket(Player player, String message, float health) throws Exception {
		PacketContainer spawnPacket = new PacketContainer(PacketType.Play.Server.SPAWN_ENTITY_LIVING);
		StructureModifier<Object> spawnPacketModifier = spawnPacket.getModifier();
		Location toSpawn = player.getEyeLocation().add(player.getEyeLocation().getDirection().normalize().multiply(23));
		spawnPacketModifier.write(0, Integer.valueOf(enderdragonId));
		spawnPacketModifier.write(1, Byte.valueOf((byte) 64));
		spawnPacketModifier.write(2, Integer.valueOf(toSpawn.getBlockX() * 32));
		spawnPacketModifier.write(3, Integer.valueOf(toSpawn.getBlockY() * 32));
		spawnPacketModifier.write(4, Integer.valueOf(toSpawn.getBlockZ() * 32));
		WrappedDataWatcher watcher = new WrappedDataWatcher();
		watcher.setObject(0, Byte.valueOf((byte) 32));
		watcher.setObject(2, message);
		watcher.setObject(6, Float.valueOf(health));
		watcher.setObject(10, message);
		watcher.setObject(20, Integer.valueOf(881));
		spawnPacket.getDataWatcherModifier().write(0, watcher);
		ProtocolLibrary.getProtocolManager().sendServerPacket(player, spawnPacket, false);
	}

	public static void setName(Player player, String message, float health) {
		try {
			if (!player.hasMetadata("SeesEnderdragon")) {
				player.setMetadata("SeesEnderdragon", new FixedMetadataValue(plugin, Boolean.valueOf(true)));
			}
			if (toHide.containsKey(player.getName())) {
				((BukkitRunnable) toHide.remove(player.getName())).cancel();
			}
			sendSpawnPacket(player, message, health);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

