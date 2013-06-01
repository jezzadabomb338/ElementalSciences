package me.jezzadabomb.es.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.tileentity.TileScannerPad;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockScannerPad extends BlockES implements ITileEntityProvider{

    public int BlockID;
    
    @SideOnly(Side.CLIENT)
    private Icon pad_top;
    @SideOnly(Side.CLIENT)
    private Icon pad_side;
    @SideOnly(Side.CLIENT)
    private Icon pad_bottom;
    
    public BlockScannerPad(int BlockID, String BlockName)
    {
        super(BlockID, Material.wood);
        setHardness(2.0f);
        setResistance(5.0f);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.250F, 1.0F);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName(BlockName);
        this.BlockID = BlockID;
    }
    
    public TileEntity createNewTileEntity(World world)
    {
       return new TileScannerPad();
    }
    
    public boolean isOpaqueCube() //Tells the game if the block is transparent
    {
             return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (!world.isRemote)
        {   
            if (entity instanceof EntityPlayer){
                world.setBlock(x, y, z, ModBlocks.scannerPad_on.blockID);
            }
        }
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.pad_top = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2() + "_top");
        this.pad_side = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2() + "_side");
        this.pad_bottom = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2() + "_bottom");
    }
    
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par1 == 1 ? this.pad_top : (par1 == 0 ? this.pad_bottom : this.pad_side);
    }
}
