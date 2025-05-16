package Buffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class SlicingBuffer {
    public static void main(String[] args){
		try{
			ByteBuffer Bbuffer = ByteBuffer.allocate(6);
			System.out.println("Starting position:"+Bbuffer.position());
			byte[] numbers = {10,11,12,13,14};
			Bbuffer.put(numbers);
			System.out.println(Arrays.toString(Bbuffer.array()));
			System.out.println("Position after 5 put:"+Bbuffer.position());
			Bbuffer.compact();
            
            System.out.println("after compact: "+Arrays.toString(Bbuffer.array()));
			System.out.println("Position after compact:"+Bbuffer.position());

			Bbuffer.put((byte)15);
			System.out.println("Position after writing 15:"+Bbuffer.position());
			System.out.println("after writing 15: "+Arrays.toString(Bbuffer.array()));

			ByteBuffer newBuffer=Bbuffer.duplicate();
			System.out.println("Duplicate Buffer: "+Arrays.toString(newBuffer.array()));

			ByteBuffer newSliceBuffer=Bbuffer.slice();
			System.out.println("Sliced Buffer: "+Arrays.toString(newSliceBuffer.array()));
			System.out.println(newSliceBuffer.position());

			newSliceBuffer.put((byte)16);
			System.out.println("Sliced Buffer after 16: "+Arrays.toString(newSliceBuffer.array()));
			System.out.println(newSliceBuffer.limit());	}
            
		catch(Exception ex){
			System.out.println("Error: "+ex.getMessage());}}}


    

