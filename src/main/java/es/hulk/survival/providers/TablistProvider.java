package es.hulk.survival.providers;

import com.google.common.collect.Sets;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.location.BedLocation;
import es.hulk.tablist.TablistAdapter;
import es.hulk.tablist.TablistColumn;
import es.hulk.tablist.TablistLayout;
import es.hulk.tablist.utils.Skin;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TablistProvider implements TablistAdapter {
    @Override
    public Set<TablistLayout> getProvider(Player player) {
        Set<TablistLayout> tabs = Sets.newHashSet();
        PlayerUtils playerUtils = new PlayerUtils(player);
        BedLocation bedLocation = new BedLocation(player);

        tabs.add(new TablistLayout(TablistColumn.LEFT, 2, "&6Tus Estadisticas", Skin.getSkin(player)));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 3, "&eMobs Matados&7: &a" + playerUtils.getMobKills()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 4, "&eJugadores&7: &a" + playerUtils.getKills()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 5, "&eMuertes&7: &a" + playerUtils.getDeaths()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 6, "&eTiempo&7: &a" + playerUtils.getNicePlayTime()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 7, "&eVida&7: &a" + playerUtils.getHealth()));

        tabs.add(new TablistLayout(TablistColumn.LEFT, 10, "&6Bosses Eliminados"));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 11, "&eWhiters&7: &a" + player.getStatistic(Statistic.KILL_ENTITY, EntityType.WITHER)));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 12, "&eEnder Dragons&7: &a" + player.getStatistic(Statistic.KILL_ENTITY, EntityType.ENDER_DRAGON)));

        tabs.add(new TablistLayout(TablistColumn.LEFT, 14, "&6Tus Coordenadas"));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 15, "&eMundo&7: &a" + playerUtils.getWorld(), Skin.PLANET_SKIN));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 16, "&eBioma&7: &a" + playerUtils.getBiome()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 17, "&eX&7: &a" + player.getLocation().getBlockX()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 18, "&eY&7: &a" + player.getLocation().getBlockY()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 19, "&eZ&7: &a" + player.getLocation().getBlockZ()));

        if (player.getBedSpawnLocation() != null) {
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 3, "&6Coords de tu Cama"));
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 4, "&eMundo&7: &a" + bedLocation.getWorld(), Skin.PLANET_SKIN));
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 5, "&eX&7: &a" + bedLocation.getBlockX()));
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 6, "&eY&7: &a" + bedLocation.getBlockY()));
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 7, "&eZ&7: &a" + bedLocation.getBlockZ()));
        }

        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 10, "&6Coords del Spawn"));
        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 11, "&eMundo&7: &aOverworld", Skin.PLANET_SKIN));
        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 12, "&eX&7: &a" + player.getWorld().getSpawnLocation().getBlockX()));
        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 13, "&eY&7: &a" + player.getWorld().getSpawnLocation().getBlockY()));
        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 14, "&eZ&7: &a" + player.getWorld().getSpawnLocation().getBlockZ()));

        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 18, "&6Nuestro Discord"));
        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 19, "&cNo Discord...", Skin.DISCORD_SKIN));

        tabs.add(new TablistLayout(TablistColumn.RIGHT, 16, "&6Informacion del Servidor", Skin.COMPASS_SKIN));
        tabs.add(new TablistLayout(TablistColumn.RIGHT, 17, "&eTu Ping&7: &a" + player.getPing() + "ms"));
        tabs.add(new TablistLayout(TablistColumn.RIGHT, 18, "&eJugadores&7: &a" + Bukkit.getOnlinePlayers().size()));

        return tabs;
    }

    @Override
    public List<String> getHeader(Player player) {
        return Arrays.asList(
                "",
                "&6Bienvendo &a" + player.getName() + " &eal Survival",
                "");
    }

    @Override
    public List<String> getFooter(Player player) {
        return Arrays.asList(
                "",
                "&6Disfruta de tu estancia en el servidor",
                "");
    }
}
