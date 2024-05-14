package com.HolyLight.decor.client.render;

import net.minecraftforge.client.model.*;
import java.nio.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.client.model.obj.*;
import org.lwjgl.*;
import java.util.*;

public class ModelWrapperDisplayList implements IModelCustom
{
    private final Map<String, Integer> lists;
    private final IntBuffer bufAll;
    private final String type;

    public ModelWrapperDisplayList(final WavefrontObject model) {
        this.lists = new HashMap<String, Integer>();
        this.type = model.getType();
        int list = GL11.glGenLists(model.groupObjects.size());
        for (final GroupObject obj : model.groupObjects) {
            GL11.glNewList(list, 4864);
            model.renderPart(obj.name);
            GL11.glEndList();
            this.lists.put(obj.name, list++);
        }
        this.bufAll = this.initBuffer();
    }

    private IntBuffer initBuffer() {
        final IntBuffer buf = BufferUtils.createIntBuffer(this.lists.size());
        for (final int i : this.lists.values()) {
            buf.put(i);
        }
        buf.flip();
        return buf;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void renderAll() {
        GL11.glCallLists(this.bufAll);
    }

    @Override
    public void renderOnly(final String... groupNames) {
        if (groupNames == null || groupNames.length == 0)
            return;
        for (final String group : groupNames) {
            this.renderPart(group);
        }
    }

    @Override
    public void renderPart(final String partName) {
        final Integer list = this.lists.get(partName);
        if (list != null) {
            GL11.glCallList(list);
        }
    }

    @Override
    public void renderAllExcept(final String... groupNames) {
        if (groupNames == null || groupNames.length == 0) {
            this.renderAll();
            return;
        }
        for (final Map.Entry<String, Integer> it : this.lists.entrySet()) {
            if (Arrays.binarySearch(groupNames, it.getKey(), String::compareTo) < 0) {
                GL11.glCallList(it.getValue());
            }
        }
    }
}
