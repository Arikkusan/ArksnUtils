# Arksn Utils

## Tested versions :

> 1.20 [![Release](https://jitpack.io/v/Arikkusan/ArksnUtils.svg)](https://jitpack.io/#Arikkusan/ArksnUtils)

## Description

This plugin was designed to help me with my other plugins. It contains a lot of useful methods and classes that I use in
my other plugins. A Utils class is also included to help you with your plugins. It contains methods that will help you
with different aspect of your project such as renaming items, adding lore to them, adding enchant effect, etc.

## How to import it

### 1. Maven

```xml 

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io/</url>
    </repository>
</repositories>
```

```xml

<dependency>
    <groupId>com.github.Arikkusan</groupId>
    <artifactId>ArksnUtils</artifactId>
    <version>-SNAPSHOT</version>
</dependency>
```

### 2. Gradle

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```

```gradle
dependencies {
    implementation 'com.github.Arikkusan:ArksnUtils:GAME_VERSION-SNAPSHOT'
}
```


First of all you must add it to your plugin.yml file :

```yaml
depend: [ArksnUtils] # or softdepend 
```

> **Be aware that :** 
> 
> If you necessarily need the plugin to work, you must use a depend and not a softdepend. Moreover, if you use a depend 
> don't forget to add the ArksnUtils.jar file to your server plugins folder. 

## How to use the plugin
### 1. ArksnCommand class

I really like the way the commands are handled in the Spigot API. However, I find it a bit too complicated to use. That's 
why I created the ArksnCommand class. It allows you to create a command in a few lines of code. Here is an example of a
command that will send a message to the player who executed it :

```java
import fr.arikkusan.arksnutils.ArksnCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyCommand extends ArksnCommand {

    @Override
    protected boolean playerCommand(Player player, String[] args) {
        player.sendMessage("Hello " + player.getName());
        player.sendMessage("You used the command " + commandName);
        return true;
    }
    
    @Override
    protected boolean consoleCommand(CommandSender sender, String[] args) {
        // This function is optional and if you don't need it you can delete it, 
        // it will automatically send a message to the sender telling him that 
        // he must be a player to execute this command
        sender.sendMessage("Hello console");
        return true;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
```

After that you'll need to register your command in your main class :

```java
import fr.arikkusan.arksnutils.ArksnCommand;import fr.arikkusan.arksnutils.ArksnUtilsMain;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // add your command to the plugin command list (don't forget to add the command to your plugin.yml file)
        ArksnUtilsMain.addCommand(this, "mycommand", new MyCommand());
    }
    
}
```

When a player execute the command, it will call the playerCommand method. If the sender is not a player, it will call


### 2. ArksnMenu class

To create a new Menu you can use the following code :

```java
import fr.arikkusan.arksnutils.ArksnUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;

class MyMenu extends ArksnMenu {

    @Override
    public void initMenu(Player player) {
        // Here you can add items to your menu using the addButton method
        MenuButton myButton = new MenuButton(
                Material.ITEM_WANTED,
                ITEM_NAME,
                p -> {
                    // action on click
                    p.closeInventory();
                    p.sendMessage("You clicked on the button");
                }
        );

        // You can also add a lore to your item
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "lore line 1");
        lore.add(ChatColor.RED + "lore line 2");
        myButton.addLore(lore);

        // You can also add an enchant effect to your item
        Utils.addEnchantEffect(myButton); // not implemented yet

        // you can add your button to your menu using the addButton method
        addButton(SLOT_INDEX, myButton);

        // you can also fill a line using the fillLine method, this method won't replace existing items on the current line
        // please note that the line index starts at 0 and the object will be renamed to ""
        fillLine(LINE_INDEX, Material.ITEM_WANTED);
    }

    @Override
    public int lineNumber() {
        return LINE_NUMBER;
    }

    @Override
    public String name() {
        return "unique menu name";
    }
}
```

After that you'll need to register your menu in your main class :

```java
import fr.arikkusan.arksnutils.menus.MenuManager;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        MenuManager.registerMenu(new MyMenu());
    }
}
```

When a player open the menu, it will call the initMenu method. Please note that the menu will be automatically closed
when the player click on an item and that there will be no possibility to get an item from it.

To open the menu you can use the following code :

```java
MenuManager.openMenu(player, MyMenu.class);
```

### 3. Utils class

The Utils class contains a lot of useful methods that will help you with your plugins. Here is a list of the methods
that are currently available :
```java
private interface IUtils {
    void setName(ItemStack item, String name); // set the player invulnerable for a certain amount of time
    void setLore(ItemStack item, List<String> lore); // set the lore of an item (each line must be colored)
    void addLore(ItemStack item, String lore); // add a lore line to an item
    ItemStack getSkull(Player player); // get the skull of a player
}
```

