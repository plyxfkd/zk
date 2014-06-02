
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGame {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void testliveofneiberhood() {
		Block block =new Block();
		
		org.junit.Assert.assertTrue(block.livetonextday(3));
		org.junit.Assert.assertTrue(block.livetonextday(2));
		org.junit.Assert.assertFalse(block.livetonextday(5));
		org.junit.Assert.assertFalse(block.livetonextday(1)); 
	}	
	
	@Test 
	public void testdeadofneiberhood() {
		Block block =new Block();
		
		org.junit.Assert.assertTrue(block.deadtonextday(3));
		org.junit.Assert.assertFalse(block.deadtonextday(5));
		org.junit.Assert.assertFalse(block.deadtonextday(1)); 
	}
	
	@Test 
	public void testnumofneibor() {
		Block block =new Block();		
		org.junit.Assert.assertEquals(4, block.getneibor(2,2));
	}
		
	@Test 
	public void testshowblock() {
		
		//surround the bllock by zero
		int[][] a = {
				{0,0,0,0,0},
				{0,1,1,1,0},
				{0,0,1,0,0},
				{0,1,0,1,0},
				{0,0,0,0,0}
		};
		int [][] result={
				{0,0,0,0,0},
				{0,1,1,1,0},
				{0,0,0,0,0},
				{0,0,1,0,0},
				{0,0,0,0,0}
		};		
		Block block =new Block(a,3,3);
		
		org.junit.Assert.assertArrayEquals(result, block.showBlock(a));
	}
}