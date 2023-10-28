package com.jefflife.frontapiserver.application.domain.model;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class CommandValue {
    private final String commandText;
    private final String lastWord;

    private CommandValue(String commandText, String lastWord) {
        this.commandText = commandText;
        this.lastWord = lastWord;
    }

    public static CommandValue of(String commandText) {
        if  (StringUtils.isBlank(commandText)) {
            throw new IllegalArgumentException("command is blank");
        }
        String strippedCommand = StringUtils.stripToEmpty(commandText);
        String[] words = strippedCommand.split(" ");
        if (words.length == 1) {
            return new CommandValue(commandText, words[0]);
        }
        String lastWord = words[words.length - 1];
        return new CommandValue(commandText, lastWord);
    }
}
