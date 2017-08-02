package main;

/**
 * Created by gezz on 2017/8/1.
 */
public class CoderLineCounter {
    private Integer noteCount = 0; //注释行数
    private Integer codeCount = 0; //代码行数
    private Integer spaceCount = 0;//空行数

    public CoderLineCounter() {
        noteCount = 0; //注释行数
        codeCount = 0; //代码行数
        spaceCount = 0;//空行数
    }

    public Integer getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(Integer noteCount) {
        this.noteCount = noteCount;
    }

    public Integer getCodeCount() {
        return codeCount;
    }

    public void setCodeCount(Integer codeCount) {
        this.codeCount = codeCount;
    }

    public Integer getSpaceCount() {
        return spaceCount;
    }

    public void setSpaceCount(Integer spaceCount) {
        this.spaceCount = spaceCount;
    }

    @Override
    public String toString() {
        return "CoderLineCounter{" +
                "noteCount=" + noteCount +
                ", codeCount=" + codeCount +
                ", spaceCount=" + spaceCount +
                '}';
    }
}
