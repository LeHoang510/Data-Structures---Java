package pkg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TDoubleLinkListTest {
    TDoubleLinkList<Integer> doubleLinkList;

    @BeforeEach
    void setUp() {
        this.doubleLinkList = new TDoubleLinkList<>();
    }

    @Test
    void isNullWhenEmpty() {
        assertTrue(this.doubleLinkList.isNull());
    }

    @Test
    void isNullWhenNotEmpty() throws TException {
        this.doubleLinkList.addRight(510);
        assertFalse(this.doubleLinkList.isNull());
    }

    @Test
    void removeWithNextValue() throws TException {
        this.doubleLinkList.addRight(510);
        this.doubleLinkList.addRight(105);
        this.doubleLinkList.prev();
        this.doubleLinkList.remove();
        assertEquals(105, this.doubleLinkList.currentValue());
    }

    @Test
    void removeWithPrevValue() throws TException {
        this.doubleLinkList.addRight(510);
        this.doubleLinkList.addRight(105);
        this.doubleLinkList.addRight(111);
        this.doubleLinkList.prev();
        this.doubleLinkList.remove();
        this.doubleLinkList.prev();
        assertEquals(510, this.doubleLinkList.currentValue());
    }

    @Test
    void nextPrevValue() throws TException {
        this.doubleLinkList.addRight(510);
        this.doubleLinkList.addRight(105);
        this.doubleLinkList.addRight(111);
        this.doubleLinkList.prev();
        this.doubleLinkList.next();
        assertEquals(111, this.doubleLinkList.currentValue());
    }

    @Test
    void prevNextValue() throws TException {
        this.doubleLinkList.addRight(510);
        this.doubleLinkList.addRight(105);
        this.doubleLinkList.addRight(111);
        this.doubleLinkList.toHead();
        this.doubleLinkList.next();
        this.doubleLinkList.prev();
        assertEquals(510, this.doubleLinkList.currentValue());
    }

    @Test
    void isOutNextToTail() throws TException {
        this.doubleLinkList.addRight(510);
        this.doubleLinkList.addRight(105);
        this.doubleLinkList.addRight(111);
        this.doubleLinkList.toTail();
        this.doubleLinkList.next();
        assertTrue(this.doubleLinkList.isOut());
    }

    @Test
    void isOutPrevHead() throws TException {
        this.doubleLinkList.addRight(510);
        this.doubleLinkList.addRight(105);
        this.doubleLinkList.addRight(111);
        this.doubleLinkList.toHead();
        this.doubleLinkList.prev();
        assertTrue(this.doubleLinkList.isOut());
    }

    @Test
    void isOutNew() {
        assertTrue(this.doubleLinkList.isOut());
    }

    @Test
    void isOutToHeadAddRight() throws TException {
        this.doubleLinkList.addRight(510);
        this.doubleLinkList.toHead();
        assertFalse(this.doubleLinkList.isOut());
    }

    @Test
    void isOutToTailAddRight() throws TException {
        this.doubleLinkList.addRight(510);
        this.doubleLinkList.toTail();
        assertFalse(this.doubleLinkList.isOut());
    }

    @Test
    void isOutAddRight() throws TException {
        this.doubleLinkList.addRight(510);
        assertFalse(this.doubleLinkList.isOut());
    }

    @Test
    void valAddRight() throws TException {
        this.doubleLinkList.addRight(510);
        assertEquals(510, this.doubleLinkList.currentValue());
    }

    @Test
    void valPrevAddRight() throws TException {
        this.doubleLinkList.addRight(510);
        this.doubleLinkList.addRight(105);
        this.doubleLinkList.prev();
        assertEquals(510, this.doubleLinkList.currentValue());
    }
}
