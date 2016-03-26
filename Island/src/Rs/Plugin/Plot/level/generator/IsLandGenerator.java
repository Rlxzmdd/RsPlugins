package Rs.Plugin.Plot.level.generator;

import cn.nukkit.block.Block;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.format.generic.BaseFullChunk;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.level.generator.object.ore.OreType;
import cn.nukkit.level.generator.populator.Populator;
import cn.nukkit.level.generator.populator.PopulatorOre;
import cn.nukkit.math.NukkitRandom;
import cn.nukkit.math.Vector3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsLandGenerator extends Generator {

    @Override
    public int getId() {
        return 5;
    }

    private ChunkManager level;

    private BaseFullChunk chunk;

    private NukkitRandom random;

    private List<Populator> populators = new ArrayList<>();

   // private int[][] structure;

    private Map<String, Object> options;

    //private int floorLevel;

   // private String preset;

    @Override
    public ChunkManager getChunkManager() {
        return level;
    }

    @Override
    public Map<String, Object> getSettings() {
        return this.options;
    }

    @Override
    public String getName() {
        return "island";
    }

    public IsLandGenerator() {
        this(new HashMap<>());
    }

    public IsLandGenerator(Map<String, Object> options) {
        this.options = options;
        this.chunk = null;

        if (this.options.containsKey("decoration")) {
            PopulatorOre ores = new PopulatorOre();
            ores.setOreTypes(new OreType[]{
                    //new OreType(new CoalOre(), 20, 16, 0, 128),
                   // new OreType(new IronOre(), 20, 8, 0, 64),
                   // new OreType(new RedstoneOre(), 8, 7, 0, 16),
                   // new OreType(new LapisOre(), 1, 6, 0, 32),
                   // new OreType(new GoldOre(), 2, 8, 0, 32),
                    //new OreType(new DiamondOre(), 1, 7, 0, 16),
                    //new OreType(new Dirt(), 20, 32, 0, 128),
                    //new OreType(new Gravel(), 20, 16, 0, 128),
            });
            this.populators.add(ores);
        }
    }
    /**
     * z
     * 7  &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     * 6  &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     * 5  &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     * 4  &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     * 3  &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     * 2  &  &  &  &  &  &  X  X   X  X  &  &  &  &  &  &
     * 1  &  &  &  &  &  X  X  s   s  X  X  &  &  &  &  &
     * 0  &  &  &  &  &  X  s  o   o  s  X  &  &  &  &  &
     *	  x < 9 ,z > 8             x > 8 , z > 8
     *	  1:2                      2:2
     * 15 &  &  &  &  &  X  s  o   o  s  X  &  &  &  &  &
     * 14 &  &  &  &  &  X  X  s   s  X  X  &  &  &  &  &
     * 13 &  &  &  &  &  &  X  X   X  X  &  &  &  &  &  &
     * 12 &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     * 11 &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     * 10 &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     *  9 &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     *  8 &  &  &  &  &  &  &  &   &  &  &  &  &  &  &  &
     *	  8  9 10 11 12 13 14 15   0  1  2  3  4  5  6  7  x
     *	  x < 9 ,z < 9             x > 8 , z < 9
     *	  1:1                      2:1
     **/
    @Override
    public void init(ChunkManager level, NukkitRandom random) {
        this.level = level;
        this.random = random;
    }

    @Override
    public void generateChunk(int chunkX, int chunkZ) {
        int CX = (chunkX % 4) < 0 ? ((chunkX % 4)+4) : (chunkX % 4);
            int CZ = (chunkZ % 4) < 0 ? ((chunkZ % 4)+4) : (chunkZ % 4);
           // System.out.print(chunkX+":"+chunkZ+"...");
            String asd = CX+":"+CZ;
            this.chunk = this.level.getChunk(chunkX, chunkZ).clone();
        int x;
        int z;
        int y;
        for (x = 0; x < 16; x++) {
            for(z = 0;z< 16;z++) {
                this.chunk.setBiomeColor(x, z, 51, 255, 102);
                for (y = 0; y < 128; ++y) {
                    this.chunk.setBlock(x, y, z, 0);
                }
                for (y = 0; y < 80; ++y) {
                    if (asd.equals("1:1")) {
                        chunk.setBlock(x, y, z, 2);
                    } else if (asd.equals("2:1")) {
                        chunk.setBlock(x, y, z, 2);
                    } else if (asd.equals("1:2")) {
                        chunk.setBlock(x, y, z, 2);
                    } else if (asd.equals("2:2")) {
                        chunk.setBlock(x, y, z, 2);
                    }
                }

            }
        }
            /*if(asd.equals("1:1")){
                //this.chunk.setBlock(15,63,15,7);
                //this.chunk.setBlock(15,64,15,2);
                //this.chunk.setBlock(14,64,14,1);
                //this.chunk.setBlock(14,63,14,11);
            }else if(asd.equals("2:1")){
               // this.chunk.setBlock(0,63,15,7);
                //this.chunk.setBlock(0,64,15,2);
               // this.chunk.setBlock(1,64,14,1);
                //this.chunk.setBlock(1,63,14,11);
                generate2a1(chunk,0,64,11);
               // new OakTree().placeObject(this.level, 64 * chunkX + 0, 64, 64 * chunkZ+15, new NukkitRandom(233));
            }else if(asd.equals("1:2")){
               // this.chunk.setBlock(15,63,0,7);
                //this.chunk.setBlock(15,64,0,2);
                //this.chunk.setBlock(14,64,1,1);
                //this.chunk.setBlock(14,63,1,11);
                generate1a2(chunk,11,64,0);
            }else if(asd.equals("2:2")){
                //this.chunk.setBlock(0,63,0,7);
                //this.chunk.setBlock(0,64,0,2);
                //this.chunk.setBlock(1,64,1,1);
                //this.chunk.setBlock(1,63,1,11);
                generate2a2(chunk, 0, 64, 0);
            }*/
        BaseFullChunk chunk = this.chunk.clone();
        chunk.setX(chunkX);
        chunk.setZ(chunkZ);
        this.level.setChunk(chunkX, chunkZ, chunk);
    }

    /*public void generate1a2(BaseFullChunk world, int i, int j, int k) {
        //youshang
        world.setBlock(i + 0, j + 4, k + 0, Block.GRASS);
        //world.setBlock(i + 0, j + 12, k + 4, Block.LEAVES, 12);
        world.setBlock(i + 1, j + 3, k + 0, Block.DIRT);
        world.setBlock(i + 1, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 1, j + 4, k + 1, Block.GRASS);
        world.setBlock(i + 2, j + 2, k + 0, Block.DIRT);
        world.setBlock(i + 2, j + 3, k + 0, Block.DIRT);
        world.setBlock(i + 2, j + 3, k + 1, Block.DIRT);
        world.setBlock(i + 2, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 2, j + 4, k + 1, Block.DIRT, 7);
        world.setBlock(i + 2, j + 4, k + 2, Block.GRASS);
        world.setBlock(i + 2, j + 9, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 9, k + 1, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 10, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 10, k + 1, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 10, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 1, k + 0, Block.DIRT);
        world.setBlock(i + 3, j + 2, k + 0, Block.STONE);
        world.setBlock(i + 3, j + 2, k + 1, Block.DIRT);
        world.setBlock(i + 3, j + 3, k + 1, Block.DIRT);
        world.setBlock(i + 3, j + 3, k + 2, Block.DIRT);
        world.setBlock(i + 3, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 3, j + 4, k + 1, Block.DIRT);
        world.setBlock(i + 3, j + 4, k + 2, Block.DIRT);
        world.setBlock(i + 3, j + 4, k + 3, Block.GRASS);
        world.setBlock(i + 3, j + 5, k + 1, Block.DIRT);
        world.setBlock(i + 3, j + 6, k + 1, Block.WOOD);
        world.setBlock(i + 3, j + 7, k + 1, Block.WOOD);
        world.setBlock(i + 3, j + 8, k + 1, Block.WOOD);
        world.setBlock(i + 3, j + 9, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 9, k + 1, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 10, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 10, k + 1, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 10, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 11, k + 0, Block.LEAVES, 4);
        world.setBlock(i + 3, j + 11, k + 1, Block.LEAVES, 4);
        world.setBlock(i + 4, j + 0, k + 0, Block.BEDROCK);
        world.setBlock(i + 4, j + 1, k + 0, Block.STONE);
        world.setBlock(i + 4, j + 1, k + 1, Block.DIRT);
        world.setBlock(i + 4, j + 2, k + 0, Block.IRON_ORE);
        world.setBlock(i + 4, j + 2, k + 1, Block.STONE);
        world.setBlock(i + 4, j + 2, k + 2, Block.DIRT);
        world.setBlock(i + 4, j + 3, k + 2, Block.DIRT);
        world.setBlock(i + 4, j + 3, k + 3, Block.DIRT);
        world.setBlock(i + 4, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 1, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 2, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 3, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 4, j + 9, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 4, j + 9, k + 1, Block.LEAVES, 12);
        world.setBlock(i + 4, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 4, j + 10, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 4, j + 10, k + 1, Block.LEAVES, 12);
        world.setBlock(i + 4, j + 10, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 4, j + 11, k + 0, Block.LEAVES, 4);
        world.setBlock(i + 4, j + 11, k + 1, Block.LEAVES, 4);
        world.setBlock(i + 4, j + 12, k + 0, Block.LEAVES, 4);
        //world.setBlock(i + 2, j + 5, k + 1, Block.crops, 7);
        world.setBlock(i + 3, j + 3, k + 0, Block.SAND);
        //world.setBlock(i + 3, j + 5, k + 0, Block.tallGrass, 1);
        //world.setBlock(i + 3, j + 5, k + 2, Block.crops, 7);
        world.setBlock(i + 4, j + 3, k + 0, Block.SAND);
        world.setBlock(i + 4, j + 3, k + 1, Block.SAND);
        //world.setBlock(i + 4, j + 5, k + 0, Block.tallGrass, 1);
        //world.setBlock(i + 4, j + 5, k + 1, Block.tallGrass, 1);
    }

    public void generate1a1(BaseFullChunk world, int i, int j, int k) {
        //youxia
        world.setBlock(i + 0, j + 4, k + 4, Block.GRASS);
       // world.setBlock(i + 0, j + 12, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 1, j + 3, k + 4, Block.DIRT);
        world.setBlock(i + 1, j + 4, k + 3, Block.GRASS);
        world.setBlock(i + 1, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 2, j + 2, k + 4, Block.DIRT);
        world.setBlock(i + 2, j + 3, k + 3, Block.DIRT);
        world.setBlock(i + 2, j + 3, k + 4, Block.DIRT);
        world.setBlock(i + 2, j + 4, k + 2, Block.GRASS);
        world.setBlock(i + 2, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 2, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 9, k + 3, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 9, k + 4, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 10, k + 2, Block.LEAVES, 4);
        world.setBlock(i + 2, j + 10, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 2, j + 10, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 3, j + 1, k + 4, Block.DIRT);
        world.setBlock(i + 3, j + 2, k + 3, Block.DIRT);
        world.setBlock(i + 3, j + 2, k + 4, Block.STONE);
        world.setBlock(i + 3, j + 3, k + 2, Block.DIRT);
        world.setBlock(i + 3, j + 3, k + 3, Block.DIRT);
        world.setBlock(i + 3, j + 4, k + 1, Block.GRASS);
        world.setBlock(i + 3, j + 4, k + 3, Block.DIRT);
        world.setBlock(i + 3, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 3, j + 5, k + 3, Block.GRASS);
        world.setBlock(i + 3, j + 6, k + 3, Block.WOOD);
        world.setBlock(i + 3, j + 7, k + 3, Block.WOOD);
        world.setBlock(i + 3, j + 8, k + 3, Block.WOOD);
        world.setBlock(i + 3, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 9, k + 3, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 9, k + 4, Block.LEAVES, 12);
        world.setBlock(i + 3, j + 10, k + 2, Block.LEAVES, 4);
        world.setBlock(i + 3, j + 10, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 3, j + 10, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 3, j + 11, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 3, j + 11, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 4, j + 0, k + 4, Block.BEDROCK);
        world.setBlock(i + 4, j + 1, k + 3, Block.DIRT);
        world.setBlock(i + 4, j + 1, k + 4, Block.STONE);
        world.setBlock(i + 4, j + 2, k + 2, Block.DIRT);
        world.setBlock(i + 4, j + 2, k + 3, Block.STONE);
        world.setBlock(i + 4, j + 2, k + 4, Block.IRON_ORE);
        world.setBlock(i + 4, j + 3, k + 1, Block.DIRT);
        world.setBlock(i + 4, j + 3, k + 2, Block.DIRT);
        world.setBlock(i + 4, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 1, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 2, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 3, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 4, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 4, j + 9, k + 3, Block.LEAVES, 12);
        world.setBlock(i + 4, j + 9, k + 4, Block.LEAVES, 12);
        world.setBlock(i + 4, j + 10, k + 2, Block.LEAVES, 4);
        world.setBlock(i + 4, j + 10, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 4, j + 10, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 4, j + 11, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 4, j + 11, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 4, j + 12, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 5, k + 3, Block.REEDS, 5);
        world.setBlock(i + 2, j + 4, k + 3, Block.STILL_WATER);
        world.setBlock(i + 2, j + 5, k + 2, Block.REEDS, 1);
        world.setBlock(i + 3, j + 3, k + 4, Block.SAND);
        world.setBlock(i + 3, j + 4, k + 2, Block.STILL_WATER);
        world.setBlock(i + 3, j + 5, k + 1, Block.REEDS, 1);
        //world.setBlock(i + 3, j + 5, k + 4, Block.plantYellow);
        world.setBlock(i + 4, j + 3, k + 3, Block.SAND);
        world.setBlock(i + 4, j + 3, k + 4, Block.SAND);
       // world.setBlock(i + 4, j + 5, k + 3, Block.tallGrass, 1);
        //world.setBlock(i + 4, j + 5, k + 4, Block.tallGrass, 1);
    }

    public void generate2a2(BaseFullChunk world, int i, int j, int k) {
       // zuoshang
        world.setBlock(i + 0, j + 0, k + 0, Block.BEDROCK);
        world.setBlock(i + 0, j + 1, k + 0, Block.STONE);
        world.setBlock(i + 0, j + 1, k + 1, Block.DIRT);
        world.setBlock(i + 0, j + 2, k + 0, Block.IRON_ORE);
        world.setBlock(i + 0, j + 2, k + 1, Block.STONE);
        world.setBlock(i + 0, j + 2, k + 2, Block.DIRT);
        world.setBlock(i + 0, j + 3, k + 2, Block.DIRT);
        world.setBlock(i + 0, j + 3, k + 3, Block.DIRT);
        world.setBlock(i + 0, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 0, j + 4, k + 1, Block.GRASS);
        world.setBlock(i + 0, j + 4, k + 2, Block.GRASS);
        world.setBlock(i + 0, j + 4, k + 3, Block.GRASS);
        world.setBlock(i + 0, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 0, j + 9, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 0, j + 9, k + 1, Block.LEAVES, 12);
        world.setBlock(i + 0, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 0, j + 10, k + 0, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 10, k + 1, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 10, k + 2, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 11, k + 0, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 11, k + 1, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 12, k + 0, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 1, k + 0, Block.DIRT);
        world.setBlock(i + 1, j + 2, k + 0, Block.STONE);
        world.setBlock(i + 1, j + 2, k + 1, Block.DIRT);
        world.setBlock(i + 1, j + 3, k + 1, Block.DIRT);
        world.setBlock(i + 1, j + 3, k + 2, Block.GRASS);
        world.setBlock(i + 1, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 1, j + 4, k + 1, Block.DIRT);
        world.setBlock(i + 1, j + 4, k + 3, Block.GRASS);
        world.setBlock(i + 1, j + 5, k + 1, Block.DIRT);
        world.setBlock(i + 1, j + 6, k + 1, Block.WOOD);
        world.setBlock(i + 1, j + 7, k + 1, Block.WOOD);
        world.setBlock(i + 1, j + 8, k + 1, Block.WOOD);
        world.setBlock(i + 1, j + 9, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 1, j + 9, k + 1, Block.LEAVES, 12);
        world.setBlock(i + 1, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 1, j + 10, k + 0, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 10, k + 1, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 10, k + 2, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 11, k + 0, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 11, k + 1, Block.LEAVES, 4);
        world.setBlock(i + 2, j + 2, k + 0, Block.DIRT);
        world.setBlock(i + 2, j + 3, k + 0, Block.DIRT);
        world.setBlock(i + 2, j + 3, k + 1, Block.GRASS);
        world.setBlock(i + 2, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 2, j + 4, k + 2, Block.GRASS);
        world.setBlock(i + 2, j + 9, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 9, k + 1, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 10, k + 0, Block.LEAVES, 4);
        world.setBlock(i + 2, j + 10, k + 1, Block.LEAVES, 4);
        world.setBlock(i + 2, j + 10, k + 2, Block.LEAVES, 4);
        world.setBlock(i + 3, j + 3, k + 0, Block.DIRT);
        world.setBlock(i + 3, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 3, j + 4, k + 1, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 0, Block.GRASS);
        //world.setBlock(i + 4, j + 12, k + 4, Block.LEAVES, 12);
        world.setBlock(i + 0, j + 3, k + 0, Block.SAND);
        world.setBlock(i + 0, j + 3, k + 1, Block.SAND);
        //world.setBlock(i + 0, j + 5, k + 0, Block.tallGrass, 1);
        //world.setBlock(i + 0, j + 5, k + 1, Block.tallGrass, 1);
        world.setBlock(i + 1, j + 3, k + 0, Block.SAND);
        world.setBlock(i + 1, j + 4, k + 2, Block.STILL_LAVA);
       // world.setBlock(i + 1, j + 5, k + 0, Block.tallGrass, 1);
        world.setBlock(i + 2, j + 4, k + 1, Block.STILL_LAVA);
    }

    public void generate2a1(BaseFullChunk world, int i, int j, int k) {
        world.setBlock(i + 0, j + 0, k + 4, Block.BEDROCK);
        world.setBlock(i + 0, j + 1, k + 3, Block.DIRT);
        world.setBlock(i + 0, j + 1, k + 4, Block.STONE);
        world.setBlock(i + 0, j + 2, k + 2, Block.DIRT);
        world.setBlock(i + 0, j + 2, k + 3, Block.STONE);
        world.setBlock(i + 0, j + 2, k + 4, Block.IRON_ORE);
        world.setBlock(i + 0, j + 3, k + 1, Block.DIRT);
        world.setBlock(i + 0, j + 3, k + 2, Block.DIRT);
        world.setBlock(i + 0, j + 4, k + 0, Block.GRASS);
        world.setBlock(i + 0, j + 4, k + 1, Block.GRASS);
        world.setBlock(i + 0, j + 4, k + 2, Block.GRASS);
        world.setBlock(i + 0, j + 4, k + 3, Block.GRASS);
        world.setBlock(i + 0, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 0, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 0, j + 9, k + 3, Block.LEAVES, 12);
        world.setBlock(i + 0, j + 9, k + 4, Block.LEAVES, 12);
        world.setBlock(i + 0, j + 10, k + 2, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 10, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 10, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 11, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 11, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 0, j + 12, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 1, k + 4, Block.DIRT);
        world.setBlock(i + 1, j + 2, k + 3, Block.DIRT);
        world.setBlock(i + 1, j + 2, k + 4, Block.STONE);
        world.setBlock(i + 1, j + 3, k + 2, Block.DIRT);
        world.setBlock(i + 1, j + 3, k + 3, Block.DIRT);
        world.setBlock(i + 1, j + 4, k + 1, Block.GRASS);
        world.setBlock(i + 1, j + 4, k + 2, Block.GRASS);
        world.setBlock(i + 1, j + 4, k + 3, Block.DIRT);
        world.setBlock(i + 1, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 1, j + 5, k + 3, Block.GRASS);
        world.setBlock(i + 1, j + 6, k + 3, Block.WOOD);
        world.setBlock(i + 1, j + 7, k + 3, Block.WOOD);
        world.setBlock(i + 1, j + 8, k + 3, Block.WOOD);
        world.setBlock(i + 1, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 1, j + 9, k + 3, Block.LEAVES, 12);
        world.setBlock(i + 1, j + 9, k + 4, Block.LEAVES, 12);
        world.setBlock(i + 1, j + 10, k + 2, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 10, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 10, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 11, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 1, j + 11, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 2, j + 2, k + 4, Block.DIRT);
        world.setBlock(i + 2, j + 3, k + 3, Block.DIRT);
        world.setBlock(i + 2, j + 3, k + 4, Block.DIRT);
        world.setBlock(i + 2, j + 4, k + 2, Block.GRASS);
        world.setBlock(i + 2, j + 4, k + 3, Block.GRASS);
        world.setBlock(i + 2, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 2, j + 9, k + 2, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 9, k + 3, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 9, k + 4, Block.LEAVES, 12);
        world.setBlock(i + 2, j + 10, k + 2, Block.LEAVES, 4);
        world.setBlock(i + 2, j + 10, k + 3, Block.LEAVES, 4);
        world.setBlock(i + 2, j + 10, k + 4, Block.LEAVES, 4);
        world.setBlock(i + 3, j + 3, k + 4, Block.DIRT);
        world.setBlock(i + 3, j + 4, k + 3, Block.GRASS);
        world.setBlock(i + 3, j + 4, k + 4, Block.GRASS);
        world.setBlock(i + 4, j + 4, k + 4, Block.GRASS);
        //world.setBlock(i + 4, j + 12, k + 0, Block.LEAVES, 12);
        world.setBlock(i + 0, j + 3, k + 3, Block.SAND);
        world.setBlock(i + 0, j + 3, k + 4, Block.SAND);
       //world.setBlock(i + 0, j + 5, k + 4, Block.tallGrass, 1);
        world.setBlock(i + 1, j + 3, k + 4, Block.SAND);
       // world.setBlock(i + 1, j + 5, k + 2, Block.pumpkinStem, 7);
       // world.setBlock(i + 1, j + 5, k + 4, Block.tallGrass, 1);
       // world.setBlock(i + 2, j + 5, k + 3, Block.melonStem, 7);
       // world.setBlock(i + 2, j + 5, k + 4, Block.tallGrass, 1);

       // return true;
    }*/
    @Override
    public void populateChunk(int chunkX, int chunkZ) {
        this.random.setSeed(0xdeadbeef ^ (chunkX << 8) ^ chunkZ ^ this.level.getSeed());
        for (Populator populator : this.populators) {
            populator.populate(this.level, chunkX, chunkZ, this.random);
        }
    }

    @Override
    public Vector3 getSpawn() {
        return new Vector3(16, 65, 0);
    }
}
