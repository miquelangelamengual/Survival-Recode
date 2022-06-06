package es.hulk.survival.recipes.recipes.diamond.armor;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class DiamondHelmet {

    public static void load() {
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&bDiamond Helmet"));
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        item.addUnsafeEnchantment(Enchantment.OXYGEN, 1);
        item.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "DIAMOND_BLOCK_HELMET");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("DDD", "D D", "   ");
        recipe.setIngredient('D', Material.DIAMOND_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
