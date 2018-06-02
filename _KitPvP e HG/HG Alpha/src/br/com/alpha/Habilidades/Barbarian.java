package br.com.alpha.Habilidades;


import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.LoadKits;
import br.com.alpha.ENUMs.KitsEnum;

public class Barbarian implements Listener {

	@EventHandler
	/*      */ public void barbarianHabilidade(PlayerDeathEvent evento)
	/*      */ {
		/* 738 */ Player jogador = evento.getEntity().getKiller();
		/*      */
		/* 740 */ if (KitsEnum.getKit(jogador) == KitsEnum.BARBARIAN)
		/*      */ {
			/* 742 */ if (jogador.getStatistic(Statistic.PLAYER_KILLS) == 3)
			/*      */ {
				/* 744 */ jogador.getInventory().remove(Material.WOOD_SWORD);
				jogador.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
				/* 746 */ jogador.sendMessage("§cVocê upou para a espada de pedra.");
				/* 747 */ jogador.playSound(jogador.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
				/*      */ }
			/* 749 */ if (jogador.getStatistic(Statistic.PLAYER_KILLS) == 6)
			/*      */ {
				/* 744 */ jogador.getInventory().remove(Material.STONE_SWORD);
				jogador.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
				/* 746 */ jogador.sendMessage("§cVocê upou para a espada de iron.");
				/* 747 */ jogador.playSound(jogador.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
				/*      */ }
			/* 756 */ if (jogador.getStatistic(Statistic.PLAYER_KILLS)==9)
			/*      */ {
				/* 758 */ jogador.getInventory().remove(Material.IRON_SWORD);
				/* 759 */ 				jogador.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
				/* 746 */ jogador.sendMessage("§cVocê upou para a espada de iron.");
				/* 747 */ jogador.playSound(jogador.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
				/*      */ }
			/* 763 */ if (jogador.getStatistic(Statistic.PLAYER_KILLS)== 12)
			/*      */ {
				/* 765 */ jogador.getInventory().remove(Material.DIAMOND_SWORD);
						
						LoadKits.criarItem(jogador, Material.DIAMOND_SWORD, "Espada de diamante.", 0, (short)0, 1, Enchantment.DAMAGE_ALL, 2);
				/* 767 */ jogador
						.sendMessage("§cVocê upou para espada de diamante com sharp l");
				/* 768 */ jogador.playSound(jogador.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
				/*      */ }
			/* 770 */ if (jogador.getStatistic(Statistic.PLAYER_KILLS)> 12)
			/*      */ {
				/* 772 */ jogador.sendMessage(MCAlpha.Logo + " Você já está no ultimo level.");
				/* 773 */ jogador.playSound(jogador.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
				/*      */ }
			/*      */ }
		/*      */ }

}
