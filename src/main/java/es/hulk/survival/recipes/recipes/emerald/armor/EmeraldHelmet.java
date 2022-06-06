package es.hulk.survival.recipes.recipes.emerald.armor;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class EmeraldHelmet {

    public static void load() {
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&aEmerald Helmet"));
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 12);
        item.addUnsafeEnchantment(Enchantment.OXYGEN, 3);
        item.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 8);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "EMERALD_BLOCK_HELMET");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("DDD", "D D", "   ");
        recipe.setIngredient('D', Material.EMERALD_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
