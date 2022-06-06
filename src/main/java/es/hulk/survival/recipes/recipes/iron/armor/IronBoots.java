package es.hulk.survival.recipes.recipes.iron.armor;

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
 * at 09/10/2021 23:22
 * Project: Survival
 * Class: IronBoots
 */

public class IronBoots {

    public static void load() {
        ItemStack item = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&fIron Boots"));
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 1);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "IRON_BLOCK_BOOTS");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("   ", "D D", "D D");
        recipe.setIngredient('D', Material.IRON_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
