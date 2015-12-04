package greymerk.roguelike.dungeon.settings.builtin;

import java.util.ArrayList;
import java.util.List;

import greymerk.roguelike.dungeon.base.SecretFactory;
import greymerk.roguelike.dungeon.segment.Segment;
import greymerk.roguelike.dungeon.segment.SegmentGenerator;
import greymerk.roguelike.dungeon.settings.DungeonSettings;
import greymerk.roguelike.dungeon.settings.LevelSettings;
import greymerk.roguelike.dungeon.settings.SpawnCriteria;
import greymerk.roguelike.dungeon.settings.TowerSettings;
import greymerk.roguelike.dungeon.towers.Tower;
import greymerk.roguelike.theme.Theme;
import net.minecraftforge.common.BiomeDictionary;

public class SettingsTempleTheme extends DungeonSettings{
	
	public SettingsTempleTheme(){
		
		this.depth = 2;
		
		this.criteria = new SpawnCriteria();
		List<BiomeDictionary.Type> biomes = new ArrayList<BiomeDictionary.Type>();
		biomes.add(BiomeDictionary.Type.JUNGLE);
		this.criteria.setBiomeTypes(biomes);
		
		this.towerSettings = new TowerSettings(Tower.JUNGLE, Theme.getTheme(Theme.JUNGLE));
		
		Theme[] themes = {Theme.JUNGLE, Theme.MOSSY, Theme.MOSSY, Theme.MOSSY, Theme.NETHER};
		
		for(int i = 0; i < 5; ++i){
			LevelSettings level = new LevelSettings();
			level.setDifficulty(3);
			
			SegmentGenerator segments;
			segments = new SegmentGenerator(Segment.ARCH);
			segments.add(Segment.DOOR, 8);
			segments.add(Segment.FIREPLACE, 2);
			segments.add(Segment.ARROW, 1);
			segments.add(Segment.CHEST, 1);
			segments.add(Segment.JUNGLE, 3);
			segments.add(Segment.SKULL, 3);
			segments.add(Segment.SPAWNER, 2);
			segments.add(Segment.SILVERFISH, 1);
			level.setSegments(segments);
			
			level.setTheme(Theme.getTheme(themes[i]));
			
			SecretFactory secrets = new SecretFactory();
			level.setSecrets(secrets);
			
			levels.put(i, level);
		}
	}
}
