package com.HolyLight.decor.client;

import com.HolyLight.decor.*;
import com.HolyLight.decor.client.render.*;
import com.HolyLight.decor.tiles.*;

import cpw.mods.fml.client.registry.*;
import net.minecraft.client.renderer.tileentity.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.*;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(final FMLPreInitializationEvent event) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileDecor.class, new RenderDecor());
        FMLCommonHandler.instance().bus().register(new ClientEventHandler());
        super.preInit(event);
    }

    @Override
    public void init(final FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(final FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
