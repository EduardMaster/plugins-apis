/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.server.ServerListPingEvent;
/*    */ 
/*    */ public class Motd implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Outros(ServerListPingEvent e)
/*    */   {
/* 15 */     e.setMotd(Main.getInstance().getConfig().getString("Motd").replace("&", "§").replace("{pular}", "\n"));
/* 16 */     e.setMaxPlayers(Bukkit.getOnlinePlayers().length + 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\Motd.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */