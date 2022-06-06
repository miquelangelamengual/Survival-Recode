package es.hulk.survival.recipes.recipes.gold.armor;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Hulk
 * at 09/10/2021 23:21
 * Project: Survival
 * Class: IronHelmet
 */

public class GoldHelmet {

    public static void load() {
        ItemStack item = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&6Golden Helmet"));
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 2);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "GOLD_BLOCK_HELMET");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("DDD", "D D", "   ");
        recipe.setIngredient('D', Material.GOLD_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
