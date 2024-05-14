package com.HolyLight.decor;

import com.HolyLight.decor.client.ClientEventHandler;
import com.HolyLight.decor.client.config.*;
import com.HolyLight.decor.tiles.*;

import cpw.mods.fml.common.*;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.item.*;
import net.minecraft.init.*;

@Mod(modid = "decor-mod", name = "HolyLight Decor Mod", version = "0.0.3", acceptedMinecraftVersions = "[1.7.10]")
public class Main
{
    @SidedProxy(clientSide = "com.HolyLight.decor.client.ClientProxy", serverSide = "com.HolyLight.decor.CommonProxy")
    private static CommonProxy proxy;
    public static final String MODID = "decor-mod";
    public static final boolean IS_SERVER = false; /*True - universal false - client*/
    public static final CreativeTabs DECOR_TAB1;
    public static final CreativeTabs DECOR_TAB2;
    public static final CreativeTabs DECOR_TAB3;
    public static final CreativeTabs DECOR_TAB4;
    public static final CreativeTabs DECOR_TAB5;

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        final DecorConfig decorConfig = new DecorConfig();
        decorConfig.readConfig();
        GameRegistry.registerTileEntity(TileDecor.class, "com.HolyLight.tiles.TileDecor");
        Main.proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        Main.proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
        Main.proxy.postInit(event);
    }

    static {
        DECOR_TAB1 = new CreativeTabs("Decor1") {
            @Override
            public Item getTabIconItem() {
                return Items.arrow;
            }
            @Override
            public String getBackgroundImageName() {
                return "item_search.png";
            }

            @Override
            public boolean hasSearchBar() {
                return true;
            }
        };
    }
    static {
        DECOR_TAB2 = new CreativeTabs("Decor2") {
            @Override
            public Item getTabIconItem() {
                return Items.arrow;
            }
            @Override
            public String getBackgroundImageName() {
                return "item_search.png";
            }

            @Override
            public boolean hasSearchBar() {
                return true;
            }
        };
        
    }
    static {
        DECOR_TAB3 = new CreativeTabs("Decor3") {
            @Override
            public Item getTabIconItem() {
                return Items.arrow;
            }
            @Override
            public String getBackgroundImageName() {
                return "item_search.png";
            }

            @Override
            public boolean hasSearchBar() {
                return true;
            }
        };
    
        
    }
    static {
        DECOR_TAB4 = new CreativeTabs("Decor4") {
            @Override
            public Item getTabIconItem() {
                return Items.arrow;
            }
            @Override
            public String getBackgroundImageName() {
                return "item_search.png";
            }

            @Override
            public boolean hasSearchBar() {
                return true;
            }
        };
        
    }
    static {
        DECOR_TAB5 = new CreativeTabs("Decor5") {
            @Override
            public Item getTabIconItem() {
                return Items.arrow;
            }
            @Override
            public String getBackgroundImageName() {
                return "item_search.png";
            }

            @Override
            public boolean hasSearchBar() {
                return true;
            }
        };
        
    }

}
