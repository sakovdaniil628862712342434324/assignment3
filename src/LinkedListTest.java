import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import sait.sll.utility.*;

class LinkedListTest {
	private LinkedListADT linkedList;

	@BeforeEach
	void setUp() throws Exception {
		// Initialized the linked list
		this.linkedList = new SLL();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.linkedList.clear();
	}

	@Test
	void testIsEmpty() {
		assertTrue(this.linkedList.isEmpty());
		assertEquals(0, this.linkedList.size());
	}

	@Test
	void testAppendNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		assertFalse(this.linkedList.isEmpty());
		assertEquals(4, this.linkedList.size());
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("b", this.linkedList.retrieve(1));
		assertEquals("c", this.linkedList.retrieve(2));
		assertEquals("d", this.linkedList.retrieve(3));
	}

	@Test
	void testPrependNodes() {
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend("c");
		this.linkedList.prepend("d");

		assertFalse(this.linkedList.isEmpty());
		assertEquals(4, this.linkedList.size());
		assertEquals("d", this.linkedList.retrieve(0));
		assertEquals("c", this.linkedList.retrieve(1));
		assertEquals("b", this.linkedList.retrieve(2));
		assertEquals("a", this.linkedList.retrieve(3));
	}

	@Test
	void testInsertNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.insert("e", 2);

		assertFalse(this.linkedList.isEmpty());
		assertEquals(5, this.linkedList.size());
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("b", this.linkedList.retrieve(1));
		assertEquals("e", this.linkedList.retrieve(2));
		assertEquals("c", this.linkedList.retrieve(3));
		assertEquals("d", this.linkedList.retrieve(4));
	}

	@Test
	void testReplaceNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.replace("e", 2);

		assertFalse(this.linkedList.isEmpty());
		assertEquals(4, this.linkedList.size());
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("b", this.linkedList.retrieve(1));
		assertEquals("e", this.linkedList.retrieve(2));
		assertEquals("d", this.linkedList.retrieve(3));
	}

	@Test
	void testDeleteNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.delete(2);

		assertFalse(this.linkedList.isEmpty());
		assertEquals(3, this.linkedList.size());
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("b", this.linkedList.retrieve(1));
		assertEquals("d", this.linkedList.retrieve(2));
	}

	@Test
	void testFindNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);

		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);

		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
	}

	@Test
	void testInsertAtBeginningAndEnd() {
		this.linkedList.append("b");
		this.linkedList.append("c");

		// Insert at beginning
		this.linkedList.insert("a", 0);
		// Insert at end
		this.linkedList.insert("d", 3);

		assertEquals(4, this.linkedList.size());
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("d", this.linkedList.retrieve(3));
	}

	@Test
	void testDeleteFirstNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");

		this.linkedList.delete(0);

		assertEquals(1, this.linkedList.size());
		assertEquals("b", this.linkedList.retrieve(0));
	}

	@Test
	void testDeleteLastNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");

		this.linkedList.delete(2);

		assertEquals(2, this.linkedList.size());
		assertEquals("b", this.linkedList.retrieve(1));

		// Ensure tail updated properly by appending
		this.linkedList.append("d");
		assertEquals("d", this.linkedList.retrieve(2));
	}

	@Test
	void testInvalidIndexExceptions() {
		this.linkedList.append("a");

		// Test OutOfBounds on delete
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.linkedList.delete(5);
		});

		// Test OutOfBounds on retrieve
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.linkedList.retrieve(-1);
		});

		// Test OutOfBounds on insert
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.linkedList.insert("z", 2);
		});
	}

	@Test
	void testClearList() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.clear();

		assertTrue(this.linkedList.isEmpty());
		assertEquals(0, this.linkedList.size());

		// Ensure list is completely wiped and ready for new data
		this.linkedList.append("c");
		assertEquals(1, this.linkedList.size());
		assertEquals("c", this.linkedList.retrieve(0));
	}
}