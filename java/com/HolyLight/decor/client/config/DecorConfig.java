package com.HolyLight.decor.client.config;

import java.io.*;

import com.HolyLight.decor.*;
import com.HolyLight.decor.blocks.*;

import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;

public class DecorConfig
{
    public void readConfig() {
        try {
            final BufferedReader e = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/assets/decor-mod/blocks.txt"), "UTF-8"));
            final StringBuffer buffer = new StringBuffer();
            boolean flag = false;
            while (!flag) {
                String itemsSplitter = e.readLine();
                if (itemsSplitter == null) {
                    flag = true;
                }
                else {
                    itemsSplitter = itemsSplitter.trim();
                    if (itemsSplitter.startsWith("//")) {
                        continue;
                    }
                    buffer.append(itemsSplitter.split("//", 2)[0]);
                }
            }
            String itemsSplitter = "\\{";
            final String parSplitter = "[\\s]*;[\\s]*";
            final String config = buffer.toString().replaceAll("\n|\r", "");
            final String[] arr$;
            final String[] splitted = arr$ = config.split("\\}");
            for (int len$ = splitted.length, i$ = 0; i$ < len$; ++i$) {
                final String str = arr$[i$];
                try {
                    final String[] e2 = str.split(itemsSplitter)[1].split(parSplitter);
                    final String name = getString(e2, "name");
                    final String modelPath = getString(e2, "model_path");
                    final String texturePath = getString(e2, "texture_path");
                    final String setBlockTextureName = getString(e2, "icons");
                    final String setLightLevel = getString(e2, "light");
                    final String creativeTa = getString(e2, "creativeTab");
                    final boolean collide = this.getBoolean(e2, "collide");
                    final int setLight = Integer.parseInt(setLightLevel);
                    final int creativeTab = Integer.parseInt(creativeTa);
                    GameRegistry.registerBlock(new BlockDecor(name, modelPath, texturePath, collide, setBlockTextureName, setLight, creativeTab), name);
                }
                catch (Exception var21) {
                    var21.printStackTrace();
                }
            }
        }
        catch (Exception var22) {
            var22.printStackTrace();
        }
    }

    private static String getString(final String[] parameters, final String name) {
        final String str = getParStr(parameters, name);
        if (str == null)
            return "";
        final String value = str.split(":", 2)[1].trim();
        return value.equals("\"\"") ? "" : value.split("\"")[1];
    }

    public boolean getBoolean(final String[] parameters, final String name) {
        final String str = getParStr(parameters, name);
        return str != null && str.split(":", 2)[1].trim().equals("true");
    }

    private static String getParStr(final String[] parameters, final String name) {
        final String toFound = name + ":";
        final String[] arr$ = parameters;
        for (int len$ = parameters.length, i$ = 0; i$ < len$; ++i$) {
            final String str = arr$[i$];
            if (str.startsWith(toFound))
                return str;
        }
        return null;
    }
}
