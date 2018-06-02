package Zey.PvP.APIs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

public class TheTitle implements Listener {
 
 
   private static int VERSION = 47;
 
   @EventHandler
   public void onPlayerColor(SignChangeEvent e) {
     if (e.getLine(0).contains("&")) {
       e.setLine(0, e.getLine(0).replace("&", "§"));
     }
     if (e.getLine(1).contains("&")) {
       e.setLine(1, e.getLine(1).replace("&", "§"));
     }
     if (e.getLine(2).contains("&")) {
       e.setLine(2, e.getLine(2).replace("&", "§"));
     }
     if (e.getLine(3).contains("&"))
       e.setLine(3, e.getLine(3).replace("&", "§")); 
   }
    public boolean onPlayerConnect(PlayerJoinEvent e)
    {
      Player p = e.getPlayer();
      
      sendTitle(p, "");
      sendSubTitle(p, "");
      
      return false;
    }
    
    public static void sendTitle(Player p, String title)
    {
      if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
        return;
      }
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(title)));
    }
    
    public static void sendSubTitle(Player p, String subtitle)
    {
      if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
        return;
      }
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a("{\"text\": \"\"}").a(subtitle)));
    }
    
    public static void sendTimings(Player p, int fadeIn, int stay, int fadeOut)
    {
      if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
        return;
      }
      try
      {
        Object handle = getHandle(p);
        Object connection = getField(handle.getClass(), "playerConnection").get(handle);
        Object packet = ProtocolInjector.PacketTitle.class.getConstructor(new Class[] { ProtocolInjector.PacketTitle.Action.class, Integer.TYPE, Integer.TYPE, Integer.TYPE }).newInstance(new Object[] { ProtocolInjector.PacketTitle.Action.TIMES, Integer.valueOf(fadeIn), Integer.valueOf(stay), Integer.valueOf(fadeOut) });
        getMethod(connection.getClass(), "sendPacket", new Class[0]).invoke(connection, new Object[] { packet });
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    
    private static boolean ClassListEqual(Class<?>[] l1, Class<?>[] l2)
    {
      boolean equal = true;
      if (l1.length != l2.length) {
        return false;
      }
      for (int i = 0; i < l1.length; i++) {
        if (l1[i] != l2[i])
        {
          equal = false;
          break;
        }
      }
      return equal;
    }
    
    private static Field getField(Class<?> clazz, String name)
    {
      try
      {
        Field field = clazz.getDeclaredField(name);
        field.setAccessible(true);
        return field;
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
      return null;
    }
    
    private static Method getMethod(Class<?> clazz, String name, Class<?>[] args)
    {
      Method[] arrayOfMethod;
      int j = (arrayOfMethod = clazz.getMethods()).length;
      for (int i = 0; i < j; i++)
      {
        Method m = arrayOfMethod[i];
        if ((m.getName().equals(name)) && ((args.length == 0) || (ClassListEqual(args, m.getParameterTypes()))))
        {
          m.setAccessible(true);
          return m;
        }
      }
      return null;
    }
    
    private static Object getHandle(Object obj)
    {
      try
      {
        return getMethod(obj.getClass(), "getHandle", new Class[0]).invoke(obj, new Object[0]);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
      return null;
    }
    
    public static void reset(Player p)
    {
      if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
        return;
      }
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.RESET));
    }
    
    public static void clear(Player p)
    {
      if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
        return;
      }
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
    }
    
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
    {
      return false;
    }
    public static void sendActionBar(Player player, String message) {
      CraftPlayer p = (CraftPlayer) player;
      if (p.getHandle().playerConnection.networkManager.getVersion() != 47) {
       return;
      }
      IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
      PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc);
      ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
     }
}