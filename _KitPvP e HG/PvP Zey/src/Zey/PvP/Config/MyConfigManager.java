package Zey.PvP.Config;

import org.bukkit.event.*;
import org.bukkit.plugin.java.*;
import java.nio.charset.*;
import java.io.*;

public class MyConfigManager implements Listener
{
    private JavaPlugin plugin;
    
    public MyConfigManager(final JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    public MyConfig getNewConfig(final String fileName, final String[] header) {
        final File file = this.getConfigFile(fileName);
        if (!file.exists()) {
            this.prepareFile(fileName);
            if (header != null && header.length != 0) {
                this.setHeader(file, header);
            }
        }
        final MyConfig config = new MyConfig(this.getConfigContent(fileName), file, this.getCommentsNum(file), this.plugin);
        return config;
    }
    
    public MyConfig getNewConfig(final String fileName) {
        return this.getNewConfig(fileName, null);
    }
    
    private File getConfigFile(final String file) {
        if (file.isEmpty() || file == null) {
            return null;
        }
        File configFile;
        if (file.contains("/")) {
            if (file.startsWith("/")) {
                configFile = new File(this.plugin.getDataFolder() + file.replace("/", File.separator));
            }
            else {
                configFile = new File(this.plugin.getDataFolder() + File.separator + file.replace("/", File.separator));
            }
        }
        else {
            configFile = new File(this.plugin.getDataFolder(), file);
        }
        return configFile;
    }
    
    public void prepareFile(final String filePath, final String resource) {
        final File file = this.getConfigFile(filePath);
        if (file.exists()) {
            return;
        }
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            if (resource != null && !resource.isEmpty()) {
                this.copyResource(this.plugin.getResource(resource), file);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void prepareFile(final String filePath) {
        this.prepareFile(filePath, null);
    }
    
    public void setHeader(final File file, final String[] header) {
        if (!file.exists()) {
            return;
        }
        try {
            final StringBuilder config = new StringBuilder("");
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                config.append(String.valueOf(currentLine) + "\n");
            }
            reader.close();
            config.append("# +----------------------------------------------------+ #\n");
            for (final String line : header) {
                if (line.length() <= 50) {
                    final int lenght = (50 - line.length()) / 2;
                    final StringBuilder finalLine = new StringBuilder(line);
                    for (int i = 0; i < lenght; ++i) {
                        finalLine.append(" ");
                        finalLine.reverse();
                        finalLine.append(" ");
                        finalLine.reverse();
                    }
                    if (line.length() % 2 != 0) {
                        finalLine.append(" ");
                    }
                    config.append("# < " + finalLine.toString() + " > #\n");
                }
            }
            config.append("# +----------------------------------------------------+ #");
            final BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(this.prepareConfigString(config.toString()));
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public InputStream getConfigContent(final File file) {
        if (!file.exists()) {
            return null;
        }
        try {
            int commentNum = 0;
            final String pluginName = this.getPluginName();
            final StringBuilder whole = new StringBuilder("");
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.startsWith("#")) {
                    final String addLine = currentLine.replaceFirst("#", String.valueOf(pluginName) + "_COMMENT_" + commentNum + ":");
                    whole.append(String.valueOf(addLine) + "\n");
                    ++commentNum;
                }
                else {
                    whole.append(String.valueOf(currentLine) + "\n");
                }
            }
            final String config = whole.toString();
            final InputStream configStream = new ByteArrayInputStream(config.getBytes(Charset.forName("UTF-8")));
            reader.close();
            return configStream;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private int getCommentsNum(final File file) {
        if (!file.exists()) {
            return 0;
        }
        try {
            int comments = 0;
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.startsWith("#")) {
                    ++comments;
                }
            }
            reader.close();
            return comments;
        }
        catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public InputStream getConfigContent(final String filePath) {
        return this.getConfigContent(this.getConfigFile(filePath));
    }
    
    private String prepareConfigString(final String configString) {
        int lastLine = 0;
        int headerLine = 0;
        final String[] lines = configString.split("\n");
        final StringBuilder config = new StringBuilder("");
        String[] array;
        for (int length = (array = lines).length, i = 0; i < length; ++i) {
            final String line = array[i];
            if (line.startsWith(String.valueOf(this.getPluginName()) + "_COMMENT")) {
                final String comment = "#" + line.trim().substring(line.indexOf(":") + 1);
                if (comment.startsWith("# +-")) {
                    if (headerLine == 0) {
                        config.append(String.valueOf(comment) + "\n");
                        lastLine = 0;
                        headerLine = 1;
                    }
                    else if (headerLine == 1) {
                        config.append(String.valueOf(comment) + "\n\n");
                        lastLine = 0;
                        headerLine = 0;
                    }
                }
                else {
                    String normalComment;
                    if (comment.startsWith("# ' ")) {
                        normalComment = comment.substring(0, comment.length() - 1).replaceFirst("# ' ", "# ");
                    }
                    else {
                        normalComment = comment;
                    }
                    if (lastLine == 0) {
                        config.append(String.valueOf(normalComment) + "\n");
                    }
                    else if (lastLine == 1) {
                        config.append("\n" + normalComment + "\n");
                    }
                    lastLine = 0;
                }
            }
            else {
                config.append(String.valueOf(line) + "\n");
                lastLine = 1;
            }
        }
        return config.toString();
    }
    
    public void saveConfig(final String configString, final File file) {
        final String configuration = this.prepareConfigString(configString);
        try {
            final BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(configuration);
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getPluginName() {
        return this.plugin.getDescription().getName();
    }
    
    private void copyResource(final InputStream resource, final File file) {
        try {
            final OutputStream out = new FileOutputStream(file);
            final byte[] buf = new byte[1024];
            int length;
            while ((length = resource.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
            out.close();
            resource.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
