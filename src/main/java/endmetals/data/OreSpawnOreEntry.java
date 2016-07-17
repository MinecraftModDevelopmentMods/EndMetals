package endmetals.data;

public class OreSpawnOreEntry {
	private String blockID;
	private int size;
	private int variation;
	private int frequency;
	private int minHeight;
	private int maxHeight;

	public String getBlockID() {
		return blockID;
	}
	
	public void setBlockID(String s) {
		blockID = s;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int i) {
		size = i;
	}

	public int getVariation() {
		return variation;
	}

	public void setVariation(int i) {
		variation = i;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int i) {
		frequency = i;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(int i) {
		minHeight = i;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int i) {
		maxHeight = i;
	}
}
