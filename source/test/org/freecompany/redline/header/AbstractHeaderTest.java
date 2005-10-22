package org.freecompany.redline.header;

import java.nio.*;
import java.nio.charset.*;
import junit.framework.*;

import static org.freecompany.redline.header.AbstractHeader.*;

public class AbstractHeaderTest extends TestCase {

	public void testCharSingle() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 1);
		buffer.put(( byte) 1);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< byte[]> entry = header.createEntry( 1);
		entry.setCount( 1);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 1);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testCharMultiple() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 2);
		buffer.put(( byte) 1);
		buffer.put(( byte) 2);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< byte[]> entry = header.createEntry( 1);
		entry.setCount( 2);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);
		assertEquals( 2, entry.values[ 1]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 2);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testInt8Single() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 1);
		buffer.put(( byte) 1);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< byte[]> entry = header.createEntry( 2);
		entry.setCount( 1);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 1);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testInt8Multiple() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 2);
		buffer.put(( byte) 1);
		buffer.put(( byte) 2);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< byte[]> entry = header.createEntry( 2);
		entry.setCount( 2);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);
		assertEquals( 2, entry.values[ 1]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 2);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testInt16Single() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 2);
		buffer.putShort(( short) 1);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< short[]> entry = header.createEntry( 3);
		entry.setCount( 1);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 2);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testInt16Multiple() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 4);
		buffer.putShort(( short) 1);
		buffer.putShort(( short) 2);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< short[]> entry = header.createEntry( 3);
		entry.setCount( 2);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);
		assertEquals( 2, entry.values[ 1]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 4);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testInt32Single() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 4);
		buffer.putInt( 1);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< int[]> entry = header.createEntry( 4);
		entry.setCount( 1);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 4);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testInt32Multiple() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 8);
		buffer.putInt( 1);
		buffer.putInt( 2);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< int[]> entry = header.createEntry( 4);
		entry.setCount( 2);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);
		assertEquals( 2, entry.values[ 1]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 8);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testInt64Single() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 8);
		buffer.putLong( 1);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< long[]> entry = header.createEntry( 5);
		entry.setCount( 1);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 8);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testInt64Multiple() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 16);
		buffer.putLong( 1);
		buffer.putLong( 2);
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< long[]> entry = header.createEntry( 5);
		entry.setCount( 2);
		entry.read( buffer);
		assertEquals( 1, entry.values[ 0]);
		assertEquals( 2, entry.values[ 1]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 16);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testStringSingle() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 8);
		buffer.put( Charset.forName( "US-ASCII").encode( "1234567\000"));
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< String[]> entry = header.createEntry( 6);
		entry.setCount( 1);
		entry.read( buffer);
		assertEquals( "1234567", entry.values[ 0]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 8);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testStringMultiple() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 16);
		buffer.put( Charset.forName( "US-ASCII").encode( "1234567\000"));
		buffer.put( Charset.forName( "US-ASCII").encode( "7654321\000"));
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< String[]> entry = header.createEntry( 6);
		entry.setCount( 2);
		entry.read( buffer);
		assertEquals( "1234567", entry.values[ 0]);
		assertEquals( "7654321", entry.values[ 1]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 16);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testBinary() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 8);
		buffer.put( new String( "12345678").getBytes());
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< byte[]> entry = header.createEntry( 7);
		entry.setCount( 8);
		entry.read( buffer);
		assertTrue( ByteBuffer.wrap( "12345678".getBytes()).equals( ByteBuffer.wrap( entry.values)));

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 8);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testStringArraySingle() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 8);
		buffer.put( Charset.forName( "US-ASCII").encode( "1234567\000"));
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< String[]> entry = header.createEntry( 8);
		entry.setCount( 1);
		entry.read( buffer);
		assertEquals( "1234567", entry.values[ 0]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 8);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testStringArrayMultiple() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 16);
		buffer.put( Charset.forName( "US-ASCII").encode( "1234567\000"));
		buffer.put( Charset.forName( "US-ASCII").encode( "7654321\000"));
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< String[]> entry = header.createEntry( 8);
		entry.setCount( 2);
		entry.read( buffer);
		assertEquals( "1234567", entry.values[ 0]);
		assertEquals( "7654321", entry.values[ 1]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 16);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testI18NStringSingle() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 8);
		buffer.put( Charset.forName( "US-ASCII").encode( "1234567\000"));
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< String[]> entry = header.createEntry( 9);
		entry.setCount( 1);
		entry.read( buffer);
		assertEquals( "1234567", entry.values[ 0]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 8);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public void testI18NStringMultiple() throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate( 16);
		buffer.put( Charset.forName( "US-ASCII").encode( "1234567\000"));
		buffer.put( Charset.forName( "US-ASCII").encode( "7654321\000"));
		buffer.flip();
		
		TestHeader header = new TestHeader();
		Entry< String[]> entry = header.createEntry( 9);
		entry.setCount( 2);
		entry.read( buffer);
		assertEquals( "1234567", entry.values[ 0]);
		assertEquals( "7654321", entry.values[ 1]);

		header.index = ByteBuffer.allocate( 16);
		header.data = ByteBuffer.allocate( 16);
		entry.write();

		header.data.flip();
		buffer.flip();
		assertTrue( buffer.equals( header.data));
	}

	public class TestHeader extends AbstractHeader {}

	public AbstractHeaderTest( String name) {
		super( name);
	}

	public static Test suite() {
		return new TestSuite( AbstractHeaderTest.class);
	}

	public static void main( String[] args) {
		junit.textui.TestRunner.run( suite());
	}
}
