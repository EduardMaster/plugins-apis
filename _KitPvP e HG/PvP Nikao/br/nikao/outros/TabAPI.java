/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import java.sql.SQLException;
/*    */ import net.minecraft.server.v1_7_R4.ChatSerializer;
/*    */ import net.minecraft.server.v1_7_R4.EntityPlayer;
/*    */ import net.minecraft.server.v1_7_R4.IChatBaseComponent;
/*    */ import net.minecraft.server.v1_7_R4.NetworkManager;
/*    */ import net.minecraft.server.v1_7_R4.PlayerConnection;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ import org.spigotmc.ProtocolInjector.PacketTabHeader;
/*    */ 
/*    */ public class TabAPI
/*    */ {
/*    */   public static void AttTaba(Player p)
/*    */     throws SQLException
/*    */   {
/* 21 */     if (isPlayerRightVersion(p)) {
/* 22 */       CraftPlayer cp = (CraftPlayer)p;
/* 23 */       EntityPlayer ep = cp.getHandle();
/* 24 */       PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;
/* 25 */       IChatBaseComponent header = ChatSerializer.a("{'text': '\n§f§l§c§lSTOMPA§8§l-§e§lKITS§7 \nServidor de KitPvP\n'}");
/* 26 */       IChatBaseComponent footer = ChatSerializer.a("{'text': ' \n§7Players: §e" + Bukkit.getOnlinePlayers().length + "§7/§e" + Bukkit.getMaxPlayers() + " §8| §7Ping: §e" + ep.ping + " §8| §7Seu Kit: §e" + KitAPI.getkit(p) + "\n§bSkype: §3stompa.kits'}");
/* 27 */       connection.sendPacket(new ProtocolInjector.PacketTabHeader(header, footer));
/*    */     }
/*    */   }
/*    */   
/*    */   public static void AddTab(Player p)
/*    */   {
/* 33 */     Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
/*    */         try {
/* 38 */           TabAPI.AttTaba(TabAPI.this);
/*    */         } catch (SQLException e) {
/* 40 */           e.printStackTrace();
/*    */         }
/*    */         
/*    */       }
/* 44 */     }, 2L, 2L);
/*    */   }
/*    */   
/*    */   public static boolean isPlayerRightVersion(Player player)
/*    */   {
/* 49 */     return ((CraftPlayer)player).getHandle().playerConnection.networkManager.getVersion() >= 47;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\TabAPI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */