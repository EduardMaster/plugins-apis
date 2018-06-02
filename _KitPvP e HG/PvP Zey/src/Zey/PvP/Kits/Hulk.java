package Zey.PvP.Kits;

import org.bukkit.event.player.*;
import org.bukkit.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Hulk implements Listener
{
    @EventHandler
    public void PickUpPlayer(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        if (e.getRightClicked() instanceof Player) {
            final Player p = e.getPlayer();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Hulk")) {
                final Player r = (Player)e.getRightClicked();
                if (Cooldown.add(p)) {
                    KitUtil.MensagemCooldown(p);
                    return;
                }
                if (p.getItemInHand().getType() != Material.SADDLE) {
                    return;
                }
                if (p.getPassenger() != null) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cAguarde o outro jogador(a) sair da sua cabeça.");
                    return;
                }
                if (r.getPassenger() != null) {
                    return;
                }
                Cooldown.add(p, 6);
                p.setPassenger((Entity)r);
                r.sendMessage(String.valueOf(Main.prefix) + " §7» Um Hulk lhe predeu Aperde §a§lSHIFT§7 para se soltar.");
            }
        }
    }
}
