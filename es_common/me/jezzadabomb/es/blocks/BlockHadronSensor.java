package me.jezzadabomb.es.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.blocks.BlockPipeComponent.PipeComponent;
import me.jezzadabomb.es.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockHadronSensor extends BlockES implements PipeComponent {

    public Icon top;
    public Icon other;
    
    public BlockHadronSensor(int id, String name) {
        super(id, Material.anvil);
        setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        if(side == 1){
            return top;
        }else{
            return other;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        top = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_top");
        other = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")));
    }
    
    @Override
    public PipeComponentType getIonComponentType() {
        return PipeComponentType.CONTROLLER;
    }

    @Override
    public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side) {
        if(side == 1){
            return false;
        }
        return true;
    }

}