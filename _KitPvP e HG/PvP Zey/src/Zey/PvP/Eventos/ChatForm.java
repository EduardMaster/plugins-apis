package Zey.PvP.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Zey.PvP.Score.SPlayer;

public class ChatForm implements Listener 
{
    @EventHandler
    public void modificarchat(AsyncPlayerChatEvent evento)
    {
    	Player jogador = evento.getPlayer();
    	
    	if (jogador.hasPermission("zey.pvp.falarcolorido"))
    	{
    		evento.setFormat(SPlayer.Rank(jogador) + " " +jogador.getDisplayName() + " §7»§f " + evento.getMessage().replace("&", "§").replace("%", " Porcento(s)".replace("<3", "§4❤")));
    	} else {
    		evento.setFormat(SPlayer.Rank(jogador) + " " +jogador.getDisplayName() + " §7» " + evento.getMessage().replace("%", " Porcento(s)"));
    	}
    	if (jogador.hasPermission("zey.pvp.falarcoloridostaff"))
    	{
    		evento.setFormat(SPlayer.Rank(jogador) + " " +jogador.getDisplayName() + " §6»§f " + evento.getMessage().replace("&", "§").replace("%", "Porcento(s)").replace("<3", "§4❤"));
    	}
    }
}
