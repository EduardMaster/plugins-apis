package br.com.alpha.APIs;

import org.bukkit.entity.*;


import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import java.lang.reflect.*;
import java.util.concurrent.*;
import java.util.*;
import net.minecraft.server.v1_7_R4.*;
import net.minecraft.server.v1_7_R4.Entity;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.properties.Property;

import java.util.regex.*;

@SuppressWarnings("unused")
public class FakePlayerUtils
{
    public static void changePlayerName(final Player player, final String name) {
        changePlayerName(player, name, true);
    }
    
    @SuppressWarnings("deprecation")
	public static void changePlayerName(final Player player, final String name, final boolean respawn) {
        final Player[] players = Bukkit.getServer().getOnlinePlayers();
        final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        final GameProfile playerProfile = entityPlayer.getProfile();
        if (respawn) {
            removeFromTab(player, players);
        }
        try {
            final Field field = playerProfile.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(playerProfile, name);
            field.setAccessible(false);
            entityPlayer.getClass().getDeclaredField("displayName").set(entityPlayer, name);
            entityPlayer.getClass().getDeclaredField("listName").set(entityPlayer, name);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (respawn) {
            respawnPlayer(player, players);
        }
    }
    
    public static void removePlayerSkin(final Player player) {
        removePlayerSkin(player, true);
    }
    
    @SuppressWarnings("deprecation")
	public static void removePlayerSkin(final Player player, final boolean respawn) {
        final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        final GameProfile playerProfile = entityPlayer.getProfile();
        playerProfile.getProperties().clear();
        if (respawn) {
            respawnPlayer(player, Bukkit.getServer().getOnlinePlayers());
        }
    }
    
    public static void changePlayerSkin(final Player player, final String name, final UUID uuid) {
        changePlayerSkin(player, name, uuid, true);
    }
    
    @SuppressWarnings("deprecation")
	public static void changePlayerSkin(final Player player, final String name, final UUID uuid, final boolean respawn) {
        final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        final GameProfile playerProfile = entityPlayer.getProfile();
        playerProfile.getProperties().clear();
        try {
            playerProfile.getProperties().put("textures", (Property)CustomPlayerAPI.Textures.get((GameProfile)new GameProfile(uuid, name)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (respawn) {
            respawnPlayer(player, Bukkit.getServer().getOnlinePlayers());
        }
    }
    
    public void addToTab(final Player player, final Collection<? extends Player> players) {
        final PacketPlayOutPlayerInfo addPlayerInfo = PacketPlayOutPlayerInfo.addPlayer(((CraftPlayer)player).getHandle());
        final PacketPlayOutPlayerInfo updatePlayerInfo = PacketPlayOutPlayerInfo.updateDisplayName(((CraftPlayer)player).getHandle());
        for (final Player online : players) {
            if (!online.canSee(player)) {
                continue;
            }
            ((CraftPlayer)online).getHandle().playerConnection.sendPacket((Packet)addPlayerInfo);
            ((CraftPlayer)online).getHandle().playerConnection.sendPacket((Packet)updatePlayerInfo);
        }
    }
    
    public static void removeFromTab(final Player player, final Player[] players) {
        final PacketPlayOutPlayerInfo removePlayerInfo = PacketPlayOutPlayerInfo.removePlayer(((CraftPlayer)player).getHandle());
        for (final Player online : players) {
            if (!online.canSee(player)) {
                continue;
            }
            ((CraftPlayer)online).getHandle().playerConnection.sendPacket((Packet)removePlayerInfo);
        }
    }
    
    public static void respawnPlayer(final Player player, final Player[] players) {
        final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        final PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(new int[] { entityPlayer.getId() });
        final PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn((EntityHuman)entityPlayer);
        final PacketPlayOutPlayerInfo addPlayerInfo = PacketPlayOutPlayerInfo.addPlayer(((CraftPlayer)player).getHandle());
        final PacketPlayOutEntityMetadata metadata = new PacketPlayOutEntityMetadata(entityPlayer.getId(), entityPlayer.getDataWatcher(), true);
        final PacketPlayOutEntityHeadRotation headRotation = new PacketPlayOutEntityHeadRotation((Entity)entityPlayer, (byte)MathHelper.d(entityPlayer.getHeadRotation() * 256.0f / 360.0f));
        final PacketPlayOutPlayerInfo removePlayerInfo = PacketPlayOutPlayerInfo.removePlayer(((CraftPlayer)player).getHandle());
        for (final Player online : players) {
            if (!online.canSee(player)) {
                continue;
            }
            ((CraftPlayer)online).getHandle().playerConnection.sendPacket((Packet)removePlayerInfo);
            ((CraftPlayer)online).getHandle().playerConnection.sendPacket((Packet)addPlayerInfo);
            if (online.getUniqueId() == player.getUniqueId()) {
                continue;
            }
            ((CraftPlayer)online).getHandle().playerConnection.sendPacket((Packet)destroy);
            ((CraftPlayer)online).getHandle().playerConnection.sendPacket((Packet)spawn);
            ((CraftPlayer)online).getHandle().playerConnection.sendPacket((Packet)metadata);
            ((CraftPlayer)online).getHandle().playerConnection.sendPacket((Packet)headRotation);
        }
    }
    
    public static boolean validateName(final String username) {
        final Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{1,16}");
        final Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
