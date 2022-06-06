package es.hulk.survival.recipes.recipes.emerald.armor;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class EmeraldLeggings {

    public static void load() {
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&aEmerald Leggings"));
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 12);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 8);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "EMERALD_BLOCK_LEGGINGS");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("DDD", "D D", "D D");
        recipe.setIngredient('D', Material.EMERALD_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
