package es.hulk.survival.recipes.recipes.gold.armor;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
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
 * Class: IronChestplate
 */

public class GoldChestplate {

    public static void load() {
        ItemStack item = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&6Golden Chestplate"));
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 2);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "GOLD_BLOCK_CHESTPLATE");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("D D", "DDD", "DDD");
        recipe.setIngredient('D', Material.GOLD_BLOCK);

        Bukkit.addRecipe(recipe);
    }
}
