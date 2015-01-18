package BetterCauldrons;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.material.Cauldron;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.yaml.snakeyaml.Yaml;

public class BetterCauldrons extends JavaPlugin implements Listener{
	@Override
    public void onEnable() {
    }
 
    @Override
    public void onDisable() {
    }
    @EventHandler(priority=EventPriority.HIGH)
    public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if(event.hasBlock())
        {
	        Location loc = event.getClickedBlock().getLocation();
	        if(loc.getBlock().getType() == Material.CAULDRON)
	        {
	        	loc.setY(loc.getY() - 1);
		        if(loc.getBlock().getType() == Material.GOLD_BLOCK)
		        {
			        if(p.getItemInHand().getEnchantments().size() > 0)
			        {
			        	for(Enchantment ench : p.getItemInHand().getEnchantments().keySet())
			        	{
			        		p.getItemInHand().removeEnchantment(ench);
			        	}
			        }
		        }
	        }
        }
    }
}
