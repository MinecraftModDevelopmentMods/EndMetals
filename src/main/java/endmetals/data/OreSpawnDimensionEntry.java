package endmetals.data;

import java.util.List;

public class OreSpawnDimensionEntry {

	private int dimension;
	private String __comment;
	private List<OreSpawnOreEntry> ores;

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int i) {
		dimension = i;
	}

	public String get__comment() {
		return __comment;
	}
	
	public void set__comment(String s) {
		__comment = s;
	}

	public List<OreSpawnOreEntry> getOres() {
		return ores;
	}

	public void setOres(List<OreSpawnOreEntry> l) {
		ores = l;
	}
}
