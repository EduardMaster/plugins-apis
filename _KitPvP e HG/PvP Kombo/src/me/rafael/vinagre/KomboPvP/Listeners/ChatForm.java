package me.rafael.vinagre.KomboPvP.Listeners;




import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatForm implements Listener 
{
    @EventHandler
    public void modificarchat(AsyncPlayerChatEvent evento)
    {
    	Player jogador = evento.getPlayer();
    	
    	if (jogador.hasPermission("chat.colorido"))
    	{
        	evento.setFormat(jogador.getDisplayName() + " §e: §f" + evento.getMessage().replace("&", "§"));
    	} else {
    		evento.setFormat(jogador.getDisplayName() + " §e: §f" + evento.getMessage());
    	}
    
 }
    
}
