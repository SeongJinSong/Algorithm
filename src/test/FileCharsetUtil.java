package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class FileCharsetUtil {
	
	public static void main(String[] args) {
		System.out.println("=============== convert start ===============");
		getFileList("window file path".replaceAll("\\\\", "/"), 0);		
		System.out.println("=============== convert end ===============");
	}
	
	public static void getFileList(String rootpath, int depth) {
		String indent = "";
		for(int i=0;i<depth;i++) indent=indent.concat(" ");
		System.out.println(indent+"- rootpath:"+rootpath);
		File path = new File(rootpath);
		FileFilter javafilter = new FileFilter() {
		    public boolean accept(File f) {
		        return f.getName().endsWith("java");
		    }
		};
		FileFilter dirfilter = new FileFilter() {
		    public boolean accept(File f) {
		        return !f.getName().endsWith("java");
		    }
		};
		File[] javalist = path.listFiles(javafilter);
		for(File f : javalist) {
			System.out.println(indent+"name:"+f.getName());
			try {
				convertEncoding(f.getAbsolutePath(), f.getAbsolutePath());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File[] dirlist = path.listFiles(dirfilter);
		for(File f : dirlist) {
			System.out.println(indent+"dir:"+f.getName());
			getFileList(f.getAbsolutePath(), depth+1);
		}
	}
	 
    public static void convertEncoding(String inFileName, String outFileName) throws Exception {
        FileInputStream fileInputStream = null;
        Reader reader = null;
        Writer writer = null;
        StringBuffer stringBuffer = new StringBuffer();
         
        int intRead = 0;
         
        fileInputStream = new FileInputStream(inFileName);
        Charset inputCharset = Charset.forName("MS949");
        InputStreamReader isr = new InputStreamReader(fileInputStream, inputCharset);
         
        reader = new BufferedReader(isr);
         
        while( ( intRead = reader.read() ) > -1 ) {
            stringBuffer.append((char)intRead);
        }
        reader.close();
         
        FileOutputStream fos = new FileOutputStream(outFileName);
        writer = new OutputStreamWriter(fos, "UTF-8");
        writer.write(stringBuffer.toString());
        stringBuffer.setLength(0);
        writer.close();
    }
}