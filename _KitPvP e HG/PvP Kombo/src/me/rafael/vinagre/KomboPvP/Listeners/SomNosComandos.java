package me.rafael.vinagre.KomboPvP.Listeners;


import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

@SuppressWarnings("unused")
public class SomNosComandos
  implements Listener {




@EventHandler
  public void digitarComando(PlayerCommandPreprocessEvent e)
  {
    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BURP, 5.0F, 5.0F);
  }
}
