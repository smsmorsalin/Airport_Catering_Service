package utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    public AppendableObjectOutputStream() throws IOException, SecurityException {
    }

    @Override
    protected void writeStreamHeader() throws IOException {
    }
}
