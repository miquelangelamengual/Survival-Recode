package es.hulk.survival.recipes.recipes.stone;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class StoneSword {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&8Stone Sword"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "stone_block_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" D ", " D ", " I ");
        recipe.setIngredient('D', Material.STONE);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
