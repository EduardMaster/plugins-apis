package br.com.alpha.Habilidades;

import java.util.ArrayList;
import java.util.List;


import org.bukkit.Location;
import org.bukkit.Material;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import br.com.alpha.MCAlpha;

import br.com.alpha.ENUMs.KitsEnum;

public class Endermage implements Listener {

	public static  ArrayList<String> cooldown = new ArrayList<>();
	
	@EventHandler
	public void endermageHabilidade(PlayerInteractEvent evento) {
		Player jogador = evento.getPlayer();

		if (KitsEnum.getKit(jogador) == KitsEnum.ENDERMAGE) {
			if ((jogador.getItemInHand().getType() == Material.PORTAL)
					|| (jogador.getItemInHand().getType() == Material.NETHER_BRICK_ITEM)) {
				if (evento.getAction() == Action.RIGHT_CLICK_BLOCK) {
					evento.setCancelled(true);

					if (!cooldown.contains(jogador)) {
						if (evento.getClickedBlock().getLocation().add(0.0D, 2.0D, 0.0D).getBlock().isEmpty()) {
							List<Entity> jogadoresAoRedor = jogador.getNearbyEntities(2.0D, 300.0D, 2.0D);

							for (Entity entidades : jogadoresAoRedor) {
								if ((entidades instanceof Player)) {
									cooldown.add(jogador.getName());
									Player jogadores = (Player) entidades;

									Block Bloco = evento.getClickedBlock().getRelative(BlockFace.UP);
									Location Local = Bloco.getLocation();

									entidades.teleport(Local);
									jogador.teleport(Local);

									jogadores.addPotionEffect(
											new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 10));
									jogador.addPotionEffect(
											new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 10));

									jogadores.sendMessage("§cVocê foi puxado por "
											+ jogador.getName());
									jogadores.sendMessage(
											"§cVocê está invencivel por 5 segundos.");

									jogador.sendMessage("§cVocê puxou alguém!");
									jogador.sendMessage(
											"§cVocê está invencivel por 5 segundos.");
								}
							}
						} else {
							jogador.sendMessage(MCAlpha.Logo + "Você não pode puxar aqui!");
						}
					} else
						mensagemCooldown(jogador);
				}
			}
		}
	}

	public static void mensagemCooldown(Player p) {
		p.sendMessage("§cVocê está com cooldown!");
	}

}
