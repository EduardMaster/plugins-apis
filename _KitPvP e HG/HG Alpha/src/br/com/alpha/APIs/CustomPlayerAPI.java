package br.com.alpha.APIs;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;

import net.minecraft.server.v1_7_R4.Entity;
import net.minecraft.server.v1_7_R4.EntityHuman;
import net.minecraft.server.v1_7_R4.EntityLiving;
import net.minecraft.server.v1_7_R4.MinecraftServer;
import net.minecraft.server.v1_7_R4.WorldServer;
import net.minecraft.util.com.google.common.cache.CacheBuilder;
import net.minecraft.util.com.google.common.cache.CacheLoader;
import net.minecraft.util.com.google.common.cache.LoadingCache;
import net.minecraft.util.com.google.common.collect.Iterables;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.properties.Property;

public class CustomPlayerAPI {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final LoadingCache<GameProfile, Property> Textures = (LoadingCache<GameProfile, Property>) CacheBuilder
			.newBuilder().expireAfterWrite(30L, TimeUnit.MINUTES)
			.build((CacheLoader) new CacheLoader<GameProfile, Property>() {
				public Property load(final GameProfile key) throws Exception {
					return loadTextures(key);
				}
			});;

	private static MinecraftServer nmsServer;

	static {
		CustomPlayerAPI.nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final Property loadTextures(final GameProfile profile) {
		MinecraftServer.getServer().av().fillProfileProperties(profile, true);
		return (Property) Iterables.getFirst((Iterable) profile.getProperties().get((String) "textures"),
				(Object) null);
	}

	public static MinecraftServer getNmsServer() {
		return CustomPlayerAPI.nmsServer;
	}

	public static WorldServer getNmsWorld(final World world) {
		return ((CraftWorld) world).getHandle();
	}

	public static void setHeadYaw(final Entity en, float yaw) {
		if (!(en instanceof EntityLiving)) {
			return;
		}
		final EntityLiving handle = (EntityLiving) en;
		while (yaw < -180.0f) {
			yaw += 360.0f;
		}
		while (yaw >= 180.0f) {
			yaw -= 360.0f;
		}
		handle.aO = yaw;
		if (!(handle instanceof EntityHuman)) {
			handle.aM = yaw;
		}
		handle.aP = yaw;
	}
}
