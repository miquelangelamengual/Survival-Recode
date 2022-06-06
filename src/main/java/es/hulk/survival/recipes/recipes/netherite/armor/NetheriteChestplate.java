package es.hulk.survival.recipes.recipes.netherite.armor;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class NetheriteChestplate {

    public static void load() {
        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&dNetherite Chestplate"));
        meta.setUnbreakable(true);
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 60);
        item.addUnsafeEnchantment(Enchantment.MENDING, 10);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 30);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "ULTIMATE_CHESTPLATE");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("D D", "DDD", "DDD");
        recipe.setIngredient('D', Material.NETHERITE_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
