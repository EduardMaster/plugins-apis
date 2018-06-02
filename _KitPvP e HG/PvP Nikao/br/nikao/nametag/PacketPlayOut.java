/*     */ package br.nikao.nametag;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class PacketPlayOut
/*     */ {
/*     */   Object packet;
/*     */   private static Method getHandle;
/*     */   private static Method sendPacket;
/*     */   private static Field playerConnection;
/*  16 */   private static String version = "";
/*     */   private static Class<?> packetType;
/*     */   
/*     */   static {
/*     */     try {
/*  21 */       version = org.bukkit.Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
/*     */       
/*  23 */       packetType = Class.forName(getPacketTeamClasspath());
/*     */       
/*  25 */       Class<?> typeCraftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
/*     */       
/*  27 */       Class<?> typeNMSPlayer = Class.forName("net.minecraft.server." + version + ".EntityPlayer");
/*     */       
/*  29 */       Class<?> typePlayerConnection = Class.forName("net.minecraft.server." + version + ".PlayerConnection");
/*     */       
/*     */ 
/*     */ 
/*  33 */       getHandle = typeCraftPlayer.getMethod("getHandle", new Class[0]);
/*  34 */       playerConnection = typeNMSPlayer.getField("playerConnection");
/*  35 */       sendPacket = typePlayerConnection.getMethod("sendPacket", new Class[] { Class.forName("net.minecraft.server." + version + ".Packet") });
/*     */     } catch (Exception e) {
/*  37 */       System.out.println("Failed to setup reflection for Packet209Mod!");
/*  38 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   PacketPlayOut(String name, String prefix, String suffix, Collection players, int paramInt)
/*     */     throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException
/*     */   {
/*  46 */     this.packet = packetType.newInstance();
/*  47 */     setField("a", name);
/*  48 */     setField("f", Integer.valueOf(paramInt));
/*     */     
/*  50 */     if ((paramInt == 0) || (paramInt == 2)) {
/*  51 */       setField("b", name);
/*  52 */       setField("c", prefix);
/*  53 */       setField("d", suffix);
/*  54 */       setField("g", Integer.valueOf(1));
/*     */     }
/*  56 */     if (paramInt == 0) {
/*  57 */       addAll(players);
/*     */     }
/*     */   }
/*     */   
/*     */   PacketPlayOut(String name, Collection players, int paramInt)
/*     */     throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException
/*     */   {
/*  64 */     this.packet = packetType.newInstance();
/*     */     
/*  66 */     if ((paramInt != 3) && (paramInt != 4)) {
/*  67 */       throw new IllegalArgumentException("Method must be join or leave for player constructor");
/*     */     }
/*     */     
/*  70 */     if ((players == null) || (players.isEmpty())) {
/*  71 */       players = new ArrayList();
/*     */     }
/*     */     
/*  74 */     setField("a", name);
/*  75 */     setField("f", Integer.valueOf(paramInt));
/*  76 */     addAll(players);
/*     */   }
/*     */   
/*     */   public void sendToPlayer(Player bukkitPlayer) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException
/*     */   {
/*  81 */     Object player = getHandle.invoke(bukkitPlayer, new Object[0]);
/*     */     
/*  83 */     Object connection = playerConnection.get(player);
/*     */     
/*  85 */     sendPacket.invoke(connection, new Object[] { this.packet });
/*     */   }
/*     */   
/*     */   private void setField(String field, Object value) throws NoSuchFieldException, IllegalAccessException {
/*  89 */     Field f = this.packet.getClass().getDeclaredField(field);
/*  90 */     f.setAccessible(true);
/*  91 */     f.set(this.packet, value);
/*     */   }
/*     */   
/*     */   private void addAll(Collection<?> col)
/*     */     throws NoSuchFieldException, IllegalAccessException
/*     */   {
/*  97 */     Field f = this.packet.getClass().getDeclaredField("e");
/*  98 */     f.setAccessible(true);
/*  99 */     ((Collection)f.get(this.packet)).addAll(col);
/*     */   }
/*     */   
/*     */   private static String getPacketTeamClasspath() {
/* 103 */     if ((Integer.valueOf(version.split("_")[1]).intValue() < 7) && (Integer.valueOf(version.toLowerCase().split("_")[0].replace("v", "")).intValue() == 1))
/*     */     {
/* 105 */       return "net.minecraft.server." + version + ".Packet209SetScoreboardTeam";
/*     */     }
/*     */     
/* 108 */     return "net.minecraft.server." + version + ".PacketPlayOutScoreboardTeam";
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\PacketPlayOut.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */