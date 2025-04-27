package Buffer;
import java.nio.CharBuffer;

public class DBuffer {
    public static void main(String [] args){
        try{
            CharBuffer cBuffer = CharBuffer.allocate(10);
            cBuffer.put('H');
            cBuffer.put('E'); 
            cBuffer.put('L');
            cBuffer.put('L');
            cBuffer.put('O');
            String st = "";
            cBuffer.flip();
            while (cBuffer.hasRemaining()) {
                st = st+cBuffer.get();
            }
            System.out.println("String: " +st);
            System.out.println("Current Position" + cBuffer.position());

        }

        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    
}
