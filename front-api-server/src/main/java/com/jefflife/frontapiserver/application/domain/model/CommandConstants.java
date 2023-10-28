package com.jefflife.frontapiserver.application.domain.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum CommandConstants {
    WHO (new String[] {"누구"}),
    STAT (new String[] {"상태", "스탯창"}),
    SAY (new String[] {"말"}),
    LOOK(new String[] {"봐", "보다"}),
    BAG (new String[] {"소지품"}),
    MOVE (new String[] {"동", "서", "남", "북", "위", "아래"}),
    GET (new String[] {"주워", "줍", "가져", "집어"}),
    DROP (new String[] {"버려"}),
    TAKEOUT (new String[] {"꺼내", "빼"}),
    PUT (new String[] {"넣어"}),
    UNLOCK (new String[] {"열어"}),
    LOCK (new String[] {"잠궈"}),
    ATTACK (new String[] {"공격"}),
    NOOP (new String[] {}), // 아무것도 하지 않는다.
    // 전투 관련
    // 근접전
    PUNCH (new String[] {"주먹"}),
    HEAD_BUTT (new String[] {"박치기"}),
    KICK (new String[] {"발차기"}),
    ;

    private final Set<String> commands;

    CommandConstants(String[] commands) {
        this.commands = new HashSet<>(Arrays.asList(commands));
    }

    public boolean matched(String command) {
        return commands.stream()
                .anyMatch(c -> c.startsWith(command));
    }

    public static CommandConstants find(CommandValue commandValue) {
        return Arrays.stream(CommandConstants.values())
                .filter(c -> c.matched(commandValue.getLastWord()))
                .findFirst()
                .orElse(null);
    }
}
