package bingguo.api;

import java.io.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/25
 **/
public class BaseFile{
    private Carries carries;

    public BaseFile(File file) {
        this.carries = new LocalCarries(file);
    }

    public BaseFile(String filePath) {
        this(new File(filePath));
    }

    public BaseFile(String fileName, byte[] content) {
        this(fileName, content, null);
    }

    public BaseFile(String fileName, byte[] content, String mimeType) {
        this.carries = new ByteArrayCarries(fileName, content, mimeType);
    }

    public BaseFile(String fileName, InputStream stream) {
        this(fileName, stream, null);
    }

    public BaseFile(String fileName, InputStream stream, String mimeType) {
        this.carries = new StreamCarries(fileName, stream, mimeType);
    }

    public boolean isValid() {
        return carries.isValid();
    }

    public String getFileName() {
        return carries.getFileName();
    }

    public String getMimeType() {
        return carries.getMimeType();
    }

    public long getFileLength() {
        return carries.getFileLength();
    }

    public void write(OutputStream output) throws IOException {
        carries.write(output);
    }

    interface Carries {
        boolean isValid();

        String getFileName();

        String getMimeType();

        long getFileLength();

        void write(OutputStream output) throws IOException;
    }

    private static class LocalCarries implements Carries {
        private File file;

        public LocalCarries(File file) {
            this.file = file;
        }

        @Override
        public boolean isValid() {
            return this.file != null && this.file.exists() && this.file.isFile();
        }

        @Override
        public String getFileName() {
            return this.file.getName();
        }

        @Override
        public String getMimeType() {
            return Constants.MIME_TYPE_DEFAULT;
        }

        @Override
        public long getFileLength() {
            return this.file.length();
        }

        @Override
        public void write(OutputStream output) throws IOException {
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
                byte[] bytes = new byte[Constants.READ_BUFFER_SIZE];
                int i;
                while ((i = inputStream.read(bytes)) != -1) {
                    output.write(bytes, 0, i);
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }

        }
    }

    private static class ByteArrayCarries implements Carries {
        private String fileName;
        private byte[] content;
        private String mimeType;

        public ByteArrayCarries(String fileName, byte[] content, String mimeType) {
            this.fileName = fileName;
            this.content = content;
            this.mimeType = mimeType;
        }

        @Override
        public boolean isValid() {
            return this.content != null && this.fileName != null;
        }

        @Override
        public String getFileName() {
            return this.fileName;
        }

        @Override
        public String getMimeType() {
            if (this.mimeType == null) {
                return Constants.MIME_TYPE_DEFAULT;
            } else {
                return this.mimeType;
            }
        }

        @Override
        public long getFileLength() {
            return this.content.length;
        }

        @Override
        public void write(OutputStream output) throws IOException {
            output.write(this.content);
        }
    }

    private static class StreamCarries implements Carries {
        private String fileName;
        private InputStream stream;
        private String mimeType;

        public StreamCarries(String fileName, InputStream stream, String mimeType) {
            this.fileName = fileName;
            this.stream = stream;
            this.mimeType = mimeType;
        }

        @Override
        public boolean isValid() {
            return this.fileName != null && this.stream != null;
        }

        @Override
        public String getFileName() {
            return this.fileName;
        }

        @Override
        public String getMimeType() {
            return null;
        }

        @Override
        public long getFileLength() {
            return 0L;
        }

        @Override
        public void write(OutputStream output) throws IOException {
            try {
                byte[] bytes = new byte[Constants.READ_BUFFER_SIZE];
                int n = 0;
                while ((n = stream.read(bytes)) != -1) {
                    output.write(bytes, 0, n);
                }
            } finally {
                if (stream != null) {
                    stream.close();
                }
            }
        }
    }
}
