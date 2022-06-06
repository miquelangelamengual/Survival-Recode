package es.hulk.survival.recipes.recipes.other;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class UltimateBow {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.BOW);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&9The Edshot Machine"));
        meta.setUnbreakable(true);
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1000);
        pickaxe.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1000);
        pickaxe.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 100);
        pickaxe.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "THE_EDSHOT_MACHINE");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("SSS", "MOM", "BBB");
        recipe.setIngredient('O', Material.BOW);
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('B', Material.OBSIDIAN);
        recipe.setIngredient('M', Material.OAK_LOG);

        Bukkit.addRecipe(recipe);
    }

}
