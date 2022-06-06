package es.hulk.survival.recipes.recipes.coal;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class CoalAxe {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.STONE_AXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&7Coal Axe"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "coal_block_axe");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" DD", " ID", " I ");
        recipe.setIngredient('D', Material.COAL_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
