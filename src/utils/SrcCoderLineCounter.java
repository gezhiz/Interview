package utils;

import domain.CoderLineCounter;

import java.io.*;

/**
 * Created by gezz on 2017/8/1.
 */
public class SrcCoderLineCounter {
    private CoderLineCounter counter = new CoderLineCounter();

    /**
     * 空格,//,/*, *, ..,
     * @param path
     * @throws IOException
     */
    public void readFiles(String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            String[] fileList = file.list();
            for (String subPath : fileList) {
                //递归调用readFiles方法
                readFiles(path + "/" + subPath);
            }
        } else {
            //阅读文件
            Reader reader = new FileReader(file);
            LineNumberReader lineReader = new LineNumberReader(reader);
            String lineStr;
            int sectionCount = 0;
            while ((lineStr = lineReader.readLine()) != null) {
                //替换所有空行
                lineStr = lineStr.trim();
//                lineStr.replaceAll("\\s*|\\t|\\r|\\n","");
                if (0 == lineStr.length()) {
                    counter.setSpaceCount(counter.getSpaceCount() + 1);
                    continue;
                }
                if (sectionCount == 0) {
                    //段落注释未开始统计
                    if (lineStr.startsWith("/*")) {
                        if (lineStr.endsWith("*/")) {
                            counter.setNoteCount(counter.getNoteCount() + 1);
                            continue;
                        }
                        sectionCount++;
                        continue;
                    }
                    if (lineStr.startsWith("//")) {
                        counter.setNoteCount(counter.getNoteCount() + 1);
                        continue;
                    }
                    counter.setCodeCount(counter.getCodeCount() + 1);
                } else {
                    //段落注释中、结尾
                    sectionCount++;
                    if (lineStr.endsWith("*/")) {
                        counter.setNoteCount(counter.getNoteCount() + sectionCount);
                        sectionCount = 0;
                        continue;
                    }
                }
            }
            if (lineReader != null) {
                lineReader.close();
                lineReader = null;
            }
            if (reader != null) {
                reader.close();
                reader = null;
            }
        }

    }

    public CoderLineCounter getCounter() {
        return counter;
    }

    public void setCounter(CoderLineCounter counter) {
        this.counter = counter;
    }
}
