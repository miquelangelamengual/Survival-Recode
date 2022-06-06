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
import org.bukkit.block.data.type.Bed;
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

        tabs.add(new TablistLayout(TablistColumn.LEFT, 2, "&aTus Estadisticas", Skin.getSkin(player)));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 3, "&bMobs Matados&7: &e" + playerUtils.getMobKills()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 4, "&bJugadores&7: &e" + playerUtils.getKills()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 5, "&bMuertes&7: &e" + playerUtils.getDeaths()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 6, "&bTiempo&7: &e" + playerUtils.getPlayTime()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 7, "&bVida&7: &e" + playerUtils.getHealth()));

        tabs.add(new TablistLayout(TablistColumn.LEFT, 10, "&aBosses Eliminados"));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 11, "&bWhiters&7: &e" + player.getStatistic(Statistic.KILL_ENTITY, EntityType.WITHER)));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 12, "&bEnder Dragons&7: &e" + player.getStatistic(Statistic.KILL_ENTITY, EntityType.ENDER_DRAGON)));

        tabs.add(new TablistLayout(TablistColumn.LEFT, 14, "&aTus Coordenadas"));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 15, "&bMundo&7: &e" + playerUtils.getWorld(), Skin.PLANET_SKIN));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 16, "&bBioma&7: &e" + playerUtils.getBiome()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 17, "&bX&7: &e" + player.getLocation().getBlockX()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 18, "&bY&7: &e" + player.getLocation().getBlockY()));
        tabs.add(new TablistLayout(TablistColumn.LEFT, 19, "&bZ&7: &e" + player.getLocation().getBlockZ()));

        if (player.getBedSpawnLocation() != null) {
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 3, "&aCoords de tu Cama"));
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 4, "&bMundo&7: &e" + bedLocation.getWorld(), Skin.PLANET_SKIN));
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 5, "&bX&7: &e" + bedLocation.getBlockX()));
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 6, "&bY&7: &e" + bedLocation.getBlockY()));
            tabs.add(new TablistLayout(TablistColumn.MIDDLE, 7, "&bZ&7: &e" + bedLocation.getBlockZ()));
        }

        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 11, "&bMundo&7: &eOverworld", Skin.PLANET_SKIN));
        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 12, "&bX&7: &e" + player.getWorld().getSpawnLocation().getBlockX()));
        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 13, "&bY&7: &e" + player.getWorld().getSpawnLocation().getBlockY()));
        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 14, "&bZ&7: &e" + player.getWorld().getSpawnLocation().getBlockZ()));

        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 18, "&aNuestro Discord"));
        tabs.add(new TablistLayout(TablistColumn.MIDDLE, 19, "&bdiscord.frostpvp.net", Skin.DISCORD_SKIN));

        tabs.add(new TablistLayout(TablistColumn.RIGHT, 16, "&aInformacion del Servidor", Skin.COMPASS_SKIN));
        tabs.add(new TablistLayout(TablistColumn.RIGHT, 17, "&bTu Ping&7: &e" + player.getPing() + "ms"));
        tabs.add(new TablistLayout(TablistColumn.RIGHT, 18, "&bJugadores&7: &e" + Bukkit.getOnlinePlayers().size()));

        return tabs;
    }

    @Override
    public List<String> getFooter(Player player) {
        return Arrays.asList(
                "",
                "&eBienvendo &a" + player.getName() + " &eal Survival",
                "");
    }

    @Override
    public List<String> getHeader(Player player) {
        return Arrays.asList(
                "",
                "&eDisfruta de tu estancia en el servidor",
                "");
    }
}
