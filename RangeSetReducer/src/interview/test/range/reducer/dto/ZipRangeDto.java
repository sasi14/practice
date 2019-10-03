package interview.test.range.reducer.dto;

public class ZipRangeDto implements Comparable<ZipRangeDto>{
	private Integer lowerRange;
	private Integer upperRange;
	
	public ZipRangeDto(Integer lr, Integer ur) {
		lowerRange = lr;
		upperRange=ur;
	}

	public Integer getLowerRange() {
		return lowerRange;
	}

	public void setLowerRange(Integer lowerRange) {
		this.lowerRange = lowerRange;
	}

	public Integer getUpperRange() {
		return upperRange;
	}

	public void setUpperRange(Integer upperRange) {
		this.upperRange = upperRange;
	}

	@Override
	public int compareTo(ZipRangeDto o) {
		int c = this.lowerRange.compareTo(o.lowerRange);
		if(c == 0) {
			return this.upperRange.compareTo(o.upperRange);
		}else {
			return c;
		}
	}

	@Override
	public String toString() {
		return "[lowerRange=" + lowerRange + ", upperRange=" + upperRange + "]";
	}

	
}
