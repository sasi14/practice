package interview.test.range.reducer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import interview.test.range.reducer.dto.ZipRangeDto;

public class ZipRangeReducerService {

	/**
	 * Its takes list of range and return reduced range
	 * @logic Since it is a set of zipcode so it will be of 5 digit and the range will not have much gap,
	 * 		So Iterating through each range, makes a list of all zip code with duplicate values
	 * 			and then loop to find new range by checking consecutive zip
	 * @param ranges
	 * @return  List<ZipRangeDto>
	 */
	public List<ZipRangeDto> newMergedZipRange(List<ZipRangeDto> ranges) {
		List<Integer> allZips = new ArrayList<>();
		List<ZipRangeDto> mergedZips = new ArrayList<>();
		if (null != ranges && ranges.size()>0) {		//check for input list if it blank or null
			for (int i = 0; i < ranges.size(); i++) {
				ZipRangeDto zip1 = ranges.get(i);
				// Adding all zip in all range to one list
				IntStream.range(zip1.getLowerRange(), zip1.getUpperRange() + 1).forEach(z -> allZips.add(z));
			}
			// sorting allZip list
			Collections.sort(allZips);
			int initIndex = 0;
			for (int j = 0; j < allZips.size() - 1; j++) {
				//finding all consecutive number in zip
				if (allZips.get(j).equals(allZips.get(j + 1)) || allZips.get(j + 1).equals(allZips.get(j) + 1)) {
					continue;
				}
				// Adding all begin and end of consecutive codes
				mergedZips.add(new ZipRangeDto(allZips.get(initIndex), allZips.get(j)));
				initIndex = j + 1;
			}
			mergedZips.add(new ZipRangeDto(allZips.get(initIndex), allZips.get(allZips.size() - 1)));
		}
		return mergedZips;

	}

}
