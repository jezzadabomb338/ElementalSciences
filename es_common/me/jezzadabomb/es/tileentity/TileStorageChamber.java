package me.jezzadabomb.es.tileentity;

import me.jezzadabomb.es.lib.BlockIds;

public class TileStorageChamber extends TileES {

    public boolean isValidMultiblock = false;

    public TileStorageChamber() {
    }

    public boolean getIsValid() {
        return isValidMultiblock;
    }

    public void invalidateMultiblock() {
        isValidMultiblock = false;
        revertDummies();
    }

    public void validateMultiblock(){
        isValidMultiblock = true;
        
        convertDummies();
    }
    public void convertDummies() {
        for (int x = -1; x <= 1; ++x) {
            for (int z = -1; z <= 1; ++z) {
                for (int y = -1; y <= 1; ++y) {
                    int x2 = xCoord + x;
                    int z2 = zCoord + z;
                    int y2 = yCoord + y;
                    System.out.println(x);
                    System.out.println(z);
                    System.out.println(y);

                    int blockId = worldObj.getBlockId(x2, y2, z2);
                    int meta = worldObj.getBlockMetadata(x2, y2, z2);
                    if (x == 0 && z == 0 && y == 0) {
                        continue;
                    }
                    if (x == -1 && z == 0 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 4, 3);
                        System.out.println("Set Core");
                        setPowerCore(x2,y2,z2);
                    } else if (x == 1 && z == 0 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 5, 3);
                        setPowerCore(x2,y2,z2);
                    } else if (x == 0 && z == -1 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 2, 3);
                        setPowerCore(x2,y2,z2);
                    } else if (x == 0 && z == 1 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 3, 3);
                        setPowerCore(x2,y2,z2);
                    } else if (x == 0 && z == 0 && y == -1) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 0, 3);
                        setPowerCore(x2,y2,z2);
                    } else if (x == 0 && z == 0 && y == 1) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 1, 3);
                        setPowerCore(x2,y2,z2);
                    } else {
                        int meta2 = worldObj.getBlockMetadata(x2, y2, z2);
                        worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DUMMY_DEFAULT, meta2, 2);
                        setDummyCore(x2, y2, z2);
                    }
                }
            }
        }
    }

    public void setDummyCore(int x, int y, int z) {
        TileChamberDummy dummyTE = (TileChamberDummy) worldObj.getBlockTileEntity(x, y, z);
        if (dummyTE != null) {
            dummyTE.setCore(this);
        }
    }

    public void setPowerCore(int x, int y, int z) {
        TilePowerEmitter dummy = (TilePowerEmitter) worldObj.getBlockTileEntity(x, y, z);
        if (dummy != null) {
            dummy.setCore(this);
        }
    }

    public void revertDummies() {
        for (int x = -1; x <= 1; ++x) {
            for (int z = -1; z <= 1; ++z) {
                for (int y = -1; y <= 1; ++y) {
                    int x2 = xCoord + x;
                    int z2 = zCoord + z;
                    int y2 = yCoord + y;
                    System.out.println(x);
                    System.out.println(z);
                    System.out.println(y);

                    int blockId = worldObj.getBlockId(x2, y2, z2);
                    int meta = worldObj.getBlockMetadata(x2, y2, z2);
                    if (x == 0 && z == 0 && y == 0) {
                        continue;
                    }
                    if (x == -1 && z == 0 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                    } else if (x == 1 && z == 0 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                    } else if (x == 0 && z == -1 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                    } else if (x == 0 && z == 1 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                    } else if (x == 0 && z == 0 && y == -1) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                    } else if (x == 0 && z == 0 && y == 1) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                    } else {
                        int meta2 = worldObj.getBlockMetadata(x2, y2, z2);
                        worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, meta2, 2);
                    }
                }
            }
        }
    }

    public boolean checkIfProperlyFormed() {

        for (int x = -1; x <= 1; ++x) {
            for (int z = -1; z <= 1; ++z) {
                for (int y = -1; y <= 1; ++y) {
                    int x2 = xCoord + x;
                    int z2 = zCoord + z;
                    int y2 = yCoord + y;
                    System.out.println(x);
                    System.out.println(z);
                    System.out.println(y);

                    int blockId = worldObj.getBlockId(x2, y2, z2);
                    int meta = worldObj.getBlockMetadata(x2, y2, z2);
                    System.out.println("ID: " + blockId + ". META: " + meta + ". XCOORD: " + x2 + ". ZCOORD: " + z2 + " . YCOORD: " + y2);
                    if (x == 0 && z == 0 && y == 0) {
                        continue;
                    }
                    if (blockId == BlockIds.CHAMBER_BLOCK_DEFAULT) {
                        continue;
                    } else {
                        System.out.println("Broken!");
                        return false;
                    }
                }
            }
        }

        return true;
    }

    @Override
    public void updateEntity() {
         if(getIsValid()){ return; }
         System.out.println("Testing");
         if (checkIfProperlyFormed()) {
             validateMultiblock();
         }
    }
}