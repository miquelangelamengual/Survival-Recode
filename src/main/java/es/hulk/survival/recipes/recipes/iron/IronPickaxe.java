package es.hulk.survival.recipes.recipes.iron;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class IronPickaxe {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&fIron Pickaxe"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 2);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "iron_block_pickaxe");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("RRR", " I ", " I ");
        recipe.setIngredient('R', Material.IRON_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
