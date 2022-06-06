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

public class EmeraldSword {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&aEmerald Sword"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 20);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 8);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "emerald_block_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" D ", " D ", " I ");
        recipe.setIngredient('D', Material.EMERALD_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
