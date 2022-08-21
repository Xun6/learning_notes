package com.geekbang.game.inputoutput;

import com.geekbang.game.util.OutputText;

public interface ClientIOModule {

    String getSingleChar();

    String getSingleCharWithDefault(String defaultVal);

    String getLine();

    void outputText(OutputText outputText);
}
