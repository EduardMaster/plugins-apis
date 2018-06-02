package Zey.PvP.Kits;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;

import java.util.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;

public class Monk implements Listener
{
    @EventHandler
    public void aoMonk(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player jogadorClicado = (Player)e.getRightClicked();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Monk") && p.getItemInHand().getType() == Material.BLAZE_ROD) {
                if (Cooldown.add(p)) {
                    KitUtil.MensagemCooldown(p);
                    return;
                }
                final int random = new Random().nextInt(jogadorClicado.getInventory().getSize() - 10 + 1 + 10);
                final ItemStack ItemSelecionado = jogadorClicado.getInventory().getItem(random);
                final ItemStack ItemMudado = jogadorClicado.getItemInHand();
                jogadorClicado.setItemInHand(ItemSelecionado);
                jogadorClicado.getInventory().setItem(random, ItemMudado);
                jogadorClicado.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você foi §c§lMONKADO§7.");
                p.sendMessage(String.valueOf(String.valueOf(Main.prefix) + " §7» §7Você §c§lMONKOU§7 o jogador(a): §e" + jogadorClicado.getName()));
                Cooldown.add(p, 20);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        KitUtil.ccooldown(p);
                    }
                }, 400L);
            }
        }
    }
}
