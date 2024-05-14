package com.HolyLight.decor.tiles;

import net.minecraft.tileentity.*;
import net.minecraft.nbt.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
public class TileDecor extends TileEntity
{
    private int rotation;

    @Override
    public void readFromNBT(final NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.safeRead(tag);
    }

    public void safeRead(final NBTTagCompound tag) {
        this.rotation = tag.getInteger("rotation");
    }

    @Override
    public void writeToNBT(final NBTTagCompound tag) {
        super.writeToNBT(tag);
        this.safeWrite(tag);
    }

    public void safeWrite(final NBTTagCompound tag) {
        tag.setInteger("rotation", this.rotation);
    }

    @Override
    public Packet getDescriptionPacket() {
        final NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(super.xCoord, super.yCoord, super.zCoord, 5, nbttagcompound);
    }

    double d0 = 5F;

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 10D, this.yCoord + 6D, this.zCoord + 10D).expand(this.d0, this.d0, this.d0);
    }

    @Override
    public void onDataPacket(final NetworkManager net, final S35PacketUpdateTileEntity packet) {
        this.readFromNBT(packet.func_148857_g());
    }

    public void plusRotation() {
        ++this.rotation;
        ++this.rotation;
        ++this.rotation;
    }

    public int getRotation() {
        return this.rotation;
    }

}