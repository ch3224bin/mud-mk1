package com.jefflife.frontapiserver.application.domain.model;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class CommandValue {
    private final String commandText;
    private final String[] words;

    private CommandValue(String commandText, String[] words) {
        this.commandText = commandText;
        this.words = words;
    }

    public static CommandValue of(String commandText) {
        if  (StringUtils.isBlank(commandText)) {
            throw new IllegalArgumentException("command is blank");
        }
        String strippedCommand = StringUtils.stripToEmpty(commandText);
        String[] words = strippedCommand.split(" ");
        return new CommandValue(commandText, words);
    }

    public int getWordCount() {
        return words.length;
    }

    public String getLastWord() {
        return words[words.length - 1];
    }
}
