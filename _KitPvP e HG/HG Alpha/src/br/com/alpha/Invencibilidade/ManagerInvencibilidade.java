package br.com.alpha.Invencibilidade;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.APIs.InventoryAPI;
import br.com.alpha.APIs.LoadKits;
import br.com.alpha.InGame.InGameEventAPI;
import br.com.alpha.InGame.Schematic.Schematic;
import br.com.alpha.ScoreBoard.Scores;
import net.minecraft.server.v1_7_R4.MinecraftServer;

public class ManagerInvencibilidade implements Listener {

	public static BukkitTask InvencibilidadeTask;

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onStart(InvencibilidadeEventAPI e) {
		MCAlpha.Time = 151;
		for (Player all : Bukkit.getOnlinePlayers()) {
			Scores.scoreInvencibility(all);

		}

		loadInvConfg();
		for (Player alls : Bukkit.getOnlinePlayers()) {
			LoadKits.loadKits(alls);
			alls.setAllowFlight(false);
			alls.getInventory().setItem(0, new ItemStack(Material.COMPASS));
		}

		InvencibilidadeTask = new BukkitRunnable() {

			public void run() {
				Messages(MCAlpha.Time);
				MCAlpha.Time--;
			}
		}.runTaskTimer(MCAlpha.mcAlpha, 0, 20L);
	}

	private static void endInvencibilidadeTask() {
		InvencibilidadeTask.cancel();
	}

	private static void Messages(Integer tempo) {
		String baseString = "§cA invencibilidade acabará em ";
		switch (tempo) {
		case 60:
			BukkitBroadcastMessage(baseString + "§41:00 minuto.");
			break;
		case 30:
			BukkitBroadcastMessage(baseString + "§430 segundos.");
			break;
		case 15:
			BukkitBroadcastMessage(baseString + "§415 segundos.");
			break;
		case 10:
			BukkitBroadcastMessage(baseString + "§410 segundos.");

			allowFlyNMS();
			removeBlockFromColiseu();

			break;
		case 5:
			BukkitBroadcastMessage(baseString + "§45 segundos.");
			break;
		case 4:
			BukkitBroadcastMessage(baseString + "§44 segundos.");
			break;
		case 3:
			BukkitBroadcastMessage(baseString + "§43 segundos.");
			break;
		case 2:
			BukkitBroadcastMessage(baseString + "§42 segundos.");
			break;
		case 1:
			BukkitBroadcastMessage(baseString + "§41 segundo.");
			break;
		case 0:
			BukkitBroadcastMessage("§cA invencibilidade acabou!");
			BukkitBroadcastMessage(" ");
			BukkitBroadcastMessage("§aBom jogo! E que a §lSORTE §aesteja com você");
			APIClass.sendSoundToAllPlayers(Sound.ENDERDRAGON_GROWL, 1F, 1F);
			APIClass.changeStatusServer();
			endInvencibilidadeTask();
			MCAlpha.Time = 0;
			Bukkit.getPluginManager().callEvent(new InGameEventAPI(APIClass.JogadoresInGame));
			break;

		}
	}

	private static void BukkitBroadcastMessage(String msg) {
		Bukkit.broadcastMessage(msg);
	}

	@SuppressWarnings("deprecation")
	private static void loadInvConfg() {
		for (Player s : Bukkit.getOnlinePlayers()) {
			s.closeInventory();
			InventoryAPI.clearInventory(s);

			s.setFoodLevel(20);
			s.setHealth(20.0D);
		}
	}

	public static void removePistonsColiseu() {
		for (Block block : MCAlpha.coliseumBlocks) {
			if (block.getType().name().contains("PISTON"))
				Schematic.setBlock(block.getWorld(), block.getX(), block.getY(), block.getZ(), 0, (byte) 0);
		}
		Bukkit.broadcastMessage(MCAlpha.Logo + " §aO Coliseu foi aberto!");
	}

	public static void removeBlockFromColiseu() {
		for (Block block : MCAlpha.coliseumBlocks) {
			Schematic.setBlock(block.getWorld(), block.getX(), block.getY(), block.getZ(), 0, (byte) 0);
		}
		Bukkit.broadcastMessage(MCAlpha.Logo + " §cO coliseu foi removido!");
	}

	public static void allowFlyNMS() {
		MinecraftServer.getServer().setAllowFlight(true);
		new BukkitRunnable() {

			@Override
			public void run() {
				MinecraftServer.getServer().setAllowFlight(false);
			}
		}.runTaskLater(MCAlpha.mcAlpha, 20 * 10);
	}
}
