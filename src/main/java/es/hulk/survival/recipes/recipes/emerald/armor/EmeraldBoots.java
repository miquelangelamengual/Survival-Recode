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

public class EmeraldBoots {

    public static void load() {
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&aEmerald Boots"));
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 12);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 8);
        item.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 6);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 6);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "EMERALD_BLOCK_BOOTS");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("   ", "D D", "D D");
        recipe.setIngredient('D', Material.EMERALD_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
