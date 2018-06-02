package Zey.PvP.Config;

import java.io.*;
import org.bukkit.plugin.java.*;
import org.bukkit.configuration.file.*;
import org.bukkit.configuration.*;
import java.util.*;

public class MyConfig
{
    private int comments;
    private MyConfigManager manager;
    private File file;
    private FileConfiguration config;
    
    @SuppressWarnings("deprecation")
	public MyConfig(final InputStream configStream, final File configFile, final int comments, final JavaPlugin plugin) {
        this.comments = comments;
        this.manager = new MyConfigManager(plugin);
        this.file = configFile;
        this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(configStream);
    }
    
    public Object get(final String path) {
        return this.config.get(path);
    }
    
    public Object get(final String path, final Object def) {
        return this.config.get(path, def);
    }
    
    public String getString(final String path) {
        return this.config.getString(path);
    }
    
    public String getString(final String path, final String def) {
        return this.config.getString(path, def);
    }
    
    public int getInt(final String path) {
        return this.config.getInt(path);
    }
    
    public int getInt(final String path, final int def) {
        return this.config.getInt(path, def);
    }
    
    public boolean getBoolean(final String path) {
        return this.config.getBoolean(path);
    }
    
    public boolean getBoolean(final String path, final boolean def) {
        return this.config.getBoolean(path, def);
    }
    
    public void createSection(final String path) {
        this.config.createSection(path);
    }
    
    public ConfigurationSection getConfigurationSection(final String path) {
        return this.config.getConfigurationSection(path);
    }
    
    public double getDouble(final String path) {
        return this.config.getDouble(path);
    }
    
    public double getDouble(final String path, final double def) {
        return this.config.getDouble(path, def);
    }
    
    public List<?> getList(final String path) {
        return (List<?>)this.config.getList(path);
    }
    
    @SuppressWarnings("rawtypes")
	public List<?> getList(final String path, final List<?> def) {
        return (List<?>)this.config.getList(path, (List)def);
    }
    
    public boolean contains(final String path) {
        return this.config.contains(path);
    }
    
    public void removeKey(final String path) {
        this.config.set(path, (Object)null);
    }
    
    public void set(final String path, final Object value) {
        this.config.set(path, value);
    }
    
    public void set(final String path, final Object value, final String comment) {
        if (!this.config.contains(path)) {
            this.config.set(String.valueOf(this.manager.getPluginName()) + "_COMMENT_" + this.comments, (Object)(" " + comment));
            ++this.comments;
        }
        this.config.set(path, value);
    }
    
    public void set(final String path, final Object value, final String[] comment) {
        for (final String comm : comment) {
            if (!this.config.contains(path)) {
                this.config.set(String.valueOf(this.manager.getPluginName()) + "_COMMENT_" + this.comments, (Object)(" " + comm));
                ++this.comments;
            }
        }
        this.config.set(path, value);
    }
    
    public void setHeader(final String[] header) {
        this.manager.setHeader(this.file, header);
        this.comments = header.length + 2;
        this.reloadConfig();
    }
    
    @SuppressWarnings("deprecation")
	public void reloadConfig() {
        this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.manager.getConfigContent(this.file));
    }
    
    public void saveConfig() {
        final String config = this.config.saveToString();
        this.manager.saveConfig(config, this.file);
    }
    
    public Set<String> getKeys() {
        return (Set<String>)this.config.getKeys(false);
    }
}
