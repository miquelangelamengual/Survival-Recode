package es.hulk.survival.utils.menu.pagination;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class JumpToPageButton extends Button
{
    private final int page;
    private final PaginatedMenu menu;
    private final boolean current;

    @Override
    public ItemStack getButtonItem(final Player player) {
        ItemBuilder itemBuilder = new ItemBuilder(this.current ? Material.ENCHANTED_BOOK : Material.BOOK).amount(this.page);
        itemBuilder.name(ChatUtil.translate("&cPage " + this.page));
        if (this.current) {
            itemBuilder.lore("", ChatUtil.translate("&aCurrent page"));
        }
        return itemBuilder.build();
    }

    @Override
    public void clicked(final Player player, final int i, final ClickType clickType, final int hb) {
        this.menu.modPage(player, this.page - this.menu.getPage());
        Button.playNeutral(player);
    }

    public JumpToPageButton(final int page, final PaginatedMenu menu, final boolean current) {
        this.page = page;
        this.menu = menu;
        this.current = current;
    }
}