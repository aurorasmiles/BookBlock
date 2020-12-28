package codes.aurora.bookblock;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class BookBlock extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onBookInteract(PlayerEditBookEvent e) {
        if (!e.getPlayer().hasPermission("bookblock.exempt")) {
            e.setCancelled(true);
            ItemStack is = new ItemStack(Material.WRITABLE_BOOK);
            e.getPlayer().getInventory().setItem(e.getPlayer().getInventory().getHeldItemSlot(), is);
        }
    }
}
