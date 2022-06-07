package es.hulk.survival.listeners;

import dev.panda.file.FileConfig;
import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityListener implements Listener {

    private final FileConfig config = Survival.getInstance().getMainConfig();

    @EventHandler
    public void onEntityDie(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        Random random = new Random();

        if (!config.getBoolean("ENTITIES.POPPY-DROP")) {
            if (event.getEntity().getType() == EntityType.IRON_GOLEM) {
                event.getDrops().removeIf(is -> is.getType() == Material.POPPY);
            }
        }

        if (config.getBoolean("ENTITIES.GUNPOWDER-BOOST")) {
            if (event.getEntity().getType() == EntityType.CREEPER) {
                event.getDrops().add(new ItemStack(Material.GUNPOWDER, random.nextInt(30)));

                if (event.getEntity() instanceof Player) {
                    if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                        event.getDrops().add(new ItemStack(Material.TNT));
                    }
                }
            }
        }

        if (config.getBoolean("ENTITIES.GHAST-THEAR-BOOST")) {
            if (event.getEntity().getType() == EntityType.GHAST) {

                event.getDrops().add(new ItemStack(Material.GHAST_TEAR, random.nextInt(20)));
                if (event.getEntity() instanceof Player) {
                    if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                        event.getDrops().add(new ItemStack(Material.NETHER_STAR, random.nextInt(2)));
                    }
                }
            }

            if (config.getBoolean("ENTITIES.CAT-BOOST")) {
                if (event.getEntity().getType() == EntityType.CAT) {
                    event.getDrops().add(new ItemStack(Material.MUTTON, random.nextInt(6)));
                    event.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(6)));
                }
            }

            if (config.getBoolean("ENTITIES.BEE-BOOST")) {
                if (event.getEntity().getType() == EntityType.BEE) {
                    event.getDrops().add(new ItemStack(Material.MUTTON, random.nextInt(6)));
                    event.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(6)));

                    if (event.getEntity() instanceof Player) {
                        if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                            event.getDrops().add(new ItemStack(Material.HONEY_BLOCK));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void entityExplode(EntityExplodeEvent event) {
        if (event.getEntity().getType() == EntityType.CREEPER) {
            event.setCancelled(true);
            return;
        }
        event.setCancelled(false);
    }
}
