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

public class NetheriteLeggings {

    public static void load() {
        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&dNetherite Leggings"));
        meta.setUnbreakable(true);
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 60);
        item.addUnsafeEnchantment(Enchantment.MENDING, 10);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 30);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "ULTIMATE_LEGGINGS");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("DDD", "D D", "D D");
        recipe.setIngredient('D', Material.NETHERITE_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
