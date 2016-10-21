import static org.junit.Assert.*;

import org.junit.Test;

public class AllianceTest {

	@Test
	public void test() {
		Alliance<String> alliance = new Alliance<String>();
		alliance.create("a");
		alliance.create("a");

		alliance.create("b");
		alliance.create("c");
		alliance.create("d");
		alliance.create("e");
		alliance.create("f");
		alliance.create("g");
		alliance.oppose("a", "b");
		alliance.oppose("a", "c");
		alliance.oppose("b", "x");
		alliance.oppose("b", "y");
		alliance.oppose("y", "b");
		alliance.oppose("y", "z");
		//alliance.oppose("c", "t");
		assertEquals(false, alliance.opponents("a", "a"));
		assertEquals(true, alliance.opponents("a", "z"));
		assertEquals(true, alliance.opponents("a", "c"));
		assertEquals(true, alliance.opponents("a", "b"));
		assertEquals(false, alliance.opponents("a", "x"));
		assertEquals(false, alliance.opponents("a", "y"));
		//assertEquals(false, alliance.opponents("y", "t"));

	}

}
