package es.hulk.survival.recipes.recipes.emerald;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class EmeraldShovel {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&aEmerald Shovel"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 20);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 12);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 6);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "emerald_block_shovel");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" D ", " I ", " I ");
        recipe.setIngredient('D', Material.EMERALD_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
