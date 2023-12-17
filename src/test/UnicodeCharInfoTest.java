import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnicodeCharInfoTest {
    private static UnicodeCharInfo one=new UnicodeCharInfo('0');
    private static UnicodeCharInfo two=new UnicodeCharInfo('N');
    private static UnicodeCharInfo three=new UnicodeCharInfo('z');
    private static UnicodeCharInfo four=new UnicodeCharInfo('Ж');
    private static UnicodeCharInfo five=new UnicodeCharInfo(' ');
    private static UnicodeCharInfo six=new UnicodeCharInfo((char) 9);
    private static UnicodeCharInfo seven=new UnicodeCharInfo('&');
    private static UnicodeCharInfo eight=new UnicodeCharInfo((char) 955);//символ лямбды в находится под номером 955 https://www.codetable.net/decimal/955

    @Test
    void unicodeInt() {
        Assertions.assertEquals(48,one.unicodeInt());
        Assertions.assertEquals(78,two.unicodeInt());
        Assertions.assertEquals(122,three.unicodeInt());
        Assertions.assertEquals(1046,four.unicodeInt());
        Assertions.assertEquals(32,five.unicodeInt());
        Assertions.assertEquals(9,six.unicodeInt());
        Assertions.assertEquals(38,seven.unicodeInt());
        Assertions.assertEquals(955,eight.unicodeInt());
    }

    @Test
    void unicodeHex() {
        Assertions.assertEquals("U+0030",one.unicodeHex());
        Assertions.assertEquals("U+004E",two.unicodeHex());
        Assertions.assertEquals("U+007A",three.unicodeHex());
        Assertions.assertEquals("U+0416",four.unicodeHex());
        Assertions.assertEquals("U+0020",five.unicodeHex());
        Assertions.assertEquals("U+0009",six.unicodeHex());
        Assertions.assertEquals("U+0026",seven.unicodeHex());
        Assertions.assertEquals("U+03BB",eight.unicodeHex());
    }

    @Test
    void nextChar() {
        Assertions.assertEquals('1',one.nextChar());
        Assertions.assertEquals('O',two.nextChar());
        Assertions.assertEquals('{',three.nextChar());
        Assertions.assertEquals('З',four.nextChar());
        Assertions.assertEquals('!',five.nextChar());
        Assertions.assertEquals((char) 10,six.nextChar());
        Assertions.assertEquals((char) 39,seven.nextChar());
        Assertions.assertEquals((char)956,eight.nextChar());
    }

    @Test
    void prevChar() {
        Assertions.assertEquals('/',one.prevChar());
        Assertions.assertEquals('M',two.prevChar());
        Assertions.assertEquals('y',three.prevChar());
        Assertions.assertEquals('Е',four.prevChar());
        Assertions.assertEquals((char) 31,five.prevChar());
        Assertions.assertEquals((char) 8,six.prevChar());
        Assertions.assertEquals((char) 37,seven.prevChar());
        Assertions.assertEquals((char) 954,eight.prevChar());
    }

    @Test
    void charType() {
        Assertions.assertEquals("DIGIT",one.charType());
        Assertions.assertEquals("LETTER_UPPER",two.charType());
        Assertions.assertEquals("LETTER_LOWER",three.charType());
        Assertions.assertEquals("LETTER_UPPER",four.charType());
        Assertions.assertEquals("SPACE",five.charType());
        Assertions.assertEquals("SPACE",six.charType());
        Assertions.assertEquals("OTHER",seven.charType());
        Assertions.assertEquals("OTHER",eight.charType());
    }

    @Test
    void alphabetNumber() {
        Assertions.assertEquals(-1,one.alphabetNumber());
        Assertions.assertEquals(14,two.alphabetNumber());
        Assertions.assertEquals(26,three.alphabetNumber());
        Assertions.assertEquals(-1,four.alphabetNumber());
        Assertions.assertEquals(-1,five.alphabetNumber());
        Assertions.assertEquals(-1,six.alphabetNumber());
        Assertions.assertEquals(-1,seven.alphabetNumber());
        Assertions.assertEquals(-1,eight.alphabetNumber());
    }
}