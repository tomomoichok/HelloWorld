package io;
import java.io.File;
//创建目录
public class CreateDir {
	public static void main(String args[]) {
        String dirname = "c:/111";
        File d = new File(dirname);
        // 现在创建目录
        d.mkdirs();
    }
}
