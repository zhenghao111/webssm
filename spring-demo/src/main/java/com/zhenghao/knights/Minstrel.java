package com.zhenghao.knights;

import java.io.PrintStream;

public class Minstrel {

    private PrintStream printStream;

    public Minstrel(PrintStream printStream) {
        this.printStream = printStream;
    }

    // 探险前调用
    public void singBeforeQuest() {
        printStream.println("Fa la la, the knight is so brave");
    }

    // 探险后调用
    public void singAfterQuest() {
        printStream.println("Tee hee hee, the brave knight did embark on a quest");
    }
}
