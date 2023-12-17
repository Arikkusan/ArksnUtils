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

## How to use the plugin

First of all you must add it to your plugin.yml file :

```yaml
depend: [ArksnUtils] # or softdepend 
```

> **Be aware that :** 
> 
> If you necessarily need the plugin to work, you must use a depend and not a softdepend. Moreover, if you use a depend 
> don't forget to add the ArksnUtils.jar file to your server plugins folder. 

### ArksnMenu class

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

### Utils class

The Utils class contains a lot of useful methods that will help you with your plugins. Here is a list of the methods
that are currently available :
> setName(ItemStack item, String name) : set the name of an item

> setLore(ItemStack item, List<String> lore) : set the lore of an item (each line must be colored)

> addLore(ItemStack item, List<String> lore) : add a lore line to an item

> getSkull(Player player) : get the skull of a player

