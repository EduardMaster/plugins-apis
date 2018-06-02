package me.recenthg.Manager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.spigotmc.ProtocolInjector;

import net.minecraft.server.v1_7_R4.ChatSerializer;

public class Title implements Listener {

 private static int VERSION = 47; 

 public static void sendTitle(Player p, String title) {
  if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
   return;
  }
  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}")
    .a(title)));
 }

 public static void sendSubTitle(Player p, String subtitle) {
  if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
   return;
  }
  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a(
    "{\"text\": \"\"}").a(subtitle)));
 }

 public static void sendTimings(Player p, int fadeIn, int stay, int fadeOut) {
  if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
   return;
  }
  try {
   Object handle = getHandle(p);
   Object connection = getField(handle.getClass(), "playerConnection").get(handle);
   Object packet = ProtocolInjector.PacketTitle.class.getConstructor(new Class[] { ProtocolInjector.PacketTitle.Action.class, Integer.TYPE, Integer.TYPE, Integer.TYPE })
     .newInstance(new Object[] { ProtocolInjector.PacketTitle.Action.TIMES, Integer.valueOf(fadeIn), Integer.valueOf(stay), Integer.valueOf(fadeOut) });
   getMethod(connection.getClass(), "sendPacket", new Class[0]).invoke(connection, new Object[] { packet });
  } catch (Exception e) {
   e.printStackTrace();
  }
 }

 private static boolean ClassListEqual(Class<?>[] l1, Class<?>[] l2) {
  boolean equal = true;
  if (l1.length != l2.length) {
   return false;
  }
  for (int i = 0; i < l1.length; i++) {
   if (l1[i] != l2[i]) {
    equal = false;
    break;
   }
  }
  return equal;
 }

 private static Field getField(Class<?> clazz, String name) {
  try {
   Field field = clazz.getDeclaredField(name);
   field.setAccessible(true);
   return field;
  } catch (Exception e) {
   e.printStackTrace();
  }
  return null;
 }

 private static Method getMethod(Class<?> clazz, String name, Class<?>... args) {
  for (Method m : clazz.getMethods()) {
   if ((m.getName().equals(name)) && ((args.length == 0) || (ClassListEqual(args, m.getParameterTypes())))) {
    m.setAccessible(true);
    return m;
   }
  }
  return null;
 }

 private static Object getHandle(Object obj) {
  try {
   return getMethod(obj.getClass(), "getHandle", new Class[0]).invoke(obj, new Object[0]);
  } catch (Exception e) {
   e.printStackTrace();
  }
  return null;
 }

 public static void reset(Player p) {
  if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
   return;
  }
  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.RESET));
 }

 public static void clear(Player p) {
  if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
   return;
  }
  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
 }
}