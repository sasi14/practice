package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import interview.test.range.reducer.ZipRangeReducerService;
import interview.test.range.reducer.dto.ZipRangeDto;

/**
 * Test class for ZipRangeReducerService 
 */
public class ZipRangeReducerTest {

	ZipRangeReducerService service = new ZipRangeReducerService();

	/**
	 * Testing newMergedZipRange method with multiple values
	 */
	@Test
	public void testZipReducerMultipleDupVal() {
		List<ZipRangeDto> ranges = new ArrayList<>();
		ranges.add(new ZipRangeDto(11001, 11095));
		ranges.add(new ZipRangeDto(18001, 18009));
		ranges.add(new ZipRangeDto(11081, 12050));
		ranges.add(new ZipRangeDto(42100, 42500));
		ranges.add(new ZipRangeDto(42500, 42600));
		ranges.add(new ZipRangeDto(66611, 66615));
		ranges.add(new ZipRangeDto(66611, 66615));
		List<ZipRangeDto> ran = service.newMergedZipRange(ranges);
		assert(ran.size()==4);
	}
	
	/**
	 * Testing newMergedZipRange method with one values
	 */
	@Test
	public void testZipReducerOneValue() {
		List<ZipRangeDto> ranges = new ArrayList<>();
		ranges.add(new ZipRangeDto(66611, 66615));
		List<ZipRangeDto> range = service.newMergedZipRange(ranges);
		assert(range.size()==1);
	}
	
	/**
	 * Testing newMergedZipRange method with blank list
	 */
	@Test
	public void testZipReducerBlankValue() {
		List<ZipRangeDto> ranges = new ArrayList<>();
		List<ZipRangeDto> range = service.newMergedZipRange(ranges);
		assert(range.size()==0);
	}
	
	/**
	 * Testing newMergedZipRange method with null
	 */
	@Test
	public void testZipReduceNullValue() {
		List<ZipRangeDto> range = service.newMergedZipRange(null);
		assert(range.size()==0);
	}
	
}
