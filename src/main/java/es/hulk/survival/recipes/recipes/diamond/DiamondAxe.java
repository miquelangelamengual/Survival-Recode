package es.hulk.survival.recipes.recipes.diamond;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class DiamondAxe {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&bDiamond Axe"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 12);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 6);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 5);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "diamond_block_axe");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" DD", " ID", " I ");
        recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
